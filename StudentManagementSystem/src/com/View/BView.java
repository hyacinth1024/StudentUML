package com.View;

import com.util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *类名： BView.java
 *作者： 19241045王彪
 *描述： 班主任界面
 *时间:  2021/12/16 4:18
 *版本:  1.8
 */
public class BView extends JFrame {
    private JFrame BView;
    private JPanel bpanel;

    public BView(){
        BView = new JFrame();
        bpanel = new JPanel();
        //获取屏幕大小
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenwidth = screenSize.width;
        int screenheight = screenSize.height;

        MyFont bmyFont = new MyFont();
        //菜单
        JMenuBar bmenuBar = new JMenuBar();
        bmenuBar.setBackground(Color.black);
        BView.setJMenuBar(bmenuBar);

        JMenu bclass = new JMenu("成绩管理");
        bmyFont.MyFont(bclass,Color.white);
        bmenuBar.add(bclass);
        JMenuItem binput = new JMenuItem("录入成绩");
        bmyFont.jmenuitemfont(binput);
        bclass.add(binput);
        binput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddGradeView();
            }
        });
        JMenuItem bdelete = new JMenuItem("删除成绩");
        bmyFont.jmenuitemfont(bdelete);
        bclass.add(bdelete);
        bdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteGradeView();
            }
        });
        JMenuItem bchange = new JMenuItem("修改成绩");
        bmyFont.jmenuitemfont(bchange);
        bclass.add(bchange);
        bchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateGradeView();
            }
        });
        JMenuItem bjudge = new JMenuItem("查询成绩");
        bmyFont.jmenuitemfont(bjudge);
        bclass.add(bjudge);
        bjudge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectGradeView();
            }
        });
        JMenuItem bsousuo = new JMenuItem("搜索成绩");
        bmyFont.jmenuitemfont(bsousuo);
        bclass.add(bsousuo);
        bsousuo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SousuoGradeView();
            }
        });

        /*JMenu bpeople = new JMenu("个人信息");
        bmyFont.MyFont(bpeople,Color.white);
        bmenuBar.add(bpeople);
        JMenuItem bchangepeople = new JMenuItem("修改个人信息");
        bmyFont.jmenuitemfont(bchangepeople);
        bpeople.add(bchangepeople);*/

        JMenu bstudent = new JMenu("查看课程信息");
        bmyFont.MyFont(bstudent,Color.white);
        bmenuBar.add(bstudent);
        JMenuItem bcheckwithsname = new JMenuItem("查询课程");
        bmyFont.jmenuitemfont(bcheckwithsname);
        bstudent.add(bcheckwithsname);
        bcheckwithsname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectCourseView();
            }
        });
        /*JMenuItem bcheckwithsnum = new JMenuItem("按学号查询");
        bmyFont.jmenuitemfont(bcheckwithsnum);
        bstudent.add(bcheckwithsnum);*/

        JMenu bexitmenu = new JMenu("退出");
        bmyFont.MyFont(bexitmenu,Color.white);
        bmenuBar.add(bexitmenu);
        JMenuItem bexit = new JMenuItem("退出");
        bmyFont.jmenuitemfont(bexit);
        bexitmenu.add(bexit);
        //监听事件
        bexit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BView.dispose();
                new MView();
            }
        });

        //背景
       /* ImageIcon bimageIcon = new ImageIcon("F:\\UML\\image\\car.png");
        JLabel bimagelabel = new JLabel(new MView.ScaleIcon(bimageIcon));
        bimagelabel.setBounds(0,0,screenwidth,screenheight);
        BView.getLayeredPane().add(bimagelabel,new Integer(Integer.MIN_VALUE));
        JPanel b =(JPanel)BView.getContentPane();
        b.setOpaque(false);
        bpanel.add(bimagelabel,BorderLayout.CENTER);
        bpanel.setOpaque(false);*/

        bpanel.setLayout(null);
        BView.add(bpanel);
        BView.setTitle("班主任");
        BView.setSize(screenwidth,screenheight);
        BView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BView.setVisible(true);
    }

//    public static void main(String[] args) {
//        BView a = new BView();
//    }
}
