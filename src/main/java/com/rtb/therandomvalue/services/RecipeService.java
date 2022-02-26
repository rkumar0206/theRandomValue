package com.rtb.therandomvalue.services;

import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe getRandomRecipe(List<String> tags);
}
