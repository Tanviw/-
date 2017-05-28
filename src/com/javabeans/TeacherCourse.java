package com.javabeans;

import java.io.Serializable;

public class TeacherCourse  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long teacherAccount;
	private String courseNumber;
	private String courseTimeId;
	private int classRoomId;
	private int capacity;
	private int surplus;
	
	private int teacherCourseId;
	private String teacherName;
	private String courseName;
	private String courseTime;
	private String classRoomLocation;
	private int credit;
	
	
	public int getTeacherCourseId() {
		return teacherCourseId;
	}
	public void setTeacherCourseId(int teacherCourseId) {
		this.teacherCourseId = teacherCourseId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	public String getClassRoomLocation() {
		return classRoomLocation;
	}
	public void setClassRoomLocation(String classRoomLocation) {
		this.classRoomLocation = classRoomLocation;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public Long getTeacherAccount() {
		return teacherAccount;
	}
	public void setTeacherAccount(Long teacherAccount) {
		this.teacherAccount = teacherAccount;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getCourseTimeId() {
		return courseTimeId;
	}
	public void setCourseTimeId(String courseTimeId) {
		this.courseTimeId = courseTimeId;
	}
	public int getClassRoomId() {
		return classRoomId;
	}
	public void setClassRoomId(int classRoomId) {
		this.classRoomId = classRoomId;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getSurplus() {
		return surplus;
	}
	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}
	
}
