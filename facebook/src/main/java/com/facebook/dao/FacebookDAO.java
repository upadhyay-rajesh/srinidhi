package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.facebook.entity.FacebookUser;

public class FacebookDAO implements FacebookDAOInterface {

	public int createProfileDAO(FacebookUser fb) {
		
		
		int i=0;
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); Connection
		 * con=DriverManager.getConnection("jdbc:mysql://localhost:3306/revatureadvance"
		 * ,"root","rajesh"); PreparedStatement
		 * ps=con.prepareStatement("insert into facebookuser values(?,?,?,?)");
		 * ps.setString(1, fb.getName()); ps.setString(2, fb.getPassword());
		 * ps.setString(3, fb.getEmail()); ps.setString(4, fb.getAddress());
		 * 
		 * i=ps.executeUpdate(); } catch(ClassNotFoundException|SQLException e) {
		 * e.printStackTrace(); }
		 */
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		/*
		 * in above configure method by default will load hibernate.cfg.xml file from src/main/java and provide all information to buildsessionfactory() method
		 * buildsessionfactory() method will create database connection , create table, do the mapping between table and entity
		 * by default SessionFactory class is singelton
		 * sessionfactory level cache is known as second level cache or L2 cache
		 */
		Session s=sf.openSession();
		/*
		 * to do any task we have to create individual session using sessionfactory object
		 * session level cache is known as first level cache or L1 cache
		 */
		EntityTransaction et=s.getTransaction();
		
		/*
		 * entitytransaction is required for DML operation like insert, delete, update or save(), delete() and update() method
		 * we must start transaction before running any DML operation and then we must commit our transaction.
		 */
		
		et.begin();
		
			s.save(fb);
		
		et.commit();
		
		
		i=1;
		
		
		
		return i;
	}

	@Override
	public boolean loginProfileDAO(FacebookUser fb) {
		boolean i=false;
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); Connection
		 * con=DriverManager.getConnection("jdbc:mysql://localhost:3306/revatureadvance"
		 * ,"root","rajesh"); PreparedStatement ps=con.
		 * prepareStatement("select * from facebookuser where email=? and password=?");
		 * ps.setString(1, fb.getEmail()); ps.setString(2, fb.getPassword());
		 * 
		 * ResultSet res=ps.executeQuery(); if(res.next()) { i=true; } }
		 * catch(ClassNotFoundException|SQLException e) { e.printStackTrace(); }
		 */
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		
		/*
		 * if our query is undecided or inbuild methods are not available to handle such type of query then we should HQL and should handle query as below
		 */
			Query q=s.createQuery("from com.facebook.entity.FacebookUser f where f.email=:em and f.password=:pw");
			q.setParameter("em", fb.getEmail());
			q.setParameter("pw", fb.getPassword());
			
			List<FacebookUser> ff=q.getResultList();
			if(ff.size()>0) {
				i=true;
			}
		
		return i;
	}

	@Override
	public FacebookUser viewProfileDAO(FacebookUser fb) {
		FacebookUser fu=null;
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); Connection
		 * con=DriverManager.getConnection("jdbc:mysql://localhost:3306/revatureadvance"
		 * ,"root","rajesh"); PreparedStatement
		 * ps=con.prepareStatement("select * from facebookuser where email=? ");
		 * ps.setString(1, fb.getEmail());
		 * 
		 * 
		 * ResultSet res=ps.executeQuery(); if(res.next()) { fu=new FacebookUser();
		 * fu.setName(res.getString(1)); fu.setPassword(res.getString(2));
		 * fu.setEmail(res.getString(3)); fu.setAddress(res.getString(4)); } }
		 * catch(ClassNotFoundException|SQLException e) { e.printStackTrace(); }
		 */
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		
		Query q=s.createQuery("from com.facebook.entity.FacebookUser f where f.email=:em");
		q.setParameter("em", fb.getEmail());
		
		fu=(FacebookUser)q.getSingleResult();
		
		
		return fu;
	}

	@Override
	public List<FacebookUser> viewAllProfileDAO() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		
		//Query q=s.createQuery("from com.facebook.entity.FacebookUser f");
		Query q=s.createNamedQuery("abc");
		List<FacebookUser> ll=q.getResultList();
		return ll;
	}

	@Override
	public int deleteProfileDAO(FacebookUser fb) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		EntityTransaction et=s.getTransaction();
		
		Query q=s.createQuery("delete from com.facebook.entity.FacebookUser f where f.email=:em");
		q.setParameter("em", fb.getEmail());
		et.begin();
		int i=q.executeUpdate();
		et.commit();
		return i;
	}

	@Override
	public int editProfileDAO(FacebookUser fb) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		EntityTransaction et=s.getTransaction();
		
		Query q=s.createQuery("update com.facebook.entity.FacebookUser f set f.name=:n , f.password=:pw , f.address=:ad where f.email=:em");
		q.setParameter("n", fb.getName());
		q.setParameter("pw", fb.getPassword());
		q.setParameter("ad", fb.getAddress());
		q.setParameter("em", fb.getEmail());
		et.begin();
		int i=q.executeUpdate();
		et.commit();
		return i;
	}

}









