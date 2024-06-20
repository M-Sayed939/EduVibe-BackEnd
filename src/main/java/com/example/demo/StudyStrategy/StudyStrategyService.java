package com.example.demo.StudyStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyStrategyService {
    @Autowired
    private StudyStrategyRepository studyStrategyRepository;

    public StudyStrategy addStudyStrategy(StudyStrategy studyStrategy) {
        return studyStrategyRepository.save(studyStrategy);
    }

    public List<StudyStrategy> getStudyStrategies() {
        return studyStrategyRepository.findAll();
    }

}
