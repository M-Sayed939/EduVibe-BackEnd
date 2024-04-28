package com.example.demo.StudyStrategy;

import com.example.demo.Course.Course;
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
    private String description;
    public StudyStrategy(String name, String description) {
    this.name = name;
    this.description = description;
}

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
