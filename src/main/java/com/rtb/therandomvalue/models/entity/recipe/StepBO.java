package com.rtb.therandomvalue.models.entity.recipe;

import lombok.*;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Embeddable
public class StepBO {

    private int number;
    private String stepName;
}
