package com.example.demo.Course;

import com.example.demo.Book.Book;
import com.example.demo.StudyStrategy.StudyStrategy;
import com.example.demo.appuser.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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


    @JsonManagedReference
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Book> books;

    @JsonManagedReference
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<StudyStrategy> studyStrategies;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
}
