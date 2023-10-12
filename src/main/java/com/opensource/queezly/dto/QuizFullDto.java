package com.opensource.queezly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opensource.queezly.common.enums.Difficulty;
import com.opensource.queezly.entity.Question;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class QuizFullDto {


    private String title;


    private String description;


    private String category;


    private Difficulty difficulty;


    private Date creationDate;


    private List<QuestionDto> questions;


}




