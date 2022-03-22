package com.rtb.therandomvalue.controllers;

import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;
import com.rtb.therandomvalue.models.entity.recipe.RecipeBO;
import com.rtb.therandomvalue.repositories.CategoryRepo;
import com.rtb.therandomvalue.repositories.RecipeRepo;
import com.rtb.therandomvalue.services.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.rtb.therandomvalue.utils.Constants.FOOD_RECIPES;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryRepo categoryRepo;

    @MockBean
    private RecipeService recipeService;

    @MockBean
    private RecipeRepo recipeRepo;

    @Test
    public void foodRecipeCategory() throws Exception {

        Recipe recipe = Recipe.builder()
                .id(1234567)
                .vegetarian(true)
                .build();

        when(recipeService.getRandomRecipeFromAPI("")).thenReturn(recipe);

        RecipeBO recipeBO = RecipeBO.builder()
                .id(recipe.getId())
                .isVeg(true)
                .build();

        when(recipeService.insertRecipeToDatabaseFromRecipeAPI(recipe)).thenReturn(recipeBO);

        mockMvc.perform(MockMvcRequestBuilders.get("/categories/" + FOOD_RECIPES))
                .andExpect(view().name("foodRecipes"))
                .andExpect(model().attributeExists("recipe"));

        verify(recipeService, times(1)).getRandomRecipeFromAPI("");
        verify(recipeService, times(1)).insertRecipeToDatabaseFromRecipeAPI(any());
    }
}