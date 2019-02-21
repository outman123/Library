/**
 * 
 */
package administrator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.Database;

/**
 * @author Administrator
 *
 */
public class GetBook {
	private Statement statement;
	private String sql;
	private ResultSet rs;
	private ArrayList<Book> books;

	public GetBook() {
		statement = Database.getStatement();
		books = new ArrayList<Book>();
	}

	public ArrayList<Book> getBook() throws SQLException {
		sql = "select * from book";
		rs = statement.executeQuery(sql);
		while (rs.next()) {
			Book book = new Book();
			book.setCode(rs.getString(1));
			book.setBookName(rs.getString(2));
			book.setWriter(rs.getString(3));
			book.setPublisher(rs.getString(4));
			book.setBuyDate(rs.getString(5));
			book.setNumber(rs.getInt(6));
			book.setIsLoan(rs.getByte(7));
			books.add(book);
		}

		for (Book book : books) {
			sql = "select student.name from student, borrowinformation where code='" + book.getCode()
					+ "' and borrowinformation.stuid=student.stuid;";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				book.setStudentName(rs.getString("name"));
			}
		}
		return books;
	}

}
