package com.college.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.StudentPaymentVO;
import com.college.management.system.entity.StudentPayment;
import com.college.management.sytem.service.StudentPaymentService;

@RestController
@CrossOrigin
public class StudentPaymentController {

	@Autowired
	private StudentPaymentService studentPaymentService;
	
	@PostMapping("/studentPayment")
	public ResponseEntity<String> studentPaymentSet(@RequestBody StudentPaymentVO studentPaymentVO){
		return new ResponseEntity<>(studentPaymentService.studentPaymentSetService(studentPaymentVO),HttpStatus.OK);
	}
}
