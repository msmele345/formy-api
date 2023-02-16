package com.mitchmele.formyapi.ingredients.service;

import com.mitchmele.formyapi.ingredients.IngredientRepository;
import com.mitchmele.formyapi.ingredients.model.Ingredient;
import com.mitchmele.formyapi.ingredients.model.IngredientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientResponse saveIngredient(Ingredient ingredient) {
        Ingredient newIngredient = ingredientRepository.save(ingredient);
        return IngredientResponse.builder().ingredient(newIngredient).message("Success").build();
    }
}
