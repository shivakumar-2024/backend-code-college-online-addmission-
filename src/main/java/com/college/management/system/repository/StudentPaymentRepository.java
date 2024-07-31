package com.college.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.management.system.entity.StudentPayment;

public interface StudentPaymentRepository extends JpaRepository<StudentPayment,Long> {

}
