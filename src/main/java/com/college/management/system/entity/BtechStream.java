package com.college.management.system.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class BtechStream {
@Id
private Long id;
private String bTechStream;
private Long coursesId;
private String name;
}
