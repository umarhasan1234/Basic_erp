package com.nrt.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrt.entity.Product;
import com.nrt.repository.ProductRepository;
import com.nrt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void saveAllProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		productRepository.findAll();
		return productRepository.findAll();
	}
	
	@Override
	public Product GetProductById(Long id) {
		Optional<Product> findById = productRepository.findById(id);
		return findById.get();
	}
	
	@Override
	public void deleteProduct(Long id) {
	  productRepository.deleteById(id);
	}
	@Override
	public void updateProducts(Product productUpdate) {
	  productRepository.save(productUpdate);
	}

}
