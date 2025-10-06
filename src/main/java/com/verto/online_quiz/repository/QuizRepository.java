package com.verto.online_quiz.repository;

import com.verto.online_quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query("SELECT q FROM Quiz q LEFT JOIN FETCH q.questions ques LEFT JOIN FETCH ques.choices LEFT JOIN FETCH ques.correctAnswers WHERE q.id = :id")
    Optional<Quiz> findByIdWithQuestions(Long id);
}
