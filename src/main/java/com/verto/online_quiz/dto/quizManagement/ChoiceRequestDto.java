package com.verto.online_quiz.dto.quizManagement;

import lombok.Data;

@Data
public class ChoiceRequestDto {
    private Integer choiceNum;
    private String choiceText;
    private String addOnFileURL;
}
