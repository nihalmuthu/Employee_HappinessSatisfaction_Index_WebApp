package com.magnit.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "SATISFACTION_REPORT")
public class SatisfactionReport {

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "CAREER_DEVELOPMENT")
	private double careerDevelopmentPercentage;
	@Column(name = "WORKLIFE_BALANCE")
	private double workLifeBalancePercentage;
	@Column(name = "WORKING_ATMOSPHERE")
	private double workingAtmospherePercentage;
	@Column(name = "COMPENSATION_BENEFITS")
	private double compensationBenefitsPercentage;
	@Column(name = "RECOGNITION_FEEDBACK")
	private double recognitionFeedbackPercentage;
	
	
	public SatisfactionReport(double careerDevelopmentPercentage, double workLifeBalancePercentage,
			double workingAtmospherePercentage, double compensationBenefitsPercentage,
			double recognitionFeedbackPercentage) {
		super();
		this.careerDevelopmentPercentage = careerDevelopmentPercentage;
		this.workLifeBalancePercentage = workLifeBalancePercentage;
		this.workingAtmospherePercentage = workingAtmospherePercentage;
		this.compensationBenefitsPercentage = compensationBenefitsPercentage;
		this.recognitionFeedbackPercentage = recognitionFeedbackPercentage;
	}
	
		
	public SatisfactionReport() {
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getCareerDevelopmentPercentage() {
		return careerDevelopmentPercentage;
	}
	public void setCareerDevelopmentPercentage(double careerDevelopmentPercentage) {
		this.careerDevelopmentPercentage = careerDevelopmentPercentage;
	}
	public double getWorkLifeBalancePercentage() {
		return workLifeBalancePercentage;
	}
	public void setWorkLifeBalancePercentage(double workLifeBalancePercentage) {
		this.workLifeBalancePercentage = workLifeBalancePercentage;
	}
	public double getWorkingAtmospherePercentage() {
		return workingAtmospherePercentage;
	}
	public void setWorkingAtmospherePercentage(double workingAtmospherePercentage) {
		this.workingAtmospherePercentage = workingAtmospherePercentage;
	}
	public double getCompensationBenefitsPercentage() {
		return compensationBenefitsPercentage;
	}
	public void setCompensationBenefitsPercentage(double compensationBenefitsPercentage) {
		this.compensationBenefitsPercentage = compensationBenefitsPercentage;
	}
	public double getRecognitionFeedbackPercentage() {
		return recognitionFeedbackPercentage;
	}
	public void setRecognitionFeedbackPercentage(double recognitionFeedbackPercentage) {
		this.recognitionFeedbackPercentage = recognitionFeedbackPercentage;
	}
		
}
