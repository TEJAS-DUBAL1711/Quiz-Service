package com.TJ7.QuizService.controllers;


import com.TJ7.QuizService.model.Question;
import com.TJ7.QuizService.model.QuestionWrapper;
import com.TJ7.QuizService.model.Response;
import com.TJ7.QuizService.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {

    @Autowired
    private QuizService service;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noQ , @RequestParam String title ){


        return  service.createQuize(category,noQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){



        return service.getQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getResponse(@PathVariable int id,  @RequestBody List<Response> responses){

         return service.getResponse(id,responses);

    }

}
