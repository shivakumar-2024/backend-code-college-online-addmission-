package com.college.management.system.serviceimp;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.StudentVO;
import com.college.management.system.common.PasswordGenerator;
import com.college.management.system.entity.MasterRoles;
import com.college.management.system.entity.UserLogin;
import com.college.management.system.entity.UserRegisteration;
import com.college.management.system.entity.UserRole;
import com.college.management.system.repository.MasterRoleDao;
import com.college.management.system.repository.StudentRepository;
import com.college.management.system.repository.UserLoginRepository;
import com.college.management.sytem.service.StudentService;

import net.bytebuddy.utility.RandomString;

@Service
public class StudentServiceImp implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Autowired
	private MasterRoleDao masterRoleDao;
	
	@Autowired
	private UserLoginRepository UserRoleRepository;

	@Override
	public String addStudentDetailService(StudentVO studentVo) {
		if(studentVo.getId()!=null) {
			UserRegisteration studentRegisteration=this.studentRepository.findById(studentVo.getId()).get();
			
			studentRegisteration.setName(studentVo.getName());
			studentRegisteration.setFatherName(studentVo.getFatherName());
			studentRegisteration.setMotherName(studentVo.getMotherName());
			studentRegisteration.setGender(studentVo.getGender());
			studentRegisteration.setPhoneNumber(studentVo.getPhoneNumber());
			studentRegisteration.setDob(studentVo.getDob());
			studentRegisteration.setAddressLin1(studentVo.getAddressLin1());
			studentRegisteration.setCity(studentVo.getCity());
			studentRegisteration.setPinCode(studentVo.getPinCode());
			studentRegisteration.setState(studentVo.getState());
			UserLogin userLogin=new UserLogin();
			
			    userLogin.setPassword(studentVo.getPassword());
			    userLogin.setUserName(studentVo.getEmail());
			   
			    
			    studentRegisteration.setUser(userLogin);
			    
			    MasterRoles masterRoles=masterRoleDao.findByRoleType(studentVo.getStudentRole());
			   
			    userLogin.setMasterRoles(chechUserMasterRoles(masterRoles.getId()));
			    this.studentRepository.save(studentRegisteration);
			    userLoginRepository.save(userLogin);
			
		}else {
			UserRegisteration student=new UserRegisteration();
			student.setName(studentVo.getName());
			student.setMotherName(studentVo.getMotherName());
			student.setFatherName(studentVo.getFatherName());
			
			student.setGender(studentVo.getGender());
			student.setPhoneNumber(studentVo.getPhoneNumber());
			
			//student.setPassword(PasswordGenerator.generatePassword());
			
			student.setDob(studentVo.getDob());
			student.setAddressLin1(studentVo.getAddressLin1());
			student.setCity(studentVo.getCity());
			student.setPinCode(studentVo.getPinCode());
			student.setState(studentVo.getState());
			
			
			UserLogin userLogin=new UserLogin();
			 MasterRoles masterRoles=masterRoleDao.findByRoleType(studentVo.getStudentRole());
		
		
			    userLogin.setPassword(studentVo.getPassword());
			    userLogin.setUserName(studentVo.getEmail());
			    userLogin =  userLoginRepository.save(userLogin);
			    student.setUser(userLogin);
			    userLogin.setMasterRoles(chechUserMasterRoles(masterRoles.getId()));
			   
			   
			   
			    this.studentRepository.save(student);
			
			
			
		}
		return "Registration is successfully complete.";
	}

	

	



	






	private MasterRoles chechUserMasterRoles(Long id) {
		 MasterRoles masterRoles=masterRoleDao.findById(id).get();
		 return masterRoles;
	}

	

}
