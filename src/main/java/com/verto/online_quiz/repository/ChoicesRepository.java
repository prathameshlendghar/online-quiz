package com.verto.online_quiz.repository;

import com.verto.online_quiz.entity.Choices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoicesRepository extends JpaRepository<Choices, Long> {
}
