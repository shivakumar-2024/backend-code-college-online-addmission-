 package com.college.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.CoursesVO;
import com.college.management.system.repository.StreamRepository;
import com.college.management.sytem.service.StreamBtechService;

@RestController
@RequestMapping("/stream")
public class BtechStreamController {
	
	@Autowired
	private StreamRepository streamRepo;
	@Autowired
	private StreamBtechService streamBtechService;
	
@GetMapping("/{id}")
public ResponseEntity<?> readBtechStream(@PathVariable("id") Long id){
		return new ResponseEntity<>(streamBtechService.readBtechStreamService(id),HttpStatus.OK);
		
	}
	

}
