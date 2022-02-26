package com.rtb.therandomvalue.services;

import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;
import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.RecipeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RestTemplate restTemplate;

    public RecipeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Recipe getRandomRecipe(List<String> tags) {

        String BASE_URL = "https://api.spoonacular.com/recipes/random";

        StringBuilder url = new StringBuilder(BASE_URL);

        if (tags != null && !tags.isEmpty()) {

            url.append(BASE_URL).append("?tags=").append(tags.get(0));

            if (tags.size() > 1) {

                for (int i = 1; i < tags.size(); i++) {

                    url.append("&").append(tags.get(i));
                }
            }
        }

        RecipeResponse recipeResponse = restTemplate.getForObject(url.toString(), RecipeResponse.class);

        return recipeResponse.getRecipes().get(0);
    }
}
