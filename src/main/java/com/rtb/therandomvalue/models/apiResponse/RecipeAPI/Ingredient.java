package com.rtb.therandomvalue.models.apiResponse.RecipeAPI;

import lombok.Data;

@Data
public class Ingredient {
    private int id;
    private String name;
    private String localizedName;
    private String image;

}
