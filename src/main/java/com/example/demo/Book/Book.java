package com.example.demo.Book;

import com.example.demo.Course.Course;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    private String id;
    private String title;
    @ElementCollection
    private List<String> authors;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String genre;
    private String publishedDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}

