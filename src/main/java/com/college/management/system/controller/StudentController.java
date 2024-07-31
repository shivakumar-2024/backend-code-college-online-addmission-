package com.college.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.StudentVO;
import com.college.management.system.entity.UserRegisteration;
import com.college.management.sytem.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {
	@Autowired
	private StudentService studentService;
	
@PostMapping("add/student/basic/detail")
public ResponseEntity<String> addStudentDetail(@RequestBody StudentVO studentVO) {
    return new ResponseEntity<>(studentService.addStudentDetailService(studentVO), HttpStatus.OK);
}
//@GetMapping()
//public ResponseEntity<List<>>
}
