package com.mitchmele.formyapi.ingredients.service;

import com.mitchmele.formyapi.ingredients.IngredientRepository;
import com.mitchmele.formyapi.ingredients.model.Ingredient;
import com.mitchmele.formyapi.ingredients.model.IngredientResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class IngredientServiceTest {

    @Mock
    private IngredientRepository repository;

    @InjectMocks
    private IngredientService service;

    @Test
    void saveIngredient_callsRepoSaveMethod() {

        Ingredient newIngredient = Ingredient.builder().name("Pepper").amount(4).build();

        service.saveIngredient(newIngredient);

        verify(repository).save(newIngredient);
    }

    @Test
    void saveIngredient_shouldReturnSuccessMessageAndEntitySaved() {
        Ingredient newIngredient = Ingredient.builder().name("Pepper").amount(4).build();
        when(repository.save(any())).thenReturn(newIngredient);

        IngredientResponse actual = service.saveIngredient(newIngredient);

        IngredientResponse expected = IngredientResponse.builder().ingredient(newIngredient).message("Success").build();
        assertThat(actual).isEqualTo(expected);
    }
}