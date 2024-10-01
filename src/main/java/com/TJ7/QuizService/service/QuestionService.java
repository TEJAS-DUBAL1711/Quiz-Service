package com.TJ7.QuizService.service;

import com.TJ7.QuizService.model.Question;
import com.TJ7.QuizService.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo repo;

    public List<Question> getAllQuestions(){

        return repo.findAll();

    }

    public void load() {

        List<Question> questions=new ArrayList<>();

        questions.add(new Question(1,"Which of the following is a valid keyword in Java?","include", "unsigned", "extends", "implement", "extends", "Easy"));
        questions.add(new Question(1,"Which of the following is a valid keyword in Java?","include", "unsigned", "extends", "implement", "extends", "Easy"));
        questions.add(new Question(1,"Which of the following is a valid keyword in Java?","include", "unsigned", "extends", "implement", "extends", "Easy"));
        questions.add(new Question(1,"Which of the following is a valid keyword in Java?","include", "unsigned", "extends", "implement", "extends", "Easy"));
        questions.add(new Question(1,"Which of the following is a valid keyword in Java?","include", "unsigned", "extends", "implement", "extends", "Easy"));
        questions.add(new Question(1,"Which of the following is a valid keyword in Java?","include", "unsigned", "extends", "implement", "extends", "Easy"));
        questions.add(new Question(1,"Which of the following is a valid keyword in Java?","include", "unsigned", "extends", "implement", "extends", "Easy"));
        questions.add(new Question(1,"Which of the following is a valid keyword in Java?","include", "unsigned", "extends", "implement", "extends", "Easy"));
        questions.add(new Question(1,"Which of the following is a valid keyword in Java?","include", "unsigned", "extends", "implement", "extends", "Easy"));
        questions.add(new Question(1,"Which of the following is a valid keyword in Java?","include", "unsigned", "extends", "implement", "extends", "Easy"));


        repo.saveAll(questions);
    }
}
