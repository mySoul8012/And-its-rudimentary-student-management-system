package com.ming.view.studentUI;

import com.ming.MiddleLayer.AbstractMiddleLayer;
import com.ming.MiddleLayer.StudentScenes;
import com.ming.MiddleLayer.TeacherScenes;
import com.ming.MiddleLayer.tertiumQuid;
import com.ming.entity.CourseSelection;
import com.ming.entity.Curriculum;
import com.ming.entity.Student;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * 学生选课管理
 */
public class StudentSelection extends JPanel implements ListSelectionListener, ActionListener {
    private JPanel jPanel = new JPanel();   // 总面板
    private JPanel courseSelectionJpanel = new JPanel();    // 课程信息面板
    private JPanel nextPagePreviousPage = new JPanel(); // 下一页面板
    private JPanel submitJpanel = new JPanel(); // 提交面板
    private JScrollPane jscrollPane;    // 课程信息表格
    private JButton nextJbutton = new JButton("下一页");
    private JButton previousJbutton = new JButton("上一页");
    private JButton submitJbutton = new JButton("提交按钮");
    private JTable jtable;
    private Student student = new Student();
    private CourseSelection courseSelection = new CourseSelection();
    private int length = 0;
    private int limt = 0;
    /**
     * @param limt 页数
     * @param length 长度
     * @return Object[][]
     * 根据limt和length获取页数
     */
    private JScrollPane getListCurriculum(int limt, int length){
        this.limt = limt;
        this.length = length;
        // 获取课程列表，默认从分页为0 页 10条记录
        tertiumQuid tertiumQuid = new tertiumQuid();
        TeacherScenes teacherScenes = new TeacherScenes(tertiumQuid);
        List<Curriculum> list = new ArrayList<Curriculum>();
        String[][] cells = new String[length][3];
        // 从场景中得到值
        System.out.println(limt + "方法" + length);
        list = teacherScenes.listCurrlculum(limt, length);
        //System.out.println(list.get(0).getCn());
        // 进行赋值
        for(int i = 0; i < length; i++){
            cells[i][0] = list.get(i).getCno();
            cells[i][1] = list.get(i).getCn();
            cells[i][2] = list.get(i).getHourc();
        }
        // 获得表头
        String[] columNames = {"课程号", "课程名", "课时"};
        // 创建表格
        this.jtable = new JTable(cells, columNames);
        // 添加滚动条
        JScrollPane jScrollPane = new JScrollPane(jtable);
        return jScrollPane;
    }
    public StudentSelection(Student _student){
        this.student = _student;
        // 获得初始页
        this.jscrollPane = this.getListCurriculum(0, 10);
        // 初始页加载到jpanel上
        this.courseSelectionJpanel.add(this.jscrollPane);
        // 添加下一个按钮
        this.nextPagePreviousPage.add(this.nextJbutton);
        this.nextPagePreviousPage.add(this.previousJbutton);
        this.submitJpanel.add(this.submitJbutton);
        // 将面板添加到主面板
        this.jPanel.add(this.jscrollPane);
        this.jPanel.add(this.nextPagePreviousPage);
        this.jPanel.add(this.submitJbutton);
        // 给单元格添加事件
        this.jtable.getSelectionModel().addListSelectionListener(this);
        // 给提交添加事件
        this.submitJbutton.addActionListener(this);
        this.nextJbutton.addActionListener(this);
        this.previousJbutton.addActionListener(this);
    }
    public JPanel getjPanel(){
        return this.jPanel;
    }

    /**
     * 表格事件处理
     *
     * @param e 当事件发生的时候，会传入此事件
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // 获取选中的课程号
        String cno = this.jtable.getValueAt(this.jtable.getSelectedRow(), 0).toString();
       this.courseSelection.setCno(cno);
       //System.out.println(this.student.getSno());
       this.courseSelection.setSno(this.student.getSno());
    }

    /**
     * button事件处理
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取点击是那个按钮
        if(e.getSource() == this.submitJbutton){
            // 当点击的是提交按钮
            // 添加一条选课记录
            AbstractMiddleLayer tertiumQuld = new tertiumQuid();
            // 新建场景
            StudentScenes studentScenes = new StudentScenes(tertiumQuld);
            // 添加一条选课记录
            if(!studentScenes.CourseSelection(this.courseSelection.getSno(), this.courseSelection.getCno())){
                JOptionPane.showMessageDialog(null, "选课失败，您已经选过该课，请选别的课程","选课结果", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"选课成功","选课结果",JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource() == this.nextJbutton){
            // 当点击的是下一页按钮
            this.limt++;    // 页数加1
            //System.out.println(this.limt + " " + this.length);
            this.jPanel.remove(this.jscrollPane);
            this.jscrollPane = this.getListCurriculum(this.limt, this.length);
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
                this.jscrollPane = this.getListCurriculum(this.limt, this.length);
                this.jscrollPane.setVisible(true);
                this.jPanel.add(this.jscrollPane);
                this.jPanel.setVisible(true);
                this.setVisible(true);
            }
        }
    }
}
