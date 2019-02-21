package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/Library?user=root&characterEncoding=utf8&useSSL=false";
	private String user = "root";
	private String dbPassword = "123456";

	private static Connection con;

	private static Database db;

	private static Statement statement;

	private Database() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, user, dbPassword);
			statement = con.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static Statement getStatement() {
		if (db == null) {
			db = new Database();
		}
		return statement;
	}

	public void connect() {

	}
	public static Connection getCon(){
		if (db == null) {
			db = new Database();
		}
		return con;
	}

}
