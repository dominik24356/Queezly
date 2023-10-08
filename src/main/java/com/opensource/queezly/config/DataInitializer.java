package com.opensource.queezly.config;

import com.opensource.queezly.entity.Quiz;
import com.opensource.queezly.repository.QuizRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DataInitializer implements ApplicationRunner {

    private final QuizRepository quizRepository;

    public DataInitializer(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Quiz quiz1 = new Quiz();
        quiz1.setTitle("Quiz o programowaniu");
        quiz1.setDescription("Test wiedzy z zakresu programowania.");
        quiz1.setCreationDate(Date.valueOf("2022-12-12"));

        Quiz quiz2 = new Quiz();
        quiz2.setTitle("Quiz o historii");
        quiz2.setDescription("Pytania z historii świata.");
        quiz2.setCreationDate(Date.valueOf("2022-11-15"));

        Quiz quiz3 = new Quiz();
        quiz3.setTitle("Quiz o matematyce");
        quiz3.setDescription("Zadania matematyczne.");
        quiz3.setCreationDate(Date.valueOf("2022-10-20"));

        quizRepository.save(quiz1);
        quizRepository.save(quiz2);
        quizRepository.save(quiz3);
    }
}
