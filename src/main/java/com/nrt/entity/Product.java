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
@Table(name = "products_table")
public class Product {
	@Id
    @Column(name="product_id",unique=true)
    private long id;
    
    @Column(name="product_name")
    private String name;
    
    @Column(name="product_description")
    private String description;
    
	@Column(name="product_price")
    private int price;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}

    
}
