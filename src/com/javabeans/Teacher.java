package com.javabeans;

import java.io.Serializable;

public class Teacher implements Serializable{

    private Long teacherAccount; 
    private String idCard;

	private String password;       
    private String teacherName;    
    private String sex;             
    private String technicalTitle;  
    private String academy;        
    private String researchFields;   
    public Long getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(Long teacherAccount) {
        this.teacherAccount = teacherAccount;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTechnicalTitle() {
        return technicalTitle;
    }

    public void setTechnicalTitle(String technicalTitle) {
        this.technicalTitle = technicalTitle;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getResearchFields() {
        return researchFields;
    }

    public void setResearchFields(String researchFields) {
        this.researchFields = researchFields;
    }
}
