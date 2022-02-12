package com.rtb.therandomvalue.controllers;

import com.rtb.therandomvalue.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.rtb.therandomvalue.utils.Constants.NUMBERS_AND_ALPHABETS;

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
    public ModelAndView selectedCategory() {

        return new ModelAndView("numbers_and_alphabets");
    }
}
