package com.verto.online_quiz.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    @Override
    public String toString() {
        return id + " " + answerText + " " + choice.getChoiceNum() + " " + choice.getChoiceText();
    }
}
