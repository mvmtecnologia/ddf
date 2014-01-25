package br.com.dicadefarmacia.infra.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDAO {
	
	private static SessionFactory factory;
	
	static {
		Configuration cfg = new Configuration();
		factory = cfg.configure().buildSessionFactory();
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
}
