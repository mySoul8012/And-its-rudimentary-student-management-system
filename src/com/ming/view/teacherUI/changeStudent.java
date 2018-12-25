package com.ming.view.teacherUI;

import com.ming.MiddleLayer.AbstractMiddleLayer;
import com.ming.MiddleLayer.TeacherScenes;
import com.ming.MiddleLayer.tertiumQuid;
import com.ming.entity.Curriculum;
import com.ming.entity.Student;
import com.ming.tools.StudentUi;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * 更改学生信息
 */
public class changeStudent extends JPanel implements ListSelectionListener, ActionListener {
    // 总面板
    private JPanel jPanel = new JPanel();
    // 列表面板
    private JPanel listJpanel = new JPanel();
    private JTable jtable = new JTable();
    private JScrollPane jscrollPane = new JScrollPane();
    private JButton nextJbutton = new JButton("下一页");
    private JButton previousJbutton = new JButton("上一页");
    private StudentUi studentUi;
    private Student student = new Student();
    private int limt = 0;
    private int length = 0;
    // 获取JPanel
    public JPanel getjPanel(){
        return this.jPanel;
    }
    // 获取JScrollPane
    private JScrollPane getJScrollPane(int limt, int length){
        this.limt = limt;
        this.length = length;
        // 获取学生列表，默认从分页为0 页 10条记录
        tertiumQuid tertiumQuid = new tertiumQuid();
        TeacherScenes teacherScenes = new TeacherScenes(tertiumQuid);
        List<Student> list = new ArrayList<Student>();
        String[][] cells = new String[length][5];
        // 从场景中得到值
        //System.out.println(limt + "方法" + length);
        list = teacherScenes.listStudent(limt, length);
        //System.out.println(list.get(0).getCn());
        // 进行赋值
        for(int i = 0; i < length; i++){
            cells[i][0] = list.get(i).getSno();
            cells[i][1] = list.get(i).getSn();
            cells[i][2] = list.get(i).getAge();
            cells[i][3] = list.get(i).getSex();
            cells[i][4] = list.get(i).getDept();
        }
        // 获得表头
        String[] columNames = {"学号", "姓名", "年龄", "性别", "系别"};
        // 创建表格
        this.jtable = new JTable(cells, columNames);
        // 添加滚动条
        JScrollPane jScrollPane = new JScrollPane(jtable);
        return jScrollPane;
    }
    public changeStudent(){
        // 获得初始页
        this.jscrollPane = this.getJScrollPane(0, 10);
        // 初始页加载到jpanel上
        this.listJpanel.add(this.jscrollPane);
        // 添加下一个按钮
        this.jPanel.add(this.nextJbutton);
        this.jPanel.add(this.previousJbutton);
        // 将面板添加到主面板
        this.jPanel.add(this.jscrollPane);
        // 获取编辑面板
        String [] info = {"学号", "姓名", "年龄", "性别", "系别"};
        this.studentUi = new StudentUi(info);
        // 将studntUi添加到面板中
        this.jPanel.add(this.studentUi);
        // 给单元格添加事件
        this.jtable.getSelectionModel().addListSelectionListener(this);
        // 给上下一页添加事件
        this.nextJbutton.addActionListener(this);
        this.previousJbutton.addActionListener(this);
        // 给studentUi添加事件
        this.studentUi.getDoTask1Button().addActionListener(this);
        this.studentUi.getDoTask2Button().addActionListener(this);
    }

    /**
     * Button
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.nextJbutton){
            // 当点击的是下一页按钮
            this.limt++;    // 页数加1
            this.jPanel.remove(this.jscrollPane);
            this.jscrollPane = this.getJScrollPane(this.limt, this.length);
            this.jscrollPane.setVisible(true);
            this.jPanel.add(this.jscrollPane);
            this.jPanel.setVisible(true);
            this.setVisible(true);
        }

        if(e.getSource() == this.previousJbutton){
            // 当单击的是上一页按钮
            // 排除处于页首的情况
            if(this.limt >= 1){
                this.limt--;    // 页数减1
                this.jPanel.remove(this.jscrollPane);
                this.jscrollPane = this.getJScrollPane(this.limt, this.length);
                this.jscrollPane.setVisible(true);
                this.jPanel.add(this.jscrollPane);
                this.jPanel.setVisible(true);
                this.setVisible(true);
            }
        }

        if(e.getSource() == this.studentUi.getDoTask1Button()){
            // 单击提交
            Student student = new Student();
            String[] tmpString = new String[5];
            tmpString = this.studentUi.getFieldValues();
            student.setSno(tmpString[0] + "");
            student.setSn(tmpString[1] + "");
            student.setAge(tmpString[2] + "");
            student.setSex(tmpString[3] + "");
            student.setDept(tmpString[4] + "");
            // 新建场景导入
            AbstractMiddleLayer tertlumQuld = new tertiumQuid();
            TeacherScenes teacherScenes = new TeacherScenes(tertlumQuld);
            if(teacherScenes.changeStudent(tmpString[0], student)){
                JOptionPane.showMessageDialog(null,"修改成功", "添加结果",JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"修改失败", "添加结果",JOptionPane.PLAIN_MESSAGE);
            }
        }
        // 单击清空
        if(e.getSource() == this.studentUi.getDoTask2Button()){
            this.studentUi.clearFields();
        }
    }

    /**
     * JTable
     *
     * @param e
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // 获取选中的课程号
        String sno = this.jtable.getValueAt(this.jtable.getSelectedRow(), 0).toString();
        this.student.setSno(sno);
        // 更新更细面板中的text
        studentUi.setFieldsFirst(sno);
        this.jPanel.setVisible(true);
        this.setVisible(true);
    }
}
