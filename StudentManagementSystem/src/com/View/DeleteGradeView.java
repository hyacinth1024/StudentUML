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
 *类名： DeleteGradeView.java
 *作者： 19241045王彪
 *描述： 删除成绩
 *时间:  2021/12/16 0:10
 *版本:  1.8
 */
public class DeleteGradeView extends JFrame {
    private JFrame DeleteGradeView;
    private JPanel DeleteGradepanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel StudentName;
    private JTextField StudentNameField;
    private JLabel CourseName;//课程名称
    private JTextField CourseNameField;//课程框

    public DeleteGradeView(){
        DeleteGradeView = new JFrame("删除成绩");
        DeleteGradepanel = new JPanel();
        Submit = new JButton("确定");
        Canel = new JButton("取消");
        CourseName = new JLabel("课程名称：");
        CourseNameField = new JTextField();
        StudentName = new JLabel("学生姓名");
        StudentNameField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(CourseName, Color.white,18);
        CourseName.setBounds(120,130,99,40);
        DeleteGradepanel.add(CourseName);
        CourseNameField.setFont(myFont.anything());
        CourseNameField.setBounds(220,135,230,35);
        DeleteGradepanel.add(CourseNameField);

        myFont.jLabelfont(StudentName,Color.white,18);
        StudentName.setBounds(120,210,99,40);
        DeleteGradepanel.add(StudentName);
        StudentNameField.setFont(myFont.anything());
        StudentNameField.setBounds(220,215,230,35);
        DeleteGradepanel.add(StudentNameField);

        myFont.buttonfont(Submit,Color.white,18);
        Submit.setBounds(120,290,330,40);
        Submit.setContentAreaFilled(false);
        DeleteGradepanel.add(Submit);

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitAct(e);
            }
        });

        myFont.buttonfont(Canel,Color.white,18);
        Canel.setBounds(120,370,330,40);
        Canel.setContentAreaFilled(false);
        DeleteGradepanel.add(Canel);

        Canel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteGradeView.dispose();
            }
        });

        DeleteGradepanel.setLayout(null);
        DeleteGradepanel.setBackground(Color.black);
        DeleteGradeView.add(DeleteGradepanel);
        DeleteGradeView.setSize(600,600);
//        AddClassView.setLocation((screenwidth-windowwidth)/2,(screenheight-windowhight)/2);
        DeleteGradeView.setLocationRelativeTo(null);//窗口相对于屏幕居中
        DeleteGradeView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DeleteGradeView.setVisible(true);
    }

    private void SubmitAct(ActionEvent e) {
        String CourseName = CourseNameField.getText();
        String StudentName = StudentNameField.getText();

        if (StringUtil.isEmpty(CourseNameField.getText())||StringUtil.isEmpty(StudentNameField.getText())){
            JOptionPane.showMessageDialog(DeleteGradeView,"课程名或学生姓名不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Grade grade = new Grade();
        grade.setName(StudentName);
        grade.setCourse(CourseName);
        GradeDao gradeDao = new GradeDao();
        if (gradeDao.deleteCourse(grade)){
            JOptionPane.showMessageDialog(DeleteGradeView,"成绩删除成功！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else {
            JOptionPane.showMessageDialog(DeleteGradeView,"成绩删除失败！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
//        System.out.println(ClassName);
    }

//    public static void main(String[] args) {
//        new DeleteGradeView();
//    }
}
