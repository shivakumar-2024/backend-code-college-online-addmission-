package com.college.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.management.system.VO.CountryVO;
import com.college.management.sytem.service.CountryService;
import com.college.management.sytem.service.CoursesService;

@RestController
@CrossOrigin
public class CountryController {

	@Autowired
	
	private CountryService countryService;
	@PostMapping("add/country")
	public ResponseEntity<CountryVO> addCountry(@RequestBody CountryVO countryVO){
		return new ResponseEntity<>(countryService.addCountry(countryVO),HttpStatus.OK);
	}
	@GetMapping("fetch/country")
	public List<CountryVO> fetchCountry() {
	    return countryService.getAllCountries();
	}
}
