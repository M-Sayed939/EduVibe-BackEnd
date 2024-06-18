package com.example.demo.StudyStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/study-strategies")
public class StudyStrategyController {

    @Autowired
    private StudyStrategyService studyStrategyService;

    @GetMapping
    public ResponseEntity<List> getStudyStrategies() {
        List<StudyStrategy> studyStrategies = studyStrategyService.getStudyStrategies();
        return ResponseEntity.ok(studyStrategies);
    }
    @PostMapping
public ResponseEntity<StudyStrategy> addStudyStrategy(@RequestBody StudyStrategy newStudyStrategy) {
    StudyStrategy studyStrategy = studyStrategyService.addStudyStrategy(newStudyStrategy);
    return new ResponseEntity<>(studyStrategy, HttpStatus.CREATED);
}
}

