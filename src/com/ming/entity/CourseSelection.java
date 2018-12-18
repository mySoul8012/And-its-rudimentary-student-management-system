package com.ming.entity;

// 对应于sc表
public class CourseSelection {
    private String sno;
    private String cno;
    private String grade;
    public String getSno(){
        return this.sno;
    }
    public void setSno(String _sno){
        this.sno = _sno;
    }
    public String getCno(){
        return this.cno;
    }
    public void setCno(String _cno){
        this.cno = _cno;
    }
    public String getGrade(){
        return this.grade;
    }
    public void setGrade(String _grade){
        this.grade = _grade;
    }
}
