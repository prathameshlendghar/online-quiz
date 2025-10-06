package com.verto.online_quiz.dto.quizManagement;

import lombok.Data;

import java.util.List;

@Data
public class CorrectAnswerRequestDto {
    private String correctAnswerText;
    private List<Integer> correctChoicesNum;
}
