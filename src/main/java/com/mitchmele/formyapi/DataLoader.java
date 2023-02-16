package com.mitchmele.formyapi;

import com.mitchmele.formyapi.ingredients.IngredientRepository;
import com.mitchmele.formyapi.ingredients.model.Ingredient;
import com.mitchmele.formyapi.meals.MealItem;
import com.mitchmele.formyapi.meals.MealsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {

    private final MealsRepository repository;
    private final IngredientRepository ingredientRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        MealItem meal1 = MealItem.builder().name("Shushi").description("Fire Asian").price(45.05).build();
        MealItem meal2 = MealItem.builder().name("Burger").description("Pub Food").price(20.15).build();
        MealItem meal3 = MealItem.builder().name("Pizza").description("Deep Dish").price(55.25).build();
        MealItem meal4 = MealItem.builder().name("Chicek Fingers").description("Crispy nugs").price(5.05).build();

        Ingredient newIngredient1 = Ingredient.builder().name("Pepper").amount(4).build();
        Ingredient newIngredient2 = Ingredient.builder().name("Onion").amount(3).build();
        Ingredient newIngredient3 = Ingredient.builder().name("Chicken").amount(1).build();
        Ingredient newIngredient4 = Ingredient.builder().name("Broccoli").amount(2).build();


        List<MealItem> expectedMeals = asList(meal1, meal2, meal3, meal4);
        List<Ingredient> expectedIngredients = asList(newIngredient1, newIngredient2, newIngredient3, newIngredient4);

        repository.deleteAll();
        ingredientRepository.deleteAll();

        ingredientRepository.saveAll(expectedIngredients);

        repository.saveAll(expectedMeals);
    }

}
