package com.college.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.CoursesVO;
import com.college.management.system.entity.Courses;
import com.college.management.system.serviceimp.CoursesServiceImp;
import com.college.management.sytem.service.CoursesService;

@RestController
@CrossOrigin
public class CourcesController {
	@Autowired 
	private CoursesService coursesService;
	@GetMapping("fetchCourses")
	public List<?> readAllCourses() {
	    return coursesService.readAllCoursesService();
	}

}
