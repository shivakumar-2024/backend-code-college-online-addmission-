package com.college.management.sytem.service;

import java.util.List;

import com.college.management.system.VO.StudentsApplyCollegesVO;
import com.college.management.system.entity.RegisterCollege;
import com.college.management.system.entity.StudentsApplyColleges;

public interface StudentsApplyCollegesService {

	//RegisterCollege studentsAddCollegesService();

	List<RegisterCollege> studentsAddCollegesService(StudentsApplyCollegesVO studentApplyCollegesVO);

}
