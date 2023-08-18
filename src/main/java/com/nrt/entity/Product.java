package com.nrt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    public Product(Long id, String name, String description, double price) {
    	this.id=id;
    	this.name=name;
    	this.description=description;
    	this.price=price;
    }

    
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;
    
    @Column(name="product_name")
    private String name;
    
    @Column(name="product_description")
    private String description;
    
	@Column(name="product_price")
    private double price;

    
}
