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
        this.listJpanel.add(this.nextJbutton);
        this.listJpanel.add(this.previousJbutton);
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
    }

    /**
     * Button
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

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
