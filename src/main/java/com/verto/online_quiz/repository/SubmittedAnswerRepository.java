package com.verto.online_quiz.repository;

import com.verto.online_quiz.entity.Choices;
import com.verto.online_quiz.entity.SubmittedAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmittedAnswerRepository  extends JpaRepository<SubmittedAnswer, Long> {
//    public List<SubmittedAnswer> findByQuestionAndQuiz(SubmittedAnswer submittedAnswer);
}
