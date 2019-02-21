package database;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateNewAccount {
	private String stuid;
	private String password;
	private String sql;
	private Statement statement;

	public CreateNewAccount(String stuid, String password) {
		this.stuid = stuid;
		this.password = password;
		statement = Database.getStatement();
	}

	public boolean createNewAccount() {
		sql = "insert into accounts values('" + stuid + "','" + password + "')";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
}
