package a12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContactWe extends JInternalFrame
{
	JFrame jf;
	JPanel jp;
	JTextArea jta;
	JScrollPane jsp;
	String s;
	public ContactWe(){
		jf=new JFrame();
		s="如果有什么需要的话，可以联系我们，电话：12345678910";
		jf.setTitle("联系我们");
		jf.setSize(200,200);
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		jta.setText(s);
		
		jta.setLineWrap(true);
        jta.setEditable(false);
		jp=new JPanel(); 
		jp.add(jta);
		jf.add(jp);
        jp.add(jsp);
	    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
	}
	public JInternalFrame getIFrame(){
		return this;
	}
	public static void main(String[] args) 
	{
		new ContactWe();
	}
}
