package com.nimap.project.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimap.project.dao.CategoryRepository;
import com.nimap.project.model.Category;
import com.nimap.project.service.CategoryService;

@RestController
public class CategoryApplicationController {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryService categoryService;

	
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory(
		@RequestParam(defaultValue = "0") int pageNo,
		@RequestParam(defaultValue = "10") int pageSize
		) throws MalformedURLException, IOException {

		return categoryService.getAllCategory(pageNo,pageSize);
	}
	/*
	@PostMapping("/getCategoryById")
	public Category getCategoryById( @RequestBody Category category) throws Exception {

		return categoryService.getCategoryById(category.getCategoryId());
	}
	*/
/*
	@GetMapping("/{categoryID}")
	public Category getCategoryById(@PathVariable("categoryID") long categoryID) throws Exception {

		return categoryService.getCategoryById(categoryID);
	}
*/

	@RequestMapping("/addCategory")
	public String addCategory(@RequestBody Category category) throws MalformedURLException, IOException {

		return categoryService.addOrUpdateCategory(category);
	}

	@RequestMapping("/deleteCategory")
	public String deleteCategory(@RequestBody Category category) throws MalformedURLException, IOException {

		return categoryService.delCategory(category);
	}
	@RequestMapping("/updateCategory")
	public String updateProduct(@RequestBody Category category ) throws MalformedURLException, IOException {
		return categoryService.addOrUpdateCategory(category);
	}

}
