package com.verto.online_quiz.dto.quizTaking;

import com.verto.online_quiz.dto.response.ChoiceResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchCorrectAnswerDto {
    private Long id;
    private String answerText;
    private List<FetchChoiceDto> correctChoices;
}