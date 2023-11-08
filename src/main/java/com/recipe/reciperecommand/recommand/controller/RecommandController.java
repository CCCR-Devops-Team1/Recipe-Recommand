package com.recipe.reciperecommand.recommand.controller;

import com.recipe.reciperecommand.global.dto.response.ResponseDto;
import com.recipe.reciperecommand.recommand.service.RecommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecommandController {
    private final RecommandService recommandService;
    // 검색어로 레시피 리스트 조회
    @GetMapping("/recommand")
    public ResponseDto searchKeyword(@RequestParam String keyword){
        return new ResponseDto(recommandService.searchKeyword("chicken").getResults());
    }
    @GetMapping("/recommand/{id}")
    public ResponseDto getRecipe(@PathVariable long id){
        return new ResponseDto(recommandService.getRecipe(id));
    }
    @PostMapping("/recommand/{id}")
    public ResponseDto getRecipeCard(@PathVariable long id){
        return new ResponseDto(recommandService.getRecipeCard(id));
    }
    @GetMapping("/recommand/random")
    public ResponseDto randomRecipes(){
        return new ResponseDto(recommandService.getRandomRecipes().getRecipes());
    }
}
