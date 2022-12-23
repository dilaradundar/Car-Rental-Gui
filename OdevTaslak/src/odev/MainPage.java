// MainPage.java        										Author: Dilara Dündar 22095630
//														    e-mail: dilaradundar2002@gmail.com

//MainPage sayfasının oluşturulması
package odev;
import javax.swing.*;
import java.awt.Container; // awt: abstract windowing toolkit
import java.awt.FlowLayout;
import java.awt.event.*; // ActionListener




public class MainPage extends JFrame implements ActionListener {
	
	private JComboBox locationBox,locationBox2;
	
	private JLabel chooseLoc,chooseRetLoc,empt,empt2,empt3;
	private JButton  exitB,choose;
	private JFrame gui;
	Login lg;
	IClient c1;


	public MainPage(IClient client) {
		/*
		 * Create GUI components
		 */
		gui = new JFrame();
		c1=client;
		chooseLoc= new JLabel("Choose rental location");
		chooseRetLoc=new JLabel("Choose return location");
		empt=new JLabel("                ");
		empt2=new JLabel("                                  ");
		empt3=new JLabel("                                      ");
		
		
		//chooseLoc.getText().isEmpty();
		String locations[]= {"Ankara","İstanbul","İzmir"};
		locationBox = new JComboBox(locations);
		locationBox2=new JComboBox(locations);
		locationBox.setBounds(50,50,30,20);
		exitB = new JButton("Exit");
		choose=new JButton("Şehirdeki Arabaları Listele");
	
		
		/*
		 * Add GUI components to container
		 */
		
		gui.setTitle("MainPage");		
		gui.setSize(300, 200);
		gui.setVisible(true);
		gui.setResizable(false);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = gui.getContentPane();
		c.setLayout(new FlowLayout()); // set layout manager

		c.add(chooseLoc);
		c.add(chooseRetLoc);
		c.add(locationBox);
		c.add(empt);
		c.add(locationBox2);
		c.add(empt2);
		c.add(choose);
		c.add(empt3);
		c.add(exitB);	
		
		/*
		 * Add gui component to be listened by the ActionListener
		 */		

		MyEventHandler meh = new MyEventHandler();
		exitB.addActionListener(this);
		locationBox.addActionListener(this);
		choose.addActionListener(meh);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitB) {
			lg=new Login();
			gui.setVisible(false); //Ekranı kapatmak istiyorum ama sistemi durdurmak istemiyorum o nedenle setvisible fonk. kullandım
		}
	}
	

	
	public class MyEventHandler extends Database implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==choose) {
			if(locationBox.getSelectedItem() == "Ankara" && locationBox.getSelectedItem()=="Ankara") {
				
				Reservation rs=new Reservation(locations.get(0),locations.get(0),c1);
				gui.setVisible(false);
			}
			else if(locationBox.getSelectedItem() == "İstanbul" && locationBox.getSelectedItem()=="İstanbul"){
				Reservation rs=new Reservation(locations.get(1),locations.get(1),c1);
				gui.setVisible(false);
			}
			else if(locationBox.getSelectedItem() == "İzmir"&& locationBox.getSelectedItem()=="İzmir"){
				Reservation rs=new Reservation(locations.get(2),locations.get(2),c1);
				gui.setVisible(false);
			}
			else if(locationBox.getSelectedItem() == "Ankara" && locationBox.getSelectedItem()=="İstanbul"){
				Reservation rs=new Reservation(locations.get(0),locations.get(1),c1);
				gui.setVisible(false);
			}
			else if(locationBox.getSelectedItem() == "Ankara"&& locationBox.getSelectedItem()=="İzmir"){
				Reservation rs=new Reservation(locations.get(0),locations.get(2),c1);
				gui.setVisible(false);
			}
			else if(locationBox.getSelectedItem() == "İzmir"&& locationBox.getSelectedItem()=="Ankara"){
				Reservation rs=new Reservation(locations.get(2),locations.get(0),c1);
				gui.setVisible(false);
			}
			else if(locationBox.getSelectedItem() == "İzmir" && locationBox.getSelectedItem()=="İstanbul"){
				Reservation rs=new Reservation(locations.get(2),locations.get(1),c1);
				gui.setVisible(false);
			}
			else if(locationBox.getSelectedItem() == "İstanbul"&& locationBox.getSelectedItem()=="İzmir"){
				Reservation rs=new Reservation(locations.get(1),locations.get(2),c1);
				gui.setVisible(false);
			}
			else if(locationBox.getSelectedItem() == "İstanbul"&& locationBox.getSelectedItem()=="Ankara"){
				Reservation rs=new Reservation(locations.get(1),locations.get(0),c1);
				gui.setVisible(false);
			}
			
			}
			
		}
	
	
	}
}
