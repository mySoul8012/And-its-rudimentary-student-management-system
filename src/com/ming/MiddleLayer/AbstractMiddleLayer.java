package com.ming.MiddleLayer;

import com.ming.ServiceLayer.CourseSelectionTable;
import com.ming.ServiceLayer.CurrlculumTable;
import com.ming.ServiceLayer.StudentInfoTable;
import com.ming.ServiceLayer.UserLogin;
import com.ming.entity.CourseSelection;
import com.ming.entity.Curriculum;
import com.ming.entity.Student;

import java.util.List;

/**
 * @author ming
 * 抽象中介者类
 * 抽象类
 */
public abstract class AbstractMiddleLayer{
    protected CourseSelectionTable courseSelectionTable;
    protected CurrlculumTable currlculumTable;
    protected StudentInfoTable studentInfoTable;
    protected UserLogin userLogin;

    /**
     * 构造函数
     */
    public AbstractMiddleLayer(){
        this.courseSelectionTable = new CourseSelectionTable();
        this.currlculumTable = new CurrlculumTable();
        this.studentInfoTable = new StudentInfoTable();
    }

    /**
     * @param str
     * @param objects
     * @return
     */
    public abstract AbstractMiddleLayer execute(String str, Object...objects);

    /**
     * @return
     */
    public abstract boolean getResult();

    /**
     * @return
     */
    public abstract Student getStudent();

    /**
     * @return
     */
    public abstract List<CourseSelection> getListCourseSelection();
    public abstract List<Curriculum> getListCurriculum();
    public abstract List<Student> getListStudent();
    public abstract Curriculum getCurriculum();
}
