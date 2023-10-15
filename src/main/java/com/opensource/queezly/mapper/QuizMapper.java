package com.opensource.queezly.mapper;

import com.opensource.queezly.dto.CreateQuizDto;
import com.opensource.queezly.dto.QuizFullDto;
import com.opensource.queezly.dto.QuizInfoDto;
import com.opensource.queezly.entity.Quiz;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuizMapper {


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    QuizFullDto mapToQuizFullDto(Quiz quiz);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    QuizInfoDto mapToQuizInfoDto(Quiz quiz);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<QuizInfoDto> mapToQuizzesInfoDto(List<Quiz> quizzes);


    @Mapping(target = "creationDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
    Quiz mapToQuiz(CreateQuizDto createQuizDto);



}

