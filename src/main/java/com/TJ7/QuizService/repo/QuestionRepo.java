package com.TJ7.QuizService.repo;

import com.TJ7.QuizService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {


    List<Question> findAllByCategory(String category);
}
