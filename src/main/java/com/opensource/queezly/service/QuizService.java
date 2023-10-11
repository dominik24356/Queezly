package com.opensource.queezly.service;

import com.opensource.queezly.entity.Quiz;
import com.opensource.queezly.exceptions.quiz.QuizNotFoundException;
import com.opensource.queezly.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long quizId) {

        return quizRepository.getQuizById(quizId)
                .orElseThrow(() -> new QuizNotFoundException(quizId));

    }

    public Quiz saveQuiz(Quiz quizToSave) {
        return quizRepository.save(quizToSave);
    }

    public void deleteQuizById(Long quizId) {
        Quiz quizById = getQuizById(quizId);
        quizRepository.delete(quizById);
    }
}
