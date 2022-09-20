package com.View;

import com.dao.ManageDao;
import com.model.Manage;
import com.util.MyFont;
import com.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *类名： CMBView.java
 *作者： 19241045王彪
 *描述： 找回密码界面
 *时间:  2021/12/16 4:14
 *版本:  1.8
 */
public class CMBView extends JFrame {
    private JFrame CMBView;
    private JPanel cmbpanel;
    private JButton cfindback;
    private JButton ccancel;
    private JLabel accountnum;
    private JLabel checkpassword;
    private JLabel newpasswordlabel;
    private JTextField accounttext;
    private JPasswordField checkpasswordlable;
    private JPasswordField newPasswordtext;

    public CMBView() {
        CMBView = new JFrame(" 忘记密码");
        cmbpanel = new JPanel();
        cfindback = new JButton("确认找回");
        ccancel = new JButton("取消");
        accountnum = new JLabel("账号：");
        checkpassword = new JLabel("确认密码：");
        newpasswordlabel = new JLabel("新密码：");
        accounttext = new JTextField();//账号框
        checkpasswordlable = new JPasswordField();//确认新密码
        newPasswordtext = new JPasswordField();//新密码

        //字体
        MyFont cmbmyFont = new MyFont();
        //添加组件
        cmbmyFont.jLabelfont(accountnum, Color.white, 16);//账号
        accountnum.setBounds(105, 180, 80, 40);
        cmbpanel.add(accountnum);

        accounttext.setFont(cmbmyFont.anything());//账号框
        accounttext.setForeground(Color.black);
        accounttext.setBounds(195, 180, 250, 25);
        cmbpanel.add(accounttext);

        cmbmyFont.jLabelfont(newpasswordlabel, Color.white, 16);//新密码
        newpasswordlabel.setBounds(105, 260, 80, 40);
        cmbpanel.add(newpasswordlabel);

        newPasswordtext.setFont(cmbmyFont.anything());//新密码框
        newPasswordtext.setForeground(Color.black);
        newPasswordtext.setBounds(195, 260, 250, 25);
        cmbpanel.add(newPasswordtext);

        cmbmyFont.jLabelfont(checkpassword, Color.white, 16);//确认密码
        checkpassword.setBounds(105, 340, 85, 40);
        cmbpanel.add(checkpassword);

        checkpasswordlable.setFont(cmbmyFont.anything());//确认密码框
        checkpasswordlable.setForeground(Color.black);
        checkpasswordlable.setBounds(195, 340, 250, 25);
        cmbpanel.add(checkpasswordlable);

        cmbmyFont.buttonfont(cfindback, Color.white, 16);//找回按钮
        cfindback.setBounds(105, 420, 340, 40);
        cfindback.setContentAreaFilled(false);
        cmbpanel.add(cfindback);

        cmbmyFont.buttonfont(ccancel, Color.white, 16);//取消按钮
        ccancel.setBounds(105, 500, 340, 40);
        ccancel.setContentAreaFilled(false);
        cmbpanel.add(ccancel);

        cmbpanel.setLayout(null);
        cmbpanel.setBackground(Color.black);
        CMBView.add(cmbpanel);
        CMBView.setSize(600, 800);
        CMBView.setVisible(true);
        CMBView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        /**
         * 按钮监听
         */
        cfindback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cfindback) {
                    cfindbackAct(e);
                }
            }

            private void cfindbackAct(ActionEvent e) {
                String account = accounttext.getText();
                String newpassword = new String(newPasswordtext.getPassword());
                String checkpassword = new String(checkpasswordlable.getPassword());
                if (StringUtil.isEmpty(account)){
                    JOptionPane.showMessageDialog(CMBView,"请输入账户！","警告",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (StringUtil.isEmpty(newpassword)){
                    JOptionPane.showMessageDialog(CMBView,"请输入新密码！","警告",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (StringUtil.isEmpty(checkpassword)){
                    JOptionPane.showMessageDialog(CMBView,"请输入确认密码！","警告",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!checkpassword.equals(newpassword)){
                    JOptionPane.showMessageDialog(CMBView,"两次密码输入不一致！","警告",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                /*System.out.println(account);
                System.out.println(newpassword);
                System.out.println(checkpassword);*/
                ManageDao manageDao = new ManageDao();
                Manage studenttmp = new Manage();
                studenttmp.setName(account);
                studenttmp.setPassword(newpassword);
                JOptionPane.showMessageDialog(CMBView, manageDao.CMBpassword(studenttmp,newpassword));
                if (manageDao.CMBpassword(studenttmp,newpassword).equals("密码修改成功！")){
                    CMBView.dispose();
                    new MView();
                }
                manageDao.closecon();
            }
        });

        ccancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CMBView.dispose();
                new MView();
            }
        });
    }

//    public static void main(String[] args) {
//        new CMBView();
//    }
}
