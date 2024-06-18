package com.example.demo.Course;

import com.example.demo.Book.Book;
import com.example.demo.StudyStrategy.StudyStrategy;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    private List<Book> books;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudyStrategy> studyStrategys;

}
