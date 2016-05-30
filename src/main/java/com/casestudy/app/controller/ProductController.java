package com.casestudy.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.app.domain.Product;
import com.casestudy.app.service.ProductsService;


@RestController
public class ProductController {
	
	@Autowired
	ProductsService  productsService;
	
	public ProductsService getProductsService() {
		return productsService;
	}
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}
	@RequestMapping(value = "/products",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Product> getProducts() {
		List<Product> productList  = productsService.getProducts();
		return productList;
		
	}
	@RequestMapping(value = "/products/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Product getProduct(@PathVariable(value="id") String id) {
		Product product = productsService.getProduct(id);
		return product ;
	}
	@RequestMapping(value = "/products",params = {"category"},method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Product> getProductByCategory(@RequestParam (value="category") String category) {
		List<Product> productList  = productsService.getProductByCategory(category);
		
		return productList ;
	}
	
}
   





