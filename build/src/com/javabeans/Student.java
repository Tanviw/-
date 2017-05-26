package com.javabeans;

import java.io.Serializable;

public class Student implements Serializable{
    private Long stuAccount;
    private String idCard;
	private String password;    
    private String stuName;   
    private String sex;         
    private String grade;       
    private String academy;    
    private String major;      
    public Long getStuAccount() {
        return stuAccount;
    }

    public void setStuAccount(Long stuAccount) {
        this.stuAccount = stuAccount;
    }
    public String getIdCard() {
    	return idCard;
    }
    
    public void setIdCard(String idCard) {
    	this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
