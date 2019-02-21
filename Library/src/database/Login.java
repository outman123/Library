package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
	private String stuid;
	private String password;
	private Statement statement;
	private String sql;
	private ResultSet rs;

	public Login(String stuid, String password) {
		this.stuid = stuid;
		this.password = password;
		statement = Database.getStatement();
	}

	public boolean login() throws SQLException {
		String passwordCheck = "";
		sql = "select password from accounts where stuid = '" + stuid + "';";
		rs = statement.executeQuery(sql);
		while (rs.next()) {
			passwordCheck = rs.getString("password");
		}
		if (password.equals(passwordCheck)) {
			return true;
		} else {
			return false;
		}
	}

}
