package com.college.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.management.system.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Long> {

}
