package com.project.Dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Entity.User;

@Repository
public class UserDao {
	@Autowired
	SessionFactory sf;
	
	public User  ValideUser(User userFromDatabase) {
		Session session=sf.openSession();
		User user=session.get(User.class, userFromDatabase.getUsername());
		session.close();
		return user;
		
		 
		 
		 
		 
	 }

	public String savedata(User save)
	{
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(save);
		tx.commit();
		return "success";
		
	
	}
}
