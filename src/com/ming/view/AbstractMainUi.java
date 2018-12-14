package com.ming.view;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;

/*
* @auto ming
* 对于主UI界面的抽象类
* */
abstract class AbstractMainUi extends JFrame implements ActionListener{
    /*
    * 默认按钮个数
    * @param COUNT static from 2
    */
    private final static int COUNT = 2;
    /*
    * 提取内容面板
    */
    private Container container = this.getContentPane();

    public JButton[] getJbuttons() {
        return jbuttons;
    }

    /*
    * 界面按钮
    * */
    private JButton[] jbuttons;
    /*
    * JLabel
    * */
    private JLabel jlabel = new JLabel("破烂的学生管理系统",JLabel.CENTER);
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
    * swing 面板容器
    * @param new JPanel()
    * */
    private JPanel innerPanelRight = new JPanel();
    private JPanel innerPanelLeft = new JPanel();
    /*
    * 构造函数
    * @param final static COUNT 2
    * */
    protected AbstractMainUi(){
        super("破烂的学生管理系统管理启动界面");
        this.container.setLayout(new BorderLayout(100,20));   // 界面总布局
        // 设置两个内容面板布局
        this.innerPanelLeft.setLayout(new GridLayout(2,1,50,50));
        // 默认新建两个按钮,并添加,并绑定事件
        jbuttons = new JButton[COUNT];
        this.jbuttons[0] = new JButton("学生登录");
        this.jbuttons[0].addActionListener(this);
        this.jbuttons[1] = new JButton("教师登录");
        this.jbuttons[1].addActionListener(this);
        this.innerPanelLeft.add(this.jbuttons[0]);
        this.innerPanelLeft.add(this.jbuttons[1]);
        this.container.add(this.innerPanelLeft,BorderLayout.WEST);
        // 添加图片到中间
        this.innerPanelRight.setLayout(new FlowLayout());
        this.innerPanelRight.add(new JLabel(this.img));
        // 添加图片到右边
        this.innerPanelRight.add(new JLabel(this.imgRight));
        this.container.add(this.innerPanelRight,BorderLayout.EAST);
        // 添加底部文字
        this.jlabel.setFont(new Font("Dialog", 1,40));
        this.container.add(this.jlabel, BorderLayout.SOUTH);
        // 设置大小，并显示
        this.setUndecorated(true);
        this.setSize(900,500);  // 设置大小
        this.setLocationRelativeTo(null);   // 居中
        this.setAlwaysOnTop(true);  // 设置在前方
        this.setVisible(true);  // 显示操作
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 关闭时间
    }
}
