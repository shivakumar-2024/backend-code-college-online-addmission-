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

import com.college.management.system.VO.RegisterAdminVO;
import com.college.management.system.entity.RegisterCollege;
import com.college.management.sytem.service.RegisterAdminService;

@RestController
@CrossOrigin
public class RegisterAdminController {
	
	@Autowired
	private RegisterAdminService registerAdminService;

	@PostMapping("add/register/admin")
	public ResponseEntity<String> addRegisterAdmin(@RequestBody RegisterAdminVO registerAdminVO ){
		return new ResponseEntity<>(registerAdminService.addRegisterAdminService(registerAdminVO),HttpStatus.OK);
	}
	
	
	@GetMapping("/fetch/register/colleges/admin")
	public List<RegisterCollege> readAdminColleges() {
	    return registerAdminService.readAdminCollegeService(); // Assuming registerAdminService is a service class and readAdminCollege() returns a list of RegisterCollege
	}
}