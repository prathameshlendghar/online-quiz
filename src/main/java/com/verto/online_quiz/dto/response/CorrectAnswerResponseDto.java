package com.verto.online_quiz.dto.response;

import com.verto.online_quiz.entity.Choices;
import com.verto.online_quiz.entity.Question;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorrectAnswerResponseDto {
    private Long id;
    private String answerText;
    private List<ChoiceResponseDto> choices;
}
