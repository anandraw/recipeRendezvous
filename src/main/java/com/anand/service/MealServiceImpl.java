package com.anand.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anand.exceptions.MealException;
import com.anand.model.Meal;
import com.anand.model.User;
import com.anand.repo.MealRepository;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	private MealRepository mealRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Meal createMeal(Meal meal, User user) {
		return mealRepository.save(meal);
	}

	@Override
	public Meal updateMeal(Long id, Meal meal) throws MealException {
		Optional<Meal> existingMeal = mealRepository.findById(id);
		if (existingMeal.isPresent()) {
			Meal updatedMeal = existingMeal.get();
			updatedMeal.setDate(meal.getDate());
			updatedMeal.setRecipes(meal.getRecipes());
			return mealRepository.save(updatedMeal);
		} else {
			throw new RuntimeException("Meal not found with id " + id);
		}
	}

	@Override
	public void deleteMeal(Long id) throws MealException {
		mealRepository.deleteById(id);

	}

	@Override
	public Meal findMealById(Long id) throws MealException {
		return mealRepository.findById(id).orElseThrow(() -> new MealException("Meal not found with ID: " + id));
	}

	@Override
	public List<Meal> getAllMeals() {
		List<Meal> meal = this.mealRepository.findAll();
		return meal;
	}

}
