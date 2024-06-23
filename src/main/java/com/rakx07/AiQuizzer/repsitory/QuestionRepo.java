package com.rakx07.AiQuizzer.repsitory;

import com.rakx07.AiQuizzer.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
