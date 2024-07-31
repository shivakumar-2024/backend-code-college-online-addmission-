package com.college.management.sytem.service;

import java.util.List;

import com.college.management.system.VO.RegisterCollegeVO;
import com.college.management.system.VO.RegisterCollegeVO1;
import com.college.management.system.entity.RegisterCollege;

public interface RegisterCollegeService {

	//String registerNewCollegeService(RegisterCollegeVO registerCollegeVO) throws Exception;

	List<RegisterCollegeVO1> getAllColleges();

	String registerNewCollegeService(RegisterCollegeVO registerCollegeVO) throws Exception;

}
