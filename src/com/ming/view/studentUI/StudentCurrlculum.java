package com.ming.view.studentUI;

import com.ming.MiddleLayer.StudentScenes;
import com.ming.MiddleLayer.TeacherScenes;
import com.ming.MiddleLayer.tertiumQuid;
import com.ming.entity.Curriculum;
import com.ming.entity.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * 学生课程信息显示
 */
public class StudentCurrlculum extends JPanel {
    private JPanel jpanel = new JPanel();   // 总面板
    private JPanel listJpanel = new JPanel();   // 列表面板
    private JTable jtable;
    private JScrollPane pane;
    public StudentCurrlculum(Student _student){
        // 从数据库中读取到数据
        tertiumQuid tertiumQuid = new tertiumQuid();
        StudentScenes teacherScenes = new StudentScenes(tertiumQuid);
        List<Curriculum> list;
        list = teacherScenes.StudentElectiveCourse(_student.getSno());
        // 将list转换为二维数组
        Object[][] cells = new Object[list.size()][3];
        // 将list转化为二维数组
        for(int i = 0; i < list.size(); i++){
            cells[i][0] = list.get(i).getCno();
            cells[i][1] = list.get(i).getCn();
            cells[i][2] = list.get(i).getHourc();
        }
        // 创建表头
        String[] columNames = {"课程号", "课程名", "课时"};
        jtable = new JTable(cells, columNames);
        // 包装进入滚动条
        pane = new JScrollPane(jtable);
        // 将其添加到面板
        listJpanel.add(pane);
        // 将其添加到总面板
        jpanel.add(listJpanel);
    }
    // 获取总面板
    public JPanel getJpanel(){
        return this.jpanel;
    }
}
