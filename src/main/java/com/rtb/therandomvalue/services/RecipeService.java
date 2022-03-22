package com.rtb.therandomvalue.services;

import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;
import com.rtb.therandomvalue.models.entity.recipe.RecipeBO;

public interface RecipeService {

    Recipe getRandomRecipeFromAPI(String tags);

    RecipeBO getRecipeById(Long id);

    RecipeBO insertRecipeToDatabaseFromRecipeAPI(Recipe recipe);
}
