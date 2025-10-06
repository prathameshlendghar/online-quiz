package com.verto.online_quiz.repository;

import com.verto.online_quiz.entity.Choices;
import com.verto.online_quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChoicesRepository extends JpaRepository<Choices, Long> {
    List<Choices> findByQuestion(Question question);
}
