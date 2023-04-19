package com.example.warehouse.controller;

import com.example.warehouse.payload.CategoryDto;
import com.example.warehouse.responce.Result;
import com.example.warehouse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/addCategory")
    public Result addCategory(@RequestBody CategoryDto categoryDto) {
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }


    @GetMapping("/getOneCategory/{id}")
    public Result getOneCategory(@PathVariable Integer id) {
        return categoryService.getOneCategory(id);
    }

    @GetMapping("/getAllCategories")
    public Result getAllCategories() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteCategory(@PathVariable Integer id) {
        return categoryService.deleteCategory(id);
    }

    @PutMapping("/updateCategory/{id}")
    public Result updateCategory(@PathVariable Integer id, CategoryDto categoryDto) {
        return categoryService.updateCategory(id, categoryDto);
    }

}
