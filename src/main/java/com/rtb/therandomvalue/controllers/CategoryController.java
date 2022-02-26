package com.rtb.therandomvalue.controllers;

import com.rtb.therandomvalue.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

import static com.rtb.therandomvalue.utils.Constants.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    //private Logger logger = LoggerFactory.getLogger(getClass());

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping()
    public ModelAndView categoriesHome() {

        return new ModelAndView("categories", "categories", categoryService.getCategoryList());
    }

    @RequestMapping("/" + NUMBERS_AND_ALPHABETS)
    public ModelAndView numberAndAlphabetsCategory() {

        return new ModelAndView("numbers_and_alphabets");
    }

    @RequestMapping("/" + DATES)
    public ModelAndView dateCategory() {

        return new ModelAndView("dates");
    }

    @RequestMapping("/" + FOOD_RECIPES)
    public ModelAndView foodRecipeCategory() {

        return new ModelAndView("foodRecipes");
    }

    @RequestMapping("/" + NUMBERS_AND_ALPHABETS + "/uuid")
    @ResponseBody
    public String getUUID() {

        return UUID.randomUUID().toString();
    }
}
