package com.college.management.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.college.management.system.VO.StudentApplicationDocumentMappingVO;
import com.college.management.system.VO.StudentApplicationShowCollegeVo;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentApplicationDocumentMapping {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private StudentApplication studentApplication; // 1-2
	
	@OneToOne
	private Qualification qualification;
	
	 private Double percentage;
	private Long passingYear;
	private String uploadDocument;
	
	
	public StudentApplicationShowCollegeVo convertoToVO() {
		StudentApplicationShowCollegeVo vo = new StudentApplicationShowCollegeVo();
		vo.setId(studentApplication.getId());
		vo.setCity(studentApplication.getCity());
		vo.setCountry(studentApplication.getCountryName().getCountryName());
		vo.setEmail(studentApplication.getEmail());
		//vo.setState(studentApplication.getState());
		vo.setFatherName(studentApplication.getFatherName());
		vo.setFirstName(studentApplication.getFirstName());
		vo.setLastName(studentApplication.getLastName());
		vo.setMotherName(studentApplication.getMotherName());
		vo.setCourse(studentApplication.getCourseMaster().getCourses());
		//vo.setStandard(studentApplication.getCity());
		vo.setPassingYear(passingYear);
		vo.setPercentage(percentage);
		vo.setPinCode(studentApplication.getPinCode());
		vo.setState(studentApplication.getState());
		vo.setPhoneNumber(studentApplication.getPhoneNumber());
		vo.setAllotStatus(studentApplication.isAllotmentStatus());
		return vo;
		
	}
	

}
