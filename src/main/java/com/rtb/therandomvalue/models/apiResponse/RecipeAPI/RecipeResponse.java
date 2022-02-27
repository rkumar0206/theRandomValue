package com.rtb.therandomvalue.models.apiResponse.RecipeAPI;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeResponse {

    private List<Recipe> recipes;
}

