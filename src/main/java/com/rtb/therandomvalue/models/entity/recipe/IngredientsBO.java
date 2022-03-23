package com.rtb.therandomvalue.models.entity.recipe;

import lombok.*;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Embeddable
public class IngredientsBO {

    private String name;
    private String original;
    private double amount;
    private String consistency; // solid, liquid
    private String unit;
}
