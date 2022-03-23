package com.rtb.therandomvalue.models.apiResponse.RecipeAPI;

import lombok.Data;

import java.util.ArrayList;

@Data
public class AnalyzedInstruction {
    private String name;
    private ArrayList<Step> steps;

}
