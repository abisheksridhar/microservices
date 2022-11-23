package com.darden.userstory.Service;

import com.darden.userstory.Entities.Category;
import com.darden.userstory.Entities.SubCategory;

import java.util.List;

public interface CategoriesService {
    List<Category> getCategories();

    Category addCategory(Category category);

    Category addSubCategory(String categoryName, SubCategory subCategory) throws Exception;

    SubCategory updateSubCategory( Long id, SubCategory subCategory) throws Exception;

    Boolean deleteSubCategory(Long categoryName, Long id) throws Exception;

    Boolean deleteCategory(long id);

    List<String> getAllCategoryName();
}
