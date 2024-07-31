//package com.college.management.system.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.college.management.system.entity.CoursesModel;
//import com.college.management.sytem.service.CoursesModelService;
//
//@RestController
//@RequestMapping("/course")
//public class CoursesModelController {
//	@Autowired
//	private  CoursesModelService coursesModelService; 
//
//	@GetMapping("/stream")
//	public ResponseEntity<?> getAllCourses(){
//		
//		return new ResponseEntity<>(coursesModelService.getAllCoursesService(), HttpStatus.OK);
//		
//	}
//}
