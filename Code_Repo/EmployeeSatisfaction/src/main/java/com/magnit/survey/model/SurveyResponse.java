package com.magnit.survey.model;

import java.util.List;


public class SurveyResponse {
	    private String jobSatisfaction;
	    private List<String> happinessFactors;
	    private List<String> unhappinessFactors;

	    public String getJobSatisfaction() {
	        return jobSatisfaction;
	    }

	    public void setJobSatisfaction(String jobSatisfaction	) {
	        this.jobSatisfaction = jobSatisfaction;
	    }

	    public List<String> getHappinessFactors() {
	        return happinessFactors;
	    }

	    public void setHappinessFactors(List<String> happinessFactors) {
	        this.happinessFactors = happinessFactors;
	    }

	    public List<String> getUnhappinessFactors() {
	        return unhappinessFactors;
	    }

	    public void setUnhappinessFactors(List<String> unhappinessFactors) {
	        this.unhappinessFactors = unhappinessFactors;
	    }
	
}
