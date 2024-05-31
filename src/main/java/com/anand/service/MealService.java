package com.anand.service;

import java.util.List;
import java.util.Optional;

import com.anand.exceptions.MealException;
import com.anand.exceptions.RecipeException;
import com.anand.model.Meal;
import com.anand.model.Recipe;
import com.anand.model.User;

public interface MealService {
	
	Meal createMeal(Meal meal, User user);
	
	Meal updateMeal(Long id, Meal meal) throws MealException;
	
	void deleteMeal(Long id) throws MealException;
	
	Meal findMealById(Long id) throws MealException;
	
	List<Meal> getAllMeals();

}
