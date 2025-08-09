package com.api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")

public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int rolNum;
	
	@Column(name="name")
	private String name;
	
	@Column(name="branch")
	private String branch;
	  
	@Column(name="percentage")
	private float percentage;

	public int getRolNum() {
		return rolNum;
	}

	public void setRolNum(int rolNum) {
		this.rolNum = rolNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}

	
	public Student( String name, String branch, float percentage) {
		super();
			
		this.name = name;
		this.branch = branch;
		this.percentage = percentage;
	}
	
	
	
	

}
