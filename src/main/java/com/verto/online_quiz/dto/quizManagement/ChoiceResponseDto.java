package com.verto.online_quiz.dto.quizManagement;

import com.verto.online_quiz.entity.CorrectAnswer;
import com.verto.online_quiz.entity.Question;
import com.verto.online_quiz.entity.SubmittedAnswer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChoiceResponseDto {
    private Long id;
    private Integer choiceNum;
    private String choiceText;
    private String addOnFileURL;
}
