package com.util;

import javax.swing.*;
import java.awt.*;
/**
 *类名： MyFont.java
 *作者： 19241045王彪
 *描述： 字体类
 *时间:  2021/12/16 1:16
 *版本:  1.8
 */
public class MyFont extends JFrame{
    private int size;
    private Font font;
    private JMenu x;
    private JButton j;
    private JLabel l;
    private JMenuItem jmi;

    //按钮字体
    public JButton buttonfont(JButton cjButton,Color mycolor,int mysize){
        font = new Font("微软雅黑",Font.BOLD|Font.ITALIC,mysize);
        j=cjButton;
        j.setFont(font);
        j.setForeground(mycolor);
        return j;
    }

    //标签字体
    public  JLabel jLabelfont(JLabel cjLabel,Color mycolor,int mysize){
        font = new Font("微软雅黑",Font.BOLD|Font.ITALIC,mysize);
        l=cjLabel;
        l.setFont(font);
        l.setForeground(mycolor);
        return l;
    }
    //菜单字体颜色
    public JMenu MyFont(JMenu a, Color color){
        size = 30;
        font = new Font("微软雅黑",Font.BOLD|Font.ITALIC,size);
        x = a;
        a.setFont(font);
        a.setForeground(color);
        return x;
    }

    //菜单项字体
    public JMenuItem jmenuitemfont(JMenuItem ji){
        size = 25;
        jmi = ji;
        Font font1 = new Font("微软雅黑",Font.PLAIN,size);
        jmi.setFont(font1);
        return jmi;
    }
    //字体
    public Font anything(){
        font = new Font("SanSerif",Font.PLAIN,16);
        return font;
    }
}

