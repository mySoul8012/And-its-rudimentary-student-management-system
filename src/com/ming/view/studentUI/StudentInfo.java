package com.ming.view.studentUI;

import javax.swing.*;
import java.awt.*;
import com.ming.entity.Student;

//学生信息查看页面
public class StudentInfo extends JPanel {
    private JPanel jPanel = new JPanel();  // 总面板
    private JPanel jPanelLeft = new JPanel();  // 左头像面板
    private JPanel jPanelRight = new JPanel(); // 右头像面板
    public StudentInfo(Student _student){
        // 创建面板
        // 左头像面板
        jPanelLeft.setLayout(new GridLayout());
        // 头像图片导入
        //ImageIcon image = new ImageIcon("file/user.jpg");
        JLabel labelImage=new JLabel();
        labelImage.setText("<html><img src=\"https://ww1.sinaimg.cn/large/007iUjdily1fyjhif1amrj3069069t8k.jpg\"><html>");
        jPanelLeft.add(labelImage);
        // 右头像面板
        jPanelRight.setLayout(new FlowLayout());
        // 添加到jPanelRight
        jPanelRight.add(new JLabel("学 号 " + _student.getSno()));
        jPanelRight.add(new JLabel("姓 名 " + _student.getSn()));
        jPanelRight.add(new JLabel("性 别 " + _student.getSex()));
        jPanelRight.add(new JLabel("年 龄 " + _student.getAge()));
        jPanelRight.add(new JLabel("系 别 " + _student.getDept()));
        // 添加到总面板
        jPanel.add(this.jPanelLeft);
        jPanel.add(this.jPanelRight);
    }
    // 获取总面板
    public JPanel getjPanel(){
        return this.jPanel;
    }
}
