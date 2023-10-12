package com.opensource.queezly.service;

import com.opensource.queezly.dto.QuizFullDto;
import com.opensource.queezly.entity.Quiz;
import com.opensource.queezly.exceptions.quiz.QuizNotFoundException;
import com.opensource.queezly.mapper.QuizMapper;
import com.opensource.queezly.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository quizRepository, QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public QuizFullDto getQuizById(Long quizId) {

        Quiz quiz = quizRepository.getQuizById(quizId)
                .orElseThrow(() -> new QuizNotFoundException(quizId));

        return quizMapper.mapToQuizFullDto(quiz);

    }

    public Quiz saveQuiz(Quiz quizToSave) {
        return quizRepository.save(quizToSave);
    }

    public void deleteQuizById(Long quizId) {
        if(quizRepository.existsById(quizId)){
            quizRepository.deleteById(quizId);

        } else {
            throw new QuizNotFoundException(quizId);
        }
    }
}
