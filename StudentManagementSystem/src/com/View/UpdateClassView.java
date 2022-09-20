package com.View;

import com.dao.SchoolClassDao;
import com.model.SchoolClass;
import com.util.MyFont;
import com.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *类名： UpdateClassView.java
 *作者： 19241045王彪
 *描述： 修改班级信息
 *时间:  2021/12/16 4:23
 *版本:  1.8
 */
public class UpdateClassView extends JFrame {
    private JFrame UpdateClassView;
    private JPanel UpdateClasspanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel ClassName;//班级名称
    private JLabel Year;//年级
    private JLabel Num;//人数
    private JTextField ClassNameField;//账号框
    private JTextField YearField;//年级框
    private JTextField NumField;//人数框
    
    public UpdateClassView(){
        UpdateClassView = new JFrame("修改班级");
        UpdateClasspanel = new JPanel();
        Submit = new JButton("确认");
        Canel = new JButton("取消");
        ClassName = new JLabel("班级名称: ");
        Year = new JLabel("年级：");
        Num = new JLabel("人数：");
        ClassNameField = new JTextField();
        YearField = new JTextField();
        NumField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(ClassName, Color.white,18);
        ClassName.setBounds(120,50,99,40);
        UpdateClasspanel.add(ClassName);
        ClassNameField.setFont(myFont.anything());
        ClassNameField.setBounds(220,55,230,35);
        UpdateClasspanel.add(ClassNameField);

        myFont.jLabelfont(Year,Color.white,18);
        Year.setBounds(120,130,99,40);
        UpdateClasspanel.add(Year);
        YearField.setFont(myFont.anything());
        YearField.setBounds(220,135,230,35);
        UpdateClasspanel.add(YearField);

        myFont.jLabelfont(Num,Color.white,18);
        Num.setBounds(120,210,99,40);
        UpdateClasspanel.add(Num);
        NumField.setFont(myFont.anything());
        NumField.setBounds(220,215,230,35);
        UpdateClasspanel.add(NumField);

        myFont.buttonfont(Submit,Color.white,18);
        Submit.setBounds(120,370,330,40);
        Submit.setContentAreaFilled(false);
        UpdateClasspanel.add(Submit);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitAct(e);
            }
        });

        myFont.buttonfont(Canel, Color.white,18);
        Canel.setBounds(120,450,330,40);
        Canel.setContentAreaFilled(false);
        UpdateClasspanel.add(Canel);
        Canel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateClassView.dispose();
            }
        });
        UpdateClasspanel.setLayout(null);
        UpdateClasspanel.setBackground(Color.black);
        UpdateClassView.add(UpdateClasspanel);
        UpdateClassView.setSize(600,600);
//        UpdateClassView.setLocation((screenwidth-windowwidth)/2,(screenheight-windowhight)/2);
        UpdateClassView.setLocationRelativeTo(null);//窗口相对于屏幕居中
        UpdateClassView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UpdateClassView.setVisible(true);
    }

    public void SubmitAct(ActionEvent event){
        String ClassName = ClassNameField.getText();
        String Year = YearField.getText();
        int Num = Integer.parseInt(NumField.getText());

        if(StringUtil.isEmpty(ClassNameField.getText())||StringUtil.isEmpty(YearField.getText())||StringUtil.isEmpty(NumField.getText())){
            JOptionPane.showMessageDialog(UpdateClassView,"班级,年纪或人数不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassname(ClassName);
        schoolClass.setYear(Year);
        schoolClass.setNum(Num);
        SchoolClassDao schoolClassDao = new SchoolClassDao();
        if(schoolClassDao.UpdateClass(schoolClass)){
            JOptionPane.showMessageDialog(UpdateClassView,"班级修改成功！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else {
            JOptionPane.showMessageDialog(UpdateClassView,"班级修改失败！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
}
