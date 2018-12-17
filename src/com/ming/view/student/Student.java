package com.ming.view.student;

import javax.swing.*;
import java.awt.*;

// 该类为Student用户登录后的管理界面
public class Student extends JFrame {
    private JTabbedPane tabbedPane;
    public Student(){
        super("学生管理界面");
        tabbedPane = new JTabbedPane(); // 创建JTabbedPane
        // 设置Layout
        tabbedPane.addTab("hello1", null,new StudentInfo().getStudentInfo(),"First Panel");
        this.setContentPane(this.tabbedPane);
        this.setSize(250,200);
        this.setVisible(true);
    }
}
