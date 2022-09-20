package com.View;

import com.util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *类名： GView.java
 *作者： 19241045王彪
 *描述： 管理员界面
 *时间:  2021/12/16 0:11
 *版本:  1.8
 */
public class GView extends JFrame {
    private JFrame GView;
    private JPanel gpanel;

    public GView(){
        GView = new JFrame();
        gpanel = new JPanel();
        //获取屏幕大小
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenwidth = screenSize.width;
        int screenheight = screenSize.height;

        MyFont gmyFont = new MyFont();
        //菜单
        JMenuBar gmenuBar = new JMenuBar();
        gmenuBar.setBackground(Color.black);
        GView.setJMenuBar(gmenuBar);

        /**
         * 账号管理
         */
        JMenu accout = new JMenu("账号管理");
        gmyFont.MyFont(accout,Color.white);
        gmenuBar.add(accout);
        JMenuItem increaseacc = new JMenuItem("增加账号");
        gmyFont.jmenuitemfont(increaseacc);
        accout.add(increaseacc);
        increaseacc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAccountView();
            }
        });
        JMenuItem deleteacc = new JMenuItem("删除账号");
        gmyFont.jmenuitemfont(deleteacc);
        accout.add(deleteacc);
        deleteacc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteAccountView();
            }
        });
        JMenuItem changeacc = new JMenuItem("修改账号");
        gmyFont.jmenuitemfont(changeacc);
        accout.add(changeacc);
        changeacc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateAccountView();
            }
        });
        JMenuItem findacc = new JMenuItem("查找账号");
        gmyFont.jmenuitemfont(findacc);
        accout.add(findacc);
        findacc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectAccountView();
            }
        });

        /**
         * 班级管理
         */
        JMenu classmanage = new JMenu("班级管理");
        gmyFont.MyFont(classmanage,Color.white);
        gmenuBar.add(classmanage);
        JMenuItem putinclass = new JMenuItem("增加班级");
        gmyFont.jmenuitemfont(putinclass);
        classmanage.add(putinclass);
        putinclass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddClassView();
            }
        });
        JMenuItem deleteclass = new JMenuItem("删除班级");
        gmyFont.jmenuitemfont(deleteclass);
        classmanage.add(deleteclass);
        deleteclass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteClassView();
            }
        });
        JMenuItem changeclass = new JMenuItem("修改班级");
        gmyFont.jmenuitemfont(changeclass);
        classmanage.add(changeclass);
        changeclass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateClassView();
            }
        });
        JMenuItem findclass = new JMenuItem("查找班级");
        gmyFont.jmenuitemfont(findclass);
        classmanage.add(findclass);
        findclass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectClassView();
            }
        });

        /**
         * 成绩管理
         */
        JMenu message = new JMenu("成绩管理");
        gmyFont.MyFont(message,Color.white);
        gmenuBar.add(message);
        JMenuItem increasem = new JMenuItem("添加成绩");
        gmyFont.jmenuitemfont(increasem);
        message.add(increasem);
        increasem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddGradeView();
            }
        });
        JMenuItem deletem = new JMenuItem("删除成绩");
        gmyFont.jmenuitemfont(deletem);
        message.add(deletem);
        deletem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteGradeView();
            }
        });
        JMenuItem changem = new JMenuItem("修改成绩");
        gmyFont.jmenuitemfont(changem);
        message.add(changem);
        changem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateGradeView();
            }
        });
        JMenuItem findm = new JMenuItem("查找成绩");
        gmyFont.jmenuitemfont(findm);
        message.add(findm);
        findm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectGradeView();
            }
        });

        /*JMenu protect = new JMenu("维护成绩");
        gmyFont.MyFont(protect,Color.white);
        gmenuBar.add(protect);*/

        /**
         * 课程管理
         */
        JMenu coursemanage = new JMenu("课程管理");
        gmyFont.MyFont(coursemanage,Color.white);
        gmenuBar.add(coursemanage);
        JMenuItem putincourse = new JMenuItem("增加课程");
        gmyFont.jmenuitemfont(putincourse);
        coursemanage.add(putincourse);
        putincourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCourseView();
            }
        });
        JMenuItem deletecourse = new JMenuItem("删除课程");
        gmyFont.jmenuitemfont(deletecourse);
        coursemanage.add(deletecourse);
        deletecourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteCourseView();
            }
        });
        JMenuItem changecourse = new JMenuItem("修改课程");
        gmyFont.jmenuitemfont(changecourse);
        coursemanage.add(changecourse);
        changecourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateCourseView();
            }
        });
        JMenuItem findcourse = new JMenuItem("查找课程");
        gmyFont.jmenuitemfont(findcourse);
        coursemanage.add(findcourse);
        findcourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectCourseView();
            }
        });

        JMenu gexitmenu = new JMenu("退出");
        gmyFont.MyFont(gexitmenu,Color.white);
        gmenuBar.add(gexitmenu);
        JMenuItem gexit = new JMenuItem("退出");
        gmyFont.jmenuitemfont(gexit);
        gexitmenu.add(gexit);

        //背景
       /* ImageIcon gimageIcon = new ImageIcon("F:\\UML\\image\\manwithblade.jpg");
        JLabel glabel = new JLabel(new MView.ScaleIcon(gimageIcon));
        glabel.setBounds(0,0,screenwidth,screenheight);
        GView.getLayeredPane().add(glabel,new Integer(Integer.MIN_VALUE));
        JPanel g = (JPanel)GView.getContentPane();
        g.setOpaque(false);
        gpanel.add(glabel,BorderLayout.CENTER);
        gpanel.setOpaque(false);*/

        gpanel.setLayout(null);
        GView.add(gpanel);
        GView.setTitle("系统管理员");
        GView.setSize(screenwidth,screenheight);
        GView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GView.setVisible(true);

        //监听事件
        gexit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GView.dispose();
                new MView();
            }
        });
        /*AbstractAction gexitAction = new AbstractAction("退出") {
            @Override
            public void actionPerformed(ActionEvent e) {
//                SView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                System.exit(0);
                GView.dispose();
            }
        };
        JMenuItem exit = new JMenuItem(gexitAction);
        gmyFont.jmenuitemfont(exit);
        gexit.add(exit);*/
    }
    
//    public static void main(String[] args) {
//        new GView();
//    }
}
