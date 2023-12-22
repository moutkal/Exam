package com.example.examprotable.entities.exam;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Quiz {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qid;

    private String title;

    private String description;

    private String maxMarks;

    private String numberOfQuestions;

    private boolean active = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
    private Set<Question> questions=new HashSet<>();

}
