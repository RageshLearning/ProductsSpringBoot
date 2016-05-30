package com.casestudy.app.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.casestudy.app.controller.ProductController;
import com.casestudy.app.domain.Product;
import com.casestudy.app.respository.ProductsRepository;

public class ProductsServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testWhenProductIdIsEmpty() {
//		ProductsRepository productsRepositoryMock =  mock(ProductsRepository.class);
//		when(productsRepositoryMock.findOne(any(long.class))).thenReturn(new Product());
//		ProductsService service = new ProductsService();
//		service.productsRepository = productsRepositoryMock;
//		Product p =  service.getProduct("");
//		System.out.println(p);
//		assertNotNull(p);
//		assertEquals(p.getId(),0);
//	}

}
