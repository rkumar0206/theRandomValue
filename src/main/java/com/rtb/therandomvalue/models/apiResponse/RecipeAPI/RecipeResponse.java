package com.rtb.therandomvalue.models.apiResponse.RecipeAPI;

import java.util.List;

public class RecipeResponse {

    private List<Recipe> recipes;

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}

