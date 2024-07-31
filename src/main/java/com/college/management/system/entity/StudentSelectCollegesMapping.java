package com.college.management.system.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.college.management.system.repository.RegisterCollegeRepository;
import com.college.management.system.repository.StudentApplicationRepository;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class StudentSelectCollegesMapping {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
    @JoinColumn(name = "student_application_id")
    private StudentApplication studentApplication;
	@OneToMany
	private List<RegisterCollege>  registerCollegeid;
	
}
