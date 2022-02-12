package com.rtb.therandomvalue.models;

import javax.persistence.*;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }
}
