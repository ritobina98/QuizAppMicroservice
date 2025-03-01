package com.ritobina.quiz_service.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizDto {
    String categoryName;
    Integer numQuestions;
    String title;
}
