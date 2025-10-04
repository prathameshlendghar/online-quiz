package com.verto.online_quiz.entity;

import com.verto.online_quiz.entity.type.QuestionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String questionText;

    private String addOnFileUrl;

    @Column(nullable = false)
    private BigDecimal maxScore;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Quiz quiz;

    @OneToMany(mappedBy = "question")
    private List<Choices> choices;

    @OneToMany(mappedBy = "question")
    private List<SubmittedAnswer> submittedAnswers;

    @OneToMany(mappedBy = "question")
    private List<CorrectAnswer> correctAnswers;
}
