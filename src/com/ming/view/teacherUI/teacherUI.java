package com.ming.view.teacherUI;


import javax.swing.*;

/**
 * @author ming
 * 添加TeacherUI
 */
public class teacherUI extends JFrame {
    private JTabbedPane tabbedPane = new JTabbedPane();
    public teacherUI(){
        super("管理界面");
        tabbedPane = new JTabbedPane(); // 创建JTabbedPane
        addStudent addStudent = new addStudent();
        changeStudent changeStudent = new changeStudent();
        // 设置Layout
        tabbedPane.addTab("增加学生",null,addStudent.getjPanel(),"First Panel");
        tabbedPane.addTab("学生信息更改",null, changeStudent.getjPanel(), "First Panel");
        //tabbedPane.addTab("学生成绩录入", null,null,"First Panel");
        this.setContentPane(this.tabbedPane);
        this.setSize(1000,500);
        this.setVisible(true);
    }
}
