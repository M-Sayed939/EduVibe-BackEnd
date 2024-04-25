package com.example.demo.Book;

import com.example.demo.Course.Course;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ElementCollection
    private List<String> authors;
    private String description;
    private String genre;
    private String publishedDate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}

