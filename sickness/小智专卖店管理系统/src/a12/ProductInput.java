package a12;

import java.sql.*;
import java.util.Date;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*; 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProductInput extends JInternalFrame implements ActionListener
{
	JPanel panel1,panel2;
	JLabel label1;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	JButton b1,b2;
	Connection conn = null;
	DateChooserJButton dcjb;
	
	int prodId = 0;
	int releaseFlag = 0;//数据库连接释放标识
	java.sql.Date inputDate;
	ResultSet rst;
	Statement stmt;
	int isHave;
	String sql,temp;
	
	Vector  idVector;
	
	Vector nameVector=new Vector();
	
	
	JComboBox pNameCB;
	
	public ProductInput()
	{
		super("新产品");
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(5, 4));
		label1 = new JLabel("产品编号", SwingConstants.CENTER); 
		tf1 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf1);
		label1 = new JLabel("产品名称", SwingConstants.CENTER); 
		tf2 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf2);
		label1 = new JLabel("产品数量", SwingConstants.CENTER); 
		tf3 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf3);
		label1 = new JLabel("产品状态", SwingConstants.CENTER); 
		tf4 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf4);
		label1 = new JLabel("产品价格", SwingConstants.CENTER); 
		tf5 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf5);
		label1 = new JLabel("优惠价格", SwingConstants.CENTER); 
		tf6 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf6);
		label1 = new JLabel("会员价格", SwingConstants.CENTER); 
		tf7 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf7);
		label1 = new JLabel("产品供应商", SwingConstants.CENTER); 
		tf8 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf8);
		
		label1 = new JLabel("产品类型", SwingConstants.CENTER);
		queryPType("productType");
nameVector.add("衣服");
		nameVector.add("鞋");
		nameVector.add("帽子");
		pNameCB = new JComboBox(nameVector);
		panel1.add(label1);
		panel1.add(pNameCB);
		
		label1 = new JLabel("入库日期", SwingConstants.CENTER); 
		dcjb = new DateChooserJButton();
		panel1.add(label1);
		panel1.add(dcjb);
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
	}
	
	public JInternalFrame getIFrame()
		{
				return this;
		}
		
		public void queryPType(String mtype)
		{
				nameVector = new Vector();
				idVector = new Vector();
				if (conn == null) 
				{
					try {
						conn = ConnectDataBase.getConn();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				try
				{
						
    				sql = "SELECT dataId, itemDataName FROM systemDataConfInfo WHERE menuDataName = '" + mtype + "'";
    						//System.out.println("SELECTsql " + sql);
						stmt = conn.createStatement();
						rst = stmt.executeQuery(sql);		
						while(rst.next())
						{
								idVector.add(rst.getInt(1));
								nameVector.add(rst.getString(2));
						}																				
				}
				catch (SQLException sqle)	
				{
						sqle.printStackTrace();
				}
		}
	
	public void actionPerformed(ActionEvent e) 
		{ 
				String cmd = e.getActionCommand(); 
				if (cmd.equals("退出")) dispose();
				else
				{	
					conn = DataBaseConnection.getConnection();
					if (conn == null) return;
		    		
						String pRecCode1 =tf1.getText(); 				
						String prodName = tf2.getText();
						String prodNum = tf3.getText();
						String prodState = tf4.getText();
						String prodPrice = tf5.getText();
						String prodprPrice = tf6.getText();
						String pmember = tf7.getText();
						String supplier = tf8.getText();
						
						String ptype = nameVector.get(pNameCB.getSelectedIndex()).toString();
												
						PreparedStatement pstmt = null;			    
				    try
				    {		//check whether the pRecCode is the only one.
						    sql = "SELECT COUNT(*) FROM productinfo WHERE pRecCode = ? ";
								pstmt = conn.prepareStatement(sql);
								pstmt.setString(1, pRecCode1);
								rst = pstmt.executeQuery();	
								rst.next();					
								temp = rst.getString(1);
						}
						catch (SQLException sqle)
						{
								sqle.printStackTrace();
						}	    
				     
				    if (temp.equals("0"))
		    		{				System.out.println(temp + "jinjinjilai");
						    if((tf1.getText().length() == 0) || (prodName.length() == 0) || 
						    		(prodNum.length() == 0) || (prodState.length() == 0) || 
						    		(prodPrice.length() == 0))
				        {
				        		releaseFlag = 1;
				        		JOptionPane.showMessageDialog(this, "请输入完整的产品信息!", "提示信息",
				        				JOptionPane.WARNING_MESSAGE);
				        }
				        else	 
				        {  	
				        		releaseFlag = 2;
				        		
										try
										{											
												java.util.Date pickDate = dcjb.getDate();
												inputDate = new java.sql.Date(pickDate.getTime());
										}
										catch (Exception pe)
										{
												pe.printStackTrace();
										}
										
						        try 
						        {	        		
						        		  sql =
						        			"INSERT INTO" +
						        			" productInfo(pRecCode, pName, pclass, pNum,pState, pPrice," +
						        			"prPrice, pmember, supplier, inDate)" +
						        			"VALUES  (?,?,?,?,?,?,?,?,?,?)";	        
						            pstmt = conn.prepareStatement(sql);
						            pstmt.setString(1, pRecCode1);
						            pstmt.setString(2, prodName);
						            pstmt.setString(3, ptype);
						            pstmt.setString(4, prodNum);
						            pstmt.setString(5, prodState);
						            pstmt.setString(6, prodPrice);
						            pstmt.setString(7, prodprPrice);
						            pstmt.setString(8, pmember);
						            pstmt.setString(9, supplier);
						            pstmt.setDate(10, inputDate);
						            
						            int updateCount = pstmt.executeUpdate();
						                        		
						            if (updateCount != 0) 
						            {
						                JOptionPane.showMessageDialog(this, "产品信息保存成功!", "提示信息", 
																JOptionPane.INFORMATION_MESSAGE);
						            } 
						            else 
						            {
						            		JOptionPane.showMessageDialog(this, "产品信息保存失败!", "错误提示",
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
				      else
				      {
				      		JOptionPane.showMessageDialog(this, "产品编号已经存在，请重新输入!", "警告",
								            				JOptionPane.ERROR_MESSAGE);
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
		{}
		JInternalFrame F = new ProductInput();
		
	}
}