package com.View;

import com.util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *类名： SousuoGradeView.java
 *作者： 19241045王彪
 *描述： 搜索查询成绩界面
 *时间:  2021/12/16 4:21
 *版本:  1.8
 */
public class SousuoGradeView extends JFrame {
    private JFrame SousuoGradeView;
    private JPanel SousuoGradepanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel StudentName;//学生姓名
    private JLabel ClassName;//班级名称
    private JTextField StudentNameField;//姓名框
    private JTextField ClassNameField;
    
    public SousuoGradeView(){
        SousuoGradeView = new JFrame("搜索成绩");
        SousuoGradepanel = new JPanel();
        Submit = new JButton("确认");
        Canel = new JButton("取消");
        StudentName = new JLabel("学生姓名: ");
        ClassName = new JLabel("班级名称：");
        StudentNameField = new JTextField();
        ClassNameField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(StudentName, Color.white,18);
        StudentName.setBounds(120,50,99,40);
        SousuoGradepanel.add(StudentName);
        StudentNameField.setFont(myFont.anything());
        StudentNameField.setBounds(220,55,230,35);
        SousuoGradepanel.add(StudentNameField);

        myFont.jLabelfont(ClassName,Color.white,18);
        ClassName.setBounds(120,130,99,40);
        SousuoGradepanel.add(ClassName);
        ClassNameField.setFont(myFont.anything());
        ClassNameField.setBounds(220,135,230,35);
        SousuoGradepanel.add(ClassNameField);

        myFont.buttonfont(Submit,Color.white,18);
        Submit.setBounds(120,370,330,40);
        Submit.setContentAreaFilled(false);
        SousuoGradepanel.add(Submit);

        myFont.buttonfont(Canel,Color.white,18);
        Canel.setBounds(120,450,330,40);
        Canel.setContentAreaFilled(false);
        SousuoGradepanel.add(Canel);

        SousuoGradepanel.setLayout(null);
        SousuoGradepanel.setBackground(Color.black);
        SousuoGradeView.add(SousuoGradepanel);
        SousuoGradeView.setSize(600,600);
        SousuoGradeView.setLocationRelativeTo(null);//窗口相对于屏幕居中
        SousuoGradeView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SousuoGradeView.setVisible(true);

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitAct(e);
            }
        });

        Canel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CanelAct(e);
            }
        });
    }

    private void CanelAct(ActionEvent e) {
        SousuoGradeView.dispose();
    }

    private void SubmitAct(ActionEvent e) {
        new SousuoGrade(StudentNameField.getText(),ClassNameField.getText());
    }
}
