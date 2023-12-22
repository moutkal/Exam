package com.example.examprotable.service;

import com.example.examprotable.entities.exam.Question;
import com.example.examprotable.entities.exam.Quiz;
import com.example.examprotable.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long quesid) {
        return questionRepository.findById(quesid).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return  questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesid) {
        questionRepository.deleteById(quesid);
    }
}
