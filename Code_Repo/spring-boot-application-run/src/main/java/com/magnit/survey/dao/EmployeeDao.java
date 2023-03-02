package com.magnit.survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.magnit.survey.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>{

}
