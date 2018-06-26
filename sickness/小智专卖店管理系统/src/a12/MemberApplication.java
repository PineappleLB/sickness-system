package a12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JInternalFrame;
import javax.swing.border.*; 
import java.sql.*;
public class MemberApplication extends JInternalFrame
{
  JTextField mid;
  JTextField muser;
  JTextField apptitle;
  JTextField application;
  JButton jb;
  JButton jb1;
  Container cont;
  JDialog jd;
  JFrame jf;
  Connection conn;
	public MemberApplication(){
     jf=new JFrame();
	 jf.setTitle("会员申请");
	 jf.setSize(600,400);
     jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	 jd=new JDialog();
	 cont=jd.getContentPane();
	 cont.setLayout(new GridLayout(3,2)); 
	 cont.add(new JLabel("会员id:",SwingConstants.CENTER));
	 mid=new JTextField();
	 cont.add(mid);
	 cont.add(new JLabel("会员名:",SwingConstants.CENTER));
	 muser=new JTextField();
	 cont.add(muser);
	 jb=new JButton("提交申请");
	 jb1=new JButton("取消");
	 cont.add(jb);
	 cont.add(jb1);
	 jb.addActionListener(new ActionListener()
						{
								public void actionPerformed(ActionEvent ae)
								{
										addContent();										
								}
						});
	 jb1.addActionListener(new ActionListener()
						{
								public void actionPerformed(ActionEvent ae)
								{
										System.exit(0);									
								}
						});
	 jd.setBounds(200, 150, 400, 130); 
     jd.getRootPane().setDefaultButton(jb); 
     jd.getRootPane().setDefaultButton(jb1); 

     jd.setVisible(true); 
	 this.jf=jf;
	 
	}
	public JInternalFrame getIFrame(){
		return this;
	}
 
 PreparedStatement pstmt=null;
 private void addContent(){
      
	  if(conn==null){
		  conn=DataBaseConnection.getConnection();
	  }
      int id=Integer.parseInt(mid.getText());
	  String user=muser.getText();
	  String aptitle=apptitle.getText();
	  String app=application.getText();
	  try{
          String sql="insert into member_sq(mid,[muser]) values(?,?,?,?)";
		  System.out.println(sql);
		  pstmt=conn.prepareStatement(sql);
		  pstmt.setInt(1,id);
		  pstmt.setString(2,user);
		  pstmt.setString(3,aptitle);
		  pstmt.setString(4,app);
		  int addCount=pstmt.executeUpdate();
		  if(addCount>0){
          JOptionPane.showMessageDialog(jd, "提交成功!", "完成提示", JOptionPane.INFORMATION_MESSAGE);
		  System.out.println("insert success");
		  }
		  else{
          JOptionPane.showMessageDialog(jd,"提交失败","请重新提交!",JOptionPane.WARNING_MESSAGE);
		  }
	  }
	  catch(Exception e){
         
	  }
 }
 public static void main(String[] args){ 

  new MemberApplication(); 
}
}