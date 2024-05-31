package com.anand.service;

import java.util.List;

import com.anand.exceptions.RecipeException;
import com.anand.model.Recipe;
import com.anand.model.User;

public interface RecipeService {
	
	public Recipe createRecipe(Recipe recipe, User user);
	
	public Recipe findRecipeById(Long id) throws RecipeException;
	
	public void deleteRecipe(Long id) throws RecipeException;
	
	public Recipe updateRecipe(Recipe recipe,Long id) throws RecipeException;
	
	public List<Recipe> findAllRecipe();
	
	public Recipe likeRecipe(Long recipeId,User user) throws RecipeException;
}
