package com.verto.online_quiz.dto.quizTaking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerDto {
    Long questionId;
    List<Long> selectedChoiceIds;
    String textAnswer;
}
