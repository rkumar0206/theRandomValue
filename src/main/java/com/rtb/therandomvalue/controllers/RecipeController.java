package com.rtb.therandomvalue.controllers;

import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;
import com.rtb.therandomvalue.services.RecipeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("/recipe/random")
    public ResponseEntity<Recipe> getRecipe(@RequestBody Tags tags) {

        log.info("Tags : " + tags.getTags());

        Recipe recipe = recipeService.getRandomRecipe(new ArrayList<>(tags.getTags()));

        if (recipe == null) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

}

@Getter
@Setter
class Tags {

    private List<String> tags;

}
