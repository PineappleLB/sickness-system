package a12;
import java.sql.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*; 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SetChatTool extends JInternalFrame implements ActionListener
{
	JPanel panel1,panel2;
	JLabel label1;
	JTextField tf1;
	JButton b1,b2;
	Connection conn = null;
	DateChooserJButton dcjb;
	int releaseFlag = 0;//数据库连接释放标识
	java.sql.Date inputDate;
	ResultSet rst;
	int isHave;
	String sql,temp;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	int updateCount = 0;
	
	public SetChatTool()
	{
		super("系统基本设置");
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 2));
		label1 = new JLabel("QQ设置", SwingConstants.CENTER); 
		tf1 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf1);
		b1 = new JButton("保存");
		b2 = new JButton("退出");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b1.updateUI();
		b2.updateUI();
		panel2 = new JPanel();
		panel2.add(b1);
		panel2.add(b2);
		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.SOUTH);
		setSize(400,200);
	  setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	  setVisible(true);
	  createRS();
	  displayInfo();
	}
	
	public JInternalFrame getIFrame()
		{
				return this;
		}
	
	ResultSet rrst;
	public ResultSet createRS()
	{
			try
			{					
				conn = DataBaseConnection.getConnection();
				if (conn == null) return null;
					String queryExShopinfosql = "SELECT dataId, itemDataName FROM systemDataConfInfo WHERE menuDataName = 'chatTool'";System.out.println(queryExShopinfosql);
					stmt = conn.createStatement();
					rrst = stmt.executeQuery(queryExShopinfosql);	
			}
			catch (SQLException sqle)
			{
					sqle.printStackTrace();
			}
			return rrst;
	}
	
	public void displayInfo()
	{
			try
			{					
					if (rrst.next())
					{
							tf1.setText(rrst.getString("itemDataName")); System.out.println(rrst.getString("itemDataName"));				
					}	
					
			}
			catch (SQLException sqle)
			{
					sqle.printStackTrace();
			}
	}
	
	String chatQQ;
	public void actionPerformed(ActionEvent e) 
		{ 
				String cmd = e.getActionCommand(); 
				if (cmd.equals("退出")) dispose();
				else
				{			
					conn = DataBaseConnection.getConnection();
					if (conn == null) return;    		
						chatQQ =tf1.getText(); 						
																						      		     
				    if((chatQQ.length() == 0))
		        {
		        		releaseFlag = 1;
		        		JOptionPane.showMessageDialog(this, "请输入QQ!", "提示信息",
		        				JOptionPane.WARNING_MESSAGE);
		        }
		        else	 
		        {  	
		        		releaseFlag = 2;		        												
				        try 
				        {	        		
				        		rst = createRS();
										if(rst.next())
										{		//update QQ if the QQ has been set in this system.
												String updateExShopinfosql = "UPDATE systemDataConfInfo SET itemDataName='" + chatQQ + "'WHERE menuDataName = 'chatTool'";
				    								System.out.println("updateExShopinfosql " + updateExShopinfosql);
												stmt = conn.createStatement();
												updateCount = stmt.executeUpdate(updateExShopinfosql);System.out.println("updateCount " + updateCount);
										}
	            			else
	            			{		//insert a new QQ if no QQ has been set in this system.
				        			sql = "INSERT INTO systemDataConfInfo(parentId , menuDataName, " + 
											"itemDataName, itemDataValue)" + 
											"VALUES (0 , 'chatTool',? , '0')";
				        		  System.out.println(sql);	        
				            pstmt = conn.prepareStatement(sql);
				            pstmt.setString(1, chatQQ);				            
				            updateCount = pstmt.executeUpdate();
						        }    
				                        		
				            if (updateCount != 0) 
				            {
				                JOptionPane.showMessageDialog(this, "QQ设置成功!", "提示信息", 
														JOptionPane.INFORMATION_MESSAGE);
				            } 
				            else 
				            {
				            		JOptionPane.showMessageDialog(this, "QQ设置失败!", "错误提示",
				            				JOptionPane.ERROR_MESSAGE);
				            }		 
				         } 
				         catch (SQLException ex) 
				         {
				            ex.printStackTrace();
				         } 
				         finally 
				         {
				         		if ((releaseFlag != 1) && (releaseFlag != 2))
				         		{
				            		new Close(rst, pstmt, conn).release();
				            }
				         }	
		         }
         } 
		} 
	
	public static void main(String[] args)
	{
		try
		{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());		
		}
		catch (Exception e)
		{
		}
		JInternalFrame F = new SetChatTool();		
	}
}