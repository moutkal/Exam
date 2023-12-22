package com.example.examprotable.service;

import com.example.examprotable.entities.exam.Category;
import com.example.examprotable.entities.exam.Quiz;
import com.example.examprotable.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService{
    private QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(quizRepository.findAll());

    }

    @Override
    public Quiz getQuiz(Long qid) {
        return quizRepository.findById(qid).get();
    }

    @Override
    public void deleteQuiz(Long qid) {
        quizRepository.deleteById(qid);
    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return quizRepository.findByCategory(category);
    }

    @Override
    public List<Quiz> getActiveQuizzes() {
        return quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category category) {
        return quizRepository.findByCategoryAndActive(category,true);
    }
}
