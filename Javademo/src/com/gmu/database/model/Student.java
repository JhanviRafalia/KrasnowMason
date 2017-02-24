package com.gmu.database.model;

public class Student {
	private int id;
	private String firstname;
	private String lastname;
	private String address;
	private String major;
	
	public Student(){
	
	}
	public Student(String firstname, String lastname, String address, String major) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.major = major;
	}
	
	public Student(int id, String firstname, String lastname, String address, String major) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.major = major;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	

}
