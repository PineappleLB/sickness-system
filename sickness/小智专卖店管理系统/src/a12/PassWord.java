package a12;
import javax.swing.UIManager; 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.border.*; 
import java.sql.*;
public class PassWord extends JFrame implements ActionListener
{ 
		Connection conn = null;
		JTextField user; 
		JPasswordField passWd; 
		JButton b1, b2; 
		Container framePane,Panel1,Panel2,Panel3,Panel4,Panel5; 
		JDialog d; 	
		JFrame frame; 
		JLabel label1, label2;
		Font font1, font2;
		Dimension dim1;
		int count = 0;
		private static String systemTitle = "���򼲲����ϵͳ";		
		/** Construct the application */ 
		public PassWord()
		{ 
			setTitle("��¼����"); 
			framePane = getContentPane();
			GridBagLayout gridbag = new GridBagLayout();
     	GridBagConstraints c = new GridBagConstraints();
     	setFont(new Font("SansSerif", Font.PLAIN, 14));
     	framePane.setLayout(gridbag);
     	MakeComponent mc = new MakeComponent();			
			c.gridy = 0;
			c.gridwidth = 6;
			c.gridheight = 1;
			c.weighty = 1;
			c.anchor = GridBagConstraints.CENTER;
			label1 = mc.makeJLabel(framePane, systemTitle, gridbag, c);
			font1 = new Font("labelName", Font.BOLD, 30);
			label1.setFont(font1);			
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.anchor = GridBagConstraints.WEST;
			c.insets = new Insets(0, 2, 0, 0);
			label1 = mc.makeJLabel(framePane,"��¼����: ", gridbag, c); 
			c.gridx = 1;
			c.gridwidth = 10;
			user = mc.makeJTextField(framePane,"", gridbag, c); 
			user.setColumns(10);			
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 4;
			c.gridheight = 1;
			label1 = mc.makeJLabel(framePane,"�û�����: ", gridbag, c); 
			c.gridx = 1;
			c.gridwidth = 10;
			passWd = mc.makeJPasswordField(framePane,"", gridbag, c);
			passWd.setColumns(10); 		    
	    c.gridx = 0;
	    c.gridy = 3;
	    c.gridwidth = 10;
	    c.anchor = GridBagConstraints.WEST;
	    c.insets = new Insets(0, 0, 0, 0);
			b1 = mc.makeJButton(framePane, "ȷ��", gridbag, c);
			c.gridx = 1;
			c.gridy = 3;
			c.anchor = GridBagConstraints.EAST;
			b2 = mc.makeJButton(framePane, "ȡ��", gridbag, c);			
			c.gridy = 4;
			c.gridx = 0;
			c.anchor = GridBagConstraints.WEST;
			label2 = mc.makeJLabel(framePane, "ע�⣺��ʼ�û���admin����123", gridbag, c);
			font2 = new Font("labelName", Font.BOLD, 12);
			label2.setFont(font2);
			b1.addActionListener(this); 
			b2.addActionListener(this); 
			setBounds(200, 150, 325, 240); 
			getRootPane().setDefaultButton(b1); 
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true); 
		} 
		
		public void actionPerformed(ActionEvent e) 
		{ 
				String cmd = e.getActionCommand(); 
				
				conn = DataBaseConnection.getConnection();
				if (conn == null) return;
				
				String name = user.getText(); 
				char[] passWord = passWd.getPassword(); 
				String passwd = new String(passWord);
				Statement stmt = null;
		    ResultSet rst = null;
		      int flag = 0;
			try {
		        if ((name.length() != 0) && (passwd.length() != 0) && cmd.equals("ȷ��")){		        		
	String sql = "select * from sysadmin where username='" + name +"' and pwd ='" + passwd + "'";
		        		System.out.println(sql);		        
		            stmt = conn.createStatement();
		            rst = stmt.executeQuery(sql);		                        		
		 if (rst.next()) {
		     System.out.println("Welcome! Byby");
		       flag = 1;
		         JFrame F = new ManagementMenu(); 
		          dispose();
		            } 
           else {
	JOptionPane.showMessageDialog(d, "�û������������", "����������", 
		JOptionPane.WARNING_MESSAGE); 
			flag = 2;
			count ++;		//System.out.println(count);
		if (count >= 3)	{
		JOptionPane.showMessageDialog(d, "���󳬹����Σ�ϵͳ�Զ��ر�", "�����µ�¼", 
		JOptionPane.WARNING_MESSAGE);
		System.exit(0);
		}												//System.out.println("cuowu");
		user.setText(""); 
		passWd.setText(""); 
		            }
		        } 
		    		else if (cmd.equals("ȡ��")) System.exit(0); 
			else {
			 JOptionPane.showMessageDialog(d, "�û������������", "����������", 
					JOptionPane.WARNING_MESSAGE); 
					flag = 3;
				count ++;
					System.out.println(count);
						if (count >= 3){
						JOptionPane.showMessageDialog(d, "���󳬹����Σ�ϵͳ�Զ��ر�", "�����µ�¼", 
						JOptionPane.WARNING_MESSAGE);
							System.exit(0);
										}
								 }
         } 
         catch (SQLException ex) {
            ex.printStackTrace();
         } 
         finally{
            if ((flag != 2) && (flag != 3))
            new Close(rst, stmt, conn).release();
         }							    
		} 	
		public static void main(String[] args){ 	
				new PassWord(); 
		}
}
