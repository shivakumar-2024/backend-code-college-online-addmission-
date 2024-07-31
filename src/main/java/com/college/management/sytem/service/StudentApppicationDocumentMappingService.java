package com.college.management.sytem.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.college.management.system.VO.StudentApplicationDocumentMappingVO;
import com.college.management.system.VO.StudentApplicationIdVO;
import com.college.management.system.VO.StudentApplicationShowCollegeVo;
import com.college.management.system.VO.StudentApplicationVO;

public interface StudentApppicationDocumentMappingService {

	StudentApplicationDocumentMappingVO addStudentDocumentService(String studentDocument, MultipartFile file) throws IOException;

	ResponseEntity<Map<Long, List<StudentApplicationShowCollegeVo>>> fetchStudentsAllDataService(boolean alloted);

	ResponseEntity<List<StudentApplicationShowCollegeVo>> fetchStudentAllAllotedService();

	Map<String,Object> studentIdPdfService(StudentApplicationIdVO studentApplicationIdVO);

	Map<String, Boolean> checkRegistrationForCollege(Long UserId);

}
