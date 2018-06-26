//package guiws.shop;
package a12;
import java.sql.*;

public class ConnectDataBase {
	
    public ConnectDataBase()
    {
    }

    public static Connection getConn() throws Exception 
    {
    		
        Connection conn = null;
  			//String strUrl="jdbc:sqlserver://127.0.0.1:1433;exclusive_shop?user=sa&password=123456&useUnicode=true&characterEncoding=utf8";
  			String strUrl="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=exclusive_shop";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
//            conn = DriverManager.getConnection(strUrl);
            conn = DriverManager.getConnection(strUrl,"sa","123456");
        return conn;

    }
 
}
