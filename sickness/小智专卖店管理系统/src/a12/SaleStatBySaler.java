package a12;
/*
*@date 20080624
*@author guiws
*/
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableModel;

public class SaleStatBySaler extends JInternalFrame
{	
		Container stockPane;
		JTable mytable;
		SaleStatBySaler(String s)
		{
				super(s);
				stockPane = getContentPane();
				stockPane.setLayout(new BorderLayout());
				rst = queryOutOfStockProduct();
				TableModel myTableModel = new TransferTableModel(rst);
				mytable = new JTable(myTableModel);
				int count = mytable.getRowCount();
				mytable.setRowHeight(25);
				int height = mytable.getRowHeight();
				int temp = count*height;
				int total = mytable.getPreferredSize().height + temp;
				JScrollPane mySP = new JScrollPane(mytable);				
				Dimension d = new Dimension(mytable.getPreferredSize().width,total);
				mySP.setPreferredSize(d);
				JPanel exitPane = new JPanel();
				JButton exitButt = new JButton("取消");
				exitPane.add(exitButt);
				stockPane.add(mySP, BorderLayout.NORTH);
				stockPane.add(exitPane, BorderLayout.SOUTH);
				exitButt.addActionListener(
					new ActionListener()
					{
							public void actionPerformed(ActionEvent ae)
							{
									dispose();//add data of type into database.
							}
					});
				this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
				this.setVisible(true);
				setResizable(true);
				pack();
		}
		
		public JInternalFrame getIFrame()
		{
				return this;
		}
		
		public class TransferTableModel extends DatabaseTableModel
		{
				String[] myDefColumName = {"用户标识","用户名","销售总额"};
				public TransferTableModel(ResultSet rs)
				{
						super(rs);
				}
				public String getColumnName(int c) 
     		{
	      		return myDefColumName[c];
     		}
		}
		
		Connection conn;
		Statement stmt;
		ResultSet rst;
		public ResultSet queryOutOfStockProduct()
		{
				ResultSet rrst = null;
				try
				{
					conn = DataBaseConnection.getConnection();
					if (conn == null) return null;
    				String sql = "select userid,username,saleTotalNum from userinfo";
    						System.out.println("SELECTsql " + sql);
						stmt = conn.createStatement();
						rrst = stmt.executeQuery(sql);																					
				}
				catch (SQLException sqle)	
				{
						sqle.printStackTrace();
				}
				return rrst;
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
				new SaleStatBySaler("销售人员统计信息");
		}
}