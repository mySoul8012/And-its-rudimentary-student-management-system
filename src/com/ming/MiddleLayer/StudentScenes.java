package com.ming.MiddleLayer;


import com.ming.entity.Curriculum;
import com.ming.entity.Student;

import java.util.List;

/**
 * @author ming
 * 学生场景
 */
public class StudentScenes extends AbstractColleague{
    /**
     * @param middleLayer
     * 和中介者建立联系
     */
    public StudentScenes(AbstractMiddleLayer middleLayer) {
        super(middleLayer);
    }

    /**
     * @param sno 学号
     * @return Student
     * 根据学号，返回学生基本信息
     */
    public Student BasicInformationForStudents(String sno){
        return super.middleLayer.execute("BasicInformationForStudents", sno).getStudent();
    }

    /**
     * @param sno 学号
     * @return list
     * 根据学号返回学生所选课程列表
     */
    public List<Curriculum> StudentElectiveCourse(String sno){
        return super.middleLayer.execute("selectionCourseSelection", sno).getListCurriculum();
    }

    /**
     * @param sno 学号
     * @param cno 课程号
     * @return boolean
     * 根据输入的学号，课程号，进行选课
     */
    public boolean CourseSelection(String sno, String cno){
        return super.middleLayer.execute("CourseSelection", sno,cno).getResult();
    }

}
