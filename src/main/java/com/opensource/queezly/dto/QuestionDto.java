package com.opensource.queezly.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDto {


    private String content;

    private List<AnswerDto> answers;


}
