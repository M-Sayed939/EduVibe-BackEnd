package com.example.demo.Course;

import com.example.demo.Notifications.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
    List<Course> findByUserId(Long userId);

    Course findByDescriptionContaining(String keyword);

    Course findByNameAndDescription(String name, String description);

    Course findByNameStartingWith(String prefix);

    Course findAllByOrderByName();
}
