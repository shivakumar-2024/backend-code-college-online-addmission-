package com.college.management.system.serviceimp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import javax.mail.Multipart;
import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.college.management.system.VO.StudentApplicationIdVO;
import com.college.management.system.VO.StudentApplicationVO;
import com.college.management.system.entity.StudentApplication;
import com.college.management.system.entity.Country;
import com.college.management.system.entity.Courses;
import com.college.management.system.repository.StudentApplicationRepository;
import com.college.management.system.repository.CountryRepository;
import com.college.management.system.repository.CoursesRepository;
import com.college.management.sytem.service.StudentApplicationService;
import com.google.gson.Gson;

@Service
public class StudentApplicationServiceImp implements StudentApplicationService {

	@Autowired
	private StudentApplicationRepository studentApplicationRepository;

	@Autowired
	private CoursesRepository coursesRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	
	

	

	private Courses getCourseMasterById(Long Id) {
		return coursesRepository.findById(Id).get();
	}

	private Country getCountryById(Long Id) {
		return countryRepository.findById(Id).get();
	}

	@Override
	public String addStudentApplicationService(String addStudentApplicationVO, MultipartFile file) {
		StudentApplication addStudentApplication = new StudentApplication();
		Gson data = new Gson();
		StudentApplicationVO addStudentApplicationVO1 = data.fromJson(addStudentApplicationVO,
				StudentApplicationVO.class);
		addStudentApplication.setFirstName(addStudentApplicationVO1.getFirstName());
		addStudentApplication.setLastName(addStudentApplicationVO1.getLastName());
		addStudentApplication.setEmail(addStudentApplicationVO1.getEmail());
		addStudentApplication.setDob(addStudentApplicationVO1.getDob());
		
		addStudentApplication.setFatherName(addStudentApplicationVO1.getFatherName());
		addStudentApplication.setMotherName(addStudentApplicationVO1.getMotherName());
		addStudentApplication.setPhoneNumber(addStudentApplicationVO1.getPhoneNumber());
		addStudentApplication.setCity(addStudentApplicationVO1.getCity());
		addStudentApplication.setCountryName(getCountryById(addStudentApplicationVO1.getCountry()));
		addStudentApplication.setCourseMaster(getCourseMasterById(Long.valueOf(addStudentApplicationVO1.getCourseMaster())));
		addStudentApplication.setState(addStudentApplicationVO1.getState());
		// addStudentApplication.setQualification(addStudentApplicationVO1.getQualification());
		addStudentApplication.setPinCode(addStudentApplicationVO1.getPinCode());
		String photo = addPhotoStudent(file);
		addStudentApplication.setPhoto(photo);
		
		addStudentApplication = this.studentApplicationRepository.save(addStudentApplication);

		return addStudentApplication.getId().toString();
	}


	

	private String addPhotoStudent(MultipartFile file) {
		String folderName = "D://Student Photo//";
		String imageName = file.getOriginalFilename();
		String fullPath = folderName + imageName;
		try {
			File folder = new File(folderName);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			Files.copy(file.getInputStream(), Paths.get(fullPath));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return fullPath;
	}



	@Override
	public String UserIdAllotTrueService(StudentApplicationIdVO studentApplicationIdVO) {
		Optional<StudentApplication> studentApplication=this.studentApplicationRepository.findById(studentApplicationIdVO.getId());
		if(studentApplication.isPresent()) { 
		    StudentApplication studentApp = studentApplication.get();
		    studentApp.setAllotmentStatus(true); 
		    
		    
		    this.studentApplicationRepository.save(studentApp);
		}
		else
			throw new RuntimeErrorException(null, "Invalid id");
		return "success";
	}

}
