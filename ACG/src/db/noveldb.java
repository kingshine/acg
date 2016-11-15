package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class noveldb {
	public static void  getAll() {
	    Connection conn = MysqlOperator.getConn();
	    String sql = "select * from novel";
	    PreparedStatement pstmt;
	    try {
	        pstmt =conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	            MysqlOperator.clearup(pstmt, rs);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    MysqlOperator.clearup(conn);
	}
}
