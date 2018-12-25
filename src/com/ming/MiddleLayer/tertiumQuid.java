package com.ming.MiddleLayer;

import com.ming.ServiceLayer.CourseSelectionTable;
import com.ming.ServiceLayer.CurrlculumTable;
import com.ming.ServiceLayer.StudentInfoTable;
import com.ming.ServiceLayer.UserLogin;
import com.ming.entity.*;
import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * 中介者
 */
public class tertiumQuid extends AbstractMiddleLayer{
    // 结果
    private boolean result = false;
    private Student student;
    private User user;
    private Curriculum curriculum;
    private CourseSelection courseSelection;
    private List<Curriculum> listCurriculum  = new ArrayList<Curriculum>();
    private List<CourseSelection> listCourseSelection = new ArrayList<CourseSelection>();
    private List<Student> listStudent = new ArrayList<Student>();
    /**
     * @param str
     * @param objects
     * 中介者
     */
    @Override
    public AbstractMiddleLayer execute(String str, Object... objects) {
        // 登录
        if("SignIn".equals(str)){
            this.singin((String)objects[0], (String)objects[1]);
        }
        // 找回密码
        if("RetrievePassword".equals(str)){
            this.RetrievePassword((String)objects[0], (String)objects[1]);
        }

        // 增加用户
        if("addUser".equals(str)){
            this.addUser((String)objects[0], (String)objects[0]);
        }

        // 显示学生基本信息
        if("BasicInformationForStudents".equals(str)){
            this.BasicInformationForStudents((String)objects[0]);
        }

        // 增加学生
        if("addStudent".equals(str)){
            this.addStudent((Student)objects[0]);
        }

        // 学生信息更改
        if("changeStudent".equals(str)){
            System.out.println(objects[0].toString());
            this.changeStudent((String)objects[0], (Student)objects[1]);
        }

        // 删除学生
        if("deleteStudent".equals(str)){
            this.deleteStudent((String)objects[0]);
        }

        // 根据学号查找课程
        if("selectionCourseSelection".equals(str)){
            this.selectionCourseSelection((String)objects[0]);
        }

        // 增加一条选课记录
        if("CourseSelection".equals(str)){
            this.CourseSelection((String)objects[0], (String)objects[1]);
        }

        // 获取学生列表
        if("ListStudent".equals(str)){
            this.ListStudent((int)objects[0], (int)objects[1]);
        }

        // 根据课程号，查询课程信息
        if("selectCurrlculum".equals(str)){
            this.selectCurrlculum((String)objects[0]);
        }

        // 增加课程
        if("addCurrlculum".equals(str)){
            this.addCurrlculum((Curriculum)objects[0]);
        }

        // 根据课程号，删除课程
        if("deleteCurrlculum".equals(str)){
            this.deleteCurrlculum((String)objects[0]);
        }

        // 更改课程信息
        if("changeCurrlculum".equals(str)){
            this.changeCurrlculum((String)objects[0], (Curriculum)objects[1]);
        }

        // 进行分页 课程
        if("listCurrlculum".equals(str)){
            this.listCurrlculum((int)objects[0], (int)objects[1]);
        }

        // 成绩录入
        if("ResultInput".equals(str)){
            this.ResultInput((String)objects[0], (String)objects[1], (String)objects[2]);
        }

        return this;
    }

    /**
     * @return boolean
     */
    @Override
    public boolean getResult(){
        return this.result;
    }

    /**
     * @return
     */
    @Override
    public Student getStudent(){
        return this.student;
    }


    @Override
    public List<CourseSelection> getListCourseSelection(){
        return this.listCourseSelection;
    }

    @Override
    public List<Curriculum> getListCurriculum(){
        return this.listCurriculum;
    }

    @Override
    public List<Student> getListStudent(){
        return this.listStudent;
    }

    @Override
    public Curriculum getCurriculum(){
        return this.curriculum;
    }
    /**
     * @param _user
     * @param _password
     * @return this
     * 登录方法
     */
    @Contract("_, _ -> this")
    private AbstractMiddleLayer singin(String _user, String _password){
        //System.out.println(_password + _user);
        User user = new User();
        user.setName(_user);
        user.setPassword(_password);
        UserLogin userLogin = new UserLogin();
        try{
            this.result = userLogin.login(user);
            userLogin.closeStatementConnection();
        }catch(Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param user 用户名
     * @param newPassword   新密码
     * @return  AbstractMiddleLayer
     * 更改密码
     */
    @Contract("_, _ -> this")
    private AbstractMiddleLayer RetrievePassword(String user, String newPassword){
        User oldUser = new User();
        User newUser = new User();
        oldUser.setName(user);
        newUser.setName(user);
        newUser.setPassword(newPassword);
        UserLogin userLogin = new UserLogin();
        try{
            this.result = userLogin.updat(oldUser, newUser);
            userLogin.closeStatementConnection();
        }catch(Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param sno 学号
     * @param password  密码
     * @return this
     * 增加用户
     */
    private AbstractMiddleLayer addUser(String name, String password){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        UserLogin userLogin = new UserLogin();
        try{
            this.result = userLogin.addUser(user);
            userLogin.closeStatementConnection();
        }catch (Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param sno 学号
     * @return this
     * 输入学号，获取学生基本信息
     */
    @Contract("_ -> this")
    private AbstractMiddleLayer BasicInformationForStudents(String sno){
        Student student = new Student();
        student.setSno(sno);
        StudentInfoTable studentInfoTable = new StudentInfoTable();
        try{
            this.student = studentInfoTable.selectStudent(student);
            studentInfoTable.closeStatementConnection();
            //System.out.println(this.student.getSno());
        }catch (Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param student
     * @return AbstractMiddleLayer
     * 增加学生
     */
    @Contract("_ -> this")
    private AbstractMiddleLayer addStudent(Student student){
        StudentInfoTable studentInfoTable = new StudentInfoTable();
        try{
            this.result = studentInfoTable.addStudent(student);
            studentInfoTable.closeStatementConnection();
            //System.out.println(this.student.getSno());
        }catch (Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param sno 学号
     * @param newStudent    新的学生实体
     * @return this
     * 根据学号，更改学生基本信息
     */
    @Contract("_, _ -> this")
    private AbstractMiddleLayer changeStudent(String sno, Student newStudent){
        Student oldStudent = new Student();
        oldStudent.setSno(sno);
        System.out.println(sno);
        StudentInfoTable studentInfoTable = new StudentInfoTable();
        try{
            this.result = studentInfoTable.changeStudent(oldStudent, newStudent);
            studentInfoTable.closeStatementConnection();
        }catch (Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param sno 学号
     * @return this
     * 根据学号删除学生
     */
    @Contract("_, _ -> this")
    private AbstractMiddleLayer deleteStudent(String sno){
        Student student = new Student();
        student.setSno(sno);
        StudentInfoTable studentInfoTable = new StudentInfoTable();
        try{
            this.result = studentInfoTable.deleteStudent(student);
            studentInfoTable.closeStatementConnection();
        }catch (Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param sno 学号
     * @return this
     * 根据sno获取当前课程对应的列表
     */
    @Contract("_, _ -> this")
    private AbstractMiddleLayer selectionCourseSelection(String sno){
        CourseSelection courseSelection = new CourseSelection();
        courseSelection.setSno(sno);
        CourseSelectionTable courseSelectionTable = new CourseSelectionTable();
        try{
            this.listCourseSelection = courseSelectionTable.selectCourseSelection(courseSelection);
            courseSelectionTable.closeStatementConnection();
            CurrlculumTable currlculumTable = new CurrlculumTable();
            for(CourseSelection courseSelection1:this.listCourseSelection){
                Curriculum curriculum = new Curriculum();
                curriculum.setCno(courseSelection1.getCno());
                this.listCurriculum.add(this.currlculumTable.selectCurriclum(curriculum));
            }
            currlculumTable.closeStatementConnection();
        }catch(Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param sno 学号
     * @param cno 课程号
     * @return this
     * 添加一条选课记录
     */
    @Contract("_, _ -> this")
    private AbstractMiddleLayer CourseSelection(String sno, String cno){
        // 由于再业务逻辑中，确保的主键，外建相同，所有数据库未设置外键
        CourseSelection courseSelection = new CourseSelection();
        courseSelection.setSno(sno);
        courseSelection.setCno(cno);
        CourseSelectionTable courseSelectionTable = new CourseSelectionTable();
        try{
            this.result = courseSelectionTable.addCourseSelection(courseSelection);
            courseSelectionTable.closeStatementConnection();
        }catch(Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param limt 页数
     * @param length 长度
     * @return this
     * 根据分页结果，进行分页
     */
    @Contract("_, _ -> this")
    private AbstractMiddleLayer ListStudent(int limt, int length){
        StudentInfoTable studentInfoTable = new StudentInfoTable();
        try{
            System.out.println(limt + "  " + length);
            this.listStudent = studentInfoTable.listStudent(limt, length);
            studentInfoTable.closeStatementConnection();
        }catch (Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param cno  课程号
     * @return this
     * 根据课程号，查询一门课程
     */
    @Contract("_, _ -> this")
    private AbstractMiddleLayer selectCurrlculum(String cno){
        CurrlculumTable currlculumTable = new CurrlculumTable();
        Curriculum curriculum = new Curriculum();
        curriculum.setCno(cno);
        try{
            this.curriculum = currlculumTable.selectCurriclum(curriculum);
            currlculumTable.closeStatementConnection();
        }catch (Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param curriculum 课程
     * @return this
     * 增加一门课程
     */
    @Contract("_, _ -> this")
    private AbstractMiddleLayer addCurrlculum(Curriculum curriculum){
        CurrlculumTable currlculumTable = new CurrlculumTable();
        try{
            this.result = currlculumTable.addCurriclum(curriculum);
            currlculumTable.closeStatementConnection();
        }catch (Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param cno 课程号
     * @return this
     * 根据课程号，删除一门课程
     */
    private AbstractMiddleLayer deleteCurrlculum(String cno){
        Curriculum curriculum = new Curriculum();
        curriculum.setCno(cno);
        CurrlculumTable currlculumTable = new CurrlculumTable();
        try{
            this.result = currlculumTable.deleteCurriculum(curriculum);
            currlculumTable.closeStatementConnection();
        }catch(Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param cno 课程号
     * @param curriculum 课程
     * @return this
     * 根据课程号，更改课程信息
     */
    private AbstractMiddleLayer changeCurrlculum(String cno, Curriculum curriculum){
        Curriculum oldCurriculum = new Curriculum();
        Curriculum newCurriculum = new Curriculum();
        CurrlculumTable currlculumTable = new CurrlculumTable();
        oldCurriculum.setCno(cno);
        try{
            this.result = currlculumTable.addCurriclum(curriculum);
            currlculumTable.closeStatementConnection();
        }catch (Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param limt 页数
     * @param length 长度
     * @return this
     * 进行分页操作,课程
     */
    @Contract("_, _ -> this")
    private AbstractMiddleLayer listCurrlculum(int limt, int length){
        CurrlculumTable currlculumTable = new CurrlculumTable();
        try{
            System.out.println(limt + "第三个" +length );
            this.listCurriculum = currlculumTable.lisrCurriculum(limt, length);
            //System.out.println(this.listCurriculum.get(0).getCn());
            currlculumTable.closeStatementConnection();
        }catch (Exception e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * @param sno
     * @param cno
     * @param achievement
     * @return
     */
    @Contract("_, _, _ -> this")
    private AbstractMiddleLayer ResultInput(String sno, String cno, String achievement){
        CourseSelection courseSelection = new CourseSelection();
        courseSelection.setGrade(achievement);
        courseSelection.setCno(cno);
        courseSelection.setSno(sno);
        try{
            CourseSelectionTable courseSelectionTable = new CourseSelectionTable();
            this.result = courseSelectionTable.addCourseSelection(courseSelection);
            courseSelectionTable.closeStatementConnection();
        }catch (Exception e){
            System.out.println(e);
        }
        return this;
    }
}
