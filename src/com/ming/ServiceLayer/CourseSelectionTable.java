package com.ming.ServiceLayer;

import com.ming.entity.CourseSelection;
import com.ming.entity.Curriculum;
import com.ming.tools.TransferredMeaning;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * 封装对sc的表真CURD
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
}
