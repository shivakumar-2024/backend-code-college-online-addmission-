package com.college.management.system.VO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterAdminVO {
	private String firstName;
	private String lastName;
	
	private String email;
	private Long mobile;
	private String address;
	private String city;
	private Long pinCode;
	private String password;
	private String adminRole;
}
