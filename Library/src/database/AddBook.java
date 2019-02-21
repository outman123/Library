package database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

/**
 * Created by Administrator on 2017/12/14.
 */
public class AddBook {
    private Statement state=Database.getStatement();
    private Connection con=Database.getCon();
    public DefaultTableModel getResultSet(String sql) throws SQLException {

        ResultSet rs = state.executeQuery(sql);
        boolean records = rs.next(); 
        if (!records) {
            JOptionPane.showMessageDialog(null, "δ�ҵ��鼮");
            return null;
        }

        Vector rows = new Vector();
        Vector columnHeads = new Vector();

            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); ++i)
                columnHeads.addElement(rsmd.getColumnName(i)); // ����

            do {
                rows.addElement(getNextRow(rs, rsmd));//ÿһ������
            }
            while (rs.next());
            DefaultTableModel model = new DefaultTableModel(rows, columnHeads);
            return model;
        
    }

    public DefaultTableModel getResultSet1(String sql,String stuid) throws SQLException {

        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,stuid);
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "δ�ҵ������Ϣ");
            return null;
        }

        Vector rows = new Vector();
        Vector columnHeads = new Vector();

        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); ++i)
            columnHeads.addElement(rsmd.getColumnName(i)); // ����

        do {
            rows.addElement(getNextRow(rs, rsmd));//ÿһ������
        }
        while (rs.next());
        DefaultTableModel model = new DefaultTableModel(rows, columnHeads);
//            table.setSize(new Dimension(383, 81));
//            JScrollPane scroller = new JScrollPane(table);
        return model;

    }


    private Vector getNextRow(ResultSet rs, ResultSetMetaData rsmd)
            throws SQLException {
        Vector currentRow = new Vector();
        for (int i = 1; i <= rsmd.getColumnCount(); ++i)
            currentRow.addElement(rs.getString(i));
        return currentRow;
    }

}
