package com.nrt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		modelAndView.setViewName("/html/product/addProduct"); // View name without extension
		return modelAndView;
	}

	// this method add product
	@PostMapping("saveProduct")
	@ResponseBody
	public ModelAndView addProduct(@RequestBody Product product, ModelAndView modelAndView) {
		System.out.println(product);
		productImpl.saveProduct(product);
		modelAndView.addObject("message", "Product add successfull"); // Add model attributes
		modelAndView.setViewName("/html/product/addProduct"); // View name without extension
		return modelAndView;
	}

	// this method find all product
	@GetMapping("/listProduct")
	public ModelAndView findProduct(ModelAndView modelAndView) {
		List<Product> products = productImpl.getAllProduct();
		modelAndView.addObject("find Product", products);
		modelAndView.addObject("message", "Product show successfull");
		modelAndView.setViewName("/html/product/listProduct");
		return modelAndView;
	}

	// this method find product by id
	@GetMapping("/getProduct/{id}")
	public ModelAndView getProduct(@RequestParam("id") Long id, ModelAndView modelAndView) {
		Product products = productImpl.GetProductById(id);

		modelAndView.addObject("getProductById", products);
		modelAndView.setViewName("/html/product/listProduct");
		return modelAndView;
	}

	// this method delete product by id
	@DeleteMapping("/delete")
	public String deleteProduct(@RequestParam("id") Long id) {
		productImpl.deleteProduct(id);
		return "Delete Succussfully";
	}
<<<<<<< HEAD
	
	@RequestMapping("/updateProduct/{id}")
	public ModelAndView updateProduct(@RequestParam("id")Long id,@ModelAttribute("updateProduct") Product product,ModelAndView modelAndView) {
		productImpl.updateProducts(id,product);
		modelAndView.setViewName("/html/product/add_product"); // View name without extension
	     modelAndView.addObject("message", "Product update successfull"); // Add model attributes
	     return modelAndView;
=======

	@RequestMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam("id") Long id, @ModelAttribute("updateProduct") Product product,
			ModelAndView modelAndView) {
		productImpl.updateProducts(id, product);
		return null;
>>>>>>> 68f141b118c9ae03fcb6b025191a9d6166e652e6
	}
}
