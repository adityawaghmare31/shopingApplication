package com.project.Controller;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectDeletedException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Entity.Category;
import com.project.Entity.ObjectNotFoundExeption;
import com.project.Service.CategoryService;

@RestController
@RequestMapping("categoryapi")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	@PostMapping("savaCategory")
	public Category saveCategory(@RequestBody Category category) {
		service.saveCategory(category);
		return category;
		
	}
	@RequestMapping("getCategory/{cid}")
	public Category getCategory(@PathVariable int cid)
	{
		Category category=service.getCategory(cid);
		if(category==null)
		{
			throw new ObjectNotFoundExeption("Record Not found");
			//raising exception using throw keyword
		}
		else
		{
			return category;
		}
	//	return service.getCategory(cid);
		
	}

	//{cid:2,name:"fashion"} is sent by client(javascript/postman)
	@PutMapping("updateCategory")
	public  Category updateCategory(@RequestBody Category category)
	{
		return service.updateCategory(category);
	}
	
	@RequestMapping("deleteCategory/{cid}")
	public Category deleteCategory(@PathVariable int cid)
	{
		
		return service.deleteCategory(cid);
		
	}
	
	@RequestMapping("getAllCategory")

	public List<Category> getAllCategory()
	{
		return service.getAllCategory();
		
		
		
	}
}
 