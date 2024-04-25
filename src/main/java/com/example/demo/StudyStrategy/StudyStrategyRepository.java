package com.example.demo.StudyStrategy;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyStrategyRepository extends JpaRepository<StudyStrategy, Long> {
    List<StudyStrategy> findByName(String name);

    List<StudyStrategy> findByDescriptionContaining(String keyword);

    List<StudyStrategy> findByNameAndDescription(String name, String description);

    List<StudyStrategy> findByNameStartingWith(String prefix);

    List<StudyStrategy> findByCourseId(Long courseId);

    List<StudyStrategy> findAllByOrderByName();
}
