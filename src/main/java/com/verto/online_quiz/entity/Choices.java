package com.verto.online_quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Choices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String choiceText;

    private String addOnFileURL;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @OneToMany(mappedBy = "choice")
    private List<SubmittedAnswer> submittedAnswers;

    @OneToOne(mappedBy = "choice")
    private CorrectAnswer correctAnswer;

}
