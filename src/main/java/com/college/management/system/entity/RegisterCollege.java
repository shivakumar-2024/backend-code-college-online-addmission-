package com.college.management.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.college.management.system.VO.RegisterCollegeVO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RegisterCollege {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String emailId;
	private String password;
	private String address;

	private String phoneNo;
	private String collegeCode;
	private Long totalSeat;
	
	@OneToOne
	private UserLogin user;
	
	@OneToOne
	private RegisterAdmin RegisterAdminId;
}
