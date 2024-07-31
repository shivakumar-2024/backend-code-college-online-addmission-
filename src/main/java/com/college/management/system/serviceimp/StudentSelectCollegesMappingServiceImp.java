package com.college.management.system.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.StudentSelectCollegesMappingVO;
import com.college.management.system.entity.RegisterCollege;
import com.college.management.system.entity.StudentApplication;
import com.college.management.system.entity.StudentSelectCollegesMapping;
import com.college.management.system.repository.RegisterCollegeRepository;
import com.college.management.system.repository.StudentApplicationRepository;
import com.college.management.system.repository.StudentSelectCollegesMappingRepository;
import com.college.management.sytem.service.StudentSelectCollegesMappingService;

@Service
public class StudentSelectCollegesMappingServiceImp  implements StudentSelectCollegesMappingService{
	
	@Autowired
	private StudentApplicationRepository studentApplicationRepository;
	
	@Autowired
	private RegisterCollegeRepository registerCollegeRepository;
	
	@Autowired
	private StudentSelectCollegesMappingRepository studentSelectCollegesMappingRepository;

	@Override
	public String studentsSelectCollegesService(StudentSelectCollegesMappingVO studentSelectCollegesMappingVO) {
		
		List<Long> dataCollege = new ArrayList<>();
		
		StudentSelectCollegesMapping studentsSelectCollegesMapping=new StudentSelectCollegesMapping();
		
		Optional<StudentApplication> studentApplication=studentApplicationRepository.findById(studentSelectCollegesMappingVO.getUserId());
		
		dataCollege.addAll(studentSelectCollegesMappingVO.getCollegeIds());
		
		if(studentApplication.isPresent()) {
			for(Long dataid:dataCollege) {
				
				Optional<RegisterCollege> registerCollege=this.registerCollegeRepository.findById(dataid);
				studentsSelectCollegesMapping.setStudentApplication(checkStudentById(studentApplication.get().getId()));
				studentsSelectCollegesMapping.setRegisterCollegeid(checkCollegeId(registerCollege.get().getId()));
				
				
				this.studentSelectCollegesMappingRepository.save(studentsSelectCollegesMapping);
				
			}
			
			
		}
		StudentApplication studentApplicationaddselectcollege=new StudentApplication();
//		studentApplicationaddselectcollege.setStudentSelectColleges(studentsSelectCollegesMapping.getId());
		this.studentApplicationRepository.save(studentApplicationaddselectcollege);
	
		
		return "success";
	}

	private List<RegisterCollege> checkCollegeId(Long id) {
	    Optional<RegisterCollege> registerCollegeOptional = this.registerCollegeRepository.findById(id);
	    
	    List<RegisterCollege> resultList = new ArrayList<>();
	    registerCollegeOptional.ifPresent(resultList::add);
	    
	    return resultList;
	}


	private StudentApplication checkStudentById(Long id) {
	    Optional<StudentApplication> studentApplication = this.studentApplicationRepository.findById(id);
	    return studentApplication.orElse(null); 
	}

}
