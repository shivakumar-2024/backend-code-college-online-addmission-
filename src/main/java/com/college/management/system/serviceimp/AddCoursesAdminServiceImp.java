package com.college.management.system.serviceimp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.AddCoursesAdminVO;
import com.college.management.system.entity.CollegeCourseMapping;
import com.college.management.system.entity.Courses;
import com.college.management.system.entity.RegisterCollege;
import com.college.management.system.repository.AddCoursesAdminRepository;
import com.college.management.system.repository.CoursesRepository;
import com.college.management.system.repository.RegisterCollegeRepository;
import com.college.management.sytem.service.AddCoursesAdminService;

@Service
public class AddCoursesAdminServiceImp implements AddCoursesAdminService {
	@Autowired
	private AddCoursesAdminRepository addcoursesAdminRepository;
	@Autowired
	private RegisterCollegeRepository registerCollegeRepository;
	@Autowired
	private CoursesRepository coursesRepository;

	@Override
	public String adminCoursesService(AddCoursesAdminVO addCoursesAdminVO) {

//		 List<Courses> coursesList = new ArrayList<>();
		RegisterCollege byCollegeCode = this.registerCollegeRepository
				.findByCollegeCode(addCoursesAdminVO.getCollegeCode())
				.orElseThrow(() -> new RuntimeException("The college code is incorrect."));

		CollegeCourseMapping addcoursesAdmin = new CollegeCourseMapping();
		addcoursesAdmin.setRegisterCollegeId(byCollegeCode);
		addcoursesAdmin.setCreatedOn(new Date());
		addcoursesAdmin.setCourses(
				addCoursesAdminVO.getCoursesId().stream().map(id -> existById(id)).collect(Collectors.toList()));
		this.addcoursesAdminRepository.save(addcoursesAdmin);

//		List<CollegeCourseMapping> code=this.addcoursesAdminRepository.findByCollegeCode(addCoursesAdminVO.getCollegeCode());
//		if(!code.isEmpty()) {
//			for(CollegeCourseMapping code1:code) {
//				Courses course = code1.getCourse();
//				 coursesList.add(course);
//				
//				}
//			
//		}
		return "Successful";

	}

	private RegisterCollege checkCollegeId(Long id) {

		RegisterCollege registerCollege = this.registerCollegeRepository.findById(id).get();
		return registerCollege;
	}

	private Courses existById(Long Id) {
		return this.coursesRepository.findById(Id).get();

	}

}