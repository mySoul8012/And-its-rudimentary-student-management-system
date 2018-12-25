package com.ming.tools;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author ming
 * 该类为StudentUi的通用界面
 */
public class StudentUi extends JPanel {
    protected JPanel innerPanelCenter, innerPanelSouth;
    protected JButton doTask1, doTask2;
    protected JTextField[] fields;
    protected JLabel[] labels;
    protected int size;
    public StudentUi(String arrayString[]){ // 传入创建的数组
        size = arrayString.length;  // 长度
        labels = new JLabel[size];
        fields = new JTextField[size];
        // 创建文本输入框
        for(int count = 0; count < labels.length; count++){
            labels[count] = new JLabel(arrayString[count]);
        }
        // 创建显示框
        for(int count = 0; count < fields.length; count++){
            fields[count] = new JTextField();
        }
        // 创建内容面板，设置布局
        innerPanelCenter = new JPanel();
        innerPanelCenter.setLayout(new GridLayout(size,2));
        for(int count = 0; count < size; count++){
            innerPanelCenter.add(labels[count]);
            innerPanelCenter.add(fields[count]);
        }
        // 创建两个提交按钮
        doTask1 = new JButton("提交");
        doTask2 = new JButton("清空");
        innerPanelSouth = new JPanel();
        innerPanelSouth.add(doTask1);
        innerPanelSouth.add(doTask2);
        // 设置布局，添加到总窗体
        setLayout(new BorderLayout());
        add(innerPanelCenter, BorderLayout.CENTER);
        add(innerPanelSouth, BorderLayout.SOUTH);
        //setSize(700,500);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        validate(); // 刷新布局
    }
    // 获取按钮
    public JButton getDoTask1Button(){
        return this.doTask1;
    }
    public JButton getDoTask2Button(){
        return this.doTask2;
    }
    // 设置第一个文本输入
    public void setFieldsFirst(String text){
        fields[0].setText(text);
    }
    // 获取文本输入框
    public JTextField[] getFields(){
        return this.fields;
    }
    // 清空文本输入框
    public void clearFields(){
        for(int count = 0; count < size; count++){
            fields[count].setText("");
        }
    }
    // 获取文本输入内容
    public String[] getFieldValues(){
        String[] values = new String[size];
        for(int count = 0; count < size; count++){
            values[count] = fields[count].getText();
        }
        return values;
    }
}
