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
 *类名： AddAccountView.java
 *作者： 19241045王彪
 *描述： 添加账号
 *时间:  2021/12/16 4:16
 *版本:  1.8
 */
public class AddAccountView extends JFrame{
    private JFrame AddAccountView;
    private JPanel AddAccountpanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel AccountName;//账号
    private JLabel Password;//密码
    private JLabel Identity;//身份
    private JTextField AccountNameField;//账号框
    private JTextField IdentityField;//身份框
    private JTextField PasswordField;//密码框


    public AddAccountView(){
        AddAccountView = new JFrame("添加账号");
        AddAccountpanel = new JPanel();
        Submit = new JButton("确认");
        Canel = new JButton("取消");
        AccountName = new JLabel("账号: ");
        Password = new JLabel("密码：");
        Identity = new JLabel("身份：");
        AccountNameField = new JTextField();
        PasswordField = new JTextField();
        IdentityField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(AccountName,Color.white,18);
        AccountName.setBounds(120,50,99,40);
        AddAccountpanel.add(AccountName);
        AccountNameField.setFont(myFont.anything());
        AccountNameField.setBounds(220,55,230,35);
        AddAccountpanel.add(AccountNameField);

        myFont.jLabelfont(Password,Color.white,18);
        Password.setBounds(120,130,99,40);
        AddAccountpanel.add(Password);
        PasswordField.setFont(myFont.anything());
        PasswordField.setBounds(220,135,230,35);
        AddAccountpanel.add(PasswordField);

        myFont.jLabelfont(Identity,Color.white,18);
        Identity.setBounds(120,210,99,40);
        AddAccountpanel.add(Identity);
        IdentityField.setFont(myFont.anything());
        IdentityField.setBounds(220,215,230,35);
        AddAccountpanel.add(IdentityField);

        myFont.buttonfont(Submit,Color.white,18);
        Submit.setBounds(120,370,330,40);
        Submit.setContentAreaFilled(false);
        AddAccountpanel.add(Submit);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitAct(e);
            }
        });

        myFont.buttonfont(Canel,Color.white,18);
        Canel.setBounds(120,450,330,40);
        Canel.setContentAreaFilled(false);
        AddAccountpanel.add(Canel);
        Canel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CanelAct(e);
            }
        });
        AddAccountpanel.setLayout(null);
        AddAccountpanel.setBackground(Color.black);
        AddAccountView.add(AddAccountpanel);
        AddAccountView.setSize(600,600);
        AddAccountView.setLocationRelativeTo(null);//窗口相对于屏幕居中
        AddAccountView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddAccountView.setVisible(true);
    }

    public void CanelAct(ActionEvent event){
        AddAccountView.dispose();
    }

    public void SubmitAct(ActionEvent e){
        String AccountName = AccountNameField.getText();
        String Password = PasswordField.getText();
        String Identity = IdentityField.getText();

        if (StringUtil.isEmpty(AccountNameField.getText())||StringUtil.isEmpty(PasswordField.getText())||StringUtil.isEmpty(IdentityField.getText())){
            JOptionPane.showMessageDialog(AddAccountView,"不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Manage manage = new Manage();
        manage.setName(AccountName);
        manage.setPassword(Password);
        manage.setIdentity(Identity);
        ManageDao manageDao = new ManageDao();

        if (manageDao.AddAccount(manage)){
            JOptionPane.showMessageDialog(AddAccountView,"账号添加成功！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else {
            JOptionPane.showMessageDialog(AddAccountView,"账号添加失败！","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
    }

//    public static void main(String[] args) {
//        new AddAccountView();
//    }
}
