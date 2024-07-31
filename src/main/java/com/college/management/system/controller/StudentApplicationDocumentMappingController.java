package com.college.management.system.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.college.management.system.VO.StudentApplicationDocumentMappingVO;
import com.college.management.system.VO.StudentApplicationIdVO;
import com.college.management.system.VO.StudentApplicationShowCollegeVo;
import com.college.management.system.VO.StudentApplicationVO;
import com.college.management.sytem.service.StudentApppicationDocumentMappingService;

@RestController
@CrossOrigin
public class StudentApplicationDocumentMappingController {

	@Autowired
	private StudentApppicationDocumentMappingService studentApplicationDocumentMappingService;

	@PostMapping(value = "/student/document", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<StudentApplicationDocumentMappingVO> addStudentDocument(
			@RequestParam(name = "document") String StudentDocument, @RequestParam(name = "files") MultipartFile file)
			throws IOException {
		return new ResponseEntity<>(
				studentApplicationDocumentMappingService.addStudentDocumentService(StudentDocument, file),
				HttpStatus.OK);
	}

	@GetMapping(value = "/fetch/Students/Data")
	public ResponseEntity<Map<Long, List<StudentApplicationShowCollegeVo>>> fetchStudentsAllData(@RequestParam(required=false, name="allot", defaultValue = "false") boolean alot) {
		 return studentApplicationDocumentMappingService.fetchStudentsAllDataService(alot);
	   
	}
	
	@GetMapping("/check-registeration/{userId}")
	public ResponseEntity<Map<String,Boolean>> checkRegistrationForCollege(@PathVariable(name="userId", required = true) Long UserId) {
		 return ResponseEntity.ok(studentApplicationDocumentMappingService.checkRegistrationForCollege(UserId));
	   
	}
	

	@GetMapping(value = "/fetch/Student/AllotSeat") 
	public ResponseEntity<List<StudentApplicationShowCollegeVo>> fetchStudentAllAlloted() {
	    return studentApplicationDocumentMappingService.fetchStudentAllAllotedService();
	}
	
	 @PostMapping("/checkStudentIdPdf")
	    public ResponseEntity<?> studentIdPdf(@RequestBody StudentApplicationIdVO studentApplicationIdVO ){
//	        St	udentApplicationDocumentMapping result = studentApplicationDocumentMappingService.studentIdPdfService(studentApplicationIdVO);
	        return new ResponseEntity<>(studentApplicationDocumentMappingService.studentIdPdfService(studentApplicationIdVO), HttpStatus.OK);
	    }
}
