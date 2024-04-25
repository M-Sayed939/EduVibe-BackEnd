package com.example.demo.StudyStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  StudyStrategyService {
    @Autowired
    private StudyStrategyRepository studyStrategyRepository;

    public List<StudyStrategy> getAllStudyStrategies() {
        return studyStrategyRepository.findAll();
    }
}
