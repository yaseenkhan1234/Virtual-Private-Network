package com.p1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class NewClientAdd {
	
	private String company;
	private String address;
	private String phone;
	@Id
	private String mail;
	private String person;
	private String password;
	
	
	

}
