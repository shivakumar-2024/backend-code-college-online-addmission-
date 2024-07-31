package com.college.management.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.management.system.entity.StudentApplicationDocumentMapping;

public interface StudentApplicationDcomentMappingRepository extends JpaRepository<StudentApplicationDocumentMapping,Long> {

	List<StudentApplicationDocumentMapping> findAllByStudentApplication_AllotmentStatusTrue();
	List<StudentApplicationDocumentMapping> findAllByStudentApplication_AllotmentStatusFalse();
	List<StudentApplicationDocumentMapping>  findByStudentApplication_Id(Long id);

	
}