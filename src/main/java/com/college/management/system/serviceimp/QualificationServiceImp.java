package com.college.management.system.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.QualificationVO;
import com.college.management.system.entity.Qualification;
import com.college.management.system.repository.QualificationRepository;
import com.college.management.sytem.service.QualificationService;

@Service
public class QualificationServiceImp implements QualificationService{
	@Autowired
	private QualificationRepository qualificationRepository;

	


	@Override
	public QualificationVO studentQualificationService(QualificationVO qualificationVO) {
		Qualification qualification=new Qualification();
		qualification.setHigherEducation(qualificationVO.getHigherEducation());
		this.qualificationRepository.save(qualification);
		
		QualificationVO qualificationVOData=new QualificationVO();
		qualificationVOData.setHigherEducation(qualification.getHigherEducation());
		return qualificationVOData;
	}
	

}
