package com.example.demo.Initializing;

import com.example.demo.StudyStrategy.StudyStrategy;
import com.example.demo.StudyStrategy.StudyStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseInitializer {

    @Autowired
    private StudyStrategyService studyStrategyService;

    @PostConstruct
    public void initDatabase() {
        List<StudyStrategy> studyStrategies = Arrays.asList(
                new StudyStrategy("Study Strategy 1", "Description 1"),
                new StudyStrategy("Study Strategy 2", "Description 2")
        );
        for (StudyStrategy studyStrategy : studyStrategies) {
            studyStrategyService.addStudyStrategy(studyStrategy);
        }
    }
}