package com.rtb.therandomvalue.models.entity.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class IngredientsBO {

    private String name;
    private String original;
    private double amount;
    private String unit;
}
