package com.mitchmele.formyapi.meals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class MealsControllerTest {

    @Mock
    private MealService mealService;

    @InjectMocks
    private MealsController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getMeals_shouldCallService() throws Exception {

            MealItem meal1 = MealItem.builder().name("Shushi").build();
            MealItem meal2 = MealItem.builder().name("Burger").build();

            List<MealItem> expectedMeals = asList(meal1, meal2);

        mockMvc.perform(get("/meals").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(mealService).getAllMeals();
    }
}