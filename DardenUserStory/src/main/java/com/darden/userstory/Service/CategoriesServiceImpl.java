package com.darden.userstory.Service;

import com.darden.userstory.Entities.Category;
import com.darden.userstory.Entities.SubCategory;
import com.darden.userstory.Repositories.CategoriesRepository;
import com.darden.userstory.Repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@Transactional
public class CategoriesServiceImpl implements CategoriesService{

    @Autowired
    private CategoriesRepository repository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<Category> getCategories() {
        return repository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Category addSubCategory(String categoryName, SubCategory subCategory) throws Exception {
        Category category = repository.findByCategoryName(categoryName)
                .orElseThrow(()-> new Exception("Category not found"));
      List<SubCategory> subCategories =  category.getSubCategories();
        subCategories.add(subCategory);
        category.setSubCategories(subCategories);
        return repository.save(category);
    }

    @Override
    public SubCategory updateSubCategory( Long id, SubCategory subCategory) throws Exception {
        SubCategory category = subCategoryRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Id not found"));
        category.setFlagStatus(subCategory.isFlagStatus());
        category.setSubCategoryType(subCategory.getSubCategoryType());
        category.setEntreeItem(subCategory.getEntreeItem());
        return subCategoryRepository.save(category);
    }

    @Override
    public Boolean deleteSubCategory(Long categoryId, Long id) throws Exception {
        Category category = repository.findById(categoryId)
                .orElseThrow(()->new IllegalArgumentException("Category not found"));
       List<SubCategory> subCategory = category.getSubCategories();
        Predicate<SubCategory> pr = sub -> sub.getSubCategoryId() == id;
        subCategory.removeIf(pr);
        category.setSubCategories(subCategory);
        repository.save(category);
        return true;
    }

    @Override
    public Boolean deleteCategory(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<String> getAllCategoryName() {
        List<Category> categories = repository.findAll();
        List<String> categoryNameList = new ArrayList<>();
        for(Category category: categories){
            categoryNameList.add(category.getCategoryName());
        }
        return categoryNameList;
    }


}
