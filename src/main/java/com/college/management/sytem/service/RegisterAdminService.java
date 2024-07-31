package com.college.management.sytem.service;

import java.util.List;

import com.college.management.system.VO.RegisterAdminVO;
import com.college.management.system.entity.RegisterCollege;

public interface RegisterAdminService {

	//RegisterAdminVO addRegisterAdminService();

	String addRegisterAdminService(RegisterAdminVO registerAdminVO);

	List<RegisterCollege> readAdminCollegeService();

}
