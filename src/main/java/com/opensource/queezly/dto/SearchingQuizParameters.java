package com.opensource.queezly.dto;

import com.opensource.queezly.common.enums.Difficulty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchingQuizParameters {
    private String title;
    private String category;
    private Difficulty difficulty;

}
