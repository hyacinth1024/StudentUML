package com.View;

import com.util.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZCView extends JFrame {
    private JFrame ZCView;
    private JPanel zcpanel;
    private JButton zregister;//注册按钮
    private JLabel zaccountnum;//账号
    private JLabel zphonelabel;//手机号
    private JLabel passwordlabel;//密码
    private JLabel secondpass;//确认密码
    private JTextField zaccounttext;//账号框
    private JTextField zphonetext;//电话框
    private JPasswordField passwordtext;//密码框
    private JPasswordField secondpasstext;//确认密码框

    public ZCView(){
        ZCView = new JFrame("注册");
        zcpanel = new JPanel();
        zregister = new JButton("注册");
        zaccountnum = new JLabel("账号：");
        zphonelabel = new JLabel("手机号：");
        passwordlabel = new JLabel("设置密码：");
        secondpass = new JLabel("确认密码：");
        zaccounttext = new JTextField();
        zphonetext = new JTextField();
        passwordtext = new JPasswordField();
        secondpasstext = new JPasswordField();

        MyFont zmyFont = new MyFont();
        //添加组件
        zmyFont.jLabelfont(zaccountnum,Color.white,16);//账号和账号框
        zaccountnum.setBounds(120,160,80,40);
        zcpanel.add(zaccountnum);
        zaccounttext.setFont(zmyFont.anything());
        zaccounttext.setBounds(200,160,250,25);
        zcpanel.add(zaccounttext);

        //电话和电话框
        zmyFont.jLabelfont(zphonelabel,Color.white,16);
        zphonelabel.setBounds(120,240,80,40);
        zcpanel.add(zphonelabel);
        zphonetext.setFont(zmyFont.anything());
        zphonetext.setBounds(200,240,250,25);
        zcpanel.add(zphonetext);

        //密码和密码框
        zmyFont.jLabelfont(passwordlabel,Color.white,15);
        passwordlabel.setBounds(120,320,80,40);
        zcpanel.add(passwordlabel);
        passwordtext.setFont(zmyFont.anything());
        passwordtext.setBounds(200,320,250,25);
        zcpanel.add(passwordtext);

        //确认密码和确认密码框
        zmyFont.jLabelfont(secondpass,Color.white,15);
        secondpass.setBounds(120,400,80,40);
        zcpanel.add(secondpass);
        secondpasstext.setFont(zmyFont.anything());
        secondpasstext.setBounds(200,400,250,25);
        zcpanel.add(secondpasstext);

        //注册按钮
        zmyFont.buttonfont(zregister,Color.white,16);
        zregister.setBounds(120,480,330,40);
        zregister.setContentAreaFilled(false);
        zcpanel.add(zregister);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenwidth = screenSize.width;
        int screenheight = screenSize.height;
        zcpanel.setLayout(null);
        zcpanel.setBackground(Color.black);
        ZCView.add(zcpanel);
        ZCView.setSize(600,800);
        ZCView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ZCView.setVisible(true);

        //监听事件
        zregister.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZCView.dispose();
            }
        });
        /*ActionListener zregisterAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZCView.dispose();
            }
        };
        zregister.addActionListener(zregisterAction);*/
    }

//    public static void main(String[] args) {
//        new ZCView();
//    }
}
