package com.rtb.therandomvalue.models.apiResponse.RecipeAPI;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient {
    private int id;
    private String name;
    private String localizedName;
    private String image;

}
