package com.example.examprotable.repository;

import com.example.examprotable.entities.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
