package com.TJ7.QuizService.controllers;


import com.TJ7.QuizService.model.Question;
import com.TJ7.QuizService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("questions")
    public List<Question> getAllQuestions(){

        return service.getAllQuestions();
    }

    @GetMapping("load")
    public String load(){

        service.load();
        return "Loding successfull...";
    }


}
