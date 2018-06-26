package a12;
//import java.awt.*;
import java.sql.* ;
public class DataBaseConnection
{	
	private final static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=exclusive_shop";
    private static final String USER="sa";
    private static final String PASSWORD="123456";
	public DataBaseConnection(){
	}
     public static Connection getConnection() 
    {
    		
        Connection conn = null;
  			//String Url="jdbc:odbc:exclusive_shop";

        try 
        {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            //conn = DriverManager.getConnection(strUrl);
            conn=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return conn;
    }
} 

