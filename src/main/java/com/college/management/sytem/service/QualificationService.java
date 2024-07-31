package com.college.management.sytem.service;

import org.springframework.http.ResponseEntity;

import com.college.management.system.VO.QualificationVO;
import com.college.management.system.entity.Qualification;

public interface QualificationService {

	//Qualification addQualificationService(Qualification qualification);

	QualificationVO studentQualificationService(QualificationVO qualificationVO);

}
