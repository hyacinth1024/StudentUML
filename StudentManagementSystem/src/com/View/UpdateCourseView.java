package com.View;

import com.dao.CourseDao;
import com.model.Course;
import com.util.MyFont;
import com.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *类名： UpdateCourseView.java
 *作者： 19241045王彪
 *描述： 修改课程
 *时间:  2021/12/16 4:24
 *版本:  1.8
 */
public class UpdateCourseView extends JFrame {
    private JFrame UpdateCourseView;
    private JPanel UpdateCoursepanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel CourseName;//课程名
    private JLabel Teacher;//任课老师
    private JTextField CourseNameField;//课程名框
    private JTextField TeacherField;//任课老师框

    public UpdateCourseView(){
        UpdateCourseView = new JFrame("修改课程");
        UpdateCoursepanel = new JPanel();
        Submit = new JButton("确认");
        Canel = new JButton("取消");
        CourseName = new JLabel("课程名: ");
        Teacher = new JLabel("任课教师：");
        CourseNameField = new JTextField();
        TeacherField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(CourseName, Color.white,18);
        CourseName.setBounds(120,130,99,40);
        UpdateCoursepanel.add(CourseName);
        CourseNameField.setFont(myFont.anything());
        CourseNameField.setBounds(220,135,230,35);
        UpdateCoursepanel.add(CourseNameField);

        myFont.jLabelfont(Teacher,Color.white,18);
        Teacher.setBounds(120,210,99,40);
        UpdateCoursepanel.add(Teacher);
        TeacherField.setFont(myFont.anything());
        TeacherField.setBounds(220,215,230,35);
        UpdateCoursepanel.add(TeacherField);

        myFont.buttonfont(Submit,Color.white,18);
        Submit.setBounds(120,370,330,40);
        Submit.setContentAreaFilled(false);
        UpdateCoursepanel.add(Submit);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitAct(e);
            }
        });

        myFont.buttonfont(Canel,Color.white,18);
        Canel.setBounds(120,450,330,40);
        Canel.setContentAreaFilled(false);
        UpdateCoursepanel.add(Canel);
        Canel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CanelAct(e);
            }
        });
        UpdateCoursepanel.setLayout(null);
        UpdateCoursepanel.setBackground(Color.black);
        UpdateCourseView.add(UpdateCoursepanel);
        UpdateCourseView.setSize(600,600);
        UpdateCourseView.setLocationRelativeTo(null);//窗口相对于屏幕居中
        UpdateCourseView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UpdateCourseView.setVisible(true);
    }

    public void CanelAct(ActionEvent event){
        UpdateCourseView.dispose();
    }

    public void SubmitAct(ActionEvent e) {
        String CourseName = CourseNameField.getText();
        String Teacher = TeacherField.getText();

        if (StringUtil.isEmpty(CourseNameField.getText()) || StringUtil.isEmpty(TeacherField.getText())) {
            JOptionPane.showMessageDialog(UpdateCourseView, "课程名或教师不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Course course = new Course();
        course.setCoursename(CourseName);
        course.setTeacher(Teacher);
        CourseDao courseDao = new CourseDao();
        if (courseDao.UpdateCourse(course)) {
            JOptionPane.showMessageDialog(UpdateCourseView, "课程修改成功！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(UpdateCourseView, "课程修改失败！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }

//    public static void main(String[] args) {
//        new UpdateCourseView();
//    }
}
