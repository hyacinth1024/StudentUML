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
 *类名： DeleteAccountView.java
 *作者： 19241045王彪
 *描述： 删除账号
 *时间:  2021/12/16 4:18
 *版本:  1.8
 */
public class DeleteAccountView extends JFrame {
    private JFrame DeleteAccountView;
    private JPanel DeleteAccountpanel;
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel AccountName;//账号
    private JLabel Identity;//身份
    private JTextField AccountNameField;//账号框
    private JTextField IdentityField;//身份框

    public DeleteAccountView() {
        DeleteAccountView = new JFrame("删除账号");
        DeleteAccountpanel = new JPanel();
        Submit = new JButton("确定");
        Canel = new JButton("取消");
        AccountName = new JLabel("账号：");
        AccountNameField = new JTextField();
        Identity = new JLabel("身份：");
        IdentityField = new JTextField();

        MyFont myFont = new MyFont();
        myFont.jLabelfont(AccountName, Color.white, 18);
        AccountName.setBounds(120, 130, 99, 40);
        DeleteAccountpanel.add(AccountName);
        AccountNameField.setFont(myFont.anything());
        AccountNameField.setBounds(220, 135, 230, 35);
        DeleteAccountpanel.add(AccountNameField);

        myFont.jLabelfont(Identity, Color.white, 18);
        Identity.setBounds(120, 210, 99, 40);
        DeleteAccountpanel.add(Identity);
        IdentityField.setFont(myFont.anything());
        IdentityField.setBounds(220, 215, 230, 35);
        DeleteAccountpanel.add(IdentityField);

        myFont.buttonfont(Submit, Color.white, 18);
        Submit.setBounds(120, 290, 330, 40);
        Submit.setContentAreaFilled(false);
        DeleteAccountpanel.add(Submit);

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitAct(e);
            }
        });

        myFont.buttonfont(Canel, Color.white, 18);
        Canel.setBounds(120, 370, 330, 40);
        Canel.setContentAreaFilled(false);
        DeleteAccountpanel.add(Canel);

        Canel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteAccountView.dispose();
            }
        });

        DeleteAccountpanel.setLayout(null);
        DeleteAccountpanel.setBackground(Color.black);
        DeleteAccountView.add(DeleteAccountpanel);
        DeleteAccountView.setSize(600, 600);
        DeleteAccountView.setLocationRelativeTo(null);//窗口相对于屏幕居中
        DeleteAccountView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DeleteAccountView.setVisible(true);
    }

    public void SubmitAct(ActionEvent event) {
        String AccountName = AccountNameField.getText();
        String Identity = IdentityField.getText();

        if (StringUtil.isEmpty(AccountNameField.getText()) || StringUtil.isEmpty(IdentityField.getText())) {
            JOptionPane.showMessageDialog(DeleteAccountView, "账号或身份不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Manage manage = new Manage();
        manage.setName(AccountName);
        manage.setIdentity(Identity);
        ManageDao manageDao = new ManageDao();
        if (manageDao.deleteAccount(manage)) {
            JOptionPane.showMessageDialog(DeleteAccountView, "账号删除成功！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(DeleteAccountView, "账号删除失败！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
}
