package com.magnit.survey.rest.controller;
	
import java.util.*;
import com.magnit.survey.model.SurveyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  
	
@RestController
@RequestMapping("/api/")
public class SurveyController {

    private List<SurveyResponse> surveyResponses = new ArrayList<>();    
    
    @PostMapping("/submitSurvey")
    public ResponseEntity<Void> submitSurvey(@RequestBody SurveyResponse surveyResponse) {
        surveyResponses.add(surveyResponse);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/surveyReport")
    public ResponseEntity<Map<String, Object>> getSurveyReport() {
        Map<String, Object> report = new HashMap<>();
        // Generate report based on surveyResponses
        // ...
        return ResponseEntity.ok(report);
    }
}	