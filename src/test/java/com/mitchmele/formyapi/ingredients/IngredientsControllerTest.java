package com.mitchmele.formyapi.ingredients;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitchmele.formyapi.ingredients.model.Ingredient;
import com.mitchmele.formyapi.ingredients.service.IngredientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class IngredientsControllerTest {

    @Mock
    private IngredientService service;

    @InjectMocks
    private IngredientsController controller;

    private MockMvc mockMvc;

    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void saveNewIngredient_shouldCalServiceToSaveValidIngredient() throws Exception {

        IngredientRequest request = IngredientRequest.builder().id("1").amount("4").title("Pepper").build();

        Ingredient newIngredient = Ingredient.builder().id(1).name("Pepper").amount(4).build();

        mockMvc
                .perform(post("/ingredient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request))
                )
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(newIngredient)));

        verify(service).saveIngredient(newIngredient);
    }
}