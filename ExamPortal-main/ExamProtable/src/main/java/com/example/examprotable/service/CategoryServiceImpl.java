package com.example.examprotable.service;

import com.example.examprotable.entities.exam.Category;
import com.example.examprotable.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long cid) {
        return categoryRepository.findById(cid).get();
    }

    @Override
    public void deleteCategory(Long cid) {
        categoryRepository.deleteById(cid);
    }
}
