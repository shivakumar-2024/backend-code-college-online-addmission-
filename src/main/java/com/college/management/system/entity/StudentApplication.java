package com.college.management.system.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class StudentApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
private String firstName;
private String lastName;
@Column(unique=true)
private String email;

@Column(unique=true)
private String phoneNumber;
private String fatherName;
private String motherName;
private Date dob;


private String city;
private Long pinCode;
private String state;

private String photo;
@ManyToOne
private Country countryName;
@ManyToOne
private Courses courseMaster;

@OneToOne
private UserRegisteration userRegisteration;

private boolean allotmentStatus =false;

@OneToMany(mappedBy = "studentApplication", cascade = CascadeType.ALL, orphanRemoval = true)
private Set<StudentSelectCollegesMapping> studentSelectColleges = new HashSet<>();






}
