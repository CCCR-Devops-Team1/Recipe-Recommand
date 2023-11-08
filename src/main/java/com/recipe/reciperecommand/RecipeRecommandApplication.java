package com.recipe.reciperecommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RecipeRecommandApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecipeRecommandApplication.class, args);
    }
}
