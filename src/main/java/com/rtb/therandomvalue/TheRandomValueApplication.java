package com.rtb.therandomvalue;

import com.rtb.therandomvalue.models.Category;
import com.rtb.therandomvalue.repositories.CategoryRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

import static com.rtb.therandomvalue.utils.Constants.*;

@SpringBootApplication
public class TheRandomValueApplication {

    private final CategoryRepo categoryRepo;

    public TheRandomValueApplication(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(TheRandomValueApplication.class, args);
    }

    @PostConstruct
    private void insertCategories() {

        categoryRepo.save(new Category(NUMBERS_AND_ALPHABETS, ""));
        categoryRepo.save(new Category(DATES, ""));
        categoryRepo.save(new Category(FOOD_RECIPES, ""));
        categoryRepo.save(new Category(IMAGES, ""));
        categoryRepo.save(new Category(SHOPPING, ""));
        categoryRepo.save(new Category(GITHUB_REPOSITORIES, ""));
        categoryRepo.save(new Category(COLORS, ""));
        categoryRepo.save(new Category(VIDEOS, ""));
        categoryRepo.save(new Category(ARTICLES, ""));
    }
}
