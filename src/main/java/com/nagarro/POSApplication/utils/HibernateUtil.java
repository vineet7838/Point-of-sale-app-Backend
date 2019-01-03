package com.nagarro.POSApplication.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.POSApplication.entitys.Customer;
import com.nagarro.POSApplication.entitys.Employee;
import com.nagarro.POSApplication.entitys.Inventory;
import com.nagarro.POSApplication.entitys.Order;
import com.nagarro.POSApplication.entitys.OrderProduct;
import com.nagarro.POSApplication.entitys.Product;

public class HibernateUtil {
	public HibernateUtil() {

	}

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().addPackage("com.nagarro.POSApplication.entitys")
					.addAnnotatedClass(Customer.class).addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Inventory.class).addAnnotatedClass(Order.class)
					.addAnnotatedClass(Product.class).addAnnotatedClass(OrderProduct.class).
					buildSessionFactory();

		} catch (final Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}



}
