package com.college.management.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {
	public UserLogin(Long userId) {
		this.id=userId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	  @Column(unique = true)
	private String userName;
	  
	  @Column(unique = true)
	private String password;
	
	@ManyToOne
	private MasterRoles masterRoles;

}
