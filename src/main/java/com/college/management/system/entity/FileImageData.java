package com.college.management.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FileImageData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
private String imageName;
private String imagetype;
private String Fullpath;
}
