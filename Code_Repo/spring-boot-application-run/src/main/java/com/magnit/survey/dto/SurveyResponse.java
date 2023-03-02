package com.magnit.survey.dto;

public class SurveyResponse {
	
	private Boolean isError;
	private Object data;
	
	public Boolean getIsError() {
		return isError;
	}
	public void setIsError(Boolean isError) {
		this.isError = isError;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
