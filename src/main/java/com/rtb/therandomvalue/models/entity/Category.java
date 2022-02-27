package com.rtb.therandomvalue.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "category_table")
public class Category {

    @Id
    @GeneratedValue
    private Long categoryId;

    @Column(length = 50, unique = true)
    private String categoryName;
    private String categoryImageUrl;

    public Category() {
    }

    public Category(String categoryName, String categoryImageUrl) {
        this.categoryName = categoryName;
        this.categoryImageUrl = categoryImageUrl;
    }
}
