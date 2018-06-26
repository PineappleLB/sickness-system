package a12;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.sql.*;

public class PDownShelfMgmt extends JInternalFrame
{
		protected static String windowTitle = "下架管理";
		Vector idVector, nameVector;
		Container contentPane, tmpPane, tmpPane1, tmpPane2, tmpPane3, tmpPaneCombo, tabAddComponent;
		JLabel pLabel, downReason, dateLabel, personLabel, ptypeLabel, pNum;
		JTextField personField, pNumField;
		JTextArea downReasonArea;
		JButton addB, exitB;
		DateChooserJButton dateField;
		JComboBox pNameCB, ptypeCB;
		JTabbedPane commentTabPane;
		JPanel queryPane;
		
		PDownShelfMgmt(String s)
		{
				super(s);				
				contentPane = this.getContentPane();
				commentTabPane = new JTabbedPane();
				tabAddComponent = new JPanel();
				tabAddComponent.setLayout(new BorderLayout());
				pLabel = new JLabel("产品");
				queryProductInfo();				
				pNameCB = new JComboBox(nameVector);		
				ptypeLabel = new JLabel("类型");
				queryPtype();
				ptypeCB = new JComboBox(typeNameVector); 				
				pNum = new JLabel("数量");
				pNumField = new JTextField();
				pNumField.setColumns(10);				
				personLabel = new JLabel("登记人");
				personField = new JTextField();
				personField.setColumns(10);
				dateLabel = new JLabel("下架日期");
				dateField = new DateChooserJButton();
				//System.out.println(dateField);
				downReason = new JLabel("下架原因");
				downReasonArea = new JTextArea(5,30);
				this.setBounds(0, 0, 350, 200);
				tmpPane = new JPanel();
				tmpPane.setLayout(new FlowLayout());
				tmpPane.add(pLabel);
				tmpPane.add(pNameCB);			
				tmpPane.add(ptypeLabel);
				tmpPane.add(ptypeCB);								
				tmpPane.add(personLabel);
				tmpPane.add(personField);	
				tmpPane1 = new JPanel();	
				tmpPane1.add(pNum);
				tmpPane1.add(pNumField);		
				tmpPane1.add(dateLabel);
				tmpPane1.add(dateField);												
				tmpPaneCombo = new JPanel();
				tmpPaneCombo.setLayout(new GridLayout(2, 1));
				tmpPaneCombo.add(tmpPane);
				tmpPaneCombo.add(tmpPane1);
				tabAddComponent.add(tmpPaneCombo, BorderLayout.NORTH);
				tmpPane2 = new JPanel();
				tmpPane2.add(downReason);
				tmpPane2.add(downReasonArea);
				tabAddComponent.add(tmpPane2, BorderLayout.CENTER);
				addB = new JButton("保存");
				exitB = new JButton("取消");
				addB.addActionListener(
						new ActionListener()
						{
								public void actionPerformed(ActionEvent ae)
								{
										addPDownShelfInfo();										
								}
						});
				exitB.addActionListener(
						new ActionListener()
						{
								public void actionPerformed(ActionEvent ae)
								{
										dispose();
								}
						});
				tmpPane3 = new JPanel();
				tmpPane3.add(addB);
				tmpPane3.add(exitB);
				tabAddComponent.add(tmpPane3, BorderLayout.SOUTH);
				commentTabPane.insertTab("添加下架产品", null, null, "", 0);
				commentTabPane.insertTab("查询下架产品", null, null, "", 1);				
				commentTabPane.setSelectedIndex(0);
				commentTabPane.addChangeListener(
						new ChangeListener()
						{
								public void stateChanged(ChangeEvent ce)
								{
										if (commentTabPane.getSelectedIndex() == 0)
										{
												commentTabPane.setComponentAt(0, tabAddComponent);
												System.out.println(commentTabPane.getSelectedIndex());
										}
										if (commentTabPane.getSelectedIndex() == 1)
										{
												
												System.out.println(commentTabPane.getSelectedIndex());
										}
								}
						});		
				contentPane.add(commentTabPane);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setVisible(true);
				setResizable(true);
		}
		
		public JInternalFrame getIFrame()
		{
				return this;
		}
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rst = null;
		Vector typeIdVector, typeNameVector;
		public void queryPtype()
		{				
				try
				{
					conn = DataBaseConnection.getConnection();
						if (conn == null) return;
    				String queryProcutSql = "SELECT dataId, itemDataName FROM systemdataconfinfo where menuDataName = 'productType' ";
    						System.out.println("queryProcutSql " + queryProcutSql);
						stmt = conn.createStatement();
						rst = stmt.executeQuery(queryProcutSql);
						typeIdVector = new Vector();
						typeNameVector = new Vector();		
						while(rst.next())
						{
								typeIdVector.add(rst.getInt(1));
								typeNameVector.add(rst.getString(2));
						}																				
				}
				catch (SQLException sqle)	
				{
						sqle.printStackTrace();
				}	
		}
		
		public void queryProductInfo()
		{				
				try
				{
					conn = DataBaseConnection.getConnection();
					if (conn == null) return;
    				String queryProcutSql = "SELECT pId, pName FROM productInfo";
    						System.out.println("queryProcutSql " + queryProcutSql);
						stmt = conn.createStatement();
						rst = stmt.executeQuery(queryProcutSql);
						idVector = new Vector();
						nameVector = new Vector();		
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
		
		PreparedStatement pstmt;
		private void addPDownShelfInfo()
		{
				int id = Integer.parseInt(idVector.get(pNameCB.getSelectedIndex()).toString());
				String name = nameVector.get(pNameCB.getSelectedIndex()).toString();
				System.out.println("id:" + id + "name:" + name);
				
				String typeId = typeIdVector.get(ptypeCB.getSelectedIndex()).toString();
				String typeName = typeNameVector.get(ptypeCB.getSelectedIndex()).toString();
				System.out.println("typeIdVectorid:" + typeId + "typeNameVectorname:" + typeName);
				
				String pNumber = pNumField.getText();
				System.out.println("pNumber:" + pNumber);
				
				String person = personField.getText();
				System.out.println("person:" + person);
				
			
				java.util.Date date = dateField.getDate();
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				System.out.println("sqlDate:" + sqlDate);
				
				String content = downReasonArea.getText();
				System.out.println("content:" + content);
				
				conn = DataBaseConnection.getConnection();
				if (conn == null) return;
				try
				{
						String insertPMsql = "INSERT INTO pManagementInfo (pId, ptype, modify, modperson, " + 
								" offShelfState,offShelfNum, offShelfDate, remark)" + 
								"VALUES (? , ?, '0', ?, '1', ?, ?, ?)";
								System.out.println("insertPMsql" + insertPMsql);
						pstmt = conn.prepareStatement(insertPMsql);
						pstmt.setInt(1, id);
						pstmt.setString(2, typeId);
						pstmt.setString(3, person);
						pstmt.setString(4, pNumber);
						pstmt.setDate(5, sqlDate);
						pstmt.setString(6, content);
						int insertCount = pstmt.executeUpdate();
						if (insertCount > 0)
						{
								JOptionPane.showMessageDialog(tabAddComponent, "添加完成!", "完成提示", JOptionPane.INFORMATION_MESSAGE);
						}	
				}
				catch(SQLException se)
				{
						se.printStackTrace();
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
				new PDownShelfMgmt(windowTitle);
		}		
}