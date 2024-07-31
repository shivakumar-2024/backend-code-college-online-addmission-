package com.college.management.system.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.RegisterAdminVO;
import com.college.management.system.entity.MasterRoles;
import com.college.management.system.entity.RegisterAdmin;
import com.college.management.system.entity.RegisterCollege;
import com.college.management.system.entity.UserLogin;
import com.college.management.system.entity.UserRole;
import com.college.management.system.repository.MasterRoleDao;
import com.college.management.system.repository.RegisterAdminRepository;
import com.college.management.system.repository.RegisterCollegeRepository;
import com.college.management.system.repository.UserLoginRepository;
import com.college.management.system.repository.UserRoleRepository;
import com.college.management.sytem.service.RegisterAdminService;

@Service
public class RegisterAdminServiceImp implements RegisterAdminService{
	@Autowired
	private RegisterAdminRepository registerAdminRepository;
	@Autowired
	private RegisterCollegeRepository registerCollegeRepository;
	
	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Autowired
	private MasterRoleDao masterRoleDao;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	
	

	@Override
	public String addRegisterAdminService(RegisterAdminVO registerAdminVO) {
	
	
	if(this.userLoginRepository.existsByUserName(registerAdminVO.getEmail())) {
		throw new RuntimeException("You are already registered.");
	}
	else {
		
		RegisterAdmin registerAdmin=new RegisterAdmin();
		registerAdmin.setFirstName(registerAdminVO.getFirstName());
		registerAdmin.setLastName(registerAdminVO.getLastName());
		//registerAdmin.setUserName(registerAdminVO.getUserName());
		registerAdmin.setCity(registerAdminVO.getCity());
		
		
		registerAdmin.setMobile(registerAdminVO.getMobile());
		
		registerAdmin.setPinCode(registerAdminVO.getPinCode());
		registerAdmin.setAddress(registerAdminVO.getAddress());
		UserLogin user = new UserLogin();
		user.setUserName(registerAdminVO.getEmail());
		user.setPassword(registerAdminVO.getPassword());
		registerAdmin.setUser(user);
		userLoginRepository.save(user);
		MasterRoles roles = this.masterRoleDao.findByRoleType(registerAdminVO.getAdminRole());
		//user.setMasterRoles(roles.getRoleType());

		user.setMasterRoles(checkUserMasterRoles(roles.getId()));
		
		//registerAdmin.setUser(user);
		registerAdmin = this.registerAdminRepository.save(registerAdmin);
		
		return registerAdmin.getId().toString();
	}
	
	
	
	
	
	}

	private MasterRoles checkUserMasterRoles(Long id) {
		MasterRoles roles = this.masterRoleDao.findById(id).get();
		return roles;
	}

	@Override
	public List<RegisterCollege> readAdminCollegeService() {
		
		return this.registerCollegeRepository.findAll();
		}

}
