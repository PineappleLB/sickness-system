package a12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;
public class IconDemo extends JInternalFrame implements ActionListener
{
	Container contentPane;
	Connection conn;
	JTable jtable;
	JDesktopPane desktopPane;
	JButton jb,jb1,jb2,jb3,jb4,jb5;
	
	JLabel label,label1,label2,label3,label4,label5;
	public IconDemo(){
     super("专卖店前台");
	 JFrame jf=new JFrame();
	   contentPane=jf.getContentPane();
      desktopPane=new JDesktopPane();
	  jtable=new JTable();
     Icon icon=new ImageIcon("d://21.jpg");
	  Icon icon1=new ImageIcon("d://22.jpg");
	  Icon icon2=new ImageIcon("d://23.jpg");
	  Icon icon3=new ImageIcon("d://24.jpg");
	  Icon icon4=new ImageIcon("d://25.jpg");
	  Icon icon5=new ImageIcon("d://26.jpg");
       label=new JLabel("步步高运动鞋",icon,SwingConstants.CENTER);
	   label1=new JLabel("宜而爽纹抑菌背",icon1,SwingConstants.CENTER);
	   label2=new JLabel("李宁马裤",icon2,SwingConstants.CENTER);
	   label3=new JLabel("纯棉衬衫",icon3,SwingConstants.CENTER);
	   label4=new JLabel("女士拖鞋",icon4,SwingConstants.CENTER);
	  label5=new JLabel("其海泳帽",icon5,SwingConstants.CENTER);
	  jb=new JButton("添加到购物车");
	   jb1=new JButton("添加到购物车");
	   jb2=new JButton("添加到购物车");
	   jb3=new JButton("添加到购物车");
	  jb4=new JButton("添加到购物车");
	   jb5=new JButton("添加到购物车");
	  JPanel jp=new JPanel();
	  JPanel jp1=new JPanel();
	  JPanel jp2=new JPanel();
	  JPanel jp3=new JPanel();
	  JPanel jp4=new JPanel();
	  JPanel jp5=new JPanel();
      
	  contentPane.setLayout(new GridLayout(3,2));
	  jp.add(label);
	  jp.add(jb);
      jp1.add(label1);
	  jp1.add(jb1);
	  jp2.add(label2);
	  jp2.add(jb2);
	  jp3.add(label3);
	 jp3.add(jb3);
	  jp4.add(label4);
	 jp4.add(jb4);
	  jp5.add(label5);
	  jp5.add(jb5);
      contentPane.add(jp);
	  contentPane.add(jp1);
	  contentPane.add(jp2);
	  contentPane.add(jp3);
	  contentPane.add(jp4);
	  contentPane.add(jp5);
	  jb.addActionListener(this);
	  jb1.addActionListener(this);
	  jb2.addActionListener(this);
	  jb3.addActionListener(this);
	  jb4.addActionListener(this);
	  jb5.addActionListener(this);
      jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  jf.setVisible(true);
	  jf.setBounds(0,0,1000,600);
   
	}
	JButton[] JB={jb,jb1,jb2,jb3,jb4,jb5};
	JLabel[] jl={label,label1,label2,label3,label4,label5};
	String[] col={"产品id","产品名称","产品类别","产品零售价","促销价","会员价","产品供应商"};
	//String[][] str_row = new String[20][7];
	int i =0;
	int k=0;
 public void actionPerformed(ActionEvent e){
	 String cmd=e.getActionCommand();
   
    	
	if(e.getSource()==jb){
	jl[0]=label;
    jl[0].getText();
	}
	
	else if(e.getSource()==jb1){
	
	jl[0]=label1;
    jl[0].getText();
	}
	else if(e.getSource()==jb2){
	
	jl[0]=label2;
    jl[0].getText();
	}
	else if(e.getSource()==jb3){
	
	jl[0]=label3;
    jl[0].getText();
	}
	else if(e.getSource()==jb4){
	
	jl[0]=label4;
    jl[0].getText();
	}
	else if(e.getSource()==jb5){
	
	jl[0]=label5;
    jl[0].getText();
	}
	 

     DefaultTableModel mm = new DefaultTableModel(col,0); 
				   
						if (conn == null) 
						{
    						conn=DataBaseConnection.getConnection();
    						}
						try
						{
                              
			                    System.out.println(jl[k].getText());
								String sql = "SELECT pid,pname,pclass,pprice,prprice,pmember,supplier FROM productInfo where pname='"+jl[k].getText()+"'";
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
								
								System.out.println(sql);
								jtable.setModel(mm);	
                               		
						}
						catch(SQLException e1)
						{
								e1.getStackTrace();
						}
		
	}
         
	public JInternalFrame getIFrame(){
		return this;
	}
				
     public static void main(String[] args) 
	{
		
             new IconDemo(); 
	}
} 