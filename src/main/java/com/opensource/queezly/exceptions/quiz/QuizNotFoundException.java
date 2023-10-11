package com.opensource.queezly.exceptions.quiz;

import com.opensource.queezly.exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class QuizNotFoundException extends BusinessException {
    public QuizNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("Quiz with id of %d does not exist", id));}

}
