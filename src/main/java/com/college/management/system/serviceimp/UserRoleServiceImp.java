package com.college.management.system.serviceimp;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.UserRoleVO;
import com.college.management.system.entity.UserRole;
import com.college.management.system.repository.UserRoleRepository;
import com.college.management.sytem.service.UserRoleService;

@Service
public class UserRoleServiceImp implements UserRoleService{

	@Autowired
	private UserRoleRepository userRoleRepository;
	

//	@Override
//	public HashMap<Long,String> checkUserService(UserRoleVO userRoleVO) {
//		UserRole userRole=userRoleRepository.findByUserNameAndPassword(userRoleVO.getUserName(),userRoleVO.getPassword());
//		HashMap<Long, String> map = new HashMap<>();
//		map.put(userRole.getUserRoleId(), userRole.getMasterRoles().getRoleType());
//		return map;
//
//	}

	
}
