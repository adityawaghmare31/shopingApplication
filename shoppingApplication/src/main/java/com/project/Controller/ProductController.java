package com.project.Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Entity.Category;
import com.project.Entity.Product;
import com.project.Entity.ProductInfo;
import com.project.Service.ProductService;

@RestController
@RequestMapping("productapi")
public class ProductController  
{
	@Autowired
	ProductService service;
	
	@RequestMapping("allProducts")
	public List<Product>allProducts	()
	{
		return service.allProducts();
	}
	
	
	@RequestMapping("allProductWithCategory")
	public List<ProductInfo> allProductsWithCategory()	
	{
		return service.allProductsWithCategory();
	}
	
	
	@RequestMapping("deleteProduct/{pid}")
	public Product deleteProduct(@PathVariable int pid)
	{
		return service.deleteProduct(pid);
	}
}