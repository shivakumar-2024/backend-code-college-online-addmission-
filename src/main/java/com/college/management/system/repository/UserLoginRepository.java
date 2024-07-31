package com.college.management.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.management.system.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin,Long>{

	boolean existsByUserName(String userName);

	Optional<UserLogin> findByUserNameAndPassword(String userName, String password);

	UserLogin findByMasterRoles(int role);

	

}
