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
	jf.setTitle("�û�ע��");
	d=new JDialog();
dialogPane = d.getContentPane(); 
dialogPane.setLayout(new GridLayout(9, 1)); 
dialogPane.add(new JLabel("�û���:", SwingConstants.CENTER)); 
user = new JTextField(); 
dialogPane.add(user); 
dialogPane.add(new JLabel("����:", SwingConstants.CENTER)); 
password = new JPasswordField(); 
dialogPane.add(password); 
dialogPane.add(new JLabel("ȷ������:", SwingConstants.CENTER)); 
qrpassword = new JPasswordField(); 
dialogPane.add(qrpassword); 
dialogPane.add(new JLabel("����:", SwingConstants.CENTER)); 
age = new JTextField(); 
dialogPane.add(age);
dialogPane.add(new JLabel("�Ա�:", SwingConstants.CENTER)); 
sex = new JTextField(); 
dialogPane.add(sex);
dialogPane.add(new JLabel("����:", SwingConstants.CENTER)); 
email = new JTextField(); 
dialogPane.add(email);
dialogPane.add(new JLabel("��ϵ�绰:", SwingConstants.CENTER)); 
telephone = new JTextField(); 
dialogPane.add(telephone);
dialogPane.add(new JLabel("��ͥ��ַ:", SwingConstants.CENTER)); 
address = new JTextField(); 
dialogPane.add(address);

b = new JButton("ע��"); 
b1 = new JButton("�˳�"); 
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
      if(cmd.equals("�˳�")) System.exit(0);
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
		  
		  if (cmd.equals("ע��")){
			  String sql="insert into �û�ע����Ϣ([user],password,qrpassword,age,sex,email,telephone,address) values(?,?,?,?,?,?,?,?)";
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

			JOptionPane.showMessageDialog(d, "ע��ɹ�", "��ʾ��Ϣ", 
         JOptionPane.WARNING_MESSAGE); 
			System.out.println("success");
				}
		  
		  else
          { 
         JOptionPane.showMessageDialog(d, "ע��ʧ��", "������ע��", 
         JOptionPane.WARNING_MESSAGE); 

		  }
		  }else{
              JOptionPane.showMessageDialog(d, "������������Ϣ", "��Ϣ������", 
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