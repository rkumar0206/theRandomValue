package com.rtb.therandomvalue.controllers;

import com.rtb.therandomvalue.models.entity.Category;
import com.rtb.therandomvalue.repositories.CategoryRepo;
import com.rtb.therandomvalue.services.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static com.rtb.therandomvalue.utils.Constants.*;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    private final String base_url = "/categories";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CategoryService categoryService;
    @MockBean
    private CategoryRepo categoryRepo;

    @Test
    public void categoriesHomeTest() throws Exception {

        when(categoryService.getCategoryList()).thenReturn(
                Arrays.asList(new Category("test1", ""), new Category("test2", ""))
        );

        mockMvc.perform(MockMvcRequestBuilders.get(base_url))
                .andExpect(status().isOk())
                .andExpect(view().name("categories"))
                .andExpect(model().attribute("categories", hasSize(2)));

        verify(categoryService, times(1)).getCategoryList();
    }


    @Test
    public void numberAndAlphabetsCategoryTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(base_url + "/" + NUMBERS_AND_ALPHABETS))
                .andExpect(status().isOk())
                .andExpect(view().name("numbers_and_alphabets"));

    }

    @Test
    public void imagesCategoryTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(base_url + "/" + IMAGES))
                .andExpect(status().isOk())
                .andExpect(view().name("images"));

    }


    @Test
    public void dateCategory() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(base_url + "/" + DATES))
                .andExpect(status().isOk())
                .andExpect(view().name("dates"));

    }

    @Test
    public void getUUID() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/categories/" + NUMBERS_AND_ALPHABETS + "/uuid");

        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        String contentString = result.getResponse().getContentAsString();

        Assert.assertNotNull(contentString);

        Assert.assertEquals(36, contentString.length());

    }

}