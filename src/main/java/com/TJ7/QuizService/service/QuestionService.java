package com.TJ7.QuizService.service;

import com.TJ7.QuizService.model.Question;
import com.TJ7.QuizService.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo repo;

    public ResponseEntity<List<Question>> getAllQuestions(){

        try{
            return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);

        }catch (Exception e){

            e.printStackTrace();
        }
        return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

/*
    public void load() {

        List<Question> questions=new ArrayList<>();

        questions.add(new Question(1, "java", "Which of the following is a valid keyword in Java?", "include", "unsigned", "extends", "implement", "extends", "Easy"));
        questions.add(new Question(2, "java", "Which method is used to start a thread in Java?", "run()", "start()", "begin()", "init()", "start()", "Medium"));
        questions.add(new Question(3, "java", "What is the default value of an int variable in Java?", "1", "-1", "0", "null", "0", "Easy"));
        questions.add(new Question(4, "java", "Which of these is not a Java feature?", "Object-oriented", "Portable", "Use of pointers", "Secure", "Use of pointers", "Medium"));
        questions.add(new Question(5, "java", "Which of the following is not an access modifier in Java?", "public", "private", "protected", "internal", "internal", "Easy"));
        questions.add(new Question(6, "java", "What is the parent class of all classes in Java?", "String", "Object", "Class", "Collections", "Object", "Medium"));
        questions.add(new Question(7, "java", "Which collection class allows you to access elements by their natural order?", "HashMap", "TreeMap", "LinkedHashMap", "HashSet", "TreeMap", "Medium"));
        questions.add(new Question(8, "java", "In Java, which keyword is used to handle exceptions?", "try", "throw", "catch", "All of the above", "All of the above", "Easy"));
        questions.add(new Question(9, "java", "What is the output of the following code snippet? System.out.println(10 + 20 + \"Java\");", "30Java", "Java30", "1020Java", "Compilation error", "30Java", "Medium"));
        questions.add(new Question(10, "java", "Which of the following is not a primitive data type in Java?", "int", "boolean", "byte", "String", "String", "Easy"));


        repo.saveAll(questions);
    }

*/

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {

            try{
                return new ResponseEntity(repo.findAllByCategory(category), HttpStatus.OK);
            }catch(Exception e){
                e.printStackTrace();
            }

            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity addQuestions(Question question) {

        try{
            repo.save(question);

            return  new ResponseEntity("Done",HttpStatus.CREATED);

        }catch (Exception e){
            e.printStackTrace();
        }


        return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
    }
}
