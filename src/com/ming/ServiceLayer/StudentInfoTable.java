package com.ming.ServiceLayer;

import com.ming.entity.Student;
import com.ming.entity.User;
import com.ming.view.studentUI.StudentInfo;

import java.sql.ResultSet;

// 此类封装了对Student表的操作
public class StudentInfoTable extends DBConnection{
    private String sno; // 学号
    private String sn; // 姓名
    private String sex; // 性别
    private String age; // 年龄
    private String dept;    // 系别
    public Student student = new Student();
    public StudentInfoTable(){
        super();    // 初始化连接
    }
    // 对学生查询
    public Student selectStudent(Student _student) throws Exception{
        // 获取当前登录信息
        // 学号
        this.sno = _student.getSno();
        // 姓名
        this.sn = _student.getSn();
        // 性别
        this.sex = _student.getSex();
        // 年龄
        this.age = _student.getAge();
        // 系别
        this.dept = _student.getDept();
        // 拼接sql
        this.sql = "SELECT sno,sn,sex,age,dept FROM s WHERE sno = '" + this.sno + "' ;";
        // 执行sql
        super.executeQuery();
        // 获取结果
        ResultSet rs = this.getResultSet();
        while(rs.next()){
            this.student.setSno(rs.getString(1));
            this.student.setSn(rs.getString(2));
            this.student.setSex(rs.getString(3));
            this.student.setAge(rs.getString(4));
            this.student.setDept(rs.getString(5));
        }
        return this.student;
    }
    // 对学生增加
    public boolean addStudent(Student _student) throws Exception{
        this.dept = _student.getDept();
        this.age = _student.getAge();
        this.sex = _student.getSex();
        this.sn = _student.getSn();
        this.sno = _student.getSno();
        // 拼接sql
        this.sql = "INSERT s(dept, age, sex, sn, sno) values('" + this.dept + "','" + this.age + "','" + this.sex + "','" + this.sn + "','" + this.sno + "');";
        // 执行sql
        super.executeQuery();
        // 进行判断
        String rs = this.getResultSetUpdate();
        if(rs.equals("1")){
            return true;
        }
        return false;
    }
    // 对学生信息更改

}
