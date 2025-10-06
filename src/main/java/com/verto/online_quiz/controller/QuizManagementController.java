package com.verto.online_quiz.controller;

import com.verto.online_quiz.dto.quizManagement.AddQuestionRequestDto;
import com.verto.online_quiz.dto.quizManagement.AddQuestionResponseDto;
import com.verto.online_quiz.dto.quizManagement.QuizRequestDto;
import com.verto.online_quiz.dto.quizManagement.FetchQuizResponseDto;
import com.verto.online_quiz.entity.Question;
import com.verto.online_quiz.service.QuizManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/quizzes/")
public class QuizManagementController {

    @Autowired
    private QuizManagementService quizManagementService;

    @PostMapping
    public FetchQuizResponseDto createQuiz(@RequestBody QuizRequestDto quizRequestDto){
        return quizManagementService.createQuizService(quizRequestDto);
    }

    @PatchMapping(path = "/{id}")
    public FetchQuizResponseDto updateQuiz(@PathVariable Long id, @RequestBody QuizRequestDto quizRequestDto){
        return quizManagementService.updateQuizService(id,quizRequestDto);
    }

    @PostMapping(path = "/questions/{id}")
    public AddQuestionResponseDto addQuestion(@PathVariable Long id, @RequestBody AddQuestionRequestDto questionDto){
        return quizManagementService.createQuestionService(id, questionDto);
    }


}
