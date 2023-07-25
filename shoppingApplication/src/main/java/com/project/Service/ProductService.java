package com.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.ProductDao;
import com.project.Entity.Product;
import com.project.Entity.ProductInfo;

@Service
public class ProductService {
	@Autowired
	ProductDao SD;

	public List<Product> allProducts() {
		return SD.allProducts();
	}
	
	public List<ProductInfo> allProductsWithCategory()	
	{
		return SD.allProductsWithCategory();
	}

	public Product deleteProduct(int pid) 
	{
	
		return SD.deleteProduct(pid);
	}
}
