package com.nrt.service;

import java.util.List;

import com.nrt.entity.Product;


public interface ProductService {
	public void saveProduct(Product product);
	List<Product> getAllProduct();
	Product GetProductById(Long id);
	void deleteProduct(Long id);
	void updateProducts(Long id, Product product);
}
