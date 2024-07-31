package com.college.management.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.college.management.system.entity.RegisterCollege;
import com.college.management.system.entity.UserLogin;

public interface RegisterCollegeRepository extends JpaRepository<RegisterCollege,Long>{
	@Query(value="select * from register_college where college_code = ?1", nativeQuery=true)
	Optional<RegisterCollege> findByCollegeCode(String collegeCode);

	void findById(Integer iD);

	Optional<RegisterCollege> findByUser_Id(Long user);

	//List<RegisterCollege> findByName();

	//List<RegisterCollege> findAllByName();

}
