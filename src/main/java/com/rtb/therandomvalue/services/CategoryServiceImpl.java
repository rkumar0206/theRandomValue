package com.rtb.therandomvalue.services;

import com.rtb.therandomvalue.models.entity.Category;
import com.rtb.therandomvalue.repositories.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepository;

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
