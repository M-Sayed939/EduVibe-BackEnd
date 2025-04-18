package com.example.demo.StudyStrategy;

import com.example.demo.Course.Course;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class StudyStrategy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;

    public StudyStrategy(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
