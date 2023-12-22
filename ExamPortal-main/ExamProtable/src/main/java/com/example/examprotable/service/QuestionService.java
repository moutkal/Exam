package com.example.examprotable.service;

import com.example.examprotable.entities.exam.Question;
import com.example.examprotable.entities.exam.Quiz;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long quesid);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long quesid);
}
