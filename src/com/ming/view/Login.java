package com.ming.view;

import com.ming.MiddleLayer.AbstractColleague;
import com.ming.MiddleLayer.AbstractMiddleLayer;
import com.ming.MiddleLayer.StudentScenes;
import com.ming.MiddleLayer.tertiumQuid;
import com.ming.ServiceLayer.phoneTable;
import com.ming.entity.Student;
import com.ming.tools.Message;
import com.ming.tools.StudentUi;
import com.ming.view.studentUI.StudentUI;
import jdk.nashorn.internal.scripts.JO;
import sun.security.util.Password;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Login {
    public JPanel Login;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton LoginButton;
    private JButton CleaerButton;
    private JLabel user;
    private JLabel password;
    private String price;
    private String flage = "login";
    private int min;    // 分钟
    private int rand;   // 随机数

    public Login(String price) {
        this.price = price;
        LoginButton.addActionListener(new ActionListener() {
            /**
             * 按钮事件处理
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //进行登录验证
                AbstractMiddleLayer tertlumQuid = new tertiumQuid();
                com.ming.MiddleLayer.Login midderLayerLogin = new com.ming.MiddleLayer.Login(tertlumQuid);
                if(flage.equals("login")){
                    // 正常登录模式
                    if (!midderLayerLogin.userLogin(textField1.getText(), passwordField1.getText())){
                        JOptionPane.showMessageDialog(null, "登录失败，请确认密码是否输入正确", "提示消息", JOptionPane.PLAIN_MESSAGE);
                    }
                }else{
                    // 验证码登
                    // 验证码相同
                    Calendar c2 = Calendar.getInstance();
                    int newMin = c2.get(Calendar.MINUTE);
                    if(!(rand + "").equals(passwordField1.getText()) && newMin - min > 15){
                        JOptionPane.showMessageDialog(null, "验证码错误","提示错误", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                // 判断学生，还是教师
                if("Student".equals(price)){
                    // 学生 0780506004 这是测试
                    // 从数据库中读取学生信息
                    tertiumQuid tertiumQuid = new tertiumQuid();
                    StudentScenes studentScenes = new StudentScenes(tertiumQuid);
                    Student student = studentScenes.BasicInformationForStudents(textField1.getText());
                    StudentUI studentUi = new StudentUI(student);
                }
            }
        });
        CleaerButton.addActionListener(new ActionListener() {
            /**
             * 按钮事件处理
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setText("学号");
                password.setText("验证码");
                flage = "phone";
                // 读取手机号
                phoneTable phoneTable = new phoneTable();
                // 获取手机号
                String phone = phoneTable.getPhoneNumber(textField1.getText());
                // 获取当前时间
                Calendar c1 = Calendar.getInstance();
                min = c1.get(Calendar.MINUTE);
                // 随机数
                rand = Integer.parseInt(Message.rand());
                // 发送短信
                if(!Message.sedMessage(phone, rand + "")){
                    JOptionPane.showMessageDialog(null,"发送信息成功，短信15分钟有效", "提示信息", JOptionPane.PLAIN_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"发送信息失败，请重试", "提示信息", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {

    }
}
