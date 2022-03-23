package com.rtb.therandomvalue.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.Recipe;
import com.rtb.therandomvalue.models.apiResponse.RecipeAPI.RecipeResponse;
import com.rtb.therandomvalue.models.entity.recipe.RecipeBO;
import com.rtb.therandomvalue.repositories.RecipeRepo;
import com.rtb.therandomvalue.utils.DbTableBuilder;
import com.rtb.therandomvalue.utils.MyStringUtils;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

@Service
@Slf4j
@NoArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private RestTemplate restTemplate;
    private RecipeRepo recipeRepo;
    private DbTableBuilder dbTableBuilder;

    @Value("${api.key.recipe}")
    private String recipeAPIKey;

    @Autowired
    public RecipeServiceImpl(RestTemplate restTemplate, RecipeRepo recipeRepo, DbTableBuilder dbTableBuilder) {
        this.restTemplate = restTemplate;
        this.recipeRepo = recipeRepo;
        this.dbTableBuilder = dbTableBuilder;
    }

    @Override
    public Recipe getRandomRecipeFromAPI(String tags) {

        String BASE_URL = "https://api.spoonacular.com/recipes/random?apiKey=" + recipeAPIKey;

        StringBuilder url = new StringBuilder(BASE_URL);

        if (MyStringUtils.isValid(tags)) {

            url.append("&tags=").append(tags);
        }

        log.info("Recipe api url : " + url);

        RecipeResponse recipeResponse = restTemplate.getForObject(url.toString(), RecipeResponse.class);

        if (recipeResponse != null && (recipeResponse.getRecipes() == null || recipeResponse.getRecipes().size() == 0)) {

            return null;
        }

        return recipeResponse.getRecipes().get(0);
    }

    @Override
    public RecipeBO getRecipeById(Long id) {

        RecipeBO recipeBO = null;

        Optional<RecipeBO> tempRecipeBO = recipeRepo.findById(id);

        if (tempRecipeBO.isPresent()) {

            recipeBO = tempRecipeBO.get();
        }

        return recipeBO;
    }

    @Override
    public RecipeBO insertRecipeToDatabaseFromRecipeAPI(Recipe recipe) {

        appendRecipeJsonToExternalFile(recipe);

        RecipeBO tempRecipeBO = getRecipeById((long) recipe.getId());

        if (tempRecipeBO == null) {

            // insert new recipe
            RecipeBO recipeBO = dbTableBuilder.buildRecipeBOFromRecipe(recipe);

            recipeRepo.save(recipeBO);

            log.info("Recipe saved to the database with id : " + recipeBO.getId());

            return recipeBO;
        } else {

            return tempRecipeBO;
        }
    }

    private void appendRecipeJsonToExternalFile(Recipe recipe) {

        try {
            FileWriter writer = new FileWriter("R:\\RecipeJson.txt", true);

            ObjectMapper mapper = new ObjectMapper();

            String recipeJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(recipe);

            writer.write("" + recipeJson);
            writer.write("\n\n------------------------\n\n");

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
