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

public class MemberFeePosition extends JInternalFrame
{	
		Container stockPane;
		MemberFeePosition(String s)
		{
				super(s);
				stockPane = getContentPane();
				stockPane.setLayout(new BorderLayout());
				TableModel myTableModel = new TransferTableModel(rst);
				JTable mytable = new JTable(myTableModel);
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
				this.setBounds(0, 0, 350, 400);
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
				String[] myDefColumName = {"会员名称","消费额"};
				public TransferTableModel(ResultSet rs)
				{
						super(rs);
						System.out.println("TransferTableModel");
				}
				public String getColumnName(int c) 
     		{System.out.println(myDefColumName[c]);
	      		return myDefColumName[c];
     		}
		}
		Connection conn;
		Statement stmt;
		ResultSet rst;
		public static void main(String[] args)
		{
				try
				{
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	
				}
				catch (Exception e)
				{
				}
				new MemberFeePosition("会员消费情况");
		}
}