package com.mitchmele.formyapi.meals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class MealServiceTest {

    @Mock
    private MealsRepository mealsRepository;

    @InjectMocks
    private MealService service;

    @Test
    void getAllMeals_shouldCallRepository() {
        service.getAllMeals();

        verify(mealsRepository).findAll();
    }

    @Test
    void getAllMeals_shouldReturnMealList() {
        MealItem meal1 = MealItem.builder().name("Shushi").build();
        MealItem meal2 = MealItem.builder().name("Burger").build();

        List<MealItem> expectedMeals = asList(meal1, meal2);
        when(mealsRepository.findAll()).thenReturn(expectedMeals);

        MealsResponse actual = service.getAllMeals();

        assertThat(actual).usingRecursiveComparison().isEqualTo(MealsResponse.builder().mealItems(expectedMeals).build());
    }

    @Test
    void getAllMeals_shouldThrowRuntimeException() {
        when(mealsRepository.findAll()).thenThrow(new RuntimeException("Something Bad"));

        assertThatThrownBy(() -> service.getAllMeals())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Something Bad");
    }
}