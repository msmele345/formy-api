package com.mitchmele.formyapi.meals;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MealsController {

    private final MealService mealService;

    @GetMapping("/meals")
    @CrossOrigin
    public ResponseEntity<MealsResponse> getMeals() {
        return ResponseEntity.ok(mealService.getAllMeals());
    }
}
