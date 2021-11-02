package com.nimap.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Query;

import com.nimap.project.dao.CategoryRepository;
import com.nimap.project.model.Category;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategory(int pageNo, int pageSize) {
		Pageable firstPageWithTwoElements = PageRequest.of(pageNo, pageSize);

		List<Category> bookList = categoryRepository.findAll(firstPageWithTwoElements).getContent();
		
		//if (bookList.size() > 0) {
			return bookList;
		// } else {
		// 	return new ArrayList<Category>();
		// }
	}

	public Category getCategoryById(Long id) throws Exception {
		Optional<Category> book = categoryRepository.findById(id);

		if (book.isPresent()) {
			return book.get();
		} else {
			throw new Exception("No category record exist for given id");
		}
	}

	public String addOrUpdateCategory(Category entity) {

			entity = categoryRepository.save(entity);
			//categoryRepository.deleteById(entity.getCategoryId());

			return "success";
	}
	public String delCategory(Category category) {
		categoryRepository.deleteById(category.getCategoryId());
		return "success";
	}

}
