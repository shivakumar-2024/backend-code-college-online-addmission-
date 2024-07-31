package com.college.management.system.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AdminLogin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
private String adminName;
	private String password;
	private Date date;
	

}