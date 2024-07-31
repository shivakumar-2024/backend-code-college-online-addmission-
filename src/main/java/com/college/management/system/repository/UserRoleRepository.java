package com.college.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.management.system.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Long>{

//	UserRole findByUserNameAndPassword(String userName, String password);

}
