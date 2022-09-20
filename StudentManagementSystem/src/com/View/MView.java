package com.View;

import com.dao.ManageDao;
import com.model.Manage;
import com.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
/**
 *类名： MView.java
 *作者： 19241045王彪
 *描述： 登录界面
 *时间:  2021/12/16 0:12
 *版本:  1.8
 */
public class MView extends JFrame {
    private JFrame jframe = new JFrame("学生成绩管理系统");
    private JPanel panel1 = new JPanel();
    private JButton login = new JButton("登录");
    private JButton findback = new JButton("忘记密码");
    //    private JButton register = new JButton("注册");
    private JLabel labell = new JLabel("账号：");
    //        JLabel label2 = new JLabel("身份：");
    private JLabel label2 = new JLabel("密码：");
    private JTextField name = new JTextField(16);//账号框
    private JPasswordField passwordField = new JPasswordField(16);//密码框
    private ButtonGroup group = new ButtonGroup();
    private JRadioButton jrbstudent;
    private JRadioButton jrbteacher;
    private JRadioButton jrbbzr;
    private JRadioButton jrbfdy;
    private JRadioButton jrbmanager;

    public MView() {

        //创建下拉框
        /*JComboBox<String> cmd = new JComboBox<>();
        cmd.addItem("学生");
        cmd.addItem("教师");
        cmd.addItem("班主任");
        cmd.addItem("辅导员");
        cmd.addItem("系统管理员");
        jl.setBounds(100, 30, 60, 30);
        panel1.add(jl);
        name.setBounds(170, 30, 140, 30);
        panel1.add(name);
        j2.setBounds(100, 160, 200, 50);
        panel1.add(j2);
        cmd.setBounds(170,80,140,30);
        panel1.add(cmd);
        j3.setBounds(100, 220, 60, 30);
        panel1.add(j3);
        passwordField.setBounds(170, 220, 140, 30);
        panel1.add(passwordField);
        login.setBounds(100, 250, 70, 30);
        panel1.add(login);
        reset.setBounds(180, 250, 70, 30);
        panel1.add(reset);
        panel1.setBackground(Color.gray);*/

        //设置窗口大小
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenwidth = screenSize.width;
        int screenheight = screenSize.height;

        //字体
        Font fontlabel = new Font("微软雅黑", Font.BOLD | Font.ITALIC, 20);
        Font fonttext = new Font("SanSerif", Font.PLAIN, 16);
        Font fontjr = new Font("微软雅黑", Font.ITALIC, 18);
//        Font fontbutton = new Font("宋体",Font.BOLD,16);

        //创建单选按钮

        jrbstudent = new JRadioButton("学生", true);
        jrbstudent.setFont(fontjr);
        jrbstudent.setForeground(Color.white);

        jrbteacher = new JRadioButton("教师", false);
        jrbteacher.setFont(fontjr);
        jrbteacher.setForeground(Color.white);

        jrbbzr = new JRadioButton("班主任", false);
        jrbbzr.setFont(fontjr);
        jrbbzr.setForeground(Color.white);

        jrbfdy = new JRadioButton("辅导员", false);
        jrbfdy.setFont(fontjr);
        jrbfdy.setForeground(Color.white);

        jrbmanager = new JRadioButton("系统管理员", false);
        jrbmanager.setForeground(Color.white);
        jrbmanager.setFont(fontjr);

        group.add(jrbstudent);
        group.add(jrbteacher);
        group.add(jrbbzr);
        group.add(jrbfdy);
        group.add(jrbmanager);

        //添加账号label
//        labell.setSize(80,40);
        labell.setBounds(320, 90, 80, 40);
        labell.setForeground(Color.white);//文本颜色
        labell.setFont(fontlabel);
        panel1.add(labell);
        //添加账号框
        name.setBounds(400, 95, 255, 25);
        name.setFont(new Font("SanSerif", Font.PLAIN, 16));
        panel1.add(name);
        //添加密码label
        label2.setBounds(320, 150, 80, 40);
        label2.setForeground(Color.white);
        label2.setFont(fontlabel);
        panel1.add(label2);
        //添加密码框
        passwordField.setBounds(400, 155, 255, 25);
        panel1.add(passwordField);
        //添加单选按钮
        jrbstudent.setContentAreaFilled(false);
        jrbstudent.setBounds(320, 210, 75, 25);
        panel1.add(jrbstudent);
        jrbteacher.setContentAreaFilled(false);
        jrbteacher.setBounds(431, 210, 75, 25);
        panel1.add(jrbteacher);
        jrbbzr.setContentAreaFilled(false);
        jrbbzr.setBounds(542, 210, 100, 25);
        panel1.add(jrbbzr);
        jrbfdy.setContentAreaFilled(false);
        jrbfdy.setBounds(320, 240, 100, 25);
        panel1.add(jrbfdy);
        jrbmanager.setContentAreaFilled(false);
        jrbmanager.setBounds(542, 240, 130, 25);
        panel1.add(jrbmanager);
        //添加按钮
        login.setFont(new Font("微软雅黑", Font.BOLD, 16));
        login.setForeground(Color.white);
        login.setContentAreaFilled(false);//设置按钮透明,不遮挡背景
//        login.setBounds(320,265,100,40);
        login.setBounds(320, 270, 335, 40);
        panel1.add(login);

        findback.setFont(new Font("微软雅黑", Font.BOLD, 16));
        findback.setForeground(Color.white);
        findback.setContentAreaFilled(false);
        findback.setBounds(320, 315, 335, 40);
        panel1.add(findback);

//        register.setFont(new Font("SanSerif",Font.BOLD,14));
//        register.setForeground(Color.white);
//        register.setContentAreaFilled(false);
//        register.setBounds(320,315,100,40);
//        panel1.add(register);

        //设置背景图
//        ImageIcon imageIcon = new ImageIcon("F:\\PHP\\个人网站\\01\\images0101\\the_lonely_parade_by_wlop-d9bvu6u.jpg");
        /*
        ScaleIcon imageIcon=new ScaleIcon(new ImageIcon("F:\\UML\\image\\lighthouse.jpg"));
        JLabel labelimage = new JLabel(imageIcon);
        //设置lable大小
        labelimage.setBounds(0,0,screenwidth/2,screenheight/2);
        //获取窗口的第二层，将label放入
        jframe.getLayeredPane().add(labelimage,new Integer(Integer.MIN_VALUE));
        //获取frame的顶层容器,并设置为透明
        JPanel j=(JPanel)jframe.getContentPane();
        j.setOpaque(false);
        panel1.add(labelimage,BorderLayout.CENTER);
        //panel透明
        panel1.setOpaque(true);
        */
        panel1.setLayout(null);
        panel1.setBackground(Color.black);
        jframe.add(panel1);
        jframe.setSize(screenwidth / 2, screenheight / 2);
        //不可调节大小
        jframe.setResizable(false);
        //关闭
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setVisible(true);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAct(e);
            }
        });

        findback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CMBView();
                jframe.dispose();
            }
        });
    }

    private void loginAct(ActionEvent e) {
        String sName = name.getText();
        String spassword = new String(passwordField.getPassword());
        if (StringUtil.isEmpty(sName)) {
            JOptionPane.showMessageDialog(panel1, "用户名不能为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (StringUtil.isEmpty(spassword)) {
            JOptionPane.showMessageDialog(panel1, "密码不能为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (jrbmanager.isSelected()) {
            //系统管理员登录
            /*System.out.println(sName);
            System.out.println(spassword);*/
            ManageDao manageDao = new ManageDao();
            Manage manageTmp = new Manage();
            manageTmp.setName(sName);
            manageTmp.setPassword(spassword);
            Manage manage = manageDao.login(manageTmp);
            manageDao.closecon();
            if (manage == null) {
                JOptionPane.showMessageDialog(panel1, "用户名或密码错误!", "警告", JOptionPane.ERROR_MESSAGE);
                return;
            }
            new GView();
            jframe.dispose();
        }
        else if (jrbbzr.isSelected()){
            //班主任登录
            ManageDao manageDao = new ManageDao();
            Manage manageTmp = new Manage();
            manageTmp.setName(sName);
            manageTmp.setPassword(spassword);
            Manage manage = manageDao.bzrlogin(manageTmp);
            manageDao.closecon();
            if (manage == null) {
                JOptionPane.showMessageDialog(panel1, "用户名或密码错误!", "警告", JOptionPane.ERROR_MESSAGE);
                return;
            }
            new BView();
            jframe.dispose();
        }
        else if (jrbfdy.isSelected()){
            //辅导员登录
            ManageDao manageDao = new ManageDao();
            Manage manageTmp = new Manage();
            manageTmp.setName(sName);
            manageTmp.setPassword(spassword);
            Manage manage = manageDao.fdylogin(manageTmp);
            manageDao.closecon();
            if (manage == null) {
                JOptionPane.showMessageDialog(panel1, "用户名或密码错误!", "警告", JOptionPane.ERROR_MESSAGE);
                return;
            }
            new FView();
            jframe.dispose();
        }
        else if (jrbteacher.isSelected()){
            //教师登录
            ManageDao manageDao = new ManageDao();
            Manage manageTmp = new Manage();
            manageTmp.setName(sName);
            manageTmp.setPassword(spassword);
            Manage manage = manageDao.teacherlogin(manageTmp);
            manageDao.closecon();
            if (manage == null) {
                JOptionPane.showMessageDialog(panel1, "用户名或密码错误!", "警告", JOptionPane.ERROR_MESSAGE);
                return;
            }
            new TView();
            jframe.dispose();
        }
        else if (jrbstudent.isSelected()){
            //学生登录
            ManageDao manageDao = new ManageDao();
            Manage manageTmp = new Manage();
            manageTmp.setName(sName);
            manageTmp.setPassword(spassword);
            Manage manage = manageDao.studentlogin(manageTmp);
            manageDao.closecon();
            if (manage == null) {
                JOptionPane.showMessageDialog(panel1, "用户名或密码错误!", "警告", JOptionPane.ERROR_MESSAGE);
                return;
            }
            new SView();
            jframe.dispose();
        }
    }

    /*添加图片*/
    public static class ScaleIcon implements Icon {

        private BufferedImage i = null;
        private Icon icon = null;

        public ScaleIcon(Icon icon) {
            this.icon = icon;
        }

        @Override
        public int getIconHeight() {
            return icon.getIconHeight();
        }

        @Override
        public int getIconWidth() {
            return icon.getIconWidth();
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            float wid = c.getWidth();
            float hei = c.getHeight();
            int iconWid = icon.getIconWidth();
            int iconHei = icon.getIconHeight();

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.scale(wid / iconWid, hei / iconHei);
            icon.paintIcon(c, g2d, 0, 0);
        }
    }
}
