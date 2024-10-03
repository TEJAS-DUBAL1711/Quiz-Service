package com.TJ7.QuizService.repo;

import com.TJ7.QuizService.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer>{


}
