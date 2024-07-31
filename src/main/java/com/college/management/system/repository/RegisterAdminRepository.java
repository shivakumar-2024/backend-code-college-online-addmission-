package com.college.management.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.management.system.entity.RegisterAdmin;

public interface RegisterAdminRepository extends JpaRepository<RegisterAdmin,Long>{

	//Optional<RegisterAdminRepository> findByUserName(String userName);

	//Optional<RegisterAdminRepository> findByUserNameAndfindByPassword(String userName, String password);

	

	//boolean existsByEmail(String email);

	
	//boolean existsByEmail(String email);

//	Optional<RegisterAdmin> findByEmail(String userName);

//	boolean existsByEmail(String email);

	

	
	
	

}
