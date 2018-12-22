package com.ming.ServiceLayer;

import com.ming.entity.Student;
import com.ming.entity.User;
import com.ming.tools.TransferredMeaning;
import com.ming.view.studentUI.StudentInfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * 此类封装了对Student表的操作
 */
public class StudentInfoTable extends DBConnection{
    private String sno = null; // 学号
    private String sn = null; // 姓名
    private String sex = null; // 性别
    private String age = null; // 年龄
    private String dept = null;    // 系别
    public Student student = new Student();
    public StudentInfoTable(){
        super();    // 初始化连接
    }

    /**
     * @param _student
     * @return Student
     * @throws Exception
     * 对学生查询
     */
    public Student selectStudent(Student _student) throws Exception{
        // 获取当前登录信息
        // 学号
        this.sno = _student.getSno();
        this.sno = TransferredMeaning.getTransferredMeaning(this.sno);
        // 姓名
        this.sn = _student.getSn();
        this.sn = TransferredMeaning.getTransferredMeaning(this.sn);
        // 性别
        this.sex = _student.getSex();
        this.sex = TransferredMeaning.getTransferredMeaning(this.sex);
        // 年龄
        this.age = _student.getAge();
        this.age = TransferredMeaning.getTransferredMeaning(this.age);
        // 系别
        this.dept = _student.getDept();
        this.dept = TransferredMeaning.getTransferredMeaning(this.dept);
        // 拼接sql
        this.sql = "SELECT sno,sn,sex,age,dept FROM s WHERE sno = '" + this.sno + "' ;";
        //System.out.println(this.sql);
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

    /**
     * @param _student
     * @return boolean
     * @throws Exception
     * 对学生增加
     */
    public boolean addStudent(Student _student) throws Exception{
        this.dept = _student.getDept();
        this.dept = TransferredMeaning.getTransferredMeaning(this.dept);
        this.age = _student.getAge();
        this.age = TransferredMeaning.getTransferredMeaning(this.age);
        this.sex = _student.getSex();
        this.sex = TransferredMeaning.getTransferredMeaning(this.sex);
        this.sn = _student.getSn();
        this.sn = TransferredMeaning.getTransferredMeaning(this.sn);
        this.sno = _student.getSno();
        this.sno = TransferredMeaning.getTransferredMeaning(this.sno);
        // 拼接sql
        this.sql = "INSERT s(dept, age, sex, sn, sno) values('" + this.dept + "','" + this.age + "','" + this.sex + "','" + this.sn + "','" + this.sno + "');";
        // 执行sql
        super.executeQuery();
        // 进行判断
        String rs = this.getResultSetUpdate();
        if("1".equals(rs)){
            return true;
        }
        return false;
    }

    /**
     * @param oldstudent
     * @param student
     * @return boolean
     * 对学生信息更改
     */
    // 对学生信息更改
    public boolean changeStudent(Student oldstudent, Student student) throws Exception{
        this.sn = student.getSn();
        this.sn = TransferredMeaning.getTransferredMeaning(this.sn);
        this.dept = student.getDept();
        this.dept = TransferredMeaning.getTransferredMeaning(this.dept);
        this.sno = student.getSno();
        this.sno = TransferredMeaning.getTransferredMeaning(this.sno);
        this.sex = student.getSex();
        this.sex = TransferredMeaning.getTransferredMeaning(this.sex);
        this.age = student.getAge();
        this.age = TransferredMeaning.getTransferredMeaning(this.age);
        // 拼接sql
        this.sql = "UPDATE s SET sn = '" + this.sn + "', sex = '" + this.sex + "', sn = '" + this.sn + "', age = '" + this.age + "' where sno = '" + oldstudent.getSno() + "';";
        // 执行
        super.executeQuery();
        // 进行判断
        String rs = this.getResultSetUpdate();
        return "1".equals(rs);
    }

    /**
     * @param student
     * @return boolean
     * 删除学生
     */
    public boolean deleteStudent(Student student)throws Exception{
       this.age = student.getAge();
       this.age = TransferredMeaning.getTransferredMeaning(this.age);
       this.sn = student.getSn();
       this.sn = TransferredMeaning.getTransferredMeaning(this.sn);
       this.sex = student.getSex();
       this.sex = TransferredMeaning.getTransferredMeaning(this.sex);
       this.dept = student.getDept();
       this.dept = TransferredMeaning.getTransferredMeaning(this.dept);
       this.sno = student.getSno();
       this.sno = TransferredMeaning.getTransferredMeaning(this.sno);
       // 拼接sql
        this.sql = "DELETE FROM s WHERE sno='" + this.sno + "';";
        // 执行
        this.executeQuery();
        // 获取结果
        return "1".equals(this.getResultSetUpdate());
    }
    /**
     * @param limt
     * @param length
     * @return List<Student>
     * 返回学生列表,第一个参数为页数  第二个参数为页数的长度，返回的是已经分页过的
     */
    public List<Student> listStudent(int limt, int length) throws Exception {
        // 验证传入值
        if(limt < 0 || length < 0){
            throw new Exception("传入的limt，length错误");
        }
        // 拼接sql
        this.sql = "SELECT sno,sn,sex,age,dept FROM s LIMIT " + limt * length + "," + length + ";";
        // 执行sql
        super.executeQuery();
        // 获取结果
        ResultSet rs = this.getResultSet();
        List<Student> list = new ArrayList<Student>();
        while(rs.next()){
            Student tmpStudent = new Student();
            //System.out.println(rs.getString(1));
            tmpStudent.setSno(rs.getString(1));
            tmpStudent.setSn(rs.getString(2));
            tmpStudent.setSex(rs.getString(3));
            tmpStudent.setAge(rs.getString(4));
            tmpStudent.setDept(rs.getString(5));
            //System.out.println(tmpStudent.getSno());
            list.add(tmpStudent);
        }
        return list;
    }
}
