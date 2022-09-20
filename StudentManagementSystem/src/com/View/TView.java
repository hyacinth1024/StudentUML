package com.View;

import com.util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *类名： TView.java
 *作者： 19241045王彪
 *描述： 教师界面
 *时间:  2021/12/16 4:23
 *版本:  1.8
 */
public class TView extends JFrame {
    private JFrame TView = new JFrame();
    private JPanel tpanel1 = new JPanel();
    public TView(){
        //获取屏幕大小
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenwidth = screenSize.width;
        int screenheight = screenSize.height;

        //字体
        MyFont myFont = new MyFont();
        //添加菜单
        JMenuBar tmenuBar = new JMenuBar();
        tmenuBar.setBackground(Color.black);
        TView.setJMenuBar(tmenuBar);

        JMenu tclass = new JMenu("成绩管理");
        myFont.MyFont(tclass,Color.white);
        tmenuBar.add(tclass);
        JMenuItem tinput = new JMenuItem("录入成绩");
        myFont.jmenuitemfont(tinput);
        tclass.add(tinput);
        tinput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddGradeView();
            }
        });
        JMenuItem tdelete = new JMenuItem("删除成绩");
        myFont.jmenuitemfont(tdelete);
        tclass.add(tdelete);
        tdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteGradeView();
            }
        });
        JMenuItem tchange = new JMenuItem("修改成绩");
        myFont.jmenuitemfont(tchange);
        tclass.add(tchange);
        tchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateGradeView();
            }
        });
        JMenuItem tsentjudge = new JMenuItem("查看成绩");
        myFont.jmenuitemfont(tsentjudge);
        tclass.add(tsentjudge);
        tsentjudge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectGradeView();
            }
        });
        JMenuItem tsousuo = new JMenuItem("搜索成绩");
        myFont.jmenuitemfont(tsousuo);
        tclass.add(tsousuo);
        tsousuo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SousuoGradeView();
            }
        });

        JMenu tstudent = new JMenu("课程管理");
        myFont.MyFont(tstudent,Color.white);
        tmenuBar.add(tstudent);
        JMenuItem tcheckwithsname = new JMenuItem("查看课程");
        myFont.jmenuitemfont(tcheckwithsname);
        tstudent.add(tcheckwithsname);
        tcheckwithsname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TeacherSelectCourseView();
            }
        });

        JMenu texitmenu = new JMenu("退出");
        myFont.MyFont(texitmenu,Color.white);
        tmenuBar.add(texitmenu);
//        JMenuItem tswitch = new JMenuItem("切换身份");
//        myFont.jmenuitemfont(tswitch);
//        texitmenu.add(tswitch);
        JMenuItem texit = new JMenuItem("退出");
        myFont.jmenuitemfont(texit);
        texitmenu.add(texit);
        //监听事件
        texit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TView.dispose();
                new MView();
            }
        });

        //设置背景
        /*ImageIcon timage = new ImageIcon("F:\\UML\\image\\spaceman.png");
        JLabel timagelabel = new JLabel(new MView.ScaleIcon(timage));
        timagelabel.setBounds(0,0,screenwidth,screenheight);
        TView.getLayeredPane().add(timagelabel,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel)TView.getContentPane();
        j.setOpaque(false);
        tpanel1.add(timagelabel,BorderLayout.CENTER);
        tpanel1.setOpaque(false);*/

        tpanel1.setLayout(null);
        TView.add(tpanel1);
        TView.setTitle("教师");
        TView.setSize(screenwidth,screenheight);
        TView.setVisible(true);
        TView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

//    public static void main(String[] args) {
//        new TView();
//    }
}
