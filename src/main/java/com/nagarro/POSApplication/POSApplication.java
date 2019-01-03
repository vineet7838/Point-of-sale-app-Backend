package com.nagarro.POSApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nagarro.POSApplication")
public class POSApplication {

	public static void main(String[] args) {
		SpringApplication.run(POSApplication.class, args);

//		Session session = HibernateUtil.openSession();
//		session.beginTransaction();
//		Inventory i1 = new Inventory();
//		i1.setQuantity(20);
//		
//		Product p1= new Product("Apple iphone", "www.imgrBB.com","its just awesomee",50000);
//		p1.setInventory(i1);
//		i1.setProduct1(p1);
//		
//		session.save(p1);


	}

}
