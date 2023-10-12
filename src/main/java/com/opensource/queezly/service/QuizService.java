package com.opensource.queezly.service;

import com.opensource.queezly.dto.QuizFullDto;
import com.opensource.queezly.dto.QuizInfoDto;
import com.opensource.queezly.entity.Quiz;
import com.opensource.queezly.exceptions.quiz.QuizNotFoundException;
import com.opensource.queezly.mapper.QuizMapper;
import com.opensource.queezly.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository quizRepository, QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
    }

    public List<QuizInfoDto> getAllQuizzes() {
        return quizRepository.findAll().stream().map(quizMapper::mapToQuizInfoDto).collect(Collectors.toList());
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
