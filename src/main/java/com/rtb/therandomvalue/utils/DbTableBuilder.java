package com.rtb.therandomvalue.utils;

import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.ExtendedIngredient;
import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;
import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Step;
import com.rtb.therandomvalue.models.entity.recipe.IngredientsBO;
import com.rtb.therandomvalue.models.entity.recipe.RecipeBO;
import com.rtb.therandomvalue.models.entity.recipe.StepBO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DbTableBuilder {


    public static IngredientsBO buildIngredientBO(ExtendedIngredient ingredient) {

        return IngredientsBO.builder()
                .amount(ingredient.getAmount())
                .name(ingredient.getName())
                .original(ingredient.getOriginal())
                .unit(ingredient.getUnit())
                .build();

    }

    public static StepBO buildStepBO(Step step) {

        return StepBO.builder().stepName(step.getStep()).number(step.getNumber()).build();

    }


    public RecipeBO buildRecipeBOFromRecipe(Recipe recipe) {

        return RecipeBO.builder()
                .id(recipe.getId())
                .creditText(recipe.getCreditsText())
                .ingredients(recipe.getExtendedIngredients().stream().map(DbTableBuilder::buildIngredientBO).collect(Collectors.toList()))
                .isCheap(recipe.isCheap())
                .isVeg(recipe.isVegetarian())
                .isVeryHealthy(recipe.isVeryHealthy())
                .licence(recipe.getLicense())
                .sourceName(recipe.getSourceName())
                .sourceUrl(recipe.getSourceUrl())
                .steps(recipe.getAnalyzedInstructions().get(0).getSteps().stream()
                        .map(DbTableBuilder::buildStepBO)
                        .collect(Collectors.toList()))
                .title(recipe.getTitle())
                .build();
    }
}
