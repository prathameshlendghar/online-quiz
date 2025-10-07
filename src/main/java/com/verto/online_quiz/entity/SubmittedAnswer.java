package com.verto.online_quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class SubmittedAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String textAns;

//    private BigDecimal marksGained;

    @ManyToOne                                               // Many submittedAnswers can belong to one question
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne                                              // Many submittedAnswers can belong to single submission
    @JoinColumn(name = "submission_id", nullable = false)
    private Submission submission;

    @ManyToOne                                              // Many submissions can belong to same choice id
    @JoinColumn(name = "choice_id", nullable = false)
    private Choices choice;

//    private Long userId;
}
