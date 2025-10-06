package com.verto.online_quiz.dto.quizTaking;

import com.verto.online_quiz.dto.response.ChoiceResponseDto;
import com.verto.online_quiz.dto.response.CorrectAnswerResponseDto;
import com.verto.online_quiz.entity.type.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchQuestionDto {
    Long id;
    private String questionText;
    private String addOnFileUrl;
    private BigDecimal maxScore;
    private QuestionType questionType;

    private List<FetchChoiceDto> choices;
//    private List<FetchCorrectAnswerDto> correctAnswers;
}