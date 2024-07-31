package com.college.management.system.VO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterCollegeVO1 {
	private String name;
	private String emailId;
	
	private String address;

	private String phoneNo;
	private String collegeCode;
	private Long totalSeat;
	private Long id;
}
