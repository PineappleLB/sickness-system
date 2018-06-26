package a12;
import java.sql.*;

public class Close
{
		ResultSet rst1 = null;
		Statement stmt1 = null;
		Connection conn1 = null;
		PreparedStatement pstmt1 = null;
		
		public Close(ResultSet rst, Statement stmt, Connection conn)
		{
				rst1 = rst;
				stmt1 = stmt;
				conn1 = conn;
		}
		
		public Close(ResultSet rst, PreparedStatement pstmt, Connection conn)
		{
				rst1 = rst;
				pstmt1 = pstmt;
				conn1 = conn;
		}
		
		public void release()
		{
       try 
       {
           if (rst1 != null) 
           {
               rst1.close();
           }
           if (stmt1 != null) 
           {
               stmt1.close();
           }
           if (pstmt1 != null) 
           {
               pstmt1.close();
           }
           if (conn1 != null) 
           {
               conn1.close();
           }
       }
        catch (Exception exc) 
       {
           exc.printStackTrace();
       }
    }
}
