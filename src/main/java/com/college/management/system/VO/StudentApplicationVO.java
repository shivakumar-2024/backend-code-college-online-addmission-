package com.college.management.system.VO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.college.management.system.entity.Courses;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class StudentApplicationVO {
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String fatherName;
	private String motherName;
	@Temporal(TemporalType.DATE)
	private Date dob;
	//private String qualification;
	private Integer course; 
	private String city;
	private Long pinCode;
	private String state;
	private Long country;
	private Long courseMaster;
	private String photo;
	

}
