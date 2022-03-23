package com.rtb.therandomvalue.models.apiResponse.RecipeAPI;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Step {
    private int number;
    private String step;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Equipment> equipment;
    private Length length;
}
