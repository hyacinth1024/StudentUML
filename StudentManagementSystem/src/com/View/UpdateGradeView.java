package com.View;

import com.dao.GradeDao;
import com.model.Grade;
import com.util.MyFont;
import com.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *类名： UpdateGradeView.java
 *作者： 19241045王彪
 *描述： 修改成绩
 *时间:  2021/12/16 4:24
 *版本:  1.8
 */
public class UpdateGradeView extends JFrame {
    private JFrame UpdateGradeView;
    private JPanel UpdateGradepanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel StudentName;
    private JTextField StudentNameField;
    private JLabel CourseName;//课程名称
    private JTextField CourseNameField;//课程框
    private JLabel CourseGrade;
    private JTextField CourseGradeField;

    public UpdateGradeView(){
        UpdateGradeView = new JFrame("修改成绩");
        UpdateGradepanel = new JPanel();
        Submit = new JButton("确定");
        Canel = new JButton("取消");
        StudentName = new JLabel("学生姓名");
        CourseName = new JLabel("课程名称：");
        CourseGrade = new JLabel("新分数：");
        StudentNameField = new JTextField();
        CourseNameField = new JTextField();
        CourseGradeField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(StudentName,Color.white,18);
        StudentName.setBounds(120,50,99,40);
        UpdateGradepanel.add(StudentName);
        StudentNameField.setFont(myFont.anything());
        StudentNameField.setBounds(220,55,230,35);
        UpdateGradepanel.add(StudentNameField);

        myFont.jLabelfont(CourseName,Color.white,18);
        CourseName.setBounds(120,130,99,40);
        UpdateGradepanel.add(CourseName);
        CourseNameField.setFont(myFont.anything());
        CourseNameField.setBounds(220,135,230,35);
        UpdateGradepanel.add(CourseNameField);

        myFont.jLabelfont(CourseGrade, Color.white,18);
        CourseGrade.setBounds(120,210,80,40);
        UpdateGradepanel.add(CourseGrade);
        CourseGradeField.setFont(myFont.anything());
        CourseGradeField.setBounds(220,215,230,35);
        UpdateGradepanel.add(CourseGradeField);

        myFont.buttonfont(Submit,Color.white,18);
        Submit.setBounds(120,290,330,40);
        Submit.setContentAreaFilled(false);
        UpdateGradepanel.add(Submit);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitAct(e);
            }
        });

        myFont.buttonfont(Canel,Color.white,18);
        Canel.setBounds(120,370,330,40);
        Canel.setContentAreaFilled(false);
        UpdateGradepanel.add(Canel);
        Canel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelAct(e);
            }
        });

        UpdateGradepanel.setLayout(null);
        UpdateGradepanel.setBackground(Color.black);
        UpdateGradeView.add(UpdateGradepanel);
        UpdateGradeView.setSize(600,600);
        UpdateGradeView.setLocationRelativeTo(null);//窗口相对于屏幕居中
        UpdateGradeView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UpdateGradeView.setVisible(true);
    }

    private void CancelAct(ActionEvent e){
        UpdateGradeView.dispose();
    }

    private void SubmitAct(ActionEvent e){
        String StudentName = StudentNameField.getText();
        String CourseName = CourseNameField.getText();
        int CourseGrade = Integer.parseInt(CourseGradeField.getText());

        if (StringUtil.isEmpty(CourseNameField.getText())||StringUtil.isEmpty(CourseGradeField.getText())||StringUtil.isEmpty(StudentNameField.getText())){
            JOptionPane.showMessageDialog(UpdateGradeView,"不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Grade grade = new Grade();
        grade.setName(StudentName);
        grade.setCourse(CourseName);
        grade.setGrade(CourseGrade);
        GradeDao gradeDao = new GradeDao();
        if (gradeDao.updateCourse(grade)){
            JOptionPane.showMessageDialog(UpdateGradeView,"修改成功！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else {
            JOptionPane.showMessageDialog(UpdateGradeView,"修改失败！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
    }

//    public static void main(String[] args) {
//        new UpdateGradeView();
//    }
}
