package com.college.management.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentsApplyColleges {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	

	@OneToOne
	private RegisterCollege register;
	
	

}
