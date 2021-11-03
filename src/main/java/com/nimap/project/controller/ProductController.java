package com.nimap.project.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import com.nimap.project.model.Product;
import com.nimap.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
    
    
	@GetMapping("")
	public List<Product> getAllProduct(@RequestParam(defaultValue = "0") int pageNo,@RequestParam(defaultValue = "10") int pageSize) throws MalformedURLException, IOException {
		return productService.getAllProduct(pageNo,pageSize);
	}
	@PostMapping("/add")
	public String addProduct(@RequestBody Product p ) throws MalformedURLException, IOException {
		return productService.addOrUpdateProduct(p);
	}
	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable(required=false,name="productId") long productId) throws MalformedURLException, IOException {
		return productService.deleteProduct(productId);
    }
	@PutMapping("/update")
	public String updateProduct(@RequestBody Product p ) throws MalformedURLException, IOException {
		return productService.addOrUpdateProduct(p);
	}
}
