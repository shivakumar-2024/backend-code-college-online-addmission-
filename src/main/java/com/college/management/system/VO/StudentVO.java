package com.college.management.system.VO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO {

	private Long id;
	private String name;
	private String fatherName;
	private String motherName;
	private String phoneNumber;
	private String email;
	private String gender;
	private Date dob;
	private String state;
	private String city;
	private String addressLin1;
	private String pinCode;
	private String password;
	private String studentRole;
}
