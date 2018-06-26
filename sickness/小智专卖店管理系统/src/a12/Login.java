package a12;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class Login extends JInternalFrame implements ActionListener {
	JTextField user;
	JPasswordField passWd;
	JButton b1;
	JButton b2;
	Container dialogPane;
	JDialog d;
	JDesktopPane jdp;
	Connection conn;
	JFrame jf;
	Statement stmt;
	ResultSet rst;
	int flag = 0;

	/** Construct the application */
	public Login() {
		jf = new JFrame();
		jf.setTitle("�û���½");
		d = new JDialog();
		jdp = new JDesktopPane();
		// d.setTitle("�û���½");
		dialogPane = d.getContentPane();
		dialogPane.setLayout(new GridLayout(3, 2));
		dialogPane.add(new JLabel("�û���:", SwingConstants.CENTER));
		user = new JTextField();
		dialogPane.add(user);
		dialogPane.add(new JLabel("�� ��:", SwingConstants.CENTER));
		passWd = new JPasswordField();
		dialogPane.add(passWd);
		b1 = new JButton("��¼");
		b2 = new JButton("ע��");
		dialogPane.add(b1);
		dialogPane.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		d.setBounds(200, 150, 400, 130);
		d.getRootPane().setDefaultButton(b1);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setVisible(true);
	}

	public JInternalFrame getIFrame() {
		return this;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (conn == null) {
			conn = DataBaseConnection.getConnection();
		}
		String name = user.getText();

		String passwd = passWd.getText();

		try {
			if ((name.length() != 0) && (passwd.length() != 0) && cmd.equals("��¼")) {
				String sql = "select user,password from register";
				stmt = conn.createStatement();
				rst = stmt.executeQuery(sql);
				if (rst.next()) {
					System.out.println("success!");
					flag = 1;
				}

				else {
					JOptionPane.showMessageDialog(d, "�û������������", "����������", JOptionPane.WARNING_MESSAGE);
				}
			} else if (e.getSource() == b2) {
				System.out.println("***");
				JInternalFrame registerF = new Regeister().getIFrame();
				jdp.add(registerF);
				jdp.setSelectedFrame(registerF);
			}

			else {
				JOptionPane.showMessageDialog(d, "�㻹û��ע��", "��ע��", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new Login();
	}
}