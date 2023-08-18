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

	
	//this method redirect product page
	@RequestMapping("/product")
	public ModelAndView defaultMethod(ModelAndView modelAndView) {
	 modelAndView.setViewName("/html/product/add_product"); // View name without extension
     return modelAndView;
	}
	
	//this method add product
	@PostMapping("saveProduct")
	public ModelAndView addProduct(@ModelAttribute("addProduct") Product product,ModelAndView modelAndView) {
		productImpl.saveProduct(product);
		modelAndView.setViewName("/html/product/add_product"); // View name without extension
	     modelAndView.addObject("message", "Product add successfull"); // Add model attributes
	     return modelAndView;
	}
	
	// this method find all product 
	@GetMapping("/findProduct")
	public ModelAndView findProduct(@ModelAttribute("findProduct") Product product,ModelAndView modelAndView) {
		List<Product> pr=productImpl.getAllProduct(product);
		 modelAndView.setViewName("/html/product/product_list");
		 modelAndView.addObject("find Product", pr);
		 modelAndView.addObject("message", "Product show successfull");
		return modelAndView;
	}
	
	
	// this method find product by id
	@GetMapping("/getProduct/{id}")
	public ModelAndView getProduct(@RequestParam("id")Long id,ModelAndView modelAndView) {
		Product pr=productImpl.GetProductById(id);
		modelAndView.setViewName("/html/product/product_list");
		modelAndView.addObject("getProductById", pr);
		return modelAndView ;
	}
	
	
	//this method delete product by id
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@RequestParam("id")Long id) {
		productImpl.deleteProduct(id);
		return "Delete Succussfully" ;
	}
	
	@RequestMapping("/updateProduct/{id}")
	public ModelAndView updateProduct(@RequestParam("id")Long id,@ModelAttribute("updateProduct") Product product,ModelAndView modelAndView) {
		productImpl.updateProducts(id,product);
		modelAndView.setViewName("/html/product/add_product"); // View name without extension
	     modelAndView.addObject("message", "Product update successfull"); // Add model attributes
	     return modelAndView;
	}
}
