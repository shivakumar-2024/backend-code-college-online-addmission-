package com.college.management.sytem.service;

import java.util.Map;

import com.college.management.system.VO.UserLoginVO;

public interface UserLoginService {

	Map<String,Object> checkUserService(UserLoginVO userLoginVO);

	//String UserLoginData(UserLoginVO userLoginVo);

	//String adminLoginData(AdminLoginVO adminLoginVo);

	//String userLoginData(UserLoginVO userLoginVo) throws Exception;

}
