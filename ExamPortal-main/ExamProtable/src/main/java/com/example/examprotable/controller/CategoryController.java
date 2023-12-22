package com.example.examprotable.controller;

import com.example.examprotable.entities.exam.Category;
import com.example.examprotable.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        Category category1 = categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    @GetMapping("/{cid}")
    public ResponseEntity<?> getCategory(@RequestParam("cid") Long cid) {
        Category category = categoryService.getCategory(cid);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PutMapping("/")
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {
        Category category1 = categoryService.updateCategory(category);
        return ResponseEntity.ok(category1);
    }

    @DeleteMapping("/{cid}")
    public void deleteCategory(@RequestParam("cid") Long cid) {
        categoryService.deleteCategory(cid);
    }
}
