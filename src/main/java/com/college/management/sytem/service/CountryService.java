package com.college.management.sytem.service;

import java.util.List;

import com.college.management.system.VO.CountryVO;

public interface CountryService {

	CountryVO addCountry(CountryVO countryVO);

	List<CountryVO> getAllCountries();

}
