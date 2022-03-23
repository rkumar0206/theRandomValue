package com.rtb.therandomvalue.models.apiResponse.RecipeAPI;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ExtendedIngredient {
    private int id;
    private String aisle;
    private String image;
    private String consistency;
    private String name;
    private String nameClean;
    private String original;
    private String originalName;
    private double amount;
    private String unit;
    private ArrayList<String> meta;
    private Measures measures;
}
