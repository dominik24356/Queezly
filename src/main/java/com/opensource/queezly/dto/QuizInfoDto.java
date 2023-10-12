package com.opensource.queezly.dto;

import com.opensource.queezly.common.enums.Difficulty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class QuizInfoDto {
    private String title;


    private String description;


    private String category;


    private Difficulty difficulty;


    private Date creationDate;



}
