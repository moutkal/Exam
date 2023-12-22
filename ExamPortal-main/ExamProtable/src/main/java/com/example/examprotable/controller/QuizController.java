package com.example.examprotable.controller;

import com.example.examprotable.entities.exam.Category;
import com.example.examprotable.entities.exam.Quiz;
import com.example.examprotable.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@AllArgsConstructor
@RequestMapping("/quiz")

public class QuizController {

    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {

        return ResponseEntity.ok(quizService.addQuiz(quiz));
    }

    @GetMapping("/{qid}")
    public ResponseEntity<?> getQuiz(@RequestParam("qid") Long qid) {
        Quiz quiz = quizService.getQuiz(qid);
        return ResponseEntity.ok(quiz);
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuizzes() {
        return ResponseEntity.ok(quizService.getQuizzes());
    }

    @PutMapping("/")
    public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz) {
        Quiz quiz1 = quizService.updateQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }

    @DeleteMapping("/{qid}")
    public void deleteQuiz(@RequestParam("qid") Long qid) {
        quizService.deleteQuiz(qid);
    }


    @GetMapping("category/{cid}")
    public List<Quiz> getQuizzesOfCategory(@RequestParam("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getQuizzesOfCategory(category);
    }

    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes() {
        return quizService.getActiveQuizzes();
    }

    @GetMapping("/category/active/{cid}")
    public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return quizService.getActiveQuizzesOfCategory(category);
    }
}
