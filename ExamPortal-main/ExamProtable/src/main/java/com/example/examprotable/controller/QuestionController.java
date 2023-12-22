package com.example.examprotable.controller;

import com.example.examprotable.entities.exam.Question;
import com.example.examprotable.entities.exam.Quiz;
import com.example.examprotable.service.QuestionService;
import com.example.examprotable.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {

    private QuestionService questionService;
    private QuizService  quizService;

    @PostMapping("/")
    public ResponseEntity<?> addQuestion (@RequestBody Question question){
        Question question1 = questionService.addQuestion(question);
        return ResponseEntity.ok(question1);
    }
    @PutMapping("/")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question){
        Question question1 = questionService.updateQuestion(question);
        return ResponseEntity.ok(question1);
    }
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?>getQuestionsOfQuiz(@RequestParam("qid") Long qid){
        /////////TEST sanns utilise getQuestionsOfQuiz mais avec  getQuestions/////////////////
        Quiz quiz =quizService.getQuiz(qid);
        Set<Question> questions =questionService.getQuestionsOfQuiz(quiz);
        List<Question> list = new ArrayList<>(questions);
        /////////////TEST SANS IF////////////////////////
        if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);

    }
    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid) {
        //////////Test sans quizService////////////////////////
        /*Quiz quiz=new Quiz();
        quiz.setQid(qid);*/
        Quiz quiz =quizService.getQuiz(qid);
        Set<Question> questionsofQuiz=questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionsofQuiz);

    }

    @GetMapping("/{quesid}")
    public ResponseEntity<Question> getQuestion(@RequestParam("quesid") Long quesid) {

        return ResponseEntity.ok(questionService.getQuestion(quesid));
    }

    @DeleteMapping("/{quesid}")
    public void deleteQuestion(@RequestParam("quesid") Long quesid) {
        questionService.deleteQuestion(quesid);
    }
}
