package com.casestudy.app.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.app.domain.Product;

// @Repository("ProductsRepository")
public interface ProductsRepository extends JpaRepository<Product,Long >{

	public List<Product> findByCategory(String category);

}


