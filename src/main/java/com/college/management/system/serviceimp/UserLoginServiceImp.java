package com.college.management.system.serviceimp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.UserLoginVO;
import com.college.management.system.entity.UserLogin;
import com.college.management.system.repository.UserLoginRepository;
import com.college.management.sytem.service.UserLoginService;

@Service
public class UserLoginServiceImp implements UserLoginService {

	@Autowired
	private UserLoginRepository userLoginRepository;

	@Override
	public Map<String, Object> checkUserService(UserLoginVO userLoginVO) {

		UserLogin userLogin = userLoginRepository
				.findByUserNameAndPassword(userLoginVO.getUserName(), userLoginVO.getPassword()).orElse(null);
		HashMap<Long, String> map = new HashMap<>();
		if (userLogin != null) {

			return Map.of("userId", userLogin.getId(), "userRole", userLogin.getMasterRoles().getRoleType());
		}
		// UserLogin userLogin1
		// =userLoginRepository.findByMasterRoles(userLoginVO.getRole());
		return null;

	}
//	@Autowired
//	private StudentRepository studentRepository;
//	@Autowired
//	private AdminLoginRepository adminLoginRepository;
//
//	@Autowired
//	private UserLoginRepository userLoginRepository;
//
//	@Autowired
//	private RegisterAdminRepository registerAdminRepository;
//
//	@Override
//	public String userLoginData(UserLoginVO userLoginVo) throws Exception {
//		if (userLoginVo.getRole().equalsIgnoreCase("Student")) {
//			Optional<UserRegisteration> studentUser = this.studentRepository.findByEmail(userLoginVo.getUserName());
//			if (!studentUser.isPresent()) {
//				throw new Exception("User is not found with email!");
//			}
//			if (!userLoginVo.getPassword().equals(studentUser.get().getPassword())) {
//				throw new Exception("Password is incorrect!");
//			} else {
//				studentUser.get().setLastLoginAt(new Date());
//				this.studentRepository.save(studentUser.get());
//			}
//		} else {
//			Optional<RegisterAdmin> adminUser = this.registerAdminRepository.findByEmail(userLoginVo.getUserName());
//			if (!adminUser.isPresent()) {
//				throw new Exception("User is not found with email!");
//			}
//			if (!userLoginVo.getPassword().equals(adminUser.get().getPassword())) {
//				throw new Exception("Password is incorrect!");
//			} else {
//				adminUser.get().setLastLoginAt(new Date());
//				this.registerAdminRepository.save(adminUser.get());
//			}
//		}
//		return "Your login was successful.";
//	}

}
