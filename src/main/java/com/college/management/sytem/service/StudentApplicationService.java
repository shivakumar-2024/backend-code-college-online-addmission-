package com.college.management.sytem.service;

import javax.mail.Multipart;

import org.springframework.web.multipart.MultipartFile;

import com.college.management.system.VO.StudentApplicationIdVO;
import com.college.management.system.VO.StudentApplicationVO;

public interface StudentApplicationService {

	//AddStudentApplicationVO addApplicationService(AddStudentApplicationVO addStudentApplicationVO);

	// addApplicationService(AddStudentApplicationVO addStudentApplicationVO);

	//AddStudentApplicationVO addStudentApplicationService(AddStudentApplicationVO addStudentApplicationVO);

	String addStudentApplicationService(String addStudentApplicationVO, MultipartFile file);

	String UserIdAllotTrueService(StudentApplicationIdVO studentApplicationIdVO);

	

}
