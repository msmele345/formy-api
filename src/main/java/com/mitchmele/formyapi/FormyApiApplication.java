package com.mitchmele.formyapi;

import com.mitchmele.formyapi.ingredients.IngredientRepository;
import com.mitchmele.formyapi.meals.MealsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {MealsRepository.class, IngredientRepository.class})
public class FormyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormyApiApplication.class, args);
	}

}
