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
 *类名： UpdateAccountView.java
 *作者： 19241045王彪
 *描述： 修改账号
 *时间:  2021/12/16 4:23
 *版本:  1.8
 */
public class UpdateAccountView extends JFrame {
    private JFrame UpdateAccountView;
    private JPanel UpdateAccountpanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel AccountName;//账号
    private JLabel Identity;//身份
    private JLabel Password;
    private JTextField AccountNameField;//账号框
    private JTextField IdentityField;//身份框
    private JTextField PasswordField;

    public UpdateAccountView(){
        UpdateAccountView = new JFrame("修改账号");
        UpdateAccountpanel = new JPanel();
        Submit = new JButton("确定");
        Canel = new JButton("取消");
        AccountName = new JLabel("账号：");
        AccountNameField = new JTextField();
        Password=new JLabel("密码：");
        PasswordField=new JTextField();
        Identity = new JLabel("身份：");
        IdentityField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(Password, Color.white,18);
        Password.setBounds(120,130,99,40);
        UpdateAccountpanel.add(Password);
        PasswordField.setFont(myFont.anything());
        PasswordField.setBounds(220,135,230,35);
        UpdateAccountpanel.add(PasswordField);

        myFont.jLabelfont(AccountName, Color.white,18);
        AccountName.setBounds(120,50,99,40);
        UpdateAccountpanel.add(AccountName);
        AccountNameField.setFont(myFont.anything());
        AccountNameField.setBounds(220,55,230,35);
        UpdateAccountpanel.add(AccountNameField);

        myFont.jLabelfont(Identity,Color.white,18);
        Identity.setBounds(120,210,99,40);
        UpdateAccountpanel.add(Identity);
        IdentityField.setFont(myFont.anything());
        IdentityField.setBounds(220,215,230,35);
        UpdateAccountpanel.add(IdentityField);

        myFont.buttonfont(Submit,Color.white,18);
        Submit.setBounds(120,290,330,40);
        Submit.setContentAreaFilled(false);
        UpdateAccountpanel.add(Submit);

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitAct(e);
            }
        });

        myFont.buttonfont(Canel,Color.white,18);
        Canel.setBounds(120,370,330,40);
        Canel.setContentAreaFilled(false);
        UpdateAccountpanel.add(Canel);

        Canel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateAccountView.dispose();
            }
        });

        UpdateAccountpanel.setLayout(null);
        UpdateAccountpanel.setBackground(Color.black);
        UpdateAccountView.add(UpdateAccountpanel);
        UpdateAccountView.setSize(600,600);
        UpdateAccountView.setLocationRelativeTo(null);//窗口相对于屏幕居中
        UpdateAccountView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UpdateAccountView.setVisible(true);
    }

    public void SubmitAct(ActionEvent event){
        String AccountName = AccountNameField.getText();
        String Password = PasswordField.getText();
        String Identity = IdentityField.getText();

        if (StringUtil.isEmpty(AccountNameField.getText())||StringUtil.isEmpty(IdentityField.getText())||StringUtil.isEmpty(PasswordField.getText())){
            JOptionPane.showMessageDialog(UpdateAccountView,"账号密码或身份不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Manage manage = new Manage();
        manage.setName(AccountName);
        manage.setPassword(Password);
        manage.setIdentity(Identity);
        ManageDao manageDao = new ManageDao();
        if (manageDao.UpdateAccount(manage)){
            JOptionPane.showMessageDialog(UpdateAccountView,"账号修改成功！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else {
            JOptionPane.showMessageDialog(UpdateAccountView,"账号修改失败！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
}
