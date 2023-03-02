package com.magnit.survey.service;

import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnit.survey.dao.SatisfactionReportDao;
import com.magnit.survey.mo.InputData;
import com.magnit.survey.model.SatisfactionReport;

@Service
public class EmployeeSatisfactionService {

	
	@Autowired
	private SatisfactionReportDao satisfactionReportDao;	
    
    @Transactional
	public void saveSurveyData(InputData inputData) {
		
    	double q1 = Stream.of(inputData.getQ1(), inputData.getQ2(), inputData.getQ3(), inputData.getQ4(), inputData.getQ5(), inputData.getQ6())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    	double q2 = Stream.of(inputData.getQ7(), inputData.getQ8(), inputData.getQ9(), inputData.getQ10(), inputData.getQ11(), inputData.getQ12())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    	double q3 = Stream.of(inputData.getQ13(), inputData.getQ14(), inputData.getQ15(), inputData.getQ16(), inputData.getQ17(), inputData.getQ18())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    	double q4 = Stream.of(inputData.getQ19(), inputData.getQ20(), inputData.getQ21(), inputData.getQ22(), inputData.getQ23(), inputData.getQ24())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    	double q5 = Stream.of(inputData.getQ25(), inputData.getQ26(), inputData.getQ27(), inputData.getQ28(), inputData.getQ29(), inputData.getQ30())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);    	

		SatisfactionReport sRprt = new SatisfactionReport(q1, q2, q3, q4, q5);		
		satisfactionReportDao.save(sRprt);
	}
	
	public SatisfactionReport getSurveyData(){
		List<SatisfactionReport> satisfactionReports = satisfactionReportDao.getAllSatisfactionReport();
		double careerDevelopmentAvg = satisfactionReports.stream()
            .mapToDouble(SatisfactionReport::getCareerDevelopmentPercentage)
            .average()
            .orElse(Double.NaN);
        
        double workLifeBalanceAvg = satisfactionReports.stream()
            .mapToDouble(SatisfactionReport::getWorkLifeBalancePercentage)
            .average()
            .orElse(Double.NaN);
        
        double workingAtmosphereAvg = satisfactionReports.stream()
            .mapToDouble(SatisfactionReport::getWorkingAtmospherePercentage)
            .average()
            .orElse(Double.NaN);
        
        double compensationBenefitsAvg = satisfactionReports.stream()
            .mapToDouble(SatisfactionReport::getCompensationBenefitsPercentage)
            .average()
            .orElse(Double.NaN);
        
        double recognitionFeedbackAvg = satisfactionReports.stream()
            .mapToDouble(SatisfactionReport::getRecognitionFeedbackPercentage)
            .average()
            .orElse(Double.NaN);
        
        SatisfactionReport sRprt = new SatisfactionReport(careerDevelopmentAvg, workLifeBalanceAvg, workingAtmosphereAvg, compensationBenefitsAvg, recognitionFeedbackAvg);
		return sRprt;
	}
	
}
