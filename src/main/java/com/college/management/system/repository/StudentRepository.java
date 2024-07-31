package com.college.management.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.management.system.entity.UserRegisteration;

public interface StudentRepository extends JpaRepository<UserRegisteration,Long>{

	//Object findByName(String userName);

	//Optional<String> findByPassword(String Password);
//
//	Optional<UserRegisteration> findByEmail(String userName);
//
//	Optional<UserRegisteration> findByPassword(String password);

}
