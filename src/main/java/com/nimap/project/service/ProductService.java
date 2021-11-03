package com.nimap.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nimap.project.dao.ProductRepository;
import com.nimap.project.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(int pageNo,int pageSize) {
		Pageable firstPageWithTwoElements = PageRequest.of(pageNo, pageSize);

        List<Product> productList =  productRepository.findAll(firstPageWithTwoElements).getContent();

        // if (productList.size() > 0) {
			return productList;
		// } else {
		// 	return new ArrayList<Product>();
		// }
	}


	public Product getProductById(Long id) throws Exception {
		Optional<Product> book = productRepository.findById(id);

		if (book.isPresent()) {
			return book.get();
		} else {
			throw new Exception("No category record exist for given id");
		}
	}

	public String addOrUpdateProduct(Product p) {

			p = productRepository.save(p);
			//categoryRepository.deleteById(entity.getCategoryId());

			return "success";
	}
    
	public String deleteProduct(long productId) {

        productRepository.deleteById(productId);
        //categoryRepository.deleteById(entity.getCategoryId());

        return "success";
    }
}


