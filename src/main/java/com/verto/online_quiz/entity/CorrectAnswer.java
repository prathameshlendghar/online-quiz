package com.verto.online_quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CorrectAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String answerText;

    @ManyToOne
    @JoinColumn(nullable = false, name = "question_id")
    private Question question;

    @OneToOne
    @JoinColumn(name = "choice_id", nullable = false)
    private Choices choice;

}
