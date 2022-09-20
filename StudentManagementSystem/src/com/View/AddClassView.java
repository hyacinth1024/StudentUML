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
 *类名： AddClassView.java
 *作者： 19241045王彪
 *描述： 添加公司
 *时间:  2021/12/16 4:16
 *版本:  1.8
 */
public class AddClassView extends JFrame {
    private JFrame AddClassView;
    private JPanel AddClasspanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel ClassName;//班级名称
    private JLabel Year;//年级
    private JLabel Num;//人数
    private JTextField ClassNameField;//账号框
    private JTextField YearField;//年级框
    private JTextField NumField;//人数框

    public AddClassView(){
        AddClassView = new JFrame("添加公司");
        AddClasspanel = new JPanel();
        Submit = new JButton("确认");
        Canel = new JButton("取消");
        ClassName = new JLabel("公司名称: ");
        Year = new JLabel("年份：");
        Num = new JLabel("人数：");
        ClassNameField = new JTextField();
        YearField = new JTextField();
        NumField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(ClassName,Color.white,18);
        ClassName.setBounds(120,50,99,40);
        AddClasspanel.add(ClassName);
        ClassNameField.setFont(myFont.anything());
        ClassNameField.setBounds(220,55,230,35);
        AddClasspanel.add(ClassNameField);

        myFont.jLabelfont(Year,Color.white,18);
        Year.setBounds(120,130,99,40);
        AddClasspanel.add(Year);
        YearField.setFont(myFont.anything());
        YearField.setBounds(220,135,230,35);
        AddClasspanel.add(YearField);

        myFont.jLabelfont(Num,Color.white,18);
        Num.setBounds(120,210,99,40);
        AddClasspanel.add(Num);
        NumField.setFont(myFont.anything());
        NumField.setBounds(220,215,230,35);
        AddClasspanel.add(NumField);

        myFont.buttonfont(Submit,Color.white,18);
        Submit.setBounds(120,370,330,40);
        Submit.setContentAreaFilled(false);
        AddClasspanel.add(Submit);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitAct(e);
            }
        });

        myFont.buttonfont(Canel, Color.white,18);
        Canel.setBounds(120,450,330,40);
        Canel.setContentAreaFilled(false);
        AddClasspanel.add(Canel);
        Canel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddClassView.dispose();
            }
        });
        AddClasspanel.setLayout(null);
        AddClasspanel.setBackground(Color.black);
        AddClassView.add(AddClasspanel);
        AddClassView.setSize(600,600);
//        AddClassView.setLocation((screenwidth-windowwidth)/2,(screenheight-windowhight)/2);
        AddClassView.setLocationRelativeTo(null);//窗口相对于屏幕居中
        AddClassView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddClassView.setVisible(true);
    }

    public void SubmitAct(ActionEvent event){
        String ClassName = ClassNameField.getText();
        String Year = YearField.getText();
        int Num = Integer.parseInt(NumField.getText());

        if(StringUtil.isEmpty(ClassNameField.getText())||StringUtil.isEmpty(YearField.getText())||StringUtil.isEmpty(NumField.getText())){
            JOptionPane.showMessageDialog(AddClassView,"班级,年纪或人数不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassname(ClassName);
        schoolClass.setYear(Year);
        schoolClass.setNum(Num);
        SchoolClassDao schoolClassDao = new SchoolClassDao();
        if(schoolClassDao.AddClass(schoolClass)){
            JOptionPane.showMessageDialog(AddClassView,"班级添加成功！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else {
            JOptionPane.showMessageDialog(AddClassView,"班级添加失败！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
    }

//    public static void main(String[] args) {
//        new AddClassView();
//    }
}
