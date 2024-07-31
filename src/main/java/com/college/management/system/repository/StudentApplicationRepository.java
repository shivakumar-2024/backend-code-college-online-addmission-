package com.college.management.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.management.system.entity.StudentApplication;

public interface StudentApplicationRepository extends JpaRepository<StudentApplication,Long>{

	Optional<StudentApplication> findByEmail(String email);

	

}
