package com.mitchmele.formyapi.ingredients;

import com.mitchmele.formyapi.ingredients.model.Ingredient;
import com.mitchmele.formyapi.ingredients.model.IngredientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class IngredientsController {

    @PostMapping("/ingredient")
    public ResponseEntity<IngredientResponse> saveNewIngredient(@RequestBody IngredientRequest request) {
        return ResponseEntity.ok().build();
    }


    private Ingredient mapIngredient(IngredientRequest ingredientRequest) {
        return Ingredient.builder().build(); //TODO
    }
}
