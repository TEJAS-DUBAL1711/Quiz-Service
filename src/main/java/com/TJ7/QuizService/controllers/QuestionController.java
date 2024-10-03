package com.TJ7.QuizService.controllers;


import com.TJ7.QuizService.model.Question;
import com.TJ7.QuizService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("questions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return service.getAllQuestions();
    }

/*
    @GetMapping("load")
    public String load(){

        service.load();
        return "Loding successfull...";
    }

 */

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>getQuestionsByCategory(@PathVariable String category){

    return  service.getQuestionsByCategory(category);

    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestions(@RequestBody Question question){

         return service.addQuestions(question);
    }

}
