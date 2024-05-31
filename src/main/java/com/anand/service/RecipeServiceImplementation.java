package com.anand.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.exceptions.RecipeException;
import com.anand.model.Recipe;
import com.anand.model.User;
import com.anand.repo.RecipeRepo;

@Service
public class RecipeServiceImplementation implements RecipeService {

	@Autowired
	private RecipeRepo recipeRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Recipe createRecipe(Recipe recipe, User user) {

		Recipe newRecipe = mapper.map(recipe, Recipe.class);
		newRecipe.setUser(user);
		newRecipe.setCreatedAt(LocalDateTime.now());
		return recipeRepo.save(newRecipe);
	}

	@Override
	public Recipe findRecipeById(Long id) throws RecipeException {
		return recipeRepo.findById(id).orElseThrow(() -> new RecipeException("Recipe not found with ID: " + id));
	}

	@Override
	public void deleteRecipe(Long id) throws RecipeException {
		Recipe recipe = findRecipeById(id);
		recipeRepo.delete(recipe);
	}

	@Override
	public Recipe updateRecipe(Recipe recipe, Long id) throws RecipeException {
		
		Recipe oldRecipe = findRecipeById(id);

		if (recipe.getDescription() != null) {
			oldRecipe.setDescription(recipe.getDescription());
		}
		if (recipe.getImage() != null) {
			oldRecipe.setImage(recipe.getImage());
		}
		if (recipe.getTitle() != null) {
			oldRecipe.setTitle(recipe.getTitle());
		}

		return recipeRepo.save(oldRecipe);
	}

	@Override
	public List<Recipe> findAllRecipe() {
		return recipeRepo.findAllByOrderByCreatedAtDesc();
	}

	@Override
	public Recipe likeRecipe(Long recipeId, User user) throws RecipeException {
		Recipe recipe=findRecipeById(recipeId);
		if(recipe.getLikes()==null) {
			recipe.setLikes(new ArrayList<>());
		}
		if(recipe.getLikes().contains(user.getId())) {
			recipe.getLikes().remove(user.getId());
		}
		else {
			recipe.getLikes().add(user.getId());
		}
		
		return recipeRepo.save(recipe);
	}

}
