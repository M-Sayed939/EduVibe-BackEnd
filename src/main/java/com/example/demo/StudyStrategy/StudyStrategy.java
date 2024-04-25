package com.example.demo.StudyStrategy;

import com.example.demo.Course.Course;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class StudyStrategy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
