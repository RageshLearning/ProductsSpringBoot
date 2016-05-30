package com.casestudy.app.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name="product")
@SecondaryTables({
  @SecondaryTable(name="productprice",
    pkJoinColumns = @PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
  )
 }
)
public class Product {
	@Id
	long id; 
	String sku;
	String name;
	String category; 
	@Column(table = "productprice", name = "price")
	float price;
	Date  lastupdated;
	public Product(long id, String sku, String name, String category, float price) {
		this(sku,name,category,price);
		this.id = id;
	}
	public Product() {
		super();
	}
	public Product( String sku, String name, String category, float price) {
		super();
		this.sku = sku;
		this.name = name;
		this.category = category;
		this.price = price;
		this.lastupdated = new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	} 
	public String getLastupdated() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:hh:mm");
		return sdf.format(lastupdated);
	}
	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", sku=" + sku + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", lastupdated=" + lastupdated + "]";
	}
	
}
