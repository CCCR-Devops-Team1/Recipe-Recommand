package com.recipe.reciperecommand.recommand.service;

import com.recipe.reciperecommand.global.dto.RandomRecipes;
import com.recipe.reciperecommand.global.dto.RecipeCardDto;
import com.recipe.reciperecommand.global.dto.RecipeDto;
import com.recipe.reciperecommand.global.dto.RecipesDto;
import com.recipe.reciperecommand.global.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommandService {
    private final RestTemplateService restTemplateService;

    public RecipesDto searchKeyword(String keyword){
        return restTemplateService.searchKeyword(keyword);
    }

    public RecipeDto getRecipe(long id) {
        return restTemplateService.getRecipe(id);
    }

    public RecipeCardDto getRecipeCard(long id) {
        return restTemplateService.getRecipeCard(id);
    }

    public RandomRecipes getRandomRecipes() { return restTemplateService.getRandomRecipes();
    }
}
