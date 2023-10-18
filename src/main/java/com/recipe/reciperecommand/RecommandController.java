package com.recipe.reciperecommand;

import com.recipe.reciperecommand.Dto.RecipeDto;
import com.recipe.reciperecommand.Dto.Response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecommandController {
    private final RestTemplateService restTemplateService;
    @GetMapping("/")
    public ResponseEntity main(){
        return restTemplateService.getInfo();
    }
}
