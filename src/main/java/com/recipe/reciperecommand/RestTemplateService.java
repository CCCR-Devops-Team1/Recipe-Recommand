package com.recipe.reciperecommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.reciperecommand.Dto.RecipeDto;
import com.recipe.reciperecommand.Exception.BaseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import java.net.URI;

import static com.recipe.reciperecommand.Dto.Response.ResponseStatus.FAIL_JSON_MAPPING;
import static com.recipe.reciperecommand.Dto.Response.ResponseStatus.FAIL_JSON_PROCESS;

@Service
public class RestTemplateService {
    @Value("${recipe.app.id}")
    private String id ;
    @Value("${recipe.app.key}")
    private String key ;

    public ResponseEntity getInfo(){
        URI uri = UriComponentsBuilder
                .fromUriString("https://api.spoonacular.com/recipes/complexSearch?query=pasta&maxFat=25&number=2?apiKey="+"8784bdcd46ec4df48fd9fa0c5cd768d5")
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
//        ObjectMapper objectMapper = new ObjectMapper();
//        RecipeDto recipeDto = null;
//        try{
//           recipeDto = objectMapper.readValue(responseEntity.getBody(), RecipeDto.class);
//        }catch(JsonMappingException e){
//          e.printStackTrace();
//          throw new BaseException(FAIL_JSON_MAPPING);
//        }catch(JsonProcessingException e){
//          e.printStackTrace();
//          throw new BaseException(FAIL_JSON_PROCESS);
//        }
//        System.out.println(recipeDto);
        return responseEntity;

    }
}
