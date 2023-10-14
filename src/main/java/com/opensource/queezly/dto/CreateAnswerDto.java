package com.opensource.queezly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAnswerDto {

    private String content;

    private boolean correct;
}
