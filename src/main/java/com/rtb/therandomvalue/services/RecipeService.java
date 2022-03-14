package com.rtb.therandomvalue.services;

import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;

public interface RecipeService {

    Recipe getRandomRecipe(String tags);
}
