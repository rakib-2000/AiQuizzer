package com.rakx07.AiQuizzer.repsitory;


import com.rakx07.AiQuizzer.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {
}
