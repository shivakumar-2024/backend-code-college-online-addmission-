package com.college.management.system.serviceimp;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.BTechSreamVO;
import com.college.management.system.VO.CoursesVO;
import com.college.management.system.entity.BtechStream;
import com.college.management.system.entity.Courses;
import com.college.management.system.repository.CoursesRepository;
import com.college.management.system.repository.StreamRepository;
import com.college.management.sytem.service.CoursesService;

@Service
public class CoursesServiceImp  implements CoursesService{
	@Autowired
private CoursesRepository coursesRepository;
	
	@Autowired StreamRepository  streamRepository;
	public List<CoursesVO> readAllCoursesService() {
		
		
		List<CoursesVO> coursesVO = this.coursesRepository.findAll().stream().map(courses -> {
		    CoursesVO vo = new CoursesVO();
		    vo.setId(courses.getId());
		    vo.setCourses(courses.getCourses());
		    return vo;
		}).collect(Collectors.toList());
		return coursesVO;

	}
				
}
