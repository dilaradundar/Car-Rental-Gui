// AdminPage.java        										Author: Dilara Dündar 22095630
//														    e-mail: dilaradundar2002@gmail.com

//AdminPage classının tasarımı ve oluşturulması
package odev;
import javax.swing.*;
import java.awt.Container; // awt: abstract windowing toolkit
import java.awt.FlowLayout;
import java.awt.event.*; // ActionListener
import java.io.IOException;

public class AdminPage extends JFrame implements ActionListener {
 
	
	private JButton go,exitB,readFileB;
	private JFrame gui;
	private JTextField valueField;
	String[] arr;
	Login lg;
	String labelData="";
	

	public AdminPage() {
		/*
		 * Create GUI components
		 */
		gui = new JFrame();
		go=new JButton("Generate Report");
		readFileB=new JButton("Read From File");
		
		valueField=new JTextField(110);
		gui.setTitle("AdminPage");		
		gui.setSize(1200, 1200);
		gui.setVisible(true);
		gui.setResizable(false);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = gui.getContentPane();
		c.setLayout(new FlowLayout()); // set layout manager
		c.add(go);
		c.add(readFileB);
		c.add(valueField);
	
		MyEventHandler meh=new MyEventHandler();
		go.addActionListener(meh);        
		readFileB.addActionListener(meh);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitB) {
			lg=new Login();
			gui.setVisible(false); //Ekranı kapatmak istiyorum ama sistemi durdurmak istemiyorum o nedenle setvisible fonk. kullandım
		}
	}
	public class MyEventHandler extends Database implements ActionListener { //Named inner class
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==go) {
				GenerateReport gp =new GenerateReport();
				gp.yaz();
				gp.dosyaYaz();
				
			}
			
			if(ae.getSource()==readFileB) {
				GenerateReport gp =new GenerateReport();
				try {
					arr=gp.dosyaOku();
					labelData="New Data From File  Client Id: "+arr[0]+" Gear Type: "+arr[1]+" Fuel Type: "+arr[2]+" Vehicle Group: "+arr[3]+" Rent Location: "+arr[4]+" Return Location: "+arr[5]+" Rent Date :"+ arr[6]+ "Return Date: "+arr[7];
					valueField.setText(labelData);
				
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	
	
	}
		
}
