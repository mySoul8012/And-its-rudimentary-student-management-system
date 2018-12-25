package com.ming.view.teacherUI;

import com.ming.MiddleLayer.AbstractMiddleLayer;
import com.ming.MiddleLayer.TeacherScenes;
import com.ming.MiddleLayer.tertiumQuid;
import com.ming.entity.Student;
import com.ming.tools.StudentUi;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.xml.bind.JAXBPermission;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ming
 * 增加学生
 */
public class addStudent extends JPanel implements ActionListener {
    private JPanel jPanel = new JPanel();   // 总面板
    private StudentUi teacherUi;
    public addStudent(){
        String [] info = {"学号", "姓名", "年龄", "性别", "系别"};
        teacherUi = new StudentUi(info);
        teacherUi.getDoTask1Button().addActionListener(this);
        teacherUi.getDoTask2Button().addActionListener(this);
        jPanel.setLayout(new BorderLayout());
        jPanel.add(this.teacherUi,BorderLayout.CENTER);
        //jPanel.setBounds(200,200,700, 500);
        this.setVisible(true);
    }

    /**
     * @return JPanel
     * 获取总面板
     */
    public JPanel getjPanel(){
        return this.jPanel;
    }

    /**
     * 单击按钮触发事件
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.teacherUi.getDoTask1Button()){
            // 单击提交按钮
            Student student = new Student();
            String[] tmpString = new String[5];
            tmpString = this.teacherUi.getFieldValues();
            student.setSno(tmpString[0]);
            student.setSn(tmpString[1]);
            student.setAge(tmpString[2]);
            student.setSex(tmpString[3]);
            student.setDept(tmpString[4]);
            // 新建场景导入
            AbstractMiddleLayer tertlumQuld = new tertiumQuid();
            TeacherScenes teacherScenes = new TeacherScenes(tertlumQuld);
            if(teacherScenes.addStudent(student)){
                JOptionPane.showMessageDialog(null,"添加成功", "添加结果",JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"添加失败", "添加结果",JOptionPane.PLAIN_MESSAGE);
            }
        }

        // 单击清空按钮
        if(e.getSource() == this.teacherUi.getDoTask2Button()){
            this.teacherUi.clearFields();
        }
    }
}
