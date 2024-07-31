package com.college.management.system.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.RegisterCollegeVO;
import com.college.management.system.VO.RegisterCollegeVO1;
import com.college.management.system.entity.RegisterCollege;
import com.college.management.system.entity.UserLogin;
import com.college.management.system.repository.RegisterAdminRepository;
import com.college.management.system.repository.RegisterCollegeRepository;
import com.college.management.sytem.service.RegisterCollegeService;
@Service
public class RegisterCollegeServiceImp implements RegisterCollegeService {
    @Autowired
    private RegisterCollegeRepository registerCollegeRepository;
    
    @Autowired
    private RegisterAdminRepository registerAdminRepository;

    @Override
    public String registerNewCollegeService(RegisterCollegeVO registerCollegeVO) throws Exception {
        Optional<RegisterCollege> registerData = this.registerCollegeRepository.findByCollegeCode(registerCollegeVO.getCollegeCode());

        if (registerData.isPresent()) {
            if (registerCollegeVO.getName().equals(registerData.get().getName())) {
                throw new Exception("The college is already registered.");
            } else {
                return "The provided college name does not match the existing name.";
            }
        } else {
            RegisterCollege registerCollege = new RegisterCollege();
            registerCollege.setAddress(registerCollegeVO.getAddress());
            registerCollege.setCollegeCode(registerCollegeVO.getCollegeCode());
            registerCollege.setEmailId(registerCollegeVO.getEmailId());
            registerCollege.setName(registerCollegeVO.getName());
            registerCollege.setPassword(registerCollegeVO.getPassword());
            registerCollege.setPhoneNo(registerCollegeVO.getPhoneNo());
            registerCollege.setTotalSeat(registerCollegeVO.getTotalSeat());
            registerCollege.setUser(new UserLogin(registerCollegeVO.getUserId()));

            this.registerCollegeRepository.save(registerCollege);
            
            
         

            return "Your registration is successful.";
        }
    }

    @Override
    public List<RegisterCollegeVO1> getAllColleges() {
        List<RegisterCollegeVO1> collegeName = new ArrayList<>();
        List<RegisterCollege> registerCollege = this.registerCollegeRepository.findAll();
        if (!registerCollege.isEmpty()) {
            collegeName = registerCollege.stream().map(data -> {
                RegisterCollegeVO1 registerCollegeVO1 = new RegisterCollegeVO1();
                registerCollegeVO1.setId(data.getId());
                registerCollegeVO1.setName(data.getName());
                registerCollegeVO1.setEmailId(data.getEmailId());
                registerCollegeVO1.setPhoneNo(data.getPhoneNo());
                registerCollegeVO1.setTotalSeat(data.getTotalSeat());
                registerCollegeVO1.setCollegeCode(data.getCollegeCode());
                registerCollegeVO1.setAddress(data.getAddress());
                return registerCollegeVO1;
            }).collect(Collectors.toList());
        }
        return collegeName;
    }
}
