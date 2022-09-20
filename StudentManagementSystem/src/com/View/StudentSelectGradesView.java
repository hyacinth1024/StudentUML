package com.View;

import com.util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *类名： StudentSelectGradesView.java
 *作者： 19241045王彪
 *描述： 学生查询成绩界面
 *时间:  2021/12/16 4:22
 *版本:  1.8
 */
public class StudentSelectGradesView extends JFrame {
    private JFrame StudentSelectGradesView;
    private JPanel AStudentSelectGradespanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel StudentName;
    private JTextField StudentNameField;

    public StudentSelectGradesView(){
        StudentSelectGradesView = new JFrame("添加账号");
        AStudentSelectGradespanel = new JPanel();
        Submit = new JButton("确认");
        Canel = new JButton("取消");
        StudentName = new JLabel("请输入你的姓名:");
        StudentNameField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(StudentName,Color.white,18);
        StudentName.setBounds(220,50,230,40);
        AStudentSelectGradespanel.add(StudentName);
        StudentNameField.setFont(myFont.anything());
        StudentNameField.setBounds(170,130,230,35);
        AStudentSelectGradespanel.add(StudentNameField);
        myFont.buttonfont(Submit,Color.white,18);
        Submit.setBounds(120,370,330,40);
        Submit.setContentAreaFilled(false);
        AStudentSelectGradespanel.add(Submit);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitAct(e);
            }
        });

        myFont.buttonfont(Canel,Color.white,18);
        Canel.setBounds(120,450,330,40);
        Canel.setContentAreaFilled(false);
        AStudentSelectGradespanel.add(Canel);
        Canel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentSelectGradesView.dispose();
            }
        });
        AStudentSelectGradespanel.setLayout(null);
        AStudentSelectGradespanel.setBackground(Color.black);
        StudentSelectGradesView.add(AStudentSelectGradespanel);
        StudentSelectGradesView.setSize(600,600);
        StudentSelectGradesView.setLocationRelativeTo(null);//窗口相对于屏幕居中
        StudentSelectGradesView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        StudentSelectGradesView.setVisible(true);
    }
    public void SubmitAct(ActionEvent e){
        new StudentSelectGrades(StudentNameField.getText());
    }

//    public static void main(String[] args) {
//        new StudentSelectGradesView();
//    }
}
