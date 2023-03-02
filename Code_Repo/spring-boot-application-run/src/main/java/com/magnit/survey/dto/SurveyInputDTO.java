package com.magnit.survey.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SurveyInputDTO {

	private Map<String, Object> inputData;

	public Map<String, Object> getInputData() {
		return inputData;
	}

	public void setInputData(Map<String, Object> inputData) {
		this.inputData = inputData;
	}
	
	
}
