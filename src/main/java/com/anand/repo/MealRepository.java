package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Long>{

}
