package com.verto.online_quiz.dto.response;

import com.verto.online_quiz.entity.CorrectAnswer;
import com.verto.online_quiz.entity.Question;
import com.verto.online_quiz.entity.SubmittedAnswer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceResponseDto {
    private Long id;
    private String choiceText;
    private String addOnFileURL;
}
