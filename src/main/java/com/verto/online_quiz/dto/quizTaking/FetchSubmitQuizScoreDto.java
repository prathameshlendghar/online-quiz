package com.verto.online_quiz.dto.quizTaking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchSubmitQuizScoreDto {
    private Double gainedScore;
    private Double totalScore;
}
