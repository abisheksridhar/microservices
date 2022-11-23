package com.darden.userstory.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.darden.userstory.Service.CategoriesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CategoriesController.class})
@ExtendWith(SpringExtension.class)
class CategoriesControllerTest {
    @Autowired
    private CategoriesController categoriesController;

    @MockBean
    private CategoriesService categoriesService;

    @Test
    void testDeleteSubCategory() throws Exception {
        when(this.categoriesService.deleteSubCategory((Long) any(), (Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/Categories/deleteSubCategory/");
        MockHttpServletRequestBuilder paramResult = deleteResult.param("categoryId", String.valueOf(1L));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("id", String.valueOf(1L));
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.categoriesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    @Test
    void testDeleteSubCategory2() throws Exception {
        when(this.categoriesService.deleteSubCategory((Long) any(), (Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/Categories/deleteSubCategory/");
        MockHttpServletRequestBuilder paramResult = deleteResult.param("categoryId", String.valueOf(1L));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("id", String.valueOf(1L));
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.categoriesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }
}

