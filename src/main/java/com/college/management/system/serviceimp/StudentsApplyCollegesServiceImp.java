package com.college.management.system.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.StudentsApplyCollegesVO;
import com.college.management.system.entity.StudentApplication;
import com.college.management.system.entity.RegisterCollege;
import com.college.management.system.entity.StudentsApplyColleges;
import com.college.management.system.exception.CollegeNotFoundException;
import com.college.management.system.exception.CustomException;
import com.college.management.system.repository.StudentApplicationRepository;
import com.college.management.system.repository.RegisterCollegeRepository;
import com.college.management.system.repository.StudentsApplyCollegesRepository;
import com.college.management.sytem.service.StudentsApplyCollegesService;

@Service
public class StudentsApplyCollegesServiceImp implements StudentsApplyCollegesService {
	@Autowired
	private StudentApplicationRepository studentApplicationRepository;

	@Autowired
	private StudentsApplyCollegesRepository studentsApplyCollegesReposiotry;

	@Autowired
	private RegisterCollegeRepository registerCollegeRepository;

	@Override
	public List<RegisterCollege> studentsAddCollegesService(StudentsApplyCollegesVO studentApplyCollegesVO) {
		List<RegisterCollege> registerCollege = new ArrayList<>();

		List<StudentsApplyColleges> stdColleges = new ArrayList<>();
		Optional<StudentApplication> studentEmail = this.studentApplicationRepository
				.findByEmail(studentApplyCollegesVO.getStudentEmail());

		if (studentEmail.isPresent()
				&& studentEmail.get().getEmail().equals(studentApplyCollegesVO.getStudentEmail())) {
			List<Integer> collegeIds = studentApplyCollegesVO.getCollegeId();

			// Set student email in studentsApplyColleges object
			for (Integer college : collegeIds) {
				StudentsApplyColleges studentsApply = new StudentsApplyColleges();
				// Correct method name

				studentsApply.setRegister(existById(Long.valueOf(college)));
				stdColleges.add(studentsApply);

			}
			this.studentsApplyCollegesReposiotry.saveAll(stdColleges);

			registerCollege = studentsApplyCollegesReposiotry.findAll().stream().map(element -> element.getRegister())
					.collect(Collectors.toList());

		}

		return registerCollege;
	}

	private StudentApplication existByEmail(String email) {
		return this.studentApplicationRepository.findByEmail(email).orElseThrow(()->new CustomException("Student application with email " + email + " not found"));
	}

	private RegisterCollege existById(Long valueOf) {
		return this.registerCollegeRepository.findById(valueOf).orElseThrow(()->new CollegeNotFoundException("Colleges not found "));
	}
}
