package com.example.examprotable.service;

import com.example.examprotable.entities.exam.Category;

import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);

    public Category updateCategory(Category category);

    public Set<Category> getCategories();

    public Category getCategory(Long cid);

    public void deleteCategory(Long cid);
}
