package com.View;

import com.util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *类名： SView.java
 *作者： 19241045王彪
 *描述： 学生界面
 *时间:  2021/12/16 3:18
 *版本:  1.8
 */
public class SView extends JFrame {
    private JFrame SView = new JFrame();
    private JPanel spanel1 = new JPanel();

    public SView() {
//        JFrame SView = new JFrame();
//        JPanel spanel1 = new JPanel();

        //字体
        MyFont menuFont = new MyFont();
        MyFont menuitemFont = new MyFont();
        //获取屏幕大小
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenwidth = screenSize.width;
        int screenheight = screenSize.height;
/*
        //设置背景
        ImageIcon simage = new ImageIcon("F:\\UML\\image\\cat.jpg");
        JLabel simagelabel = new JLabel(new MView.ScaleIcon(simage));
        simagelabel.setBounds(0,0,screenwidth,screenheight);
        SView.getLayeredPane().add(simagelabel,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel)SView.getContentPane();
        j.setOpaque(false);
        spanel1.add(simagelabel,BorderLayout.CENTER);
        spanel1.setOpaque(false);*/

        //构建菜单
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(Color.black);
//        menubar.setSize(screenwidth,60);
        SView.setJMenuBar(menubar);

        JMenu classMenu = new JMenu("成绩管理");
        menuFont.MyFont(classMenu,Color.white);
        menubar.add(classMenu);
        //添加菜单项
        JMenuItem checkwithname = new JMenuItem("查看成绩");
        menuitemFont.jmenuitemfont(checkwithname);
        classMenu.add(checkwithname);
        checkwithname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentSelectGradesView();
            }
        });
        /*JMenuItem checkwithnumber = new JMenuItem("按课程号查看");
        menuitemFont.jmenuitemfont(checkwithnumber);
        classMenu.add(checkwithnumber);*/

        /*JMenu checkMenu = new JMenu("选择");
        menuFont.MyFont(checkMenu,Color.white);
        menubar.add(checkMenu);
        JMenuItem choose = new JMenuItem("选择课程");
        menuitemFont.jmenuitemfont(choose);
        checkMenu.add(choose);
        JMenuItem delete = new JMenuItem("删除课程");
        menuitemFont.jmenuitemfont(delete);
        checkMenu.add(delete);*/

        JMenu exitMenu = new JMenu("退出");
        menuFont.MyFont(exitMenu,Color.white);
        menubar.add(exitMenu);
        JMenuItem sexit = new JMenuItem("退出");
        menuFont.jmenuitemfont(sexit);
        exitMenu.add(sexit);

        spanel1.setLayout(null);
        SView.add(spanel1);
        SView.setTitle("学生");
        SView.setSize(screenwidth,screenheight);
        //关闭窗口
        SView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SView.setVisible(true);

        sexit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SView.dispose();
                new MView();
            }
        });
    }

//    public static void main(String[] args) {
//        new SView();
//    }
}