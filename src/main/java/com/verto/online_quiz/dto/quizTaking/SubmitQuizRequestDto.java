package com.verto.online_quiz.dto.quizTaking;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitQuizRequestDto {
    Long quizId;
    List<QuestionAnswerDto> questionAnswerList;
}
