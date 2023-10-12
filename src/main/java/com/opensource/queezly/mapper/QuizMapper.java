package com.opensource.queezly.mapper;

import com.opensource.queezly.dto.AnswerDto;
import com.opensource.queezly.dto.QuestionDto;
import com.opensource.queezly.dto.QuizFullDto;
import com.opensource.queezly.entity.Answer;
import com.opensource.queezly.entity.Question;
import com.opensource.queezly.entity.Quiz;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuizMapper {


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    QuizFullDto mapToQuizFullDto(Quiz quiz);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    QuestionDto mapToQuestionDto(Question question);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AnswerDto mapToAnswerDto(Answer answer);
}

