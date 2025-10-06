package com.verto.online_quiz.dto.quizManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorrectAnswerResponseDto {
    private String correctAnswerText;
    private List<Integer> correctChoiceNum;
}
//