package com.college.management.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.management.system.entity.CollegeCourseMapping;

public interface AddCoursesAdminRepository extends JpaRepository<CollegeCourseMapping,Long>{
	
	//List<CollegeCourseMapping> findByCollegeCode(String collegeCode);	

}
