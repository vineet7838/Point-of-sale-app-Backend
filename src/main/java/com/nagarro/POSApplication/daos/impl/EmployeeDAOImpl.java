package com.nagarro.POSApplication.daos.impl;

import java.util.List;

import org.apache.tomcat.util.bcel.classfile.Constant;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.POSApplication.constants.Constants;
import com.nagarro.POSApplication.daos.EmployeeDAO;
import com.nagarro.POSApplication.dtos.CashDrawerDTO;
import com.nagarro.POSApplication.dtos.CustomerDTO;
import com.nagarro.POSApplication.dtos.EmployeeDTO;
import com.nagarro.POSApplication.dtos.LoginDTO;
import com.nagarro.POSApplication.dtos.LoginResponseDTO;
import com.nagarro.POSApplication.dtos.MessageDTO;
import com.nagarro.POSApplication.dtos.OrderDTO;
import com.nagarro.POSApplication.dtos.ProductDTO;
import com.nagarro.POSApplication.dtos.mapper.CustomerDTOMapper;
import com.nagarro.POSApplication.dtos.mapper.EmployeeDTOMapper;
import com.nagarro.POSApplication.dtos.mapper.ProductDTOMapper;
import com.nagarro.POSApplication.entitys.Customer;
import com.nagarro.POSApplication.entitys.Employee;
import com.nagarro.POSApplication.entitys.Order;
import com.nagarro.POSApplication.entitys.OrderProduct;
import com.nagarro.POSApplication.entitys.Product;
import com.nagarro.POSApplication.utils.HibernateUtil;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public LoginResponseDTO loginEmployee(LoginDTO dto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		LoginResponseDTO responseDTO = null;
		String hql = "select E.employeeId from Employee E where E.employeeName =: employeeName and E.employeePassword =: employeePassword ";
		Query query = session.createQuery(hql);
		query.setParameter("employeeName", dto.getUserName());
		query.setParameter("employeePassword", dto.getUserPassword());
		List res = query.list();
		if (res.isEmpty()) {
			responseDTO = new LoginResponseDTO(0, "Invalid Id or Password");

		} else {
			responseDTO = new LoginResponseDTO((int) res.get(0), "Login Successfully");
		}
		
		
		session.close();
		
		//adfdsf
		
		
		return responseDTO;
	}

	@Override
	public List<CustomerDTO> getCustomers(String param) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Customer C where C.customerName like concat('%',:param,'%')";
		Query query = session.createQuery(hql);
		query.setParameter("param", param);
		List<Customer> res = query.list();
		session.close();
		return CustomerDTOMapper.mapToListCustomerDTO(res);

	}

	@Override
	public List<ProductDTO> getProducts(String param) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Product P where P.productName like concat('%',:param,'%') or P.productDescription like concat('%',:param,'%') ";
		Query query = session.createQuery(hql);
		query.setParameter("param", param);
		List<Product> res = query.list();
		session.close();
		return ProductDTOMapper.mapToListProductDTO(res);

	}

	@Override
	public LoginResponseDTO setInitialDrawerBal(CashDrawerDTO dto) {
		LoginResponseDTO responseDTO = new LoginResponseDTO();
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "update Employee E set E.startingBal =:initialBal , "
				+ " E.endingBal =:endingBal	where E.employeeId =:employeeId ";

		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("initialBal", dto.getInitialBal());
		query.setParameter("endingBal", dto.getEndingBal());
		query.setParameter("employeeId", dto.getEmployeeId());
		int res = query.executeUpdate();
		session.getTransaction().commit();
		responseDTO.setEmployeeId(dto.getEmployeeId());
		if (res > 0) {
			responseDTO.setMessage("Success");
		} else {
			responseDTO.setMessage("Failed");
		}
		session.close();

		return responseDTO;
	}

	@Override
	public EmployeeDTO getEmployeeDetails(EmployeeDTO dto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Employee E where E.employeeId =:employeeId ";
		Query query = session.createQuery(hql);
		query.setParameter("employeeId", dto.getEmployeeId());
		List<Employee> res = query.list();
		if (res.isEmpty()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setMessage("Failed");
		}
		return EmployeeDTOMapper.mapToEmployeeDTO((Employee) res.get(0));

	}

	@Override
	public MessageDTO placeOrder(OrderDTO dto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Order order = new Order(dto.getEmployeeId(), dto.getCustomerId(), dto.getStatus(), dto.getPaymentMode(),
				dto.getSubTotal(), dto.getTotal());

		for (ProductDTO productDTO : dto.getProducts()) {
			Product product = (Product) session.get(Product.class, productDTO.getProductId());
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setOrder(order);
			orderProduct.setProduct(product);
			orderProduct.setQuantity(productDTO.getQuantity());
			order.getOrderProducts().add(orderProduct);
		}

		session.save(order);
		
		MessageDTO messageDTO = new MessageDTO("Success");

		session.getTransaction().commit();
		session.close();
		return messageDTO;

	}

	@Override
	public MessageDTO updateInventory(OrderDTO dto) {
		Session session=  HibernateUtil.getSessionFactory().openSession();
		MessageDTO messageDTO = new MessageDTO();
		session.beginTransaction();
		for(ProductDTO productDTO: dto.getProducts()) {
		String hql = "update  Inventory I set I.quantity = I.quantity - :quantity where "
				+ "I.product1.productId =:productId";
		Query query = session.createQuery(hql);
		query.setParameter("quantity", productDTO.getQuantity());
		query.setParameter("productId", productDTO.getProductId());
		System.out.println(query.executeUpdate());
		}
		session.getTransaction().commit();
		session.close();
		messageDTO.setMessage(Constants.SUCCESS);
		return messageDTO;
		
		
		
	}
	
	

}
