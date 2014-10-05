package com.dao.manager;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DatabaseManager {
	private SessionFactory factory=ConnectionManager.getInstance().getSessionFactory();
	public Object insertData(Object obj){
		 Session session = factory.openSession();
		 Transaction tx = null;
		 Object id=null;
		 try{
	         tx = session.beginTransaction();
	         id=session.save(obj); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return id;
	}
	public int updateData(Object obj){
		Session session = factory.openSession();
		Transaction tx = null;
		int result=1;
		try{
	         tx = session.beginTransaction();
	         session.update(obj); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         System.out.println(e.getMessage());
	         //return result; 
	      }finally {
	         session.close(); 
	      }		 
		return result;
	}
	public int deleteData(Object obj){
		Session session = factory.openSession();
		Transaction tx = null;
		int result=1;
		try{
	         tx = session.beginTransaction();
	         session.delete(obj); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         System.out.println(e.getMessage());
	         //return result; 
	      }finally {
	         session.close(); 
	      }		 
		return result;
	}
	public List<Object> getList(String query){
		List<Object> records=null;
		Session session = factory.openSession();
		Transaction tx = null;
		try{
	         tx = session.beginTransaction();
	         Query res = session.createQuery(query);
	         records =  res.list();
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	        // System.out.println(e.getMessage());
	         e.printStackTrace();
	         //return result; 
	      }finally {
	         session.close(); 
	      }
		return records;
	}
	public void getResultSet(String query){
		
	}
	
}
