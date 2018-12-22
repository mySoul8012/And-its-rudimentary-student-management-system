package com.ming.entity;

// 对应于sc表
public class CourseSelection extends AbstractEntity{
    private String sno;
    private String cno;
    private String grade;

    /**
     * 构造
     */
    public CourseSelection(){
        this.sno = "";
        this.cno = "";
        this.grade = "";
    }

    /**
     * @param
     * @return String
     * get sno
     */
    public String getSno(){
        return this.sno;
    }

    /**
     * @param _sno
     * @return void
     * set sno
     */
    public void setSno(String _sno){
        this.sno = _sno;
    }

    /**
     * @return
     */
    public String getCno(){
        return this.cno;
    }

    /**
     * @param _cno
     */
    public void setCno(String _cno){
        this.cno = _cno;
    }

    /**
     * @return
     */
    public String getGrade(){
        return this.grade;
    }

    /**
     * @param _grade
     */
    public void setGrade(String _grade){
        this.grade = _grade;
    }
}
