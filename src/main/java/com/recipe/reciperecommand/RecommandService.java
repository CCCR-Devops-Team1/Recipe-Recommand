package com.recipe.reciperecommand;

import com.recipe.reciperecommand.Dto.RecipeCardDto;
import com.recipe.reciperecommand.Dto.RecipeDto;
import com.recipe.reciperecommand.Dto.RecipesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
}
