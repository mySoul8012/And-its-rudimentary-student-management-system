package com.ming.MiddleLayer;

import com.ming.entity.Curriculum;
import com.ming.entity.Student;
import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * 教师场景
 */
public class TeacherScenes extends AbstractColleague{
    public TeacherScenes(AbstractMiddleLayer middleLayer) {
        super(middleLayer);
    }
    // 学生管理
    /**
     * @param student 学生
     * @return boolean
     * 增加学生,即增加学生,学生的初始密码为12345678
     */
    public boolean addStudent(Student student){
        if(!super.middleLayer.execute("addStudent", student).getResult()){
            return false;
        }

        if(!super.middleLayer.execute("addUser", student.getSno(), "12345678").getResult()){
            return false;
        }

        return true;
    }

    /**
     * @param sno 学号
     * @param newStudent    新实体类
     * @return  boolean
     * 更改学生，更改学生的基本信息
     */
    public boolean changeStudent(String sno, Student newStudent){
        System.out.println(sno);
        return super.middleLayer.execute("changeStudent", sno,newStudent).getResult();
    }

    /**
     * @param sno 学号
     * @return boolean
     * 根据学号，删除学生
     */
    public boolean deleteStudent(String sno){
        return super.middleLayer.execute("deleteStudent", sno).getResult();
    }

    /**
     * @param limt 页数
     * @param length  长度
     * @return list<Student></>
     * 获取学生列表
     */
    public List<Student> listStudent(int limt, int length){
        return super.middleLayer.execute("ListStudent", limt, length).getListStudent();
    }

    // 课程
    /**
     * @param cno 学号
     * @return boolean
     * 根据课程号，获取课程信息
     */
    public Curriculum selectCurrlculum(String cno){
        return super.middleLayer.execute("selectCurrlculum", cno).getCurriculum();
    }

    /**
     * @param curriculum 课程
     * @return boolean
     * 增加一门课程
     */
    public boolean addCurrlculum(Curriculum curriculum){
        return super.middleLayer.execute("addCurrlculum", curriculum).getResult();
    }

    /**
     * @param cno 学号
     * @return boolean
     * 根据课程号，删除课程信息
     */
    public boolean deleteCurrlculum(String cno){
        return super.middleLayer.execute("deleteCurrlculum", cno).getResult();
    }

    /**
     * @param cno 课程号
     * @param curriculum   课程
     * @return boolean
     * 根据课程号，更改课程信息
     */
    public boolean changeCurrlculum(String cno, Curriculum curriculum){
        return super.middleLayer.execute("changeCurrlculum", cno, curriculum).getResult();
    }

    /**
     * @param limt
     * @return
     * 根据给定的limt length 进行分页
     */
    public List<Curriculum> listCurrlculum(int limt, int length){
        List<Curriculum> listCurriculum = new ArrayList<Curriculum>();
        System.out.println(limt + " 场景" + length);
        listCurriculum = super.middleLayer.execute("listCurrlculum", limt, length).getListCurriculum();
        //System.out.println(listCurriculum.get(0).getCn());
        return listCurriculum;
    }

    /**
     * @param sno
     * @param cno
     * @param achievement
     * @return
     */
    // 成绩录入
    public boolean ResultInput(String sno, String cno, String achievement){
        return super.middleLayer.execute("ResultInput", sno, cno, achievement).getResult();
    }
}
