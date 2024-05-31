package com.anand.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anand.exceptions.MealException;
import com.anand.exceptions.UserException;
import com.anand.model.Meal;
import com.anand.model.User;
import com.anand.responce.ApiResponce;
import com.anand.service.MealService;
import com.anand.service.UserService;

@RestController
@RequestMapping("/api/meals")
public class MealPlanController {

	@Autowired
	private MealService mealService;

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<Meal> createMeal(@RequestBody Meal meal, @RequestHeader("Authorization") String jwt)
			throws UserException {
		User user = userService.findUserProfileByJwt(jwt);
		Meal newMeal = mealService.createMeal(meal, user);
		return new ResponseEntity<>(newMeal, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Meal> getMealById(@PathVariable("id") Long id) throws MealException {
		Meal meal = mealService.findMealById(id);
		return new ResponseEntity<>(meal, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Meal>> getAllMeals() throws MealException {
		List<Meal> allMeals = mealService.getAllMeals();
		return new ResponseEntity<>(allMeals, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponce> deleteMeal(@PathVariable("id") Long id) throws MealException {
		mealService.deleteMeal(id);
		ApiResponce api = new ApiResponce("Meal is deleted", true);
		return new ResponseEntity<>(api, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Meal> updateMeal(@PathVariable("id") Long id, @RequestBody Meal meal) throws MealException {
		Meal updatedMeal = mealService.updateMeal(id, meal);
		return new ResponseEntity<>(updatedMeal, HttpStatus.OK);
	}
}