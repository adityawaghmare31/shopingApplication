package com.project.Service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.CategoryDao;
import com.project.Entity.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryDao dao;
	public Category saveCategory(Category category) 
	{
		dao.saveCategory(category);
		return category;

	}
	
	public Category getCategory(int cid) 
	{
		return dao.getCategory(cid);
	}

	public Category updateCategory(Category category) 
	{
		return dao.updateCategory(category);
	}

	public Category deleteCategory(int cid) {
		return dao.deleteCategory(cid);
	}
	
	public List<Category> getAllCategory()
	{
		
		return dao.getAllCategory();
		
	}
}