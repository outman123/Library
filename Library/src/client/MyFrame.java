package client;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/12/14.
 */
public class MyFrame extends JFrame implements ActionListener,ListSelectionListener {

    private database.AddBook add;
    private String id;
    private JTextArea userinfor;
    private JPanel background;
    private JTable table;
    private JMenuBar mb1=new JMenuBar();private JMenu m1=new JMenu("用户信息");
    private JMenuBar mb2=new JMenuBar();private JMenu m2=new JMenu("借阅信息");
    private int row;
    private DefaultTableModel model;
    JButton btnAdd = new JButton("添加");
    JButton btnDel = new JButton("删除");
    JButton btnModify = new JButton("更新");
    JButton btnQuery = new JButton("查找");

    public MyFrame(String str) {
        id=str;
        setResizable(false);
        setBounds(new Rectangle(450, 250, 610, 420));
        setTitle(str+"图书借阅");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        int offsetX = -20;

        background=new JPanel() {
            private static final long serialVersionUID = 1L;
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(new ImageIcon("./img/1.png").getImage(), 0, 0,
                    getWidth(), getHeight(), null);
        }

        };
        setContentPane(background);
        background.setLayout(null);

//        userinfor = new JTextArea();
//        JScrollPane scrollSource1 = new JScrollPane(userinfor);
//        scrollSource1.setSize(570, 90);
//        scrollSource1.setLocation(10, 10);
//        getContentPane().add(scrollSource1);
//        scrollSource1.setBorder(new TitledBorder("用户信息"));
//        scrollSource1.setOpaque(false);
//        scrollSource1.getViewport().setOpaque(false);
//        userinfor.setOpaque(false);
        mb1.add(m1);
        mb1.setBounds(10,10,610,20);
        mb1.setOpaque(false);
        getContentPane().add(mb1);
        showTable("select * from student where stuid=?",id,20,30,550, 100);


        mb2.add(m2);
        mb2.setBounds(10,110,610,20);
        mb2.setOpaque(false);
        getContentPane().add(mb2);
        showTable("select * from borrowinformation where stuid=?",id,20,130,550, 190);

        btnAdd.setBounds(new Rectangle(100 + offsetX, 350, 100, 20));
        btnAdd.addActionListener(this);
        btnAdd.setFont(new java.awt.Font("黑体", 4, 12));
        btnAdd.setBackground(Color.white);
        getContentPane().add(btnAdd);


        btnDel.setBounds(new Rectangle(250 + offsetX, 350, 100, 20));
        btnDel.addActionListener(this);
        btnDel.setFont(new java.awt.Font("黑体", 4, 12));
        btnDel.setBackground(Color.white);
        getContentPane().add(btnDel);


        btnModify.setBounds(new Rectangle(400 + offsetX, 350, 100, 20));
        btnModify.addActionListener(this);
        btnModify.setFont(new java.awt.Font("黑体", 4, 12));
        btnModify.setBackground(Color.white);
        getContentPane().add(btnModify);


        btnQuery.setBounds(new Rectangle(484 + offsetX, 350, 100, 20));
        btnQuery.addActionListener(this);
        btnQuery.setFont(new java.awt.Font("黑体", 4, 12));
        btnQuery.setBackground(Color.white);
        //getContentPane().add(btnQuery);


    }
    public String getId(){
        return id;
    }
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnAdd){
//            String bookname=JOptionPane.showInputDialog(null,"请输入书籍名：",JOptionPane.QUESTION_MESSAGE)
           JOptionPane.showMessageDialog(this,"请选择书籍");

            try {
                new BookSelect(id);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        if(e.getSource()==btnDel){


            if(row==-1){
                JOptionPane.showMessageDialog(this,"请选择要删除的信息");
            }

            String stuid= String.valueOf(table.getValueAt(row,0));
            String code= String.valueOf(model.getValueAt(row,1));
            new database.OperateBorrow().deleteborrow(stuid,code);
            new database.OperateBorrow().updatabookstate1(code);
            model.removeRow(row);
            JOptionPane.showMessageDialog(this,"借阅信息删除成功");
        }
        if(e.getSource()==btnModify){
            showTable("select * from borrowinformation where stuid=?",id,20,130,550, 190);

        }
        if(e.getSource()==btnQuery){

        }
    }
    public void showTable(String sql,String stuid,int x,int y,int width,int height){
        try {

            add=new database.AddBook();
            model=add.getResultSet1(sql,stuid);
            table=new JTable(model);
            JScrollPane scroll = new JScrollPane(table);
            scroll.setBounds(x, y, width, height);
            //scroll.setBorder(new TitledBorder("借阅信息"));
            getContentPane().add(scroll);
            scroll.setOpaque(false);
            scroll.getViewport().setOpaque(false);
            table.setOpaque(false);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
}

    public void valueChanged(ListSelectionEvent e) {
        row=table.getSelectedRow();
    }
}

