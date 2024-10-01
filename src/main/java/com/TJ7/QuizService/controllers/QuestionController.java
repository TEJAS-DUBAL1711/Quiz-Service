package com.TJ7.QuizService.controllers;


import com.TJ7.QuizService.model.Question;
import com.TJ7.QuizService.service.QuestionService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("category/{category}")
    public List<Question>getQuestionsByCategory(@PathVariable String category){

    return  service.getQuestionsByCategory(category);

    }

    @PostMapping("add")
    public String addQuestions(@RequestBody Question question){

        service.addQuestions(question);
        return "Done";
    }

}
