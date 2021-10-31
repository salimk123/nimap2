package com.nimap.project.model;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nimap.project.dto.CategoryDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Category {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long categoryId;
	
	private String categoryName;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
	cascade = CascadeType.ALL)
	private Set<Product> products;
	public  Category(long categoryId, String categoryName){
		this.categoryName=categoryName;
		this.categoryId=categoryId;

	}

}
