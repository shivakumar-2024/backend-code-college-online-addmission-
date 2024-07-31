package com.college.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.AddCoursesAdminVO;
import com.college.management.sytem.service.AddCoursesAdminService;
@RestController
@CrossOrigin
public class CollegeCourseMappingController {
    @Autowired
    private AddCoursesAdminService addCoursesAdminService;
    
    @PostMapping("/admin/courses")
    public ResponseEntity<String> adminCourses(@RequestBody AddCoursesAdminVO addCoursesAdminVO) {
        String message = addCoursesAdminService.adminCoursesService(addCoursesAdminVO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}