package com.casestudy.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.app.domain.Product;
import com.casestudy.app.respository.ProductsRepository;


@Service
public class ProductsService {
	
	@Autowired
	ProductsRepository productsRepository;
	

	

	public ProductsRepository getProductsRepository() {
		return productsRepository;
	}

	public void setProductsRepository(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	public  List<Product>  getProducts() {
		List<Product> productList = productsRepository.findAll();
		return productList;
	}
		
	public  Product  getProduct(String id) {

	    long longid = Long.parseLong(id);
		Product product = productsRepository.findOne(longid);
		return product;
	}
	
	public List<Product>   getProductByCategory(String category) {
		List<Product> productList = productsRepository.findByCategory(category);
		return productList;
	}

	public Product save (Product p){
		return productsRepository.save(p);
	}
	
}

