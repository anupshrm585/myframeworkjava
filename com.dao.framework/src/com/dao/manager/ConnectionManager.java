package com.dao.manager;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.dao.util.BaseUtility;

public class ConnectionManager {
	private static ConnectionManager connection=null;
	private static SessionFactory factory=null;
	private ConnectionManager(){}
	
	public static synchronized ConnectionManager getInstance(){
		if(BaseUtility.isEmpty(connection)){
			connection=new ConnectionManager();
		}
		return connection;
			
	}
	
	public SessionFactory getSessionFactory(){
		if(BaseUtility.isEmpty(factory)){
			Configuration configuration = new Configuration();
	 	    configuration.configure();
	 	    ServiceRegistry registry = new StandardServiceRegistryBuilder()
	 	    				.applySettings(configuration.getProperties()).build();
			factory=configuration.buildSessionFactory(registry);
		}
		return factory;
	}
	
	
}
