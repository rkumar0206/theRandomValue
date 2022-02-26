package com.rtb.therandomvalue.services;

import com.rtb.therandomvalue.models.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategoryList();

    Category getCategoryById(Long id);

}
