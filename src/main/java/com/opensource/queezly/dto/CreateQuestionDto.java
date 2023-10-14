package com.opensource.queezly.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateQuestionDto {

    private String content;

    private List<CreateAnswerDto> answers;


}
