package com.gmu.databasedemo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gmu.database.model.Grades;
import com.gmu.database.model.Student;
import com.gmu.databasedemo.db.DBUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is respondible for updating the database with new recocrd
 * 
 * @author jhanvi
 *
 */
public class DataAccess {
	public void addNew(Student student) {

		try {
			PreparedStatement preparedStatement = DBUtils.getPreparedStatement("insert into student(firstname, lastname, address, major) values(?,?,?,?)");

			preparedStatement.setString(1, student.getFirstname());
			preparedStatement.setString(2, student.getLastname());
			preparedStatement.setString(3, student.getAddress());
			preparedStatement.setString(4, student.getMajor());

			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public static List<Student> getAll(){
		List<Student> ls = new LinkedList<>();

		try {
			ResultSet rs = DBUtils.getPreparedStatement("select * from student").executeQuery();
			while(rs.next()){
				Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				ls.add(student);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
		}


		return ls;
	}

	public static List<Student> getStudentById(int id){
		List<Student> ls = new LinkedList<>();
		String sql = "select * from student where id = " +id;
		try {
			ResultSet rs = DBUtils.getPreparedStatement(sql).executeQuery();
			while(rs.next()){
				Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				ls.add(student);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
		}


		return ls;
	}	

	public void edit(int id, String firstname, String lastname, String address, String major){
		try {
			String sql = "update student SET firstname = ?, lastname = ?, address = ?, major = ?" + " where id = ?";
			PreparedStatement preparedstatement= DBUtils.getPreparedStatement(sql);
			preparedstatement.setString(1, firstname);
			preparedstatement.setString(2, lastname);
			preparedstatement.setString(3, address);
			preparedstatement.setString(4, major);           
			preparedstatement.setInt(5, id);
			preparedstatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void delete(int id){
		try {
			String sql = "delete from student where id = ?";
			PreparedStatement ps = DBUtils.getPreparedStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static Student searchbyStudentById(int id){
		Student n = new Student();
		String sql = "select * from student where id = " +id;
		try {
			ResultSet rs = DBUtils.getPreparedStatement(sql).executeQuery();
			while(rs.next()){
				n = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
		}


		return n ;
	}	

	public void addNewGrade(Grades grades){

		try {
			PreparedStatement ps = DBUtils.getPreparedStatement("insert into grades(coursename, grade) values(?,?)");

			ps.setString(1, grades.getCoursename());
			ps.setString(2, grades.getGrade());


			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public static List<Grades> getAllGrades(){
		List<Grades> ls = new LinkedList<>();

		try {
			ResultSet rs = DBUtils.getPreparedStatement("select * from grades").executeQuery();
			while(rs.next()){
				Grades s = new Grades(rs.getInt(1), rs.getString(2),rs.getString(3));
				ls.add(s);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ls;

	}
	public void deleteg(int id){
		try {
			String sql = "delete from grades where sid = ?";
			PreparedStatement ps = DBUtils.getPreparedStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static List<Grades> getGradesById(int id) {
		List<Grades> ls = new LinkedList<>();
		String sql = "select * from grades where sid = " +id;
		try {
			ResultSet rs = DBUtils.getPreparedStatement(sql).executeQuery();
			while(rs.next()) {
				Grades n = new Grades(rs.getInt(1), rs.getString(2), rs.getString(3));
				ls.add(n);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ls;
	}
	
	public void editgrades(int id, String coursename, String grade){
		try {
			String sql = "update grades SET coursename = ?, grade = ?" + " where sid = ?";
			PreparedStatement preparedstatement= DBUtils.getPreparedStatement(sql);
			preparedstatement.setString(1, coursename);
			preparedstatement.setString(2, grade);
			           
			preparedstatement.setInt(3, id);
			preparedstatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
