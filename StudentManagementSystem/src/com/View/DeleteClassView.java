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
 *类名： DeleteClassView.java
 *作者： 19241045王彪
 *描述： 删除班级
 *时间:  2021/12/16 4:18
 *版本:  1.8
 */
public class DeleteClassView extends JFrame {
    private JFrame AddClassView;
    private JPanel AddClasspanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel ClassName;//班级名称
    private JLabel Year;//年级
    private JTextField ClassNameField;//账号框
    private JTextField YearField;//年级框

    public DeleteClassView(){
        AddClassView = new JFrame("删除班级");
        AddClasspanel = new JPanel();
        Submit = new JButton("确认");
        Canel = new JButton("取消");
        ClassName = new JLabel("班级名称: ");
        Year = new JLabel("年级：");
        ClassNameField = new JTextField();
        YearField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(ClassName, Color.white,18);
        ClassName.setBounds(120,130,99,40);
        AddClasspanel.add(ClassName);
        ClassNameField.setFont(myFont.anything());
        ClassNameField.setBounds(220,135,230,35);
        AddClasspanel.add(ClassNameField);

        myFont.jLabelfont(Year,Color.white,18);
        Year.setBounds(120,210,99,40);
        AddClasspanel.add(Year);
        YearField.setFont(myFont.anything());
        YearField.setBounds(220,215,230,35);
        AddClasspanel.add(YearField);

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

        if(StringUtil.isEmpty(ClassNameField.getText())||StringUtil.isEmpty(YearField.getText())){
            JOptionPane.showMessageDialog(AddClassView,"班级或年纪不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassname(ClassName);
        schoolClass.setYear(Year);
        SchoolClassDao schoolClassDao = new SchoolClassDao();
        if(schoolClassDao.DeleteClass(schoolClass)){
            JOptionPane.showMessageDialog(AddClassView,"班级删除成功！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else {
            JOptionPane.showMessageDialog(AddClassView,"班级删除失败！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
}
