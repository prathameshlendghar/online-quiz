package com.verto.online_quiz.repository;

import com.verto.online_quiz.entity.Choices;
import com.verto.online_quiz.entity.Question;
import com.verto.online_quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository  extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);
}
