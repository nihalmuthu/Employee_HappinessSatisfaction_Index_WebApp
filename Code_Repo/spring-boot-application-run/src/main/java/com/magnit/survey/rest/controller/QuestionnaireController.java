package com.magnit.survey.rest.controller;
	
import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 
import com.magnit.survey.dto.SurveyResponse;
import com.magnit.survey.mo.InputData;
import com.magnit.survey.model.SatisfactionReport;
import com.magnit.survey.service.EmployeeSatisfactionService;


@RestController
public class QuestionnaireController {

	@Autowired
	private EmployeeSatisfactionService employeeSatisfactionService;
	
    
    @GetMapping("/api/getReport")
    public SurveyResponse getReport() {
    	
    	SurveyResponse surveyResponse = new SurveyResponse();
    	surveyResponse.setData(employeeSatisfactionService.getSurveyData());
    	surveyResponse.setIsError(false);
		return surveyResponse;
    }
    

    @GetMapping("/api/getSurveyData")
    public String hello() {
    	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			SatisfactionReport datas= employeeSatisfactionService.getSurveyData();
			String json = ow.writeValueAsString(datas);
			return json;
        } catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
    }
    
    @PostMapping(
    		value = "/api/saveSurveyData",
    		produces = {MediaType.APPLICATION_JSON_VALUE},
    		consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Boolean> saveSurveyData(@RequestBody InputData inputData) {
        employeeSatisfactionService.saveSurveyData(inputData);
    	return ResponseEntity.ok(true);
    }
}
