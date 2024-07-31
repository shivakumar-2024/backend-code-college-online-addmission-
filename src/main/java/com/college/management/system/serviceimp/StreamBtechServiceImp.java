package com.college.management.system.serviceimp;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.entity.BtechStream;
import com.college.management.system.entity.Courses;
import com.college.management.system.repository.CoursesRepository;
import com.college.management.system.repository.StreamRepository;
import com.college.management.sytem.service.StreamBtechService;


@Service
public class StreamBtechServiceImp implements StreamBtechService {
	
	@Autowired
	private CoursesRepository coursesRepository;
	@Autowired
	private StreamRepository streamrepository;
	@Override
	public List<BtechStream> readBtechStreamService(Long id) {
		List<BtechStream> courses=this.streamrepository.findAllByCoursesId(id);
	//	System.err.println(courses.toString());
		//this.coursesRepository.findAll().
		return courses;
	}

	
	

}
