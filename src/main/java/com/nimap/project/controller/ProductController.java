package com.nimap.project.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import com.nimap.project.model.Product;
import com.nimap.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
    
    
	@RequestMapping("/getAllProduct")
	public List<Product> getAllProduct(@RequestParam(defaultValue = "0") int pageNo,@RequestParam(defaultValue = "10") int pageSize) throws MalformedURLException, IOException {
		return productService.getAllProduct(pageNo,pageSize);
	}
		@RequestMapping("/addProduct")
	public String addProduct(@RequestBody Product p ) throws MalformedURLException, IOException {
		return productService.addOrUpdateProduct(p);
	}
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestBody Product p ) throws MalformedURLException, IOException {
		return productService.deleteProduct(p);
    }
	@RequestMapping("/updateProduct")
	public String updateProduct(@RequestBody Product p ) throws MalformedURLException, IOException {
		return productService.addOrUpdateProduct(p);
	}
}
