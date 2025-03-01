package com.ritobina.quiz_service.services;


import com.ritobina.quiz_service.dao.QuizDao;
import com.ritobina.quiz_service.feign.QuizIntereface;
import com.ritobina.quiz_service.models.QuestionWrapper;
import com.ritobina.quiz_service.models.Quiz;
import com.ritobina.quiz_service.models.Response;
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
    QuizDao quizDao;

    @Autowired
    QuizIntereface quizIntereface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions = quizIntereface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Quiz quiz= quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizIntereface.getQuestionsFromId(questionIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizIntereface.getScore(responses);
        return score;
    }
}
