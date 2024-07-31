package com.college.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.management.system.entity.MasterRoles;

public interface MasterRoleDao extends JpaRepository<MasterRoles,Long> {

	//MasterRoles findByName(String name);

	MasterRoles findByRoleType(String string);

}
