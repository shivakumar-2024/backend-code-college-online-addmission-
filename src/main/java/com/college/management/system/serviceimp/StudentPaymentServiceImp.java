package com.college.management.system.serviceimp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.StudentPaymentVO;
import com.college.management.system.entity.StudentApplication;
import com.college.management.system.entity.StudentPayment;
import com.college.management.system.repository.StudentApplicationRepository;
import com.college.management.system.repository.StudentPaymentRepository;
import com.college.management.sytem.service.StudentPaymentService;

@Service
public class StudentPaymentServiceImp implements StudentPaymentService {
	@Autowired
	private StudentApplicationRepository studentApplicationRepository;
	
	@Autowired
	private StudentPaymentRepository studentPaymentRepository;

	@Override
	public String studentPaymentSetService(StudentPaymentVO studentPaymentVO) {
		
		Optional<StudentApplication> studentApplication=this.studentApplicationRepository.findById(studentPaymentVO.getStudentId());
		
		
		 if (studentApplication != null) {
             // Create a new StudentPayment object
             StudentPayment studentPayment = new StudentPayment();
             studentPayment.setStudentApplicationPaymentId(studentApplication.get());
             studentPayment.setAmountFees(studentPaymentVO.getAmountFees());

             // Save the payment details
             studentPaymentRepository.save(studentPayment);

		 }
		return "Payment Successful";
	}

	
}
