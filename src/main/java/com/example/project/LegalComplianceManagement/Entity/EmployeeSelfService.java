package com.example.project.LegalComplianceManagement.Entity;

public class EmployeeSelfService 
{
	private Integer id ;
	private String Name;
	private String Gender;
	private Integer LeaveBalance;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Integer getLeaveBalance() {
		return LeaveBalance;
	}
	public void setLeaveBalance(Integer leaveBalance) {
		LeaveBalance = leaveBalance;
	}

}
