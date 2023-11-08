package com.recipe.reciperecommand.global.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipesDto{
    public List<Result> results;
    public int offset;
    public int number;
    public int totalResults;
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Result{
        public long id;
        public String title;
        public String image;
        public String imageType;
    }
}