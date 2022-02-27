package com.rtb.therandomvalue.models.apiResponse.RecipeAPI;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Step {
    private int number;
    private String step;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Equipment> equipment;
    private Length length;
}
