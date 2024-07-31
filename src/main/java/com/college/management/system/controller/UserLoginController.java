package com.college.management.system.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.UserLoginVO;
import com.college.management.sytem.service.UserLoginService;

@RestController
@CrossOrigin

public class UserLoginController {
	@Autowired
	private UserLoginService userLoginService;
//@PostMapping("/user/login")
//public ResponseEntity<String> userLogin( @RequestBody UserLoginVO userLoginVo) throws Exception{
//	return new ResponseEntity<>(useerLoginService.userLoginData(userLoginVo),HttpStatus.OK);
//}
	@PostMapping("/check/user")
	public ResponseEntity<?> checkUser(@RequestBody UserLoginVO userLoginVO) {
	    Map<String, Object> result = userLoginService.checkUserService(userLoginVO);
	    return ResponseEntity.ok(result);
	}


}

