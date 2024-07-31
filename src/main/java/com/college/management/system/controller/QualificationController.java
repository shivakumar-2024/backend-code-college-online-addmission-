package com.college.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.QualificationVO;
import com.college.management.system.entity.Qualification;
import com.college.management.sytem.service.QualificationService;

@RestController
public class QualificationController {
	
	@Autowired 
	private QualificationService qualificationService;
	
	@PostMapping("/student/qualification")
	public QualificationVO studentQualification(@RequestBody QualificationVO  qualificationVO){
		return qualificationService.studentQualificationService(qualificationVO);
		
	}

}
