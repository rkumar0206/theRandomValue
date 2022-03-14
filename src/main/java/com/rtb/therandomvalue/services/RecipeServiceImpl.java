package com.rtb.therandomvalue.services;

import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;
import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.RecipeResponse;
import com.rtb.therandomvalue.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key.recipe}")
    private String recipeAPIKey;

    @Override
    public Recipe getRandomRecipe(String tags) {

        String BASE_URL = "https://api.spoonacular.com/recipes/random?apiKey=" + recipeAPIKey;

        StringBuilder url = new StringBuilder(BASE_URL);

        if (StringUtils.isValid(tags)) {

            url.append("&tags=").append(tags);
        }

        log.info("Recipe api url : " + url);

        RecipeResponse recipeResponse = restTemplate.getForObject(url.toString(), RecipeResponse.class);

        if (recipeResponse != null && (recipeResponse.getRecipes() == null || recipeResponse.getRecipes().size() == 0)) {

            return null;
        }

        return recipeResponse.getRecipes().get(0);
    }
}
