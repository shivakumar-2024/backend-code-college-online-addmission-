package com.college.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.college.management.system.VO.StudentApplicationIdVO;
import com.college.management.sytem.service.StudentApplicationService;

@RestController
@CrossOrigin
public class StudentApplicationController {
	@Autowired
	private StudentApplicationService addStudentApplicationService;

	@PostMapping(value = "add/student/application", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> addApplication(@RequestParam("studentPhoto") MultipartFile file,
			@RequestParam("StudentApplication") String addStudentApplicationVO) {
		return new ResponseEntity<>(
				addStudentApplicationService.addStudentApplicationService(addStudentApplicationVO, file),
				HttpStatus.OK);
	}

	@PostMapping("/allot/users/seat")
	public ResponseEntity<String> userIdAllotTrue(@RequestBody StudentApplicationIdVO studentApplicationIdVO) {
		String result = addStudentApplicationService.UserIdAllotTrueService(studentApplicationIdVO);

		return ResponseEntity.ok(result);

	}
	

}
