package database;

import java.sql.*;

/**
 * Created by Administrator on 2017/12/15.
 */
public class OperateBorrow {
    Statement state=Database.getStatement();
    Connection con=Database.getCon();

    public void deleteborrow(String stuid,String code){
        String sql = "delete from borrowinformation where stuid=? and code=?";

        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,stuid);
            ps.setString(2,code);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertBorrowInfor(String stuid, String code,Date loandata, Date returndata){
        String sql="insert into borrowinformation values(?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,stuid);
            ps.setString(2,code);
            ps.setDate(3,loandata);
            ps.setDate(4,returndata);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatabookstate0(String code){
        String sql="update book set isload=0 where code=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,code);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatabookstate1(String code){
        String sql="update book set isload=1 where code=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,code);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
