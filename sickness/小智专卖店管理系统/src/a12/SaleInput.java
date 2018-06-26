package a12;
/*
*@date 20080624
*@author guiws
*/

import java.sql.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*; 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SaleInput extends JInternalFrame implements ActionListener
{
	JPanel panel1,panel2;
	JLabel label1,remarkLabel;
	JTextField tf1,tf2,tf3,tf4,tf5,remarkJTF;
	JButton b1,b2;
	Connection conn = null;
	DateChooserJButton dcjb;	
	int prodId = 0, isHave;
	int releaseFlag = 0;//数据库连接释放标识
	java.sql.Date inputDate;
	ResultSet rst;
	String sql,temp;
	PreparedStatement pstmt;
	Statement stmt;
	
	public SaleInput()
	{
		super("产品销售录入");
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 4));
		label1 = new JLabel("产品速记码", SwingConstants.CENTER); 
		tf1 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf1);		
		label1 = new JLabel("销售人员", SwingConstants.CENTER); 
		tf2 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf2);		
		label1 = new JLabel("产品数量", SwingConstants.CENTER); 
		tf3 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf3);		
		label1 = new JLabel("客户类型", SwingConstants.CENTER); 
		tf4 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf4);		
		label1 = new JLabel("客户标识", SwingConstants.CENTER); 
		tf5 = new JTextField(); 
		panel1.add(label1);
		panel1.add(tf5);	
		remarkLabel = new JLabel("备注信息", SwingConstants.CENTER); 
		remarkJTF  = new JTextField(); 
		panel1.add(remarkLabel);
		panel1.add(remarkJTF);		
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
	
	public void actionPerformed(ActionEvent e) 
		{ 
				String cmd = e.getActionCommand(); 
				if (cmd.equals("退出")) dispose();
				else
				{
					conn = DataBaseConnection.getConnection();
					if (conn == null) return;
		    		try
		    		{
		    				conn.setAutoCommit(false);
		    		}
		    		catch (SQLException eee)
		    		{
		    		}
						String pRecCode1 =tf1.getText(); 			
						String saleMan = tf2.getText();
						String saleNum = tf3.getText();
						String custType = tf4.getText();
						String custId = tf5.getText();
						String remark = remarkJTF.getText();
						
						String price = "", saleTNum;				
						int tempC = 0, updateCount = 0;			    		     
		
				    if((tf1.getText().length() == 0) || (saleMan.length() == 0) || 
				    		(saleNum.length() == 0))
		        {
		        		releaseFlag = 1;
		        		JOptionPane.showMessageDialog(this, "请输入完整的产品信息!", "提示信息",
		        				JOptionPane.WARNING_MESSAGE);
		        }
		        else	 
		        {  	
		        		releaseFlag = 2;		        		
		        		try
						    {		//check whether the pRecCode is the only one.
								    sql = "SELECT * FROM productinfo WHERE pRecCode = ? ";
										pstmt = conn.prepareStatement(sql);
										pstmt.setString(1, pRecCode1);
										rst = pstmt.executeQuery();	
										if (rst.next())
										{
												price = rst.getString(6);
												System.out.println(price);
										}
										else 
										{
												JOptionPane.showMessageDialog(this, "请输入正确的产品速记码!", "提示信息", 
																JOptionPane.INFORMATION_MESSAGE);
												return;
										}
								}
								catch (SQLException sqle)
								{
										sqle.printStackTrace();
								}	
								
								tempC = Integer.parseInt(saleNum) * Integer.parseInt(price);
								saleTNum = new Integer(tempC).toString();
													
				        try 
				        {	  //record the saler's sale total num.
				        		String queryUserinfosql = "SELECT * FROM userInfo WHERE userName = ? ";
										pstmt = conn.prepareStatement(queryUserinfosql);
										pstmt.setString(1, saleMan);
										rst = pstmt.executeQuery();	
										if(rst.next())
										{		//update the saler's saleTotalNum if the saler own sale record.
												String oldAmount = rst.getString("saleTotalNum");System.out.println("oldAmount:"+oldAmount);
												String newAmount = new Integer(Integer.parseInt(oldAmount) + Integer.parseInt(saleTNum)).toString();
												System.out.println(newAmount);
												String updateuserinfosql = "UPDATE userInfo SET saleTotalNum='" + newAmount + "' , date = now() WHERE userName ='" +  saleMan +"'";
				    						System.out.println("updateuserinfosql " + updateuserinfosql);
												stmt = conn.createStatement();
												int updateMemCount = pstmt.executeUpdate(updateuserinfosql);System.out.println("updateMemCount " + updateMemCount);
										}
	            			else
	            			{		//insert a new record if the saler is new comer.
				            		String insertmeminfosql =
				        			"INSERT INTO" +
				        			" userInfo(userType,saleTotalNum,userName,password,conPhone, date)" +
				        			"VALUES  ('0',?,?,'123456','',now())";
				        						System.out.println(insertmeminfosql);	        
						            pstmt = conn.prepareStatement(insertmeminfosql);
						            pstmt.setString(1, saleTNum);
						            pstmt.setString(2, saleMan);			       					            
						            int insertMemCount = pstmt.executeUpdate();	  
						        }  
						        
						        //record the product sale info.
						        String querysaleinfosql = "SELECT * FROM saleInfo WHERE pRecCode = ? ";
										pstmt = conn.prepareStatement(querysaleinfosql);
										pstmt.setString(1, pRecCode1);
										rst = pstmt.executeQuery();	
										if(rst.next())
										{		//update the product's saleTotalNum if the product owns  record in this table.
												String oldnumAmount = rst.getString("saleNum");System.out.println("oldnumAmount:"+oldnumAmount);
												String newnumAmount = new Integer(Integer.parseInt(oldnumAmount) + Integer.parseInt(saleNum)).toString();
												String oldmoneyAmount = rst.getString("saleTotalNum");System.out.println("oldmoneyAmount:"+oldmoneyAmount);
												String newmoneyAmount = new Integer(Integer.parseInt(oldmoneyAmount) + Integer.parseInt(saleTNum)).toString();
												System.out.println(newnumAmount +"  " +  newmoneyAmount);
												String updatesaleinfosql = "UPDATE saleInfo SET saleNum='" + newnumAmount + "' , saleTotalNum='" + newmoneyAmount + "'  WHERE pRecCode ='" +  pRecCode1 +"'";
				    						System.out.println("updatesaleinfosql " + updatesaleinfosql);
												stmt = conn.createStatement();
												int updatesaleCount = pstmt.executeUpdate(updatesaleinfosql);System.out.println("updatesaleCount " + updatesaleCount);
										}
	            			else
	            			{		//insert a new record if the product is new.
				            		String insertsaleinfosql =
				        			"INSERT INTO" +
				        			" saleInfo(pRecCode,saleNum,saleTotalNum,salePos)" +
				        			"VALUES  (?,?,?,'0')";
				        						System.out.println(insertsaleinfosql);	        
						            pstmt = conn.prepareStatement(insertsaleinfosql);
						            pstmt.setString(1, pRecCode1);
						            pstmt.setString(2, saleNum);	
						            pstmt.setString(3, saleTNum);		       					            
						            int insertsaleCount = pstmt.executeUpdate();	  
						        }                
				        
				            //record the inputing sale info.
			        		  String insertSaleinfosql =
			        			"INSERT INTO" +
			        			" saleStatInfo(pRecCode, pType, saleMan, startDate, endDate, processor, saleNum,saleTotalNum,custType,custId,remark)" +
			        			"VALUES  (?,'0',?,now(),now(),'admin',?,?,?,?,?)";
			        				System.out.println(insertSaleinfosql);	        
				            pstmt = conn.prepareStatement(insertSaleinfosql);
				            pstmt.setString(1, pRecCode1);
				            pstmt.setString(2, saleMan);
				            pstmt.setString(3, saleNum);
				            pstmt.setString(4, saleTNum);
				            pstmt.setString(5, custType);
				            pstmt.setString(6, custId);
				            pstmt.setString(7, remark);
				            
				            updateCount = pstmt.executeUpdate();
				            
				            if (custType.equals("1"))//judge whether this is a member.
				            {
				            		sql = "SELECT * FROM memConsumeInfo WHERE memberId = ? ";
												pstmt = conn.prepareStatement(sql);
												pstmt.setString(1, custId);
												rst = pstmt.executeQuery();	
																												
												if(rst.next())//update member fee record if this is a member.
												{
														String oldAmount = rst.getString("consumpAmount");
														String newAmount = new Integer(Integer.parseInt(oldAmount) + Integer.parseInt(saleTNum)).toString();
														String updatememsql = "UPDATE memConsumeInfo SET consumpAmount='" + newAmount + "' , currentDay = now() WHERE memberId ='" +  custId +"'";
						    						System.out.println("updatememsql " + updatememsql);
														stmt = conn.createStatement();
														int updateMemCount = pstmt.executeUpdate(updatememsql);
												}
			            			else
			            			{		            		  //insert a record if this is a new customer.
						            		String insertmeminfosql =
						        			"INSERT INTO" +
						        			" memConsumeInfo(memberId, consumpAmount, currentDay)" +
						        			"VALUES  (?,?,now())";
						        				System.out.println(insertmeminfosql);	        
								            pstmt = conn.prepareStatement(insertmeminfosql);
								            pstmt.setInt(1, Integer.parseInt(custId));
								            pstmt.setString(2, saleTNum);			       					            
								            int insertMemCount = pstmt.executeUpdate();	  
								        }         
				           	}
				           				                        		
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
				           conn.commit();  
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
		JInternalFrame F = new SaleInput();		
	}
}