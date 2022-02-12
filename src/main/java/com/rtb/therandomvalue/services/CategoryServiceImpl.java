package com.rtb.therandomvalue.services;

import com.rtb.therandomvalue.models.Category;
import com.rtb.therandomvalue.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepository;

    @Autowired  // work even if not specified
    public CategoryServiceImpl(CategoryRepo categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {

        Category category = null;

        Optional<Category> tempCategory = categoryRepository.findById(id);

        if (tempCategory.isPresent()) {

            category = tempCategory.get();
        }

        return category;
    }
}
