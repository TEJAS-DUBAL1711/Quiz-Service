package com.TJ7.QuizService.service;


import com.TJ7.QuizService.model.Question;
import com.TJ7.QuizService.model.QuestionWrapper;
import com.TJ7.QuizService.model.Quiz;
import com.TJ7.QuizService.model.Response;
import com.TJ7.QuizService.repo.QuestionRepo;
import com.TJ7.QuizService.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionRepo questionRepo;


    public ResponseEntity createQuize(String category, int noQ, String title) {



        List<Question> questions= questionRepo.findRandomQuestionsByCategory(category,noQ);

        Quiz quiz=new Quiz();
        quiz.setId(1);
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizRepo.save(quiz);

        return new ResponseEntity("Created", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {

        Optional<Quiz> questions=quizRepo.findById(id);
        List<QuestionWrapper> wrappers=new ArrayList<>();


        for(Question question:questions.get().getQuestions()){

            QuestionWrapper wrapper=new QuestionWrapper();

            wrapper.setId(question.getId());
            wrapper.setQuestionTitle(question.getQuestionTitle());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());

            wrappers.add(wrapper);
        }
        return new ResponseEntity<>(wrappers,HttpStatus.OK);


    }

    public ResponseEntity<Integer> getResponse(int id,List<Response> responses) {

        int reslut=0;


        Quiz quiz=quizRepo.findById(id).get();
        List<Question> questions=quiz.getQuestions();


        /*

        for(Response response:responses){

           Question question= questionRepo.findById(response.getId()).get();
            boolean res=response.getResponse().equals(question.getRightAnswer());

            if(res)
                reslut++;


        }  */
        int i=0;
        for(Response response:responses){

            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                reslut++;

            i++;


        }

       return new ResponseEntity(reslut,HttpStatus.OK);

    }
}
