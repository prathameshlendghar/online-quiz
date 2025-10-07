package com.verto.online_quiz.controller;

import com.verto.online_quiz.dto.quizManagement.CorrectAnswerResponseDto;
import com.verto.online_quiz.dto.quizTaking.FetchCompleteQuizDto;
import com.verto.online_quiz.dto.quizTaking.FetchSubmitQuizScoreDto;
import com.verto.online_quiz.dto.quizTaking.SubmitQuizRequestDto;
import com.verto.online_quiz.entity.CorrectAnswer;
import com.verto.online_quiz.service.QuizTakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/quizzes/take/")
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

    @PostMapping
    public FetchSubmitQuizScoreDto submitQuizScoreDto(@RequestBody SubmitQuizRequestDto request){
        return quizTakingService.submitQuiz(request);
    }
}
