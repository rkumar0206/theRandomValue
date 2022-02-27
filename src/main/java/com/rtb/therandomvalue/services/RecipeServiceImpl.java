package com.rtb.therandomvalue.services;

import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;
import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.RecipeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RestTemplate restTemplate;

    @Override
    public Recipe getRandomRecipe(List<String> tags) {

        String BASE_URL = "https://api.spoonacular.com/recipes/random";

        StringBuilder url = new StringBuilder(BASE_URL);

        if (tags != null && !tags.isEmpty()) {

            url.append("?tags=").append(String.join(",", tags));
        }

        log.info("Recipe api url : " + url);

        RecipeResponse recipeResponse = restTemplate.getForObject(url.toString(), RecipeResponse.class);

        if (recipeResponse != null && (recipeResponse.getRecipes() == null || recipeResponse.getRecipes().size() == 0)) {

            return null;
        }

        return recipeResponse.getRecipes().get(0);
    }
}
