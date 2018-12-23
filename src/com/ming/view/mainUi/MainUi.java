package com.ming.view.mainUi;

import com.ming.view.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
// 主UI界面的事件处理
public class MainUi extends AbstractMainUi {
    @Override
    public void actionPerformed (ActionEvent e){
        // 学生
        if(e.getSource() == this.getJbuttons()[0]){
            JFrame frame = new JFrame("Login");
            frame.setContentPane(new Login("Student").Login);
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.pack();
            frame.setSize(300,200);
            frame.setVisible(true);
        }
        // 教师
        if(e.getSource() == this.getJbuttons()[1]){
            JFrame frame = new JFrame("Login");
            frame.setContentPane(new Login("Teacher").Login);
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.pack();
            frame.setSize(300,200);
            frame.setVisible(true);
        }
    }
}
