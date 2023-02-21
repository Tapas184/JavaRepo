package com.nt.services;

import com.nt.beans.Employee;

public class EmployeeService {

	public void generatePayslip(Employee emp) throws Exception{
		Float grossSalary=emp.getBasicSalary()+(emp.getBasicSalary()*0.4f);
		Float netSalary = grossSalary-(grossSalary*0.2f);
		emp.setGrossSalary(grossSalary);
		emp.setNetSalary(netSalary);
	}
}
