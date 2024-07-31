package com.college.management.system.VO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentApplicationShowCollegeVo {
private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String fatherName;
	private String motherName;
	private String course; 
	private String city;
	private Long pinCode;
	private String state;
	private String country;
	
	private String standard;
	private Double percentage;
	private Long passingYear;
	private boolean  allotStatus;

	
}
