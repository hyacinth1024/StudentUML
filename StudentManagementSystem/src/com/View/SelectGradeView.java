package com.View;

import com.dao.GradeDao;
import com.util.MyFont;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.*;
import java.util.Vector;
/**
 *类名： SelectGradeView.java
 *作者： 19241045王彪
 *描述： 查询成绩
 *时间:  2021/12/16 0:40
 *版本:  1.8
 */
public class SelectGradeView extends JFrame {
    private JFrame SelectGradeView;
    private JPanel SelectGradepanel = (JPanel) getContentPane();
    private JButton Submit;//提交按钮
    private JButton Canel;
    private JLabel StudentName;//学生姓名
    private JLabel CourseName;//课程名称
    private JLabel CourseGrade;//分数
    private JTextField StudentNameField;//姓名框
    private JTextField CourseNameField;//课程框
    private JTextField CourseGradeField;//分数框
    private DefaultTableModel tablemodel = new DefaultTableModel();
    private JTable table = new JTable();
    private JScrollPane jScrollPane = new JScrollPane();
    private String[] columnNames = new String[]{"编号", "姓名", "班级", "课程名称", "分数"};
    private String[][] tableValues;
    private Vector<String> setvec = new Vector<String>();//创建集合类

//    public SelectCourseView(){
//        SelectCourseView = new JFrame("查询成绩");
//        SelectCoursepanel = new JPanel();
//        Submit = new JButton("确认");
//        Canel = new JButton("取消");
//        StudentName = new JLabel("学生姓名");
//        CourseName = new JLabel("课程名称：");
//        CourseGrade = new JLabel("分数：");
//        StudentNameField = new JTextField();
//        CourseNameField = new JTextField();
//        CourseGradeField = new JTextField();
//
//        MyFont myFont = new MyFont();
//        myFont.jLabelfont(StudentName, Color.white,18);
//        StudentName.setBounds(120,50,99,40);
//        SelectCoursepanel.add(StudentName);
//        StudentNameField.setFont(myFont.anything());
//        StudentNameField.setBounds(220,55,230,35);
//        SelectCoursepanel.add(StudentNameField);
//
//        myFont.jLabelfont(CourseName,Color.white,18);
//        CourseName.setBounds(120,130,99,40);
//        SelectCoursepanel.add(CourseName);
//        CourseNameField.setFont(myFont.anything());
//        CourseNameField.setBounds(220,135,230,35);
//        SelectCoursepanel.add(CourseNameField);
//
//        myFont.jLabelfont(CourseGrade,Color.white,18);
//        CourseGrade.setBounds(120,210,80,40);
//        SelectCoursepanel.add(CourseGrade);
//        CourseGradeField.setFont(myFont.anything());
//        CourseGradeField.setBounds(220,215,230,35);
//        SelectCoursepanel.add(CourseGradeField);
//
//        myFont.buttonfont(Submit,Color.white,18);
//        Submit.setBounds(120,290,330,40);
//        Submit.setContentAreaFilled(false);
//        SelectCoursepanel.add(Submit);
//
//        myFont.buttonfont(Canel,Color.white,18);
//        Canel.setBounds(120,370,330,40);
//        Canel.setContentAreaFilled(false);
//        SelectCoursepanel.add(Canel);
//
//        //获取屏幕大小
//        /*Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension screenSize = toolkit.getScreenSize();
//        int screenwidth = screenSize.width;
//        int screenheight = screenSize.height;
//        //获取窗口宽高
//        int windowwidth = AddClassView.getWidth();
//        int windowhight = AddClassView.getHeight();*/
//        SelectCoursepanel.setLayout(null);
//        SelectCoursepanel.setBackground(Color.black);
//        SelectCourseView.add(SelectCoursepanel);
//        SelectCourseView.setSize(600,600);
////        AddClassView.setLocation((screenwidth-windowwidth)/2,(screenheight-windowhight)/2);
//        SelectCourseView.setLocationRelativeTo(null);//窗口相对于屏幕居中
//        SelectCourseView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        SelectCourseView.setVisible(true);
//
//        Submit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SubmitAct(e);
//            }
//        });
//
//        Canel.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CanelAct(e);
//            }
//        });
//    }

    /*private JTable jt = null;
    private JScrollPane jsp = null;
    private JButton jb = null;*/

    //    JPanel panel=(JPanel)getContentPane();
    public SelectGradeView() {
        super("查询成绩");
        tablepaint();
        Init();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1920, 1005);
        this.setLocation(0,80);
        this.setVisible(true);
    }

    //        Grade grade = new Grade();
//        GradeDao gradeDao = new GradeDao();
//        gradeDao.selectCourse(grade);
//        jt = new JTable(gradeDao.rowData,gradeDao.columnName);
//        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        jsp = new JScrollPane(jt);
//
//        this.add(jsp);
//        this.setSize(1920,1005);
//        this.setLocation(0,75);
//        this.setResizable(true);
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        this.setVisible(true);

    public void tablepaint() {
        Object[][] tableValues = {}; // 设定表格的字段
        Vector<String> vec = null;
        tablemodel = new DefaultTableModel(tableValues, columnNames) {
            public boolean isCellEditable(int row, int column) {
                // 表格不可编辑
                return false;
            }
        };
        GradeDao gradeDao = new GradeDao();
        String sql = "SELECT * FROM grade";
        try {
            PreparedStatement prst = gradeDao.con.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            while (rs.next()){
                vec = new Vector<String>();
                vec.add(rs.getString("id").trim());
                vec.add(rs.getString("name"));
                vec.add(rs.getString("class"));
                vec.add(rs.getString("course").trim());
                vec.add(String.valueOf(rs.getInt("grade")));
                tablemodel.addRow(vec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        gradeDao.closecon();
    }

    public void Init() {
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
//    private void CanelAct(ActionEvent e) {
//        SelectCourseView.dispose();
//    }

//    private void SubmitAct(ActionEvent e) {
//        String StudentName = StudentNameField.getText();
//        String CourseName = CourseNameField.getText();
//        int CourseGrade = Integer.parseInt(CourseGradeField.getText());
//
//        if (StringUtil.isEmpty(CourseNameField.getText()) && StringUtil.isEmpty(CourseGradeField.getText()) && StringUtil.isEmpty(StudentNameField.getText())) {
//            JOptionPane.showMessageDialog(SelectCourseView, "学生姓名或课程名或分数不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        Grade grade = new Grade();
//        grade.setName(StudentName);
//        grade.setCourse(CourseName);
//        grade.setGrade(CourseGrade);
//        GradeDao gradeDao = new GradeDao();
//        if (gradeDao.selectCourse(grade)) {
//            JOptionPane.showMessageDialog(SelectCourseView, "成绩查询成功！", "提示", JOptionPane.WARNING_MESSAGE);
//            return;
//        } else {
//            JOptionPane.showMessageDialog(SelectCourseView, "成绩查询失败！", "提示", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//    }

//    public static void main(String[] args) {
//        new SelectCourseView();
//    }
//public static void main(String[] args) {
//    new SelectGradeView();
//}
}


