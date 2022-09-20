package com.View;

import com.util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *类名： FView.java
 *作者： 19241045王彪
 *描述： 辅导员界面
 *时间:  2021/12/16 4:19
 *版本:  1.8
 */
public class FView extends JFrame {
    private JFrame FView;
    private JPanel fpanel;

    public FView() {
        FView = new JFrame();
        fpanel = new JPanel();
        //获取屏幕大小
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenwidth = screenSize.width;
        int screenheight = screenSize.height;

        MyFont fmyFont = new MyFont();
        //菜单
        JMenuBar fmenuBar = new JMenuBar();
        fmenuBar.setBackground(Color.black);
        FView.setJMenuBar(fmenuBar);

        JMenu fclass = new JMenu("成绩管理");
        fmyFont.MyFont(fclass, Color.white);
        fmenuBar.add(fclass);
        JMenuItem finput = new JMenuItem("录入成绩");
        fmyFont.jmenuitemfont(finput);
        fclass.add(finput);
        finput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddGradeView();
            }
        });
        JMenuItem fdelete = new JMenuItem(" 删除成绩");
        fmyFont.jmenuitemfont(fdelete);
        fclass.add(fdelete);
        fdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteGradeView();
            }
        });
        JMenuItem fchange = new JMenuItem("修改成绩");
        fmyFont.jmenuitemfont(fchange);
        fclass.add(fchange);
        fchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateGradeView();
            }
        });
        JMenuItem fjudge = new JMenuItem("查询成绩");
        fmyFont.jmenuitemfont(fjudge);
        fclass.add(fjudge);
        fjudge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectGradeView();
            }
        });
        JMenuItem fsousuo = new JMenuItem("搜索成绩");
        fmyFont.jmenuitemfont(fsousuo);
        fclass.add(fsousuo);
        fsousuo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SousuoGradeView();
            }
        });

        JMenu fstudent = new JMenu("班级管理");
        fmyFont.MyFont(fstudent, Color.white);
        fmenuBar.add(fstudent);
        JMenuItem fcheckwithsname = new JMenuItem("查询班级信息");
        fmyFont.jmenuitemfont(fcheckwithsname);
        fstudent.add(fcheckwithsname);
        fcheckwithsname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectClassView();
            }
        });
        JMenuItem fcheckwithsnum = new JMenuItem("修改班级信息");
        fmyFont.jmenuitemfont(fcheckwithsnum);
        fstudent.add(fcheckwithsnum);
        fcheckwithsnum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateClassView();
            }
        });

        JMenu fexitmenu = new JMenu("退出");
        fmyFont.MyFont(fexitmenu, Color.white);
        fmenuBar.add(fexitmenu);
        JMenuItem fexit = new JMenuItem("退出");
        fmyFont.jmenuitemfont(fexit);
        fexitmenu.add(fexit);
        //监听事件
        fexit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FView.dispose();
                new MView();
            }
        });

        //背景
        /*ImageIcon fimageIcon = new ImageIcon("F:\\UML\\image\\city.jpg");
        JLabel fimagelabel = new JLabel(new MView.ScaleIcon(fimageIcon));
        fimagelabel.setBounds(0,0,screenwidth,screenheight);
        FView.getLayeredPane().add(fimagelabel,new Integer(Integer.MIN_VALUE));
        JPanel f = (JPanel)FView.getContentPane();
        f.setOpaque(false);
        fpanel.add(fimagelabel,BorderLayout.CENTER);
        fpanel.setOpaque(false);*/

        fpanel.setLayout(null);
        FView.add(fpanel);
        FView.setTitle("辅导员");
        FView.setSize(screenwidth, screenheight);
        FView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FView.setVisible(true);
    }
//    public static void main(String[] args) {
//        new FView();
//    }
}
