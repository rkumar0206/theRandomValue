package com.rtb.therandomvalue.controllers;

import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;
import com.rtb.therandomvalue.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RecipeController {


    // todo : use this controller to get the random recipe and do something of tags

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/random")
    public ResponseEntity<Recipe> getRecipe() {

        return new ResponseEntity<>(recipeService.getRandomRecipe(new ArrayList<>()), HttpStatus.OK);
    }

}
