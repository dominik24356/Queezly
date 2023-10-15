package com.opensource.queezly.service;

import com.opensource.queezly.common.enums.Difficulty;
import com.opensource.queezly.dto.CreateQuizDto;
import com.opensource.queezly.dto.QuizFullDto;
import com.opensource.queezly.dto.QuizInfoDto;
import com.opensource.queezly.entity.Quiz;
import com.opensource.queezly.exceptions.quiz.QuizNotFoundException;
import com.opensource.queezly.mapper.QuizMapper;
import com.opensource.queezly.repository.QuestionRepository;
import com.opensource.queezly.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    private final QuestionRepository questionRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository, QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
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

    public Quiz saveQuiz(CreateQuizDto createQuizDto) {
        Quiz quiz = quizMapper.mapToQuiz(createQuizDto);

        quiz.getQuestions().forEach(question -> {
            question.setQuiz(quiz);
            question.getAnswers().forEach(answer -> answer.setQuestion(question));
        });

        return quizRepository.save(quiz);
    }

    public void deleteQuizById(Long quizId) {
        if(quizRepository.existsById(quizId)){
            quizRepository.deleteById(quizId);

        } else {
            throw new QuizNotFoundException(quizId);
        }
    }


    public List<QuizInfoDto> getQuizzesByTitleAndCategoryAndDifficulty(String title, String category, Difficulty difficulty) {
        List<Quiz> quizzes = quizRepository.findQuizzesByTitleAndCategoryAndDifficulty(title, category, difficulty);

        return quizMapper.mapToQuizzesInfoDto(quizzes);
    }
}
