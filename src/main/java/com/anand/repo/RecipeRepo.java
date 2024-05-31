package com.anand.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.model.Recipe;

public interface RecipeRepo extends JpaRepository<Recipe, Long>{
	
	List<Recipe> findAllByOrderByCreatedAtDesc();
	
	

}
