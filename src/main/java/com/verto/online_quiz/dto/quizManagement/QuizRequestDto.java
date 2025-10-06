package com.verto.online_quiz.dto.quizManagement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class QuizRequestDto {
    private String title;

    private String description;

    private Long durationInMinutes;

    private BigDecimal totalMarks;
}
