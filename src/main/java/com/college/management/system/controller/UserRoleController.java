package com.college.management.system.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.UserRoleVO;
import com.college.management.sytem.service.UserRoleService;

@RestController
public class UserRoleController {
	@Autowired
	private UserRoleService userRoleService;

//	@PostMapping("check/user")
//	public ResponseEntity<HashMap<Long,String>> checkUserService(UserRoleVO userRoleVO){
//		return new ResponseEntity<>(userRoleService.checkUserService(userRoleVO));
//	}
}
