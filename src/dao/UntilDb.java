package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UntilDb {
	private static String url = "jdbc:mysql://localhost:3306/vinsinwsweb";
	private static String user = "root";
	private static String password = "123456";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
			Connection conn;
			try {
				conn = DriverManager.getConnection(url, user, password);
				return conn;
			} catch (SQLException e) {
				System.out.println("数据库连接错误！");
				return null;
			}
		
	}
	


	public static boolean closeAll(Connection conn, Statement stmt, ResultSet rs) {
		boolean finish = true;
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				finish = false;
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				finish = false;
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				finish = false;
			}
		}
		return finish;
	}
	
}
