package com.ming.view.studentUI;

import javax.swing.*;

import com.ming.entity.Student;

// 该类为Student用户登录后的管理界面
public class StudentUI extends JFrame {
    private JTabbedPane tabbedPane;
    private StudentInfo studentInfo;
    private StudentCurrlculum studentCurrlculum;
    private StudentSelection studentSelection;
    public StudentUI(Student student){
        super("学生用户界面");
        studentInfo = new StudentInfo(student);
        studentCurrlculum = new StudentCurrlculum(student);
        this.studentSelection = new StudentSelection(student);
        tabbedPane = new JTabbedPane(); // 创建JTabbedPane
        // 设置Layout
        tabbedPane.addTab("学生信息查看", null,studentInfo.getjPanel(),"First Panel");
        tabbedPane.addTab("学生课程查看",null, studentCurrlculum.getJpanel(), "First Panel");
        tabbedPane.addTab("学生选课管理", null,this.studentSelection.getjPanel(),"First Panel");
        this.setContentPane(this.tabbedPane);
        this.setSize(700,500);
        this.setVisible(true);
    }
}
