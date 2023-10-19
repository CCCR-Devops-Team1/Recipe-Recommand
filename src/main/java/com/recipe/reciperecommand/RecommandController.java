package com.recipe.reciperecommand;

import com.recipe.reciperecommand.Dto.RecipeDto;
import com.recipe.reciperecommand.Dto.Response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
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
}
