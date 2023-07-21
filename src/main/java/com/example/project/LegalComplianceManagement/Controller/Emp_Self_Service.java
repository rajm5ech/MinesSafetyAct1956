package com.example.project.LegalComplianceManagement.Controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.LegalComplianceManagement.Entity.EmployeeCentral;
import com.example.project.LegalComplianceManagement.Entity.EmployeeSelfService;
import com.example.project.LegalComplianceManagement.Repository.EmployeeRepo;

@RestController

public class Emp_Self_Service 
{
	@Autowired
	public EmployeeRepo e_repo;
	
	@GetMapping("/emp-self-service/id/{id}")
	public ResponseEntity<EmployeeSelfService> employee(@PathVariable Integer id )
	{
		EmployeeCentral emp = e_repo.findByid(id);
		EmployeeSelfService ss = new EmployeeSelfService();
		ss.setId(emp.getId());
		ss.setName(emp.getName()+emp.getLastname());
		ss.setGender(emp.getGender());
		ss.setLeaveBalance(emp.getLeave());
		return ResponseEntity.ok().body(ss);
	}
	@PostMapping("/emp-self-service/id/{id}/leave/from/{from}/to/{to}")
	public ResponseEntity<String> employee_leave(@PathVariable Integer id , @PathVariable Date from , @PathVariable Date to )
	{
		EmployeeCentral emp = e_repo.findByid(id);
		EmployeeSelfService ss = new EmployeeSelfService();
		 LocalDate fromDate = LocalDate.parse((CharSequence) from);
		    LocalDate toDate = LocalDate.parse((CharSequence) to);

		    // Calculate the number of days between the dates
		    int numberOfDays = (int) ChronoUnit.DAYS.between(fromDate, toDate);

		int leavebalance = ss.getLeaveBalance();
		int leaveapplied = numberOfDays;

		if(leavebalance >= leaveapplied)
		{
			int leavetaken = leavebalance - leaveapplied;
			emp.setLeave(leavetaken);
			e_repo.save(emp);
			return ResponseEntity.ok().body("Leave approved.");
		}
		return ResponseEntity.ok().body("Leave rejected");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
