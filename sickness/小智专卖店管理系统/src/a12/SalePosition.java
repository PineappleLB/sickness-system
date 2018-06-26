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

public class SalePosition extends JInternalFrame
{	
		Container stockPane;
		JButton queryByNum,queryByTotalNum;
		JTable mytable;
		SalePosition(String s)
		{
				super(s);
				stockPane = getContentPane();
				stockPane.setLayout(new BorderLayout());
				
				mytable = new JTable();
				mySP = new JScrollPane(mytable);
				mySP.setPreferredSize(mytable.getPreferredSize());
				JPanel exitPane = new JPanel();
				JButton exitButt = new JButton("取消");
				Dimension dim = new Dimension(2,1);
				exitButt.setSize(dim);
				exitButt.setLocation(1,1);
				queryByNum = new JButton("按照销售数量排名");
				queryByNum.addActionListener(
					new ActionListener()
					{
							public void actionPerformed(ActionEvent ae)
							{
									setMyNumModel();
							}
					});
				queryByTotalNum = new JButton("按照销售额排名");
				queryByTotalNum.addActionListener(
					new ActionListener()
					{
							public void actionPerformed(ActionEvent ae)
							{
									setMyTotalNumModel();
							}
					});
				
				exitPane.add(queryByNum);
				exitPane.add(queryByTotalNum);
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
		
		public class NumTransferTableModel extends DatabaseTableModel
		{
				String[] myDefColumName = {"产品速记码","产品名称","销售数量"};
				public NumTransferTableModel(ResultSet rs)
				{
						super(rs);
				}
				public String getColumnName(int c) 
     		{
	      		return myDefColumName[c];
     		}
		}
		JScrollPane mySP;
		public void setMyNumModel()
		{
				rst = creatPositionByNumAmount();
				TableModel myTableModel = new NumTransferTableModel(rst);
				mytable.setModel(myTableModel);
				
				int count = mytable.getRowCount();
				mytable.setRowHeight(25);
				int height = mytable.getRowHeight();
				int temp = count*height;
				int total = mytable.getPreferredSize().height + temp;
				
				Dimension d = new Dimension(mytable.getPreferredSize().width,total);
				mySP.setPreferredSize(d);
				pack();
		}		
		
		public class TotalNumTransferTableModel extends DatabaseTableModel
		{
				String[] myDefColumName = {"产品速记码","产品名称","销售总额"};
				public TotalNumTransferTableModel(ResultSet rs)
				{
						super(rs);
				}
				public String getColumnName(int c) 
     		{
	      		return myDefColumName[c];
     		}
		}
		public void setMyTotalNumModel()
		{
				rst = creatPositionByMoneyNum();
				TableModel myTableModel = new TotalNumTransferTableModel(rst);
				mytable.setModel(myTableModel);
				
				int count = mytable.getRowCount();
				mytable.setRowHeight(25);
				int height = mytable.getRowHeight();
				int temp = count*height;
				int total = mytable.getPreferredSize().height + temp;
				
				Dimension d = new Dimension(mytable.getPreferredSize().width,total);
				mySP.setPreferredSize(d);
				pack();
		}
		
		Connection conn;
		Statement stmt;
		ResultSet rst;
		public ResultSet creatPositionByNumAmount()
		{
				ResultSet rrst = null;
				try
				{
					conn = DataBaseConnection.getConnection();
					if (conn == null) return null;
    				String sql = "select a.pRecCode,b.pName,a.saleNum from saleinfo a,productinfo b where a.pRecCode = b.pRecCode order by a.saleNum DESC";
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
		
		public ResultSet creatPositionByMoneyNum()
		{
				ResultSet rrst = null;
				try
				{
					conn = DataBaseConnection.getConnection();
					if (conn == null) return null;
    				String sql = "select a.pRecCode,b.pName,a.saleTotalNum from saleinfo a,productinfo b where a.pRecCode = b.pRecCode order by a.saleTotalNum DESC";
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
				new SalePosition("销售排名信息");
		}
}