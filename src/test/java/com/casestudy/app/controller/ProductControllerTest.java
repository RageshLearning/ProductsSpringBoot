package com.casestudy.app.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.casestudy.app.Application;
import com.casestudy.app.domain.Product;
import com.casestudy.app.service.ProductsService;

import junit.framework.Assert;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration

public class ProductControllerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype());

    private MockMvc mockMvc;
    private Product product;
    private List<Product> productList = new ArrayList<>();

    private HttpMessageConverter mappingJackson2HttpMessageConverter;
 

    @Autowired
    private ProductsService productsService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

//        this.productsService.deleteAllInBatch();
//        this.accountRepository.deleteAllInBatch();

        this.product = productsService.save(new Product(1,"sku" , "name" ,"category" , 30.00f));
        
        productList.add(productsService.save(new Product(2,"sku2" , "name2" ,"category2" , 40.00f))) ;
        productList.add(productsService.save(new Product(3,"sku2" , "name2" ,"category2" , 40.00f))) ;
     
    }

    @Test
    public void readSingleProduct() throws Exception {
        mockMvc.perform(get("/products/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(2)))
        		.andExpect(jsonPath("$.sku", is("sku2")))
        		.andExpect(jsonPath("$.name", is("name2")))
        		.andExpect(jsonPath("$.category", is("category2")))
        		.andExpect(jsonPath("$.price", is(40.00)));  

    }







}
