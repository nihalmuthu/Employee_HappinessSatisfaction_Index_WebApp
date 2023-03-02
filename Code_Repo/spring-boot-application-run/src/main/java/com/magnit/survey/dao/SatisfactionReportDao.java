package com.magnit.survey.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.magnit.survey.model.SatisfactionReport;

public interface SatisfactionReportDao extends JpaRepository<SatisfactionReport, Long> {

	@Query("SELECT obj FROM SatisfactionReport obj")
	public List<SatisfactionReport> getAllSatisfactionReport();


}
