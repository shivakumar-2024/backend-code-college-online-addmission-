package com.college.management.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Courses {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private  String courses;
//@ManyToMany(targe)
//private
}
