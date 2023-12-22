package com.example.examprotable.entities.exam;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Question {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quesId;
    private String content;

    private String image;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String answer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;
}
