package com.ming.ServiceLayer;

import com.ming.entity.CourseSelection;
import com.ming.tools.TransferredMeaning;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * 封装对sc的表CURD
 */
public class CourseSelectionTable extends DBConnection{
    private CourseSelection courseSelection;
    public CourseSelectionTable(){
        super();
        this.courseSelection = new CourseSelection();
    }

    /**
     * @param courseSelection
     * @return ResultSet
     * 对学生选课表的查询 两个查询参数，sno，cno，任选其一。
     */
    public List<CourseSelection> selectCourseSelection(CourseSelection courseSelection)throws Exception{
        this.courseSelection = courseSelection;
        String tmp = null;
        if (this.courseSelection.getCno().length() > 0){
            tmp = TransferredMeaning.getTransferredMeaning(this.courseSelection.getCno());
            this.sql = "SELECT sno,cno,grade FROM sc where cno = '" + tmp + "';";
        }else {
            tmp = TransferredMeaning.getTransferredMeaning(this.courseSelection.getSno());
            this.sql = "SELECT sno,cno,grade FROM sc where sno = '" + tmp + "';";
        }
        // 执行
        this.executeQuery();
        // 返回结果
        ResultSet rs = this.getResultSet();
        List<CourseSelection> list = new ArrayList<CourseSelection>();
        while(rs.next()){
            CourseSelection courseSelection1 = new CourseSelection();
            courseSelection1.setSno(rs.getString(1));
            courseSelection1.setCno(rs.getString(2));
            courseSelection1.setGrade(rs.getString(3));
            list.add(courseSelection1);
        }
        return list;
    }

    /**
     * @param courseSelection
     * @return boolean
     * 增加选课记录 两个参数sno，cno，必须同时具有
     */
    public boolean addCourseSelection(CourseSelection courseSelection)throws Exception{
        this.courseSelection = courseSelection;
        this.sql = "INSERT sc(sno,cno,grade) VALUES('" + TransferredMeaning.getTransferredMeaning(this.courseSelection.getSno()) + "','" + TransferredMeaning.getTransferredMeaning(this.courseSelection.getCno()) + "','" + TransferredMeaning.getTransferredMeaning(this.courseSelection.getGrade()) + "');";
        // 执行
        this.executeQuery();
        // 判断结果
        return "1".equals(this.getResultSetUpdate());
    }

    /**
     * @param oldCourseSelection
     * @param courseSelection
     * @return boolean
     * 更改选课记录，sno，cno同时不为空
     */
    public boolean changeCourseSelection(CourseSelection oldCourseSelection, CourseSelection courseSelection)throws Exception{
        this.courseSelection = courseSelection;
        String tmp = null;
        if(oldCourseSelection.getCno().length() >= 0 || oldCourseSelection.getSno().length() >= 0){
            tmp = this.courseSelection.getGrade();
            tmp = TransferredMeaning.getTransferredMeaning(tmp);
            oldCourseSelection.setSno(TransferredMeaning.getTransferredMeaning(oldCourseSelection.getSno()));
            oldCourseSelection.setCno(TransferredMeaning.getTransferredMeaning(oldCourseSelection.getCno()));
            this.sql = "UPDATE sc SET grade = '" + tmp + "' WHERE cno = '" + oldCourseSelection.getCno() + "' AND  sno = '" + oldCourseSelection.getSno() + "';";
            //System.out.println(sql);
        }else{
            return false;
        }
        this.executeQuery();
        return "1".equals(this.getResultSetUpdate());
    }

    /**
     * @param courseSelection
     * @return boolean
     * 删除某一条选课记录，根据sno，cno
     */
    public boolean deleteCourseSelection(CourseSelection courseSelection) throws Exception{
        this.courseSelection = courseSelection;
        courseSelection.setCno(TransferredMeaning.getTransferredMeaning(this.courseSelection.getCno()));
        courseSelection.setSno(TransferredMeaning.getTransferredMeaning(this.courseSelection.getSno()));
        this.sql = "DELETE FROM sc WHERE sno = '" + this.courseSelection.getSno() + "' AND cno = '" + this.courseSelection.getCno() + "';";
        this.executeQuery();
        return "1".equals(this.getResultSetUpdate());
    }

    /**
     * @param limt
     * @param length
     * @return list<CourseSelection></>
     * 返回列表，进行分页
     */
    public List<CourseSelection> listCourseSelection(int limt, int length) throws Exception {
        // 验证传入值
        if(limt < 0 || length < 0){
            throw new Exception("传入的limt，length错误");
        }
        // 拼接sql
        this.sql = "SELECT sno, cno, grade FROM sc LIMIT " + limt * length + ", " + length + ";";
        // 执行sql
        super.executeQuery();
        // 获取结果
        ResultSet rs = this.getResultSet();
        List<CourseSelection> list = new ArrayList<CourseSelection>();
        while(rs.next()){
            CourseSelection tmpCourseSelection = new CourseSelection();
            tmpCourseSelection.setSno(rs.getString(1));
            tmpCourseSelection.setCno(rs.getString(2));
            tmpCourseSelection.setGrade(rs.getString(3));
            list.add(tmpCourseSelection);
        }
        return list;
    }
}
