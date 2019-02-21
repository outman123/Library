/**
 * 
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Administrator
 *
 */
public class AddNewBook {
	private String bookName;
	private String writer;
	private String publisher;
	private String buyDate;
	private int amount;
	private String code;

	private Statement statement;
	private String sql;
	private ResultSet rs;

	public AddNewBook(String bookName, String writer, String publisher, String buyDate, int amount)
			throws SQLException {
		this.bookName = bookName;
		this.writer = writer;
		this.publisher = publisher;
		this.buyDate = buyDate;
		this.amount = amount;
		statement = Database.getStatement();
		setCode();
	}

	private void setCode() throws SQLException {
		code = String.valueOf((int)(Math.random() * 1000000000));
		sql = "select code from book where code='" + code + "'";
		rs = statement.executeQuery(sql);
		while (rs.next()) {
			setCode();
			return;
		}
		return;
	}
	
	public void add() throws SQLException {
		sql="insert into book values('"+code+"','"+bookName+"','"+writer+"','"+publisher+"','"+buyDate+"',"+amount+",0)";
		statement.executeUpdate(sql);
	}
}
