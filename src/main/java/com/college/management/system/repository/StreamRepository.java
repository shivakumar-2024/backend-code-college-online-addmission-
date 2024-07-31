package com.college.management.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.management.system.entity.BtechStream;

@Repository
public interface StreamRepository extends JpaRepository<BtechStream, Long> {

	//List<BtechStream> findBycourseId(Long id);

	//Object findAllByCourse_Id(Long id);

	List<BtechStream> findAllByCoursesId(Long id);

	
}
