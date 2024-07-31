package com.college.management.system.VO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CountryVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
private String countryName;
}
