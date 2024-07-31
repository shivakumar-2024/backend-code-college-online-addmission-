package com.college.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.StudentsApplyCollegesVO;
import com.college.management.system.entity.RegisterCollege;
import com.college.management.system.entity.StudentsApplyColleges;
import com.college.management.sytem.service.StudentsApplyCollegesService;

@RestController
public class StudentsApplyCollegesController {
	@Autowired
	private StudentsApplyCollegesService studentsApplyCollegesService;
@PostMapping("add/student/colleges")
public ResponseEntity<List<RegisterCollege>> studentChoiceColleges(@RequestBody StudentsApplyCollegesVO studentApplyCollegesVO){
return new ResponseEntity<>(studentsApplyCollegesService.studentsAddCollegesService(studentApplyCollegesVO),HttpStatus.OK);	
}
	

}
