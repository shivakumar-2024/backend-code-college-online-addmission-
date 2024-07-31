package com.college.management.system.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.management.system.VO.CountryVO;
import com.college.management.system.entity.Country;
import com.college.management.system.repository.CountryRepository;
import com.college.management.sytem.service.CountryService;
import com.college.management.sytem.service.CoursesService;

@Service
public class CountryServiceImp implements CountryService{
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public CountryVO addCountry(CountryVO countryVO) {
		Country country=new Country();
		country.setCountryName(countryVO.getCountryName());
		this.countryRepository.save(country);
		CountryVO countryVo=new CountryVO();
		countryVo.setCountryName(country.getCountryName());
		countryVo.setId(countryVo.getId());
		
		return countryVo;
	}

	@Override
	public List<CountryVO> getAllCountries() {
		
		List<Country> country=this.countryRepository.findAll();
		
		List <CountryVO>  countryVO =new ArrayList<CountryVO>();
		 
		 for(Country countryAddress:country) {
			 CountryVO countryVO1 = new CountryVO();
			 countryVO1.setId(countryAddress.getId());
			 countryVO1.setCountryName(countryAddress.getCountryName());
			 
			 countryVO.add(countryVO1);
		 }
		// countryVO.setCountryName(country.get);
		return countryVO;
	}

	

	
	}


