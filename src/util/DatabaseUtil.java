package util;
/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月24日 下午3:00:36
 * @description 类说明
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseUtil {
	
	private static Connection conn;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				conn = connection();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	private static Connection connection() throws ClassNotFoundException, SQLException {
		String strUrl="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=sicknessSystem";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(strUrl,"sa","123456");
		return conn;
	}
	public static void main(String[] args) {
		getConnection();
		System.out.println(conn);
	}

}
