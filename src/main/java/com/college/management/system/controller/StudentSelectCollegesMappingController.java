package com.college.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.StudentSelectCollegesMappingVO;
import com.college.management.sytem.service.StudentSelectCollegesMappingService;

@RestController
@CrossOrigin
public class StudentSelectCollegesMappingController {
	
	@Autowired
	private StudentSelectCollegesMappingService studentSelectCollegesMappingService;

	@PostMapping("/studentSelectColleges")
	public ResponseEntity<String> studentsSelectColleges(@RequestBody StudentSelectCollegesMappingVO studentSelectCollegesMappingVO) {
	    String responseMessage = studentSelectCollegesMappingService.studentsSelectCollegesService(studentSelectCollegesMappingVO);
	    return ResponseEntity.ok(responseMessage);
	}

}
