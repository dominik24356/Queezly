package com.opensource.queezly.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opensource.queezly.common.enums.Difficulty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties({"questions"})
@Builder
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @NotBlank
    private String title;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "category")
    @NotBlank
    private String category;

    @Column(name = "difficulty")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Difficulty difficulty;

    @Column(name = "creation_date")
    private Date creationDate;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;

    public Quiz() {
        this.creationDate = new Date(System.currentTimeMillis());
    }

}



