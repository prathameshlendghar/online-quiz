package com.verto.online_quiz.repository;

import com.verto.online_quiz.entity.Choices;
import com.verto.online_quiz.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository  extends JpaRepository<Submission, Long> {
}
