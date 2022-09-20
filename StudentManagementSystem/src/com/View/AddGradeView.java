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
 *类名： AddGradeView.java
 *作者： 19241045王彪
 *描述： 添加成绩
 *时间:  2021/12/16 4:17
 *版本:  1.8
 */
public class AddGradeView extends JFrame {
    private JFrame AddGradeView;
    private JPanel AddGradepanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel StudentName;//学生姓名
    private JLabel CourseName;//课程名称
    private JLabel ClassName;//班级名称
    private JLabel CourseGrade;//分数
    private JTextField StudentNameField;//姓名框
    private JTextField ClassNameField;
    private JTextField CourseNameField;//课程框
    private JTextField CourseGradeField;//分数框

    public AddGradeView(){
        AddGradeView = new JFrame("添加成绩");
        AddGradepanel = new JPanel();
        Submit = new JButton("确认");
        Canel = new JButton("取消");
        StudentName = new JLabel("学生姓名: ");
        ClassName = new JLabel("班级名称：");
        CourseName = new JLabel("课程名称：");
        CourseGrade = new JLabel("分数：");
        StudentNameField = new JTextField();
        ClassNameField = new JTextField();
        CourseNameField = new JTextField();
        CourseGradeField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(StudentName,Color.white,18);
        StudentName.setBounds(120,50,99,40);
        AddGradepanel.add(StudentName);
        StudentNameField.setFont(myFont.anything());
        StudentNameField.setBounds(220,55,230,35);
        AddGradepanel.add(StudentNameField);

        myFont.jLabelfont(ClassName,Color.white,18);
        ClassName.setBounds(120,130,99,40);
        AddGradepanel.add(ClassName);
        ClassNameField.setFont(myFont.anything());
        ClassNameField.setBounds(220,135,230,35);
        AddGradepanel.add(ClassNameField);

        myFont.jLabelfont(CourseName,Color.white,18);
        CourseName.setBounds(120,210,99,40);
        AddGradepanel.add(CourseName);
        CourseNameField.setFont(myFont.anything());
        CourseNameField.setBounds(220,215,230,35);
        AddGradepanel.add(CourseNameField);

        myFont.jLabelfont(CourseGrade,Color.white,18);
        CourseGrade.setBounds(120,290,80,40);
        AddGradepanel.add(CourseGrade);
        CourseGradeField.setFont(myFont.anything());
        CourseGradeField.setBounds(220,295,230,35);
        AddGradepanel.add(CourseGradeField);

        myFont.buttonfont(Submit,Color.white,18);
        Submit.setBounds(120,370,330,40);
        Submit.setContentAreaFilled(false);
        AddGradepanel.add(Submit);

        myFont.buttonfont(Canel,Color.white,18);
        Canel.setBounds(120,450,330,40);
        Canel.setContentAreaFilled(false);
        AddGradepanel.add(Canel);

        //获取屏幕大小
        /*Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenwidth = screenSize.width;
        int screenheight = screenSize.height;
        //获取窗口宽高
        int windowwidth = AddClassView.getWidth();
        int windowhight = AddClassView.getHeight();*/
        AddGradepanel.setLayout(null);
        AddGradepanel.setBackground(Color.black);
        AddGradeView.add(AddGradepanel);
        AddGradeView.setSize(600,600);
        AddGradeView.setLocationRelativeTo(null);//窗口相对于屏幕居中
        AddGradeView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddGradeView.setVisible(true);

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
        AddGradeView.dispose();
    }

    private void SubmitAct(ActionEvent e) {
        String StudentName = StudentNameField.getText();
        String ClassName = ClassNameField.getText();
        String CourseName = CourseNameField.getText();
        int CourseGrade = Integer.parseInt(CourseGradeField.getText());

        if (StringUtil.isEmpty(CourseNameField.getText())||StringUtil.isEmpty(CourseGradeField.getText())||StringUtil.isEmpty(StudentNameField.getText())){
            JOptionPane.showMessageDialog(AddGradeView,"学生姓名或课程名或分数不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Grade grade = new Grade();
        grade.setName(StudentName);
        grade.setClassname(ClassName);
        grade.setCourse(CourseName);
        grade.setGrade(CourseGrade);
        GradeDao gradeDao = new GradeDao();
        if (gradeDao.addCourse(grade)){
            JOptionPane.showMessageDialog(AddGradeView,"成绩添加成功！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else {
            JOptionPane.showMessageDialog(AddGradeView,"成绩添加失败！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        /*System.out.println(ClassName);
        System.out.println(ClassGrade);*/
    }


//    public static void main(String[] args) {
//        new AddGradeView();
//    }
}
