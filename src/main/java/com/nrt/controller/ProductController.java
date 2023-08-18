package com.nrt.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nrt.entity.Product;
import com.nrt.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productImpl;

	// this method redirect product page
	@RequestMapping("/product")
	public ModelAndView defaultMethod(ModelAndView modelAndView) {
		modelAndView.setViewName("/html/product/add_Product"); // View name without extension
		return modelAndView;
	}

	// this method add product
	@RequestMapping("/saveProduct")
	public ModelAndView addProduct(@ModelAttribute Product product, ModelAndView modelAndView) {
		System.out.println(product);
		productImpl.saveAllProduct(product);
		modelAndView.addObject("message", "Product add successfull"); // Add model attributes
		modelAndView.setViewName("/html/product/add_Product"); // View name without extension
		return modelAndView;
	}

	// this method find all product
	@GetMapping("/listProduct")
	public ModelAndView findProduct(ModelAndView modelAndView) {
		List<Product> products = productImpl.getAllProduct();
		modelAndView.addObject("products", products);
		modelAndView.setViewName("/html/product/list_product");
		return modelAndView;
	}

	// this method find product by id
	@GetMapping("/getProduct/")
	public ModelAndView getProduct(@RequestParam("id") Long id, ModelAndView modelAndView) {
		Product products = productImpl.GetProductById(id);

		modelAndView.addObject("getProductById", products);
		modelAndView.setViewName("/html/product/list_product");
		return modelAndView;
	}

	// this method delete product by id
	@GetMapping("/delete/")
	public ModelAndView deleteProduct(@RequestParam("id") Long id, ModelAndView modelAndView) {
		
		productImpl.deleteProduct(id);
		
		List<Product> products = productImpl.getAllProduct();
		modelAndView.addObject("products", products);
		modelAndView.setViewName("/html/product/list_product");
		return modelAndView;
	}

	//update product call by id
	@GetMapping("/updateById/")
	public ModelAndView updateProduct(@RequestParam("id")Long id,@ModelAttribute Product product,ModelAndView modelAndView) {
		System.out.println("before first update ");
		modelAndView.addObject("product", product);
	     modelAndView.setViewName("/html/product/update_product"); // View name without extension
	     return modelAndView;
	     
	}
//	//update product 
	@RequestMapping("/updateProduct")
	public ModelAndView updateProduct(@ModelAttribute Product product,ModelAndView modelAndView) {
		System.out.println("before update ");
		productImpl.updateProducts(product);
		System.out.println("after update ");
		modelAndView.addObject("products", product);
		modelAndView.setViewName("/html/product/list_product");
		return modelAndView;
	     
	}
}
