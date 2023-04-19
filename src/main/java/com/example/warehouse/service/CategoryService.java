package com.example.warehouse.service;


import com.example.warehouse.entity.Category;
import com.example.warehouse.payload.CategoryDto;
import com.example.warehouse.repository.CategoryRepository;
import com.example.warehouse.responce.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Result addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategoryId());

            if (!optionalCategory.isPresent()) return new Result("bunday categoriya mavjuda emas", false);

            category.setParentCategory(optionalCategory.get());
        }

        categoryRepository.save(category);
        return new Result("Muvaffaqiyatli saqlandi", true);

    }

    public Result getOneCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("Bunday kategoriya mavjud emas", false);

        Category category = optionalCategory.get();
        return new Result("Categoriya", true, category);
    }

    public Result getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return new Result("Category list", true, categories);
    }

    public Result updateCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("bunday category mavjud emas", false);
        Category category = optionalCategory.get();

        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalCategory1 = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalCategory1.isPresent()) return new Result("bunday categoriya mavjuda emas", false);
            category.setParentCategory(optionalCategory.get());
        }

        categoryRepository.save(category);
        return new Result("Muvaffaqiyatli saqlandi", true);

    }

    public Result deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return new Result("Category deleted", true);
    }
}
