package a12;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.*;
import java.sql.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;
public class Shopping extends JInternalFrame implements ActionListener
{
	
	JComboBox combo;
	JTextField tf;
	JButton jb,qButton;
	JFrame jf;
	JDialog jd;
	JOptionPane jop;
	JLabel jlabel,jlabel2,jlabel3;
    JTable jtable;
    JPanel pn1;
    JScrollPane jscrollpane;
	JDesktopPane desktopPane;
    PreparedStatement pstmt;
	
    Connection conn = null;
	ResultSet rst;
	String sql;
	public Shopping(){
		 jf=new JFrame("news");
		 jf.setSize(500,300);
		 jd=new JDialog();
		 jop=new JOptionPane();
		
         desktopPane=new JDesktopPane();
		 jlabel = new JLabel("请输入信息名称");
		 jlabel2 = new JLabel("信息名称");
		 jtable = new JTable();
		 combo=new JComboBox();
		 jscrollpane = new JScrollPane(jtable);
		 qButton = new JButton("查询");
		 tf = new JTextField();
		 pn1 = new JPanel();    
		pn1.setLayout(new FlowLayout());
				pn1.add(jlabel2);
				tf.setColumns(7);
				pn1.add(tf);
				pn1.add(qButton);
		    
				jf.setLayout(new BorderLayout());
				jf.add(jlabel,BorderLayout.NORTH);
				jf.add(jscrollpane,BorderLayout.CENTER);
				jf.add(pn1,BorderLayout.SOUTH);
				  
				qButton.addActionListener(this);
				jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
				jf.setVisible(true);
		         jf.show();
	}

	String[] col={"产品id","产品名称","产品类别","产品零售价","促销价","会员价","产品供应商"};
	
public void actionPerformed(ActionEvent e) 
		{
				if(e.getSource()==qButton)
				{
                      
						DefaultTableModel mm = new DefaultTableModel(col,0); 
				   
						if (conn == null) 
						{
    						conn=DataBaseConnection.getConnection();
    						}
						try
						{
								System.out.println(tf.getText());
								String sql = "SELECT pid,pname,pclass,pprice,prprice,pmember,supplier FROM productInfo where pname='"+tf.getText()+"'";
								 System.out.println(sql);
								Statement stmt = conn.createStatement();
								ResultSet rst = stmt.executeQuery(sql);
								while(rst.next())
								{
										String pid = rst.getString("pid");
										
										String pname = rst.getString("pname");
										String pclass = rst.getString("pclass");
										String pprice = rst.getString("pprice");
										String prprice = rst.getString("prprice");
										String  pmember = rst.getString("pmember");
										String supplier = rst.getString("supplier");
										
										String[] str_row={pid, pname, pclass, pprice,prprice,pmember,supplier};
										mm.addRow(str_row);
								}
								jtable.setModel(mm);								
								
						}
						catch(SQLException e1)
						{
								e1.getStackTrace();
						}
						
				}
		}
		
public JInternalFrame getIFrame(){
		return this;
	}
public static void main(String[] args)
		{
				
				new Shopping();
		}		
}
