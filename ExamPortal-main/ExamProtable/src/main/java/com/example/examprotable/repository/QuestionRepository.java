package com.example.examprotable.repository;

import com.example.examprotable.entities.exam.Question;
import com.example.examprotable.entities.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);

}
