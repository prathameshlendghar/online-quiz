package com.verto.online_quiz.dto.quizTaking;

import com.verto.online_quiz.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchCompleteQuizDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime updatedAt;
    private Long durationInMinutes;
    private BigDecimal totalMarks;

    private List<FetchQuestionDto> questions;
}
