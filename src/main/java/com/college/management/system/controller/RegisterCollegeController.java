package com.college.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.RegisterCollegeVO;
import com.college.management.system.VO.RegisterCollegeVO1;
import com.college.management.system.entity.RegisterCollege;
import com.college.management.sytem.service.RegisterCollegeService;

@RestController
@CrossOrigin
public class RegisterCollegeController {
	@Autowired
	private RegisterCollegeService registerCollegeService;

	@PostMapping("add/college")
	public ResponseEntity<String> registerNewCollege(@RequestBody RegisterCollegeVO registerCollegeVO)
			throws Exception {
		return new ResponseEntity<>(registerCollegeService.registerNewCollegeService(registerCollegeVO), HttpStatus.OK);

	}

	@GetMapping("/fetch/college")
	public List<RegisterCollegeVO1> fetchColleges() {
		return registerCollegeService.getAllColleges();	
		

	}
}
