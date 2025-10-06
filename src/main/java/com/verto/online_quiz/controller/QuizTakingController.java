package com.verto.online_quiz.controller;

import com.verto.online_quiz.dto.quizTaking.FetchCompleteQuizDto;
import com.verto.online_quiz.service.QuizTakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/quizzes/")
public class QuizTakingController {
    //solve
    //to-solve
    //submissions
    @Autowired
    private QuizTakingService quizTakingService;

    @GetMapping("/{id}")
    public FetchCompleteQuizDto fetchQuiz(@PathVariable Long id){
        return quizTakingService.fetchQuiz(id);
    }
}
