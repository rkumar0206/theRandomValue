package com.rtb.therandomvalue.models.apiResponse.RecipeAPI;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class AnalyzedInstruction {
    private String name;
    private ArrayList<Step> steps;

}
