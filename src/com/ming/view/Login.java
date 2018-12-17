package com.ming.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel Login;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton LoginButton;
    private JButton CleaerButton;

    public Login() {
        LoginButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // 登录按钮
                System.out.println(textField1.getText());
            }
        });
        CleaerButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // 清空按钮
                textField1.setText("");
                passwordField1.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().Login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(300,200);
        frame.setVisible(true);
    }
}
