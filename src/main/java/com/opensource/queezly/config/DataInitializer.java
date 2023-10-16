package com.opensource.queezly.config;

import com.opensource.queezly.common.enums.Difficulty;
import com.opensource.queezly.entity.Answer;
import com.opensource.queezly.entity.Question;
import com.opensource.queezly.entity.Quiz;
import com.opensource.queezly.repository.AnswerRepository;
import com.opensource.queezly.repository.QuestionRepository;
import com.opensource.queezly.repository.QuizRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DataInitializer implements ApplicationRunner {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    public DataInitializer(QuizRepository quizRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Quiz quiz1 = new Quiz();
        quiz1.setTitle("Quiz o programowaniu");
        quiz1.setDescription("Test wiedzy z zakresu programowania.");
        quiz1.setCreationDate(Date.valueOf("2022-12-12"));
        quiz1.setCategory("Programowanie");
        quiz1.setDifficulty(Difficulty.HARD);

        Quiz quiz2 = new Quiz();
        quiz2.setTitle("Quiz o historii");
        quiz2.setDescription("Pytania z historii świata.");
        quiz2.setCreationDate(Date.valueOf("2022-11-15"));
        quiz2.setCategory("Historia");
        quiz2.setDifficulty(Difficulty.MEDIUM);

        Quiz quiz3 = new Quiz();
        quiz3.setTitle("Quiz o matematyce");
        quiz3.setDescription("Zadania matematyczne.");
        quiz3.setCreationDate(Date.valueOf("2022-10-20"));
        quiz3.setCategory("Matematyka");
        quiz3.setDifficulty(Difficulty.EASY);


        Question question1 = new Question();
        question1.setContent("Jaka jest nazwa języka programowania stworzonego w 1995 roku przez Sun Microsystems?");
        question1.setQuiz(quiz1);

        Question question4 = new Question();
        question4.setContent("Who is Sebastian Enrique Alvarez?");
        question4.setQuiz(quiz1);

        Answer answer1_1 = new Answer();
        answer1_1.setContent("Java");
        answer1_1.setCorrect(true);
        answer1_1.setQuestion(question1);

        Answer answer1_2 = new Answer();
        answer1_2.setContent("Python");
        answer1_2.setCorrect(false);
        answer1_2.setQuestion(question1);

        Answer answer1_3 = new Answer();
        answer1_3.setContent("GIGA CHAD");
        answer1_3.setCorrect(true);
        answer1_3.setQuestion(question4);

        Answer answer1_4 = new Answer();
        answer1_4.setContent("BETA MALE");
        answer1_4.setCorrect(false);
        answer1_4.setQuestion(question4);


        Question question2 = new Question();
        question2.setContent("Kto był pierwszym prezydentem Stanów Zjednoczonych?");
        question2.setQuiz(quiz2);

        Answer answer2_1 = new Answer();
        answer2_1.setContent("George Washington");
        answer2_1.setCorrect(true);
        answer2_1.setQuestion(question2);

        Answer answer2_2 = new Answer();
        answer2_2.setContent("Abraham Lincoln");
        answer2_2.setCorrect(false);
        answer2_2.setQuestion(question2);


        Question question3 = new Question();
        question3.setContent("Ile wynosi pierwiastek kwadratowy z 16?");
        question3.setQuiz(quiz3);

        Answer answer3_1 = new Answer();
        answer3_1.setContent("4");
        answer3_1.setCorrect(true);
        answer3_1.setQuestion(question3);

        Answer answer3_2 = new Answer();
        answer3_2.setContent("8");
        answer3_2.setCorrect(false);
        answer3_2.setQuestion(question3);


        quizRepository.save(quiz1);
        quizRepository.save(quiz2);
        quizRepository.save(quiz3);
        questionRepository.save(question1);
        questionRepository.save(question2);
        questionRepository.save(question3);
        questionRepository.save(question4);
        answerRepository.save(answer1_1);
        answerRepository.save(answer1_2);
        answerRepository.save(answer1_3);
        answerRepository.save(answer1_4);
        answerRepository.save(answer2_1);
        answerRepository.save(answer2_2);
        answerRepository.save(answer3_1);
        answerRepository.save(answer3_2);
    }
}
