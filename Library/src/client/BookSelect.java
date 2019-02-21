package client;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

//import java.sql.Date;

/**
 * Created by Administrator on 2017/12/15.
 */
public class BookSelect implements ActionListener,ListSelectionListener{

    JTable table;
    DefaultTableModel model;
    private database.AddBook add;
    ListSelectionModel selectmodel;
    JFrame frame=new JFrame("?üž???");
    JButton confire=new JButton("???");
    JButton cancel=new JButton("???");
    int row;String id;

    public BookSelect(String stuid) throws SQLException {
        id=stuid;

        frame.setBounds(450,250,570,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);

        add=new database.AddBook();
        model=add.getResultSet("select * from book");
        table=new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(10,10,530, 380);
        frame.getContentPane().add(scroll);
        scroll.setBorder(new TitledBorder("??????"));
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        table.setOpaque(false);
        
        //table.setEnabled(false);
        table.setRowSelectionAllowed(true);
        selectmodel=table.getSelectionModel();
        selectmodel.addListSelectionListener(this);

        confire.setBounds(100,400,100, 30);
        confire.addActionListener(this);
        confire.setFont(new java.awt.Font("????", 4, 14));
        confire.setBackground(Color.white);
        frame.getContentPane().add(confire);

        cancel.setBounds(400,400,100, 30);
        cancel.addActionListener(this);
        cancel.setFont(new java.awt.Font("????", 4, 14));
        cancel.setBackground(Color.white);
        frame.getContentPane().add(cancel);

    }
    public void valueChanged(ListSelectionEvent e) {
        row=table.getSelectedRow();
        String isload=String.valueOf(table.getValueAt(row,6)).trim();
        if(isload.equals("1")){
            JOptionPane.showMessageDialog(frame,"???üž?????????");
        }
    }


    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==confire){
            if(row==-1){
                JOptionPane.showMessageDialog(frame,"????????????üž");
                return;
            }
            JOptionPane.showMessageDialog(frame,"??????");
            frame.setVisible(false);

            String code=String.valueOf(table.getValueAt(row,0));

            java.util.Date curDate = new java.util.Date();
            java.sql.Date loandata = new java.sql.Date(curDate.getTime());

            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, 1);
            Date returndata=c.getTime();
            java.sql.Date returndata1 = new java.sql.Date(returndata.getTime());
            new database.OperateBorrow().insertBorrowInfor(id,code,loandata,returndata1);
            new database.OperateBorrow().updatabookstate0(code);
        }
        if(e.getSource()==cancel){
            frame.setVisible(false);

        }
    }
}
