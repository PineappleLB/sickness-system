package a12;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*; 
import javax.swing.JInternalFrame;
import java.sql.*;
public class UserNote extends JInternalFrame implements ActionListener
{
	JTextField uid;
	JTextField utitle;
	JTextArea unote;
	JButton jb;
	JButton jb1;
	Container cont;
	JDialog jd;
	JFrame jf;
	Connection conn;
	
	public UserNote(){
	 jf=new JFrame();
	 jf.setTitle("用户留言");
	 jd=new JDialog();
	 cont=jd.getContentPane();
	 jf.setSize(300,200);
	 cont.setLayout(new GridLayout(3,2)); 
	 cont.add(new JLabel("留言标题:",SwingConstants.CENTER));
	 utitle=new JTextField();
	 cont.add(utitle);
	  cont.add(new JLabel("留言内容:",SwingConstants.CENTER));
	 unote=new JTextArea(10,30);
	 this.setBounds(0, 0, 350, 200);
	 cont.add(unote);
	 jb=new JButton("提交");
	  jb1=new JButton("取消");
	 cont.add(jb);
	 cont.add(jb1);
	 jb.addActionListener(this);
	 jb1.addActionListener(this);
	 jd.setBounds(200, 150, 400, 130); 
     jd.getRootPane().setDefaultButton(jb); 
     jd.getRootPane().setDefaultButton(jb1); 
     jd.setVisible(true); 
	 
	}
	public JInternalFrame getIFrame(){
		return this;
	}
 public void actionPerformed(ActionEvent e){
	 String cmd=e.getActionCommand();
	
	 if(cmd.equals("取消")) System.exit(0);
	 if(conn==null){
        conn=DataBaseConnection.getConnection();
	 }
	
     String title=utitle.getText();
	 String note=unote.getText();
     PreparedStatement pstmt;
     int add=0;
	
	 try{
		  if((title.length()!=0)&&(note.length()!=0)&&cmd.equals("提交")){
      String sql="insert into 用户留言(unote,utitle) values(?,?)";
       pstmt=conn.prepareStatement(sql);
	  pstmt.setString(1,title);
	  pstmt.setString(2,note);
	  add=pstmt.executeUpdate();
	   if(add!=0){
		JOptionPane.showMessageDialog(jd,"提交成功","谢谢你的留言!",JOptionPane.INFORMATION_MESSAGE);
		System.out.println("success");
		}
		  }
      else {
         JOptionPane.showMessageDialog(jd,"提交失败","请重新提交!",JOptionPane.WARNING_MESSAGE);
	       }
		  
	 }
	 catch(Exception ex){
		 ex.printStackTrace();
	 } 
 }
 public static void main(String[] args){ 

   new UserNote(); 
}
}