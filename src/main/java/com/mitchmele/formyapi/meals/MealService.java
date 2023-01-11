package com.mitchmele.formyapi.meals;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealsRepository repository;

    public MealsResponse getAllMeals() {
        try {
           return MealsResponse.builder().mealItems(repository.findAll()).build();
        } catch (Throwable e) {
            throw new RuntimeException("Something Bad");
        }
    }
}
