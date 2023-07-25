package com.project.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Entity.Category;

@Repository
public class CategoryDao {

	@Autowired
	SessionFactory sf;
	
	public Category saveCategory(Category category) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
			session.save(category);
		tx.commit();
		session.close();
		
		return category;
		
		
		
		
	}
	
	public Category getCategory(int cid)
	{
		Session session=sf.openSession();
		Category category=session.get(Category.class, cid);  //get works only on id

		//Criteria criteria=session.createCriteria(Category.class);
		//criteria.add(Restrictions.eq("cid", cid));
		//List<Category> list=criteria.list();
		//Category category=list.get(0);
		
		return category;
		
	}
	
	public Category updateCategory(Category category)
	{
		Session session=sf.openSession();
		//criteria API is only for retrival (getting data from database)
		Transaction tr=session.beginTransaction();
		session.update(category);
		tr.commit();
		return category;
	}

	public Category deleteCategory(int cid) {
		Session session=sf.openSession();
		//criteria API is only for retrival (getting data from database)
		Category category=session.get(Category.class, cid);  //get works only on id
		// get() gives null value if record is not present in database

		Transaction tx=session.beginTransaction();
			session.delete(category);
		tx.commit();
		
		return category;
	}
	
	public List<Category> getAllCategory()
	{
		Session session=sf.openSession();

		Criteria criteria=session.createCriteria(Category.class);
		
		List<Category> list=criteria.list();
		
		return list;
		
	}
	

	

}
