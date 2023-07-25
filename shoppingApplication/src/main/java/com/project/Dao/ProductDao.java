package com.project.Dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Entity.Product;
import com.project.Entity.ProductInfo;

@Repository
public class ProductDao {
	
	@Autowired
	SessionFactory sf;

	public List<Product> allProducts() {
		
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> list=criteria.list();
		return list;
		//[pid=1 name=pen price=100] Product class object
		// Spring calls getter methods to read data of variables and then create JSON String
	}

	public List<ProductInfo> allProductsWithCategory()	
	{
		Session session=sf.openSession();
		
		Query query =session.createSQLQuery("select product.pid,product.name,product.price,category.cid,category.name as cname from product join category on product.cid=category.cid"); 
		
		List<Object[]> list=query.list();
		
		List<ProductInfo> arrayList= new ArrayList<ProductInfo>();
		for (Object[] array : list)
		{
			arrayList.add(new ProductInfo((int)array[0], (String)array[1], (int)array[2], (int)array[3], (String)array[4]));
			
		}
		return arrayList;
	}
	
	public Product deleteProduct(int pid)
	{
		Session session=sf.openSession();
		Product product=session.get(Product.class, pid);
		
		Transaction tx=session.beginTransaction();
			session.delete(product);
		tx.commit();
		
		return product;
		
	}
}
