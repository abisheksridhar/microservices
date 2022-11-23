package com.darden.userstory.Controller;

import com.darden.userstory.Entities.Category;
import com.darden.userstory.Entities.SubCategory;
import com.darden.userstory.Service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriesController {

    @Autowired
    private CategoriesService service;

    @GetMapping("/get")
    public ResponseEntity getCategories(){
        return ResponseEntity.status(200).body(service.getCategories());
    }

    @PostMapping("/addCategory")
    public ResponseEntity addCategory(@RequestBody Category category){
        service.addCategory(category);
        return ResponseEntity.status(200).body("added");
    }

    @PostMapping("/addSubCategory/{categoryName}")
    public  ResponseEntity addSubCategory(@PathVariable("categoryName") String categoryName, @RequestBody SubCategory subCategory) throws Exception {
        service.addSubCategory(categoryName,subCategory);
        return ResponseEntity.status(200).body("added");
    }

    @PutMapping("/updateSubCategory/{id}")
    public  ResponseEntity updateSubCategory(@PathVariable("id") Long id,@RequestBody SubCategory subCategory) throws Exception {
        service.updateSubCategory(id,subCategory);
        return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/deleteSubCategory/")
    public  ResponseEntity deleteSubCategory(@RequestParam Long categoryId,@RequestParam Long id) throws Exception {
        service.deleteSubCategory(categoryId,id);
        return ResponseEntity.status(200).body("deleted");
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity deleteCategory(@PathVariable("id") long id){
        service.deleteCategory(id);
        return ResponseEntity.status(200).body("deleted");
    }

    @GetMapping("/getCategoryNames")
    public ResponseEntity getCategoryNames(){
        return ResponseEntity.status(200).body(service.getAllCategoryName());
    }
}
