package com.ming.view.mainUi;

import java.awt.event.ActionEvent;
// 主UI界面的事件处理
public class MainUi extends AbstractMainUi {
    @Override
    public void actionPerformed (ActionEvent e){
        // 学生
        if(e.getSource() == this.getJbuttons()[0]){
            System.out.println("helo world");
        }
        // 教师
        if(e.getSource() == this.getJbuttons()[1]){

        }
    };
}
