package com.verto.online_quiz.dto.quizManagement;

import com.verto.online_quiz.entity.type.QuestionType;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddQuestionRequestDto {
    private String questionText;
    private String addOnFileUrl;
    private BigDecimal maxScore;
    private QuestionType questionType;
    private List<ChoiceRequestDto> choices;
    private CorrectAnswerRequestDto correctAnswers;
}
