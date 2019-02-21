/**
 * 
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import administrator.Student;

/**
 * @author Administrator
 *
 */
public class GetAllAccounts {
	private String sql;
	private Statement statement;
	private ResultSet rs;
	private ArrayList<Student> students;
	
	public GetAllAccounts() {
		statement=Database.getStatement();
		students=new ArrayList<Student>();
	}
	
	public ArrayList<Student> getAllAccounts() throws SQLException {
		sql="select * from student";
		rs=statement.executeQuery(sql);
		while(rs.next()) {
			Student stu=new Student();
			stu.setStuid(rs.getString("stuid"));
			stu.setName(rs.getString("name"));
			stu.setSex(rs.getString("sex"));
			stu.setDepno(rs.getString("depno"));
			stu.setDepname(rs.getString("depname"));
			stu.setGrade(rs.getString("grade"));
			stu.setClassNo(rs.getString("class"));
			stu.setTel(rs.getString("tel"));
			stu.setAddr(rs.getString("addr"));
			students.add(stu);
		}	
		
		for(Student stu:students) {
			sql="select count(*) from borrowInformation where stuid='"+stu.getStuid()+"'";
			rs=statement.executeQuery(sql);
			while(rs.next()) {
				stu.setBorrowBookNumber(rs.getInt(1));
			}
		}
		return students;
	}	
}
