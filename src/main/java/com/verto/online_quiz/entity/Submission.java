package com.verto.online_quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal gainedMarks;

    @Column(precision = 5, scale = 2)               //100.00% scale
    private BigDecimal scorePercentage;

    @CreationTimestamp
    private LocalDateTime submittedAt;

    @ManyToOne
    @JoinColumn(nullable = false, name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "submission")
    private List<SubmittedAnswer> submittedAnswer = new ArrayList<>();

//    private Long userId;

}
