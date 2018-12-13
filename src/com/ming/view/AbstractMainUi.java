package com.ming.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
* @auto ming
* 对于主UI界面的抽象类
* */
abstract class AbstractMainUi extends JFrame {
    /*
    * 默认按钮个数
    * @param COUNT static from 2
    */
    private final static int COUNT = 2;
    /*
    * 提取内容面板
    */
    private Container container = this.getContentPane();
    private Box box = new Box(2);
    /*
    * 布局方式 设置为BorderLayout 布局方式，高度和宽度为10
    * @param BorderLayout from hfap 10 wgap 10
    * */
    private FlowLayout layout = new FlowLayout();
    /*
    * 界面按钮
    * */
    private JButton[] jbuttons;
    /*
    * JLabel
    * */
    private JLabel jlabel;
    /*
    * 加载图片,中间图片
    * @param img ./../file/index.png
    * */
    private ImageIcon img = new ImageIcon("src/com/ming/file/index.png");
    /*
    * 加载图片 右边图片
    * @param imgRight ./../file/user.jpg
    * */
    private ImageIcon imgRight = new ImageIcon("src/com/ming/file/user.jpg");
    /*
    * 构造函数
    * @param final static COUNT 2
    * */
    protected AbstractMainUi(){
        super("破烂的学生管理系统管理启动界面");
        // 设置布局 为BorderLayout
        this.container.setLayout(this.layout);
        // 默认新建两个按钮,并添加
        jbuttons = new JButton[COUNT];
        for(int i = 0; i < COUNT; i++){
            this.jbuttons[i] = new JButton("学生登录");
            this.jbuttons[i] = new JButton("教师登录");
            // 并添加到西部
            this.box.add(this.jbuttons[i]);
        }
        this.container.add(box);
        // 添加图片到中间
        this.container.add(new JLabel(this.img),BorderLayout.CENTER);
        // 添加图片到右边
        this.container.add(new JLabel(this.imgRight),BorderLayout.EAST);
        // 设置大小，并显示
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);   // 最大化
        this.setAlwaysOnTop(true);  // 设置在前方
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 调用Systm.exit进行退出操作
        this.setVisible(true);  // 显示操作
    }
    protected AbstractMainUi(JLabel jlabel) {
        this.jlabel = jlabel;
    }
    protected abstract void a();
}
