package com.nt.beans;

import java.io.Serializable;

import lombok.Data;
@Data
public class Employee implements Serializable {
	private String name;
	private String eadd;
	private Float basicSalary;
	private Float grossSalary;
	private Float netSalary;
	

}
