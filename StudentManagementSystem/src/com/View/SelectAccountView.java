package com.View;

import com.dao.GradeDao;
import com.dao.ManageDao;
import com.util.MyFont;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *类名： SelectAccountView.java
 *作者： 19241045王彪
 *描述： 查询账号
 *时间:  2021/12/16 4:19
 *版本:  1.8
 */
public class SelectAccountView extends JFrame {
    private JPanel SelectGradepanel = (JPanel) getContentPane();
    private DefaultTableModel tablemodel = new DefaultTableModel();
    private JTable table = new JTable();
    private JScrollPane jScrollPane = new JScrollPane();
    private String[] columnNames = new String[]{"编号", "账号名", "密码", "身份"};
    private String[][] tableValues;
    private Vector<String> setvec = new Vector<String>();//创建集合类

    public SelectAccountView(){
        super("查询账号");
        tablepaint();
        Init();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1920, 1005);
        this.setLocation(0,80);
        this.setVisible(true);
    }

    public void tablepaint(){
        Object[][] tableValues = {}; // 设定表格的字段
        Vector<String> vec = null;
        tablemodel = new DefaultTableModel(tableValues, columnNames) {
            public boolean isCellEditable(int row, int column) {
                // 表格不可编辑
                return false;
            }
        };
        ManageDao manageDao = new ManageDao();
        String sql = "SELECT * FROM user";
        try {
            PreparedStatement prst = manageDao.con.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            while (rs.next()){
                vec = new Vector<String>();
                vec.add(rs.getString("id").trim());
                vec.add(rs.getString("name"));
                vec.add(rs.getString("password"));
                vec.add(rs.getString("identity").trim());
                tablemodel.addRow(vec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        manageDao.closecon();
    }

    public void Init(){
        MyFont myFont = new MyFont();
        table = new JTable(tablemodel);
        jScrollPane.setBounds(10, 10, 1920, 1005);//设置可以上下拉的拉框
        SelectGradepanel.add(jScrollPane);
        SelectGradepanel.add(table);
        jScrollPane.getViewport().add(table, null);//把table放在唯一的jScrollpane上
        //table设置
        table.setRowSorter(new TableRowSorter<>(tablemodel));//排序器
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置单选
        table.setRowHeight(40);//行高
        table.setGridColor(Color.black);
        table.setFont(myFont.anything());
        table.setDragEnabled(true);
        table.setSelectionForeground(Color.blue);//选中之后的字体颜色
        table.setSelectionBackground(Color.gray);//选中之后的周围颜色
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowSelectionAllowed(true);
        table.setShowVerticalLines(true);
        table.getTableHeader().setReorderingAllowed(false);//表格列头不可移动
    }
}
