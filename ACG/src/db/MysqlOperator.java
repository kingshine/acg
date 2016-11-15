package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MysqlOperator {
	public static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://10.200.70.111:3306/acg?useUnicode=true&characterEncoding=utf-8";
	    String username = "root";
	    String password = "19901215";
	    Connection conn = null;
	    try {
	        Class.forName(driver); 
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	public static void clearup(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			conn = null;
		}
	}

	public static void clearup(PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			rs = null;
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			pstmt = null;
		}

	}

}
