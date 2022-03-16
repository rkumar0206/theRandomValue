package com.rtb.therandomvalue.models.entity.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RECIPE")
public class RecipeBO {

    @Id
    private long id;
    private boolean isVeg;
    private boolean isCheap;
    private boolean isVeryHealthy;
    private String title;
    private String creditText;
    private String licence;
    private String sourceName;
    private String sourceUrl;

    @ElementCollection
    @CollectionTable(name = "recipe_steps", joinColumns = @JoinColumn(name = "recipe_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "number", column = @Column(name = "number")),
            @AttributeOverride(name = "stepName", column = @Column(name = "step_name"))
    })
    private List<StepBO> steps;

    @ElementCollection
    @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    private List<IngredientsBO> ingredients;
}
