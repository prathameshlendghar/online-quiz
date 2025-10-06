package com.verto.online_quiz.dto.quizManagement;

import com.verto.online_quiz.entity.Choices;
import com.verto.online_quiz.entity.CorrectAnswer;
import com.verto.online_quiz.entity.Quiz;
import com.verto.online_quiz.entity.SubmittedAnswer;
import com.verto.online_quiz.entity.type.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddQuestionResponseDto {
    private Long id;
    private String questionText;
    private String addOnFileUrl;
    private BigDecimal maxScore;

    private QuestionType questionType;

    private Long quizId;

    private List<ChoiceResponseDto> choices;

    private CorrectAnswerResponseDto correctAnswers;
}
