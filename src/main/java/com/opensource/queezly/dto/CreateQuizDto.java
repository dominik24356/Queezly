package com.opensource.queezly.dto;

import com.opensource.queezly.common.enums.Difficulty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateQuizDto {

    private String title;

    private String description;

    private String category;


    private Difficulty difficulty;

    private List<CreateQuestionDto> questions;

}
