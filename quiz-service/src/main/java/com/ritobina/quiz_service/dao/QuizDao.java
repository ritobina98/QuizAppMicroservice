package com.ritobina.quiz_service.dao;


import com.ritobina.quiz_service.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
