package com.example.examprotable.repository;

import com.example.examprotable.entities.exam.Category;
import com.example.examprotable.entities.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    public List<Quiz> findByCategory(Category category);

    public List<Quiz> findByActive(Boolean b);

    public List<Quiz> findByCategoryAndActive(Category category, Boolean b);
}
