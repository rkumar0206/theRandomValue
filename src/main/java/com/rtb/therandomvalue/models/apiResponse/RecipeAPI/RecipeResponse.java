package com.rtb.therandomvalue.models.apiResponse.RecipeAPI;

import lombok.Data;

import java.util.List;

@Data
public class RecipeResponse {

    private List<Recipe> recipes;
}

