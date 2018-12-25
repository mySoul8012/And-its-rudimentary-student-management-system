package com.ming.entity;

// 对应于数据库的s表
public class Student {
    private String sno; // 学号
    private String sn; // 姓名
    private String sex; // 性别
    private String age; // 年龄
    private String dept;    // 系别

    /**
     *
     */
    public Student(){
        this.age = "";
        this.dept = "";
        this.sex = "";
        this.sn = "";
        this.sno = "";
    }

    /**
     * @return
     */
    public String getSno(){
        return this.sno;
    }

    /**
     * @param _sno
     */
    public void setSno(String _sno){
        this.sno = _sno;
    }

    /**
     * @return
     */
    public String getSn(){
        return this.sn;
    }

    /**
     * @param _sn
     */
    public void setSn(String _sn){
        this.sn = _sn;
    }

    /**
     * @return
     */
    public String getSex(){
        return this.sex;
    }

    /**
     * @param _sex
     */
    public void setSex(String _sex){
        this.sex = _sex;
    }

    /**
     * @return
     */
    public String getAge(){
        return this.age;
    }

    /**
     * @param _age
     */
    public void setAge(String _age){
        this.age = _age;
    }

    /**
     * @return
     */
    public String getDept(){
        return this.dept;
    }

    /**
     * @param _dept
     */
    public void setDept(String _dept){
        this.dept = _dept;
    }
}
