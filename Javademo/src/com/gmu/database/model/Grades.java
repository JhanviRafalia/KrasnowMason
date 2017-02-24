package com.gmu.database.model;

public class Grades {
	private final int sid;
	private final String coursename;
	private final String grade;
	
	/**
	 * This construcotr will be used to create new Grad object for insert
	 * 
	 * @param coursename
	 * @param grade
	 */
	public Grades(String coursename, String grade) {
		this.sid = -1;
		this.coursename = coursename;
		this.grade = grade;
	}
	
	/**
	 * This oconstructor will be used when reading from the database
	 * 
	 * @param sid
	 * @param coursename
	 * @param grade
	 */
	public Grades(int sid, String coursename, String grade) {
		this.sid = sid;
		this.coursename = coursename;
		this.grade = grade;
	}
	
	public int getSid() {
		return sid;
	}
	
	public String getCoursename() {
		return coursename;
	}
	
	public String getGrade() {
		return grade;
	}
}
