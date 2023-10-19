package com.recipe.reciperecommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.reciperecommand.Dto.RecipeCardDto;
import com.recipe.reciperecommand.Dto.RecipeDto;
import com.recipe.reciperecommand.Dto.RecipesDto;
import com.recipe.reciperecommand.Dto.Response.ResponseDto;
import com.recipe.reciperecommand.Exception.BaseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static com.recipe.reciperecommand.Dto.Response.ResponseStatus.FAIL_JSON_MAPPING;
import static com.recipe.reciperecommand.Dto.Response.ResponseStatus.FAIL_JSON_PROCESS;

@Service
public class RestTemplateService {
    @Value("${recipe.app.key}")
    private String key ;
    public RecipesDto searchKeyword(String keyword) {
        String url = String.format("https://api.spoonacular.com/recipes/complexSearch?query=%s&apiKey=%s", keyword, key);
        ResponseEntity<String> responseEntity = requestApi(url);
        ObjectMapper objectMapper = new ObjectMapper();
        RecipesDto recipesDto = null;
        try{
            recipesDto = objectMapper.readValue(responseEntity.getBody(), RecipesDto.class);
        }catch(JsonMappingException e){
          e.printStackTrace();
          throw new BaseException(FAIL_JSON_MAPPING);
        }catch(JsonProcessingException e){
          e.printStackTrace();
          throw new BaseException(FAIL_JSON_PROCESS);
        }
        return recipesDto;
    }

    public RecipeDto getRecipe(long id) {
        String url = String.format("https://api.spoonacular.com/recipes/%d/summary?apiKey=%s", id, key);
        ResponseEntity<String> responseEntity = requestApi(url);
        ObjectMapper objectMapper = new ObjectMapper();
        RecipeDto recipeDto = null;
        try{
           recipeDto = objectMapper.readValue(responseEntity.getBody(), RecipeDto.class);
        }catch(JsonMappingException e){
          e.printStackTrace();
          throw new BaseException(FAIL_JSON_MAPPING);
        }catch(JsonProcessingException e){
          e.printStackTrace();
          throw new BaseException(FAIL_JSON_PROCESS);
        }
        return recipeDto;
    }

    public RecipeCardDto getRecipeCard(long id) {
        String url = String.format("https://api.spoonacular.com/recipes/%d/card?apiKey=%s", id, key);
        ResponseEntity<String> responseEntity = requestApi(url);
        ObjectMapper objectMapper = new ObjectMapper();
        RecipeCardDto recipeDto = null;
        try{
            recipeDto = objectMapper.readValue(responseEntity.getBody(), RecipeCardDto.class);
        }catch(JsonMappingException e){
          e.printStackTrace();
          throw new BaseException(FAIL_JSON_MAPPING);
        }catch(JsonProcessingException e){
          e.printStackTrace();
          throw new BaseException(FAIL_JSON_PROCESS);
        }
        return recipeDto;
    }

    public ResponseEntity requestApi(String url){
        URI uri = UriComponentsBuilder
                .fromUriString(url)
                .encode()
                .build()
                .toUri();
        HttpEntity<MultiValueMap<String,String>> tokenRequest = new HttpEntity<>(null);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                tokenRequest,
                String.class
        );
        return responseEntity;
    }
}
