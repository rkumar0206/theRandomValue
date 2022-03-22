package com.rtb.therandomvalue.controllers;

import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;
import com.rtb.therandomvalue.models.entity.recipe.RecipeBO;
import com.rtb.therandomvalue.services.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.rtb.therandomvalue.utils.Constants.FOOD_RECIPES;

@Slf4j
@AllArgsConstructor
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    // todo : remove this method after a while
    @GetMapping("/recipe/random")
    public ResponseEntity<RecipeBO> getRecipe(@RequestParam Optional<String> tags) {

        Recipe recipe;

        if (tags.isPresent()) {

            recipe = recipeService.getRandomRecipeFromAPI(tags.get());

        } else {

            recipe = recipeService.getRandomRecipeFromAPI("");
        }

        if (recipe == null) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(recipeService.insertRecipeToDatabaseFromRecipeAPI(recipe), HttpStatus.OK);
    }

    @GetMapping("/categories/" + FOOD_RECIPES)
    public ModelAndView foodRecipeCategory(@RequestParam Optional<String> tags) {

        Recipe recipe = null;

//        if (tags.isPresent()) {
//
//            recipe = recipeService.getRandomRecipeFromAPI(tags.get());
//        } else {
//
//            recipe = recipeService.getRandomRecipeFromAPI("");
//        }

        Map<String, Object> recipeMap = new HashMap<>();

        if (recipe == null) {

            recipeMap.put("isResultValid", false);
        } else {

            RecipeBO recipeBO = recipeService.insertRecipeToDatabaseFromRecipeAPI(recipe);

            recipeMap.put("isResultValid", true);
            recipeMap.put("recipe", recipeBO);
        }

        return new ModelAndView("foodRecipes", "recipe", recipeMap);
    }

}