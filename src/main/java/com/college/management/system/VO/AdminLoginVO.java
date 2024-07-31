package com.college.management.system.VO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLoginVO {

	private String UserName;
	private String password;
	private Date date;
	private String role;
}
