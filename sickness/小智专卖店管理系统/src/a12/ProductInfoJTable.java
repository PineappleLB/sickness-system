package a12;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager;

import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;

public class ProductInfoJTable extends JInternalFrame implements ActionListener, MouseListener
{
		PreparedStatement pstmt;//the variables the database will use.
		Statement stmt;
		Connection conn = null;
		ResultSet rst;
		String sql;
		
		int rowModifyFlag = 0;
		
		JLabel jlabel = new JLabel("按照速记码查询");
		JLabel jlabel2 = new JLabel("产品速记码");
		JTable jtable = new JTable();
		JScrollPane jscrollpane = new JScrollPane(jtable);//将表格加个滚动条
		JButton qButton = new JButton("查询");
		JButton delButton = new JButton("删除");
		JButton exitButton = new JButton("取消");
		JTextField tf = new JTextField();
		JPanel pn1 = new JPanel();
			 
		ProductInfoJTable(String s)
		{
				super(s);
				jscrollpane.setPreferredSize(jtable.getPreferredSize());
				pn1.setLayout(new FlowLayout());
				pn1.add(jlabel2);
				tf.setColumns(10);
				pn1.add(tf);
				pn1.add(qButton);
				pn1.add(delButton);
				pn1.add(exitButton);	    
				this.setLayout(new BorderLayout());
				this.add(jlabel,BorderLayout.NORTH);
				JPanel controlScrollPane = new JPanel();
				controlScrollPane.add(jscrollpane);
				controlScrollPane.add(pn1);
				JScrollPane SPane = new JScrollPane(controlScrollPane);
				this.add(SPane,BorderLayout.SOUTH);				  
				qButton.addActionListener(this);
				delButton.addActionListener(this);
				exitButton.addActionListener(this);
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.setVisible(true);//设置窗口显示true  
				setResizable(true);
				pack();
		}
		
		public JInternalFrame getIFrame()
		{
				return this;
		}
		 
		String[] translateCol = { "pId", "pRecCode", "pName", "pclass", "pNum", "pState", "pPrice", "prPrice", "pmember", "supplier", "inDate"};
		String[] col = { "编号", "速记码", "名称", "类型", "数量", "状态", "进价", "优惠价", "会员价", "商品厂商", "入库日期"};
		
		int findFlag = 0, i;
		public String findDataBaseField(String str)
		{
				for (i = 0; (i < col.length) && (findFlag == 0); i ++)
				{
						if (str.equals(col[i]))
								findFlag = 1;							
				}
				return translateCol[i-1];
		}
		
		public void actionPerformed(ActionEvent e) 
		{
				if(e.getSource()==qButton)
				{
						DefaultTableModel mm = new DefaultTableModel(col,0); //定义一个表的模板
				   
						conn = DataBaseConnection.getConnection();
						if (conn == null) return;
						try
						{
								if (tf.getText().length() != 0)
								{
										sql = "SELECT * FROM productinfo WHERE pRecCode = ?";
										pstmt = conn.prepareStatement(sql);
										pstmt.setString(1, tf.getText());
										rst = pstmt.executeQuery();	
								}								
								else 
										if (tf.getText().length() == 0)
										{
												sql = "SELECT * FROM productinfo";
												stmt = conn.createStatement();
												rst = stmt.executeQuery(sql);
										}
								
								while(rst.next())
								{
										String pId = rst.getString("pId");
										System.out.println(pId);
										String pRecCode = rst.getString("pRecCode");
										System.out.println(pRecCode);
										String pName = rst.getString("pName");
										String pclass = rst.getString("pclass");
										String pNum = rst.getString("pNum");
										String pState = rst.getString("pState");
										String pPrice = rst.getString("pPrice");
										String prPrice = rst.getString("prPrice");
										String pmember = rst.getString("pmember");
										String supplier = rst.getString("supplier");
										String inDate = rst.getString("inDate");
										
										String[] str_row={pId, pRecCode, pName, pclass, pNum,pState,pPrice,prPrice,pmember,supplier,inDate}; //将一行的数据存在str_row 字符串数组里
										mm.addRow(str_row);//添加在表模板中
								}
								jtable.setModel(mm);//将jtable这个表 设置为刚刚定义的模板
								this.add(jscrollpane); //将加载了表的滚动条在JFrame中显示
								int count = jtable.getRowCount();
								jtable.setRowHeight(25);
								int height = jtable.getRowHeight();
								int temp = count*height;
								int total = jtable.getPreferredSize().height + temp;							
								Dimension d = new Dimension(jtable.getPreferredSize().width,total);
								jscrollpane.setPreferredSize(d);
								jscrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
								jscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
								pack();
								jtable.addMouseListener(this);
						}
						catch(SQLException e1)
						{
								e1.getStackTrace();
						}
						finally
						{
								//new Close(rst, pstmt, conn).release();
						}
				}
				else	if (e.getSource()==delButton)
							{
									System.out.println("delButtonEntered");
									selectedRows = jtable.getSelectedRows();
									for (int i = 0; i < selectedRows.length; i ++)
									{
											selectedPid =Integer.parseInt(jtable.getValueAt(selectedRows[i], 0).toString());
											System.out.println(selectedPid);
											deleteProductInfo(selectedPid);
									}
							}else
							{
									
									dispose();
							}
		}
		
		TableColumnModel tcm;//the variables the jtable will use 
		int selectedR, selectedC;
		Object obj;
		int editingR = 100, editingC = 100;
		Object editingV, editedV, editedRecId;
		int   row = 100;
		int   column = 100;
		Object   value;
		Point pointx, pointy;
		int updateFlag = 0;
		int deleteCount;//the variables the delete function will use 
		int selectedPid;
		int[] selectedRows;
		
		public void mouseClicked(MouseEvent me)
		{	 
				row   =   jtable.rowAtPoint(me.getPoint()); 
        column   =   jtable.columnAtPoint(me.getPoint());  
        value   =   jtable.getValueAt(row,   column);
       
				if (updateFlag == 0)
				{
						if ((editingR != 100) && (editingC != 100))
						{ 
								if ((row != editingR) || (column != editingC))
								{System.out.println( "ontherv " + value);
										 editedV = jtable.getValueAt(editingR, editingC);
										 System.out.println("EditedValue " + editedV);
										 if( !editedV.equals(editingV))
										 {
										 		obj = jtable.getColumnModel().getColumn(editingC).getHeaderValue();
										 		updateCell(editedRecId, obj, editedV);
										 		updateFlag = 1;								 			
										 }
								}
						}
				}
				selectedR = jtable.getSelectedRow();System.out.println("selectedR " + selectedR);
				selectedC = jtable.getSelectedColumn();
				obj = jtable.getColumnModel().getColumn(selectedC).getHeaderValue();
		}
		public void mouseEntered(MouseEvent me)
		{
		}
		
		public void mouseExited(MouseEvent me)
		{
		}
		public void mousePressed(MouseEvent me)
		{
				if   (me.getClickCount()   >=   2)   
				{  
						updateFlag = 0;
						editingR = jtable.getEditingRow();
						editingC = jtable.getEditingColumn();
						editingV = jtable.getValueAt(editingR, editingC);
						editedRecId = jtable.getValueAt(editingR, 0);
        }  
		}
		public void mouseReleased(MouseEvent me)
		{
		}
		
		public void updateCell(Object editedRecId, Object columnHeaderField, Object modColumnField)
		{
				String modField = modColumnField.toString();
				String prodId = editedRecId.toString();
				String cHeaderField = findDataBaseField(columnHeaderField.toString());
				findFlag = 0;
				try
				{
					DataBaseConnection.getConnection();
					if (conn == null) return;
    				String sql = "UPDATE productinfo SET " + cHeaderField + "='" + modField + "' WHERE pId ='" +  prodId +"'";
						stmt = conn.createStatement();
						int updateCount = stmt.executeUpdate(sql);
				}
				catch (SQLException se)
				{
						se.printStackTrace();
				}
				finally
				{
						//new Close(null, pstmt, conn).release();
				}
		}
		
		public int deleteProductInfo(int deletePid)
		{
				try
				{
					conn = DataBaseConnection.getConnection();
					if (conn == null) return 0;
    				
						sql = "DELETE FROM productinfo WHERE pId = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, deletePid);
						deleteCount = pstmt.executeUpdate();							
				}
				catch (SQLException sqle)
				{
						sqle.printStackTrace();
				}
				return deleteCount;
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
				new ProductInfoJTable("产品");
		}
}