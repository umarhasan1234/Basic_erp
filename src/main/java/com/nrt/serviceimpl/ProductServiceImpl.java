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
	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct(Product product) {
		List<Product> pr=productRepository.findAll();
		return pr;
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
	public void updateProducts(Long id,Product productUpdate) {
	  productRepository.save(productUpdate);
	}

}
