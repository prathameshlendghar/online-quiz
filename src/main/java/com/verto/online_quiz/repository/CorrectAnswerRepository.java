package com.verto.online_quiz.repository;

import com.verto.online_quiz.entity.Choices;
import com.verto.online_quiz.entity.CorrectAnswer;
import com.verto.online_quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorrectAnswerRepository  extends JpaRepository<CorrectAnswer, Long> {
    List<CorrectAnswer> findByQuestion(Question question);
}
