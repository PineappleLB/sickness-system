package a12;
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.border.*; 
import java.sql.*;
public class Regeister extends JInternalFrame implements ActionListener{ 
JTextField user; 
JPasswordField password;
JPasswordField qrpassword;
JTextField age;
JTextField sex;
JTextField email;
JTextField telephone;
JTextField address;
JButton b ,b1; 
Container dialogPane; 
JDialog d; 
JOptionPane jop;
JFrame jf; 
Connection conn=null;


/** Construct the application */ 
public Regeister(){ 
	jf=new JFrame();
	jf.setTitle("用户注册");
	d=new JDialog();
dialogPane = d.getContentPane(); 
dialogPane.setLayout(new GridLayout(9, 1)); 
dialogPane.add(new JLabel("用户名:", SwingConstants.CENTER)); 
user = new JTextField(); 
dialogPane.add(user); 
dialogPane.add(new JLabel("密码:", SwingConstants.CENTER)); 
password = new JPasswordField(); 
dialogPane.add(password); 
dialogPane.add(new JLabel("确认密码:", SwingConstants.CENTER)); 
qrpassword = new JPasswordField(); 
dialogPane.add(qrpassword); 
dialogPane.add(new JLabel("年龄:", SwingConstants.CENTER)); 
age = new JTextField(); 
dialogPane.add(age);
dialogPane.add(new JLabel("性别:", SwingConstants.CENTER)); 
sex = new JTextField(); 
dialogPane.add(sex);
dialogPane.add(new JLabel("邮箱:", SwingConstants.CENTER)); 
email = new JTextField(); 
dialogPane.add(email);
dialogPane.add(new JLabel("联系电话:", SwingConstants.CENTER)); 
telephone = new JTextField(); 
dialogPane.add(telephone);
dialogPane.add(new JLabel("家庭地址:", SwingConstants.CENTER)); 
address = new JTextField(); 
dialogPane.add(address);

b = new JButton("注册"); 
b1 = new JButton("退出"); 
dialogPane.add(b); 
dialogPane.add(b1);
b.addActionListener(this); 
b1.addActionListener(this);
d.setBounds(50, 300, 300, 280); 
d.getRootPane().setDefaultButton(b); 
d.getRootPane().setDefaultButton(b1);
d.setVisible(true); 

} 
public void actionPerformed(ActionEvent e) 
{ 

String cmd = e.getActionCommand(); 
conn = DataBaseConnection.getConnection();
	if(conn==null) return;
      if(cmd.equals("退出")) System.exit(0);
	  String name=user.getText();
	  String passwd=password.getText();
	  String passwd1=qrpassword.getText();
	  int age1=Integer.parseInt(age.getText().toString());
	  String sex1=sex.getText();
	  String email1=email.getText();
	  String telephone1=telephone.getText();
	  String address1=address.getText();
	  PreparedStatement pstmt=null;
	  //ResultSet rst;
	  int flag=0;
	  try{
		  
		  if (cmd.equals("注册")){
			  String sql="insert into 用户注册信息([user],password,qrpassword,age,sex,email,telephone,address) values(?,?,?,?,?,?,?,?)";
			 pstmt = conn.prepareStatement(sql);
                   pstmt.setString(1, name);
				   pstmt.setString(2, passwd);
				   pstmt.setString(3, passwd1);
				   pstmt.setInt(4, age1);
				   pstmt.setString(5, sex1);
			       pstmt.setString(6, email1);
				   pstmt.setString(7, telephone1);
				   pstmt.setString(8, address1);
						            
			  flag=pstmt.executeUpdate(); 
		        if(flag!=0){

			JOptionPane.showMessageDialog(d, "注册成功", "提示信息", 
         JOptionPane.WARNING_MESSAGE); 
			System.out.println("success");
				}
		  
		  else
          { 
         JOptionPane.showMessageDialog(d, "注册失败", "请重新注册", 
         JOptionPane.WARNING_MESSAGE); 

		  }
		  }else{
              JOptionPane.showMessageDialog(d, "请输入完整信息", "信息不完整", 
         JOptionPane.WARNING_MESSAGE); 
		  }
				}  
				catch(Exception ex){
					 ex.printStackTrace();
				}
	  
//d.show(); 

	  }
	  public JInternalFrame getIFrame(){
		return this;
	}
public static void main(String[] args){ 

new Regeister(); 
}
}