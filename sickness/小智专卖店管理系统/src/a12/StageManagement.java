package a12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;
public class StageManagement extends JFrame implements ActionListener
{   private static final String IconDemo = null;
JMenuItem shopcart;
    JScrollPane jsp;
	JDesktopPane desktopPane;
	JMenuItem ma,ms,usernote;
	JMenu pricecenter;
	JMenuBar MBar;
	Container contentPane;
	JButton jb,jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb11,jb12;
	JTable jtable=new JTable();;
	File file;
	JLabel label,label1,label2,label3,label4,label5;
	PreparedStatement stmt;
	Connection conn;
	ResultSet rs;
	public StageManagement(){
      super("���򼲲����ϵͳǰ̨");
	   contentPane=getContentPane();
      MBar = new JMenuBar();
	  jsp=new JScrollPane();
      Icon icon=new ImageIcon("2.jpg");
	  Icon icon1=new ImageIcon("3.jpg");
	  Icon icon2=new ImageIcon("4.jpg");
	  Icon icon3=new ImageIcon("5.jpg");
	  Icon icon4=new ImageIcon("6.jpg");
	  Icon icon5=new ImageIcon("7.jpg");
      label=new JLabel("�������˶�Ь",icon,SwingConstants.CENTER);
	  label1=new JLabel("�����˶�Ь",icon1,SwingConstants.CENTER);
	  label2=new JLabel("�������",icon2,SwingConstants.CENTER);
	  label3=new JLabel("��˳���",icon3,SwingConstants.CENTER);
	  label4=new JLabel("��ľ�����",icon4,SwingConstants.CENTER);
	  label5=new JLabel("��˳����",icon5,SwingConstants.CENTER);
	   jb=new JButton("����ͼ��");
       jb5=new JButton("����ͼ��");
	   jb6=new JButton("����ͼ��");
	   jb7=new JButton("����ͼ��");
	   jb8=new JButton("����ͼ��");
	   jb9=new JButton("����ͼ��");
	   
	  jb1=new JButton("������Ϣ");
	  jb2=new JButton("������Ϣ");
	  jb3=new JButton("������Ϣ");
	  jb4=new JButton("������Ϣ");
	  jb11=new JButton("������Ϣ");
	  jb12=new JButton("������Ϣ");
	  JPanel jp=new JPanel();
	  JPanel jp1=new JPanel();
	  JPanel jp2=new JPanel();
	  JPanel jp3=new JPanel();
      JPanel jp4=new JPanel();
	  JPanel jp5=new JPanel();
	  
	  jp.add(label);
	 jp.add(jb);
	  jp.add(jb1);
      jp1.add(label1);
	  jp1.add(jb5);
	  jp1.add(jb2);
	  jp2.add(label2);
	  jp2.add(jb6);
	  jp2.add(jb3);
	  jp3.add(label3);
	  jp3.add(jb7);
	  jp3.add(jb4);
	  jp4.add(label4);
	  jp4.add(jb8);
	  jp4.add(jb11);
	  jp5.add(label5);
	  jp5.add(jb9);
	  jp5.add(jb12);
	  contentPane.setLayout(new FlowLayout());
      contentPane.add(jp);
	  contentPane.add(jp1);
	  contentPane.add(jp2);
	  contentPane.add(jp3);
	  contentPane.add(jp4);
	  contentPane.add(jp5);
	  contentPane.add(jsp,BorderLayout.CENTER);
	  jb.addActionListener(this);
	  jb1.addActionListener(this);
	  jb2.addActionListener(this);
	  jb3.addActionListener(this);
	  jb4.addActionListener(this);
	  jb5.addActionListener(this);
	  jb6.addActionListener(this);
	 jb7.addActionListener(this);
	  jb8.addActionListener(this);
	  jb9.addActionListener(this);
	  jb11.addActionListener(this);
	  jb12.addActionListener(this);
	  setVisible(true);
	  setBounds(0,0,1000,600);
   
	  JMenu useradmin = new JMenu("�������");
	  JMenuItem ma=new JMenuItem("����ע��");
	  JMenu admin=new JMenu("��̨����");
	  JMenuItem aadmin=new JMenuItem("����Ա����");
	  JMenuItem ms=new JMenuItem("��Ա����");
	  JMenu browsepro=new JMenu("�����Ϣ");
	  JMenu pricecenter=new JMenu("");
      JMenuItem shopcart=new JMenuItem("��ѯ��Ϣ");
	 
	  
	 //JMenuItem shophelp=new JMenuItem("����");
	  //JMenu shopguide=new JMenu("����ָ��");
	  
	 
      JMenu feedback=new JMenu("���Է���");
	  JMenuItem usernote=new JMenuItem("�û�����");
	  JMenu  aboutour=new JMenu("��������");
	  JMenuItem contactwe=new JMenuItem("��ϵ����");
     
     
      useradmin.add(ma);
      useradmin.addSeparator();
      useradmin.add(ms);
	  feedback.add(usernote);
	  aboutour.add(contactwe);
	  admin.add(aadmin);
	 desktopPane=new JDesktopPane();
	  contentPane.add(desktopPane); 
        setSize(350, 350); 
    
	  MBar.add(useradmin);
	  MBar.add(admin);
	  MBar.add(browsepro);  
	  browsepro.add(shopcart);
	
	  //shopguide.add(shophelp);
	  //MBar.add(pricecenter);

	  MBar.add(feedback);  
	  //MBar.add(shopguide);  
	 
	  MBar.add(aboutour); 
	  setJMenuBar(MBar);  
	 desktopPane = new JDesktopPane();
	add(desktopPane);
	  
	setBounds(0, 0, 800, 400);
     
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setVisible(true);
	  
	  addWindowListener(
	  	new WindowAdapter() 
	  	{
		    public void windowClosing(WindowEvent e) 
		    {
		      System.exit(0); 
		    }
	  });	  
	  setVisible(true);
      shopcart.addActionListener(
	  		new ActionListener()
	  		{
	  				public void actionPerformed(ActionEvent ae)
	  				{
	  						creatSCFrame();
	  				}
	  		}
	  );
	  
	  
	  ma.addActionListener(
	  		new ActionListener()
	  		{
	  				public void actionPerformed(ActionEvent ae)
	  				{
	  						creatMemberMFrame();
	  				}
	  		}
	  );	
	  ms.addActionListener(
	  		new ActionListener()
	  		{
	  				public void actionPerformed(ActionEvent ae)
	  				{
	  						creatMemberAFrame();
	  				}
	  		}
	  ); 
	 usernote.addActionListener(
	  		new ActionListener()
	  		{
	  				public void actionPerformed(ActionEvent ae)
	  				{
	  						creatMemberUNFrame();
	  				}
	  		}
	  ); 
	 /* shophelp.addActionListener(
	  		new ActionListener()
	  		{
	  				public void actionPerformed(ActionEvent ae)
	  				{
	  						creatShopGIFrame();
	  				}
	  		}
	  ); */
	  
	  contactwe.addActionListener(
		     new ActionListener()
		    {
		             public void actionPerformed(ActionEvent ae)
				    {
                             createContactFrame();
					}
	        }
	 );
	  aadmin.addActionListener(
		     new ActionListener()
		    {
		             public void actionPerformed(ActionEvent ae)
				    {
                             createADFrame();
					}
	        }
	 );
	}
  
String[] col={"��Ʒid","��Ʒ����","��Ʒ���","��Ʒ���ۼ�","������","��Ա��","��Ʒ��Ӧ��"};
JLabel[] jl={label,label1,label2,label3,label4,label5};
int k=0;
int i=0;
	 public void actionPerformed(ActionEvent e){
		 String cmd = e.getActionCommand(); 
     if(cmd.equals("����")){
        
        JInternalFrame createIc = new IconDemo().getIFrame(); 		
  		desktopPane.add(createIc);
  		desktopPane.setSelectedFrame(createIc);
		 }   
	  else if(e.getSource()==jb1){
	jl[0]=label;
    jl[0].getText();
	}
	
	else if(e.getSource()==jb2){
	
	jl[0]=label1;
    jl[0].getText();
	}
 else if(e.getSource()==jb3){
	
	jl[0]=label2;
    jl[0].getText();
	}
	 else if(e.getSource()==jb4){
	
	jl[0]=label3;
    jl[0].getText();
	}
	 else if(e.getSource()==jb11){
	
	jl[0]=label4;
    jl[0].getText();
	}
	else if(e.getSource()==jb12){
	
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
  private void creatSCFrame()
  {   System.out.println("creatSCFrame");
  		JInternalFrame createSCF = new Shopping().getIFrame(); 		
  		desktopPane.add(createSCF);
  		desktopPane.setSelectedFrame(createSCF);
  }
  private void creatMemberMFrame()
  {   System.out.println("creatMemberMFrame");
  		JInternalFrame createMF = new Regeister().getIFrame(); 		
  		desktopPane.add(createMF);
  		desktopPane.setSelectedFrame(createMF);
  }
  private void creatMemberAFrame()
  {   System.out.println("creatMemberAFrame");
  		JInternalFrame createMAF = new MemberApplication().getIFrame(); 		
  		desktopPane.add(createMAF);
  		desktopPane.setSelectedFrame(createMAF);
  }
  private void creatMemberUNFrame(){
   System.out.println("creatMemberUNFrame");
  		JInternalFrame createMUNF = new UserNote().getIFrame(); 		
  		desktopPane.add(createMUNF);
  		desktopPane.setSelectedFrame(createMUNF);
  }
  private void creatShopGIFrame(){
   System.out.println("creatShopGIFrame()");
  		//JInternalFrame createShopGF = new ShopGuide().getIFrame(); 		
  		//desktopPane.add(createShopGF);
  		//desktopPane.setSelectedFrame(createShopGF);
  }
  private void creatUserLFrame(){
   System.out.println("creatUserLFrame()");
  		JInternalFrame createUserLoF = new Login().getIFrame(); 		
  		desktopPane.add(createUserLoF);
  		desktopPane.setSelectedFrame(createUserLoF);
  }
   private void createContactFrame(){
   System.out.println("createContactFrame()");
  		JInternalFrame createConF = new ContactWe().getIFrame(); 		
  		desktopPane.add(createConF);
  		desktopPane.setSelectedFrame(createConF);
  }
   private void createADFrame(){
   System.out.println("createADFrame()");
  		JFrame createAF = new PassWord(); 		
  		
  }
	public static void main(String[] args) 
	{
		
             JFrame F=new StageManagement(); 
	}
}
