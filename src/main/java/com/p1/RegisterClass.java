package com.p1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class RegisterClass {
	
	@Id
	private Long reg;
	private String name;
	private String address;
	private String email;
	private Long phone;
	private String placement;
	private String batch;
	private String date;
	private String duration;
	private Long regfees;

	
	
	
}
