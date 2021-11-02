package com.nimap.project.dao;


import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import com.nimap.project.dto.CategoryDto;
import com.nimap.project.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    
}
