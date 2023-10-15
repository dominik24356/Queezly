package com.opensource.queezly.controller;

import com.opensource.queezly.dto.CreateQuizDto;
import com.opensource.queezly.dto.QuizFullDto;
import com.opensource.queezly.dto.QuizInfoDto;
import com.opensource.queezly.dto.SearchingQuizParameters;
import com.opensource.queezly.entity.Quiz;
import com.opensource.queezly.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quizzes")
    public List<QuizInfoDto> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }


    @GetMapping("/quizzes/{quizId}")
    public ResponseEntity<QuizFullDto> getQuizById(@PathVariable Long quizId) {
        QuizFullDto quizById = quizService.getQuizById(quizId);

        return ResponseEntity.ok(quizById);
    }

    @PostMapping("/quizzes")
    public ResponseEntity<Void> saveQuiz(@RequestBody CreateQuizDto quizDto) {
        Quiz savedQuiz = quizService.saveQuiz(quizDto);

        String uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedQuiz.getId())
                .toUriString();

        return ResponseEntity.created(URI.create(uri)).build();
    }

    @DeleteMapping("/quizzes/{quizId}")
    public ResponseEntity<Void> deleteQuizById(@PathVariable Long quizId) {
        quizService.deleteQuizById(quizId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/quizzes/search")
    public ResponseEntity<List<QuizInfoDto>> getQuizzesByTitleAndCategoryAndDifficulty(@RequestBody SearchingQuizParameters parameters) {
        List<QuizInfoDto> quizzes = quizService
                .getQuizzesByTitleAndCategoryAndDifficulty(parameters.getTitle(), parameters.getCategory(), parameters.getDifficulty());

        return ResponseEntity.ok(quizzes);
    }
}
