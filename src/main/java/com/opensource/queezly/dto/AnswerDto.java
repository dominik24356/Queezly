package com.opensource.queezly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {

    private Long id;

    private String content;

    private boolean correct;
}
