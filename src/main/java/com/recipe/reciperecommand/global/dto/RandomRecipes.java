package com.recipe.reciperecommand.global.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomRecipes {
    public List<Recipe> recipes;
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Recipe{
        public List<Result> extendedIngredients;
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        static class Result{
            public long id;
            public String image;
            public String name;

        }
    }

}
