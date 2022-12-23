// Login.java        										Author: Dilara Dündar 22095630
//														    e-mail: dilaradundar2002@gmail.com

//Login sayfasının oluşturulması
package odev;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JOptionPane;


public class Login extends JFrame {
	private JLabel l1,l2;
	private JButton f1;
	private JTextField tf1;
	private JTextField tf2;
	private String adminId="admin";
	private String adminPass="admin";
	MainPage mp;
	AdminPage ap;
	
	public Login() {
		
		f1 = new JButton("Login");
		tf1 = new JTextField(20);
		tf2 = new JPasswordField(20); //Şifre gizleme
		l1=new JLabel("id");
		l2=new JLabel("Sifre");
		
		//l1.setVisible(false);
		
		l1.setForeground(Color.black);
		l2.setForeground(Color.black);
		
		
		Container c = getContentPane();
		SpringLayout layout = new SpringLayout();
		c.setLayout(layout);
		
		
		c.add(f1);
		c.add(l1);
		c.add(tf1);
		c.add(l2);
		c.add(tf2);
		
		
		layout.putConstraint(SpringLayout.WEST, l1, 6, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, l1, 6, SpringLayout.NORTH, c);//L1
	
		layout.putConstraint(SpringLayout.WEST, tf1, 40, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, tf1, 6, SpringLayout.NORTH, c);//TF1
		
		layout.putConstraint(SpringLayout.WEST, l2, 6, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, l2, 30, SpringLayout.NORTH, c);//L2
		
		layout.putConstraint(SpringLayout.WEST, tf2, 40, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, tf2, 30, SpringLayout.NORTH, c);//L1
		
		layout.putConstraint(SpringLayout.WEST, f1, 70, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, f1, 60, SpringLayout.NORTH, c);//f1
		
		
		setTitle("Login");
		setSize(300, 150);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyEventHandler meh = new MyEventHandler();
		f1.addActionListener(meh);
	
		
	}
	public class MyEventHandler extends Database implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			
			if (ae.getSource()==f1) {
				
				String id = tf1.getText().toString();
				String pw = tf2.getText().toString();
				//System.out.println(id);
				if(adminId.equals(id)&& adminPass.equals(pw)) {
					ap=new AdminPage();
				}
				
			for(int i=0;i<clients.size();i++) {
					System.out.println(i);
					try {
						if(clients.get(i).getId().equals(id) && clients.get(i).getPassword().equals(pw)) {
							System.out.println("Basarili Giris");
							dispose();
							mp=new MainPage(clients.get(i));//giriş yapılan kullanıcının hesabından giriş yapılıyor.
						
						}
						
						
					}
					catch(Exception e) {//Type Hatası alma durumunda diye düşündüm
						e.getMessage();
					}
				}
			}
			
			else { 
				 System.exit(0);
			}
		}//action performed
	}//event handler
}
