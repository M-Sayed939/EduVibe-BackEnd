package com.example.demo.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);

    Course findByDescriptionContaining(String keyword);

    Course findByNameAndDescription(String name, String description);

    Course findByNameStartingWith(String prefix);

    Course findAllByOrderByName();
}
