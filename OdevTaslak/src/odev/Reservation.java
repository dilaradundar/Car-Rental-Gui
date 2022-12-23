// Reservation.java        										Author: Dilara Dündar 22095630
//														    e-mail: dilaradundar2002@gmail.com

//Rezervasyon işlemlerinin gerçekleştirilmesini sağlayan classın tanımlanması
package odev;
import javax.swing.*;
import javax.swing.JOptionPane;

import java.awt.Container; // awt: abstract windowing toolkit
import java.awt.FlowLayout;
import java.awt.event.*; // ActionListener
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation extends JFrame  {
		
		private JLabel car1,car2,car3,car4,car5,car6,car7,car8,car9,car10,price,empt1,empt2,empt3,empt4,rentDate,returnDate;
		private JTextField priceBox;
		private JButton but1,but2,but3,but4,verify,exit;
		private JFrame gui;
		private JCheckBox roof,trailer,snowChains,navigation,childSeat;
		private JTextField date1,date2;
		float total=0;
		float[] totalArr=new float[20];
		MainPage mg;
		IClient c1;
		String l1,l2;
	

		public Reservation(ILocation loc,ILocation loc2,IClient client) {
			/*
			 * Create GUI components
			 */
			l1=loc.getNameCity();
			l2=loc2.getNameCity();
			gui = new JFrame();
			c1=client;
			priceBox = new JTextField(20);
			car1=new JLabel();
			car2=new JLabel();
			car3=new JLabel();
			car4=new JLabel();
			car5=new JLabel();
			car6=new JLabel();
			car7=new JLabel();
			car8=new JLabel();
			car9=new JLabel();
			car10=new JLabel();
			exit=new JButton("exit");
			but1=new JButton("Rent");
			but2=new JButton("Rent");
			but3=new JButton("Rent");
			but4=new JButton("Rent");
			
			verify=new JButton("Verify Reservation");
			priceBox.setEditable(false);
			rentDate=new JLabel(" Enter your rental date (dd mm yy)");
			returnDate=new JLabel("  Enter your return date (dd mm yy)");
			price=new JLabel("Your Total Fee ");
			empt1=new JLabel("                ");
			empt2=new JLabel("   -    ");
			empt3=new JLabel(" -                                                                                                                                ");
			empt4=new JLabel("                                                                                          -");
			JButton butArr[]= {but1,but2,but3,but4};
			JLabel labArr[]= {car1,car2,car3,car4,car5,car6,car7,car8,car9,car10};
			roof=new JCheckBox("Roof Rack (+500 TL)");
			trailer=new JCheckBox("Trailer (+1500 TL)");
			snowChains=new JCheckBox("Snow Chains (+200 TL)");
			navigation=new JCheckBox("Navigation (+150 TL)");
			childSeat=new JCheckBox("Child Seat (+100 TL)");
			date1=new JTextField(10);
			date2=new JTextField(10);
			
			/*
			 * Add GUI components to container
			 */
			
			gui.setTitle("Reservation");		
			gui.setSize(790, 400);
			gui.setVisible(true);
			gui.setResizable(false);
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Container c = gui.getContentPane();
			c.setLayout(new FlowLayout()); // set layout manager
			
			c.add(rentDate);
			c.add(returnDate);
			c.add(empt4);
			c.add(date1);
			c.add(empt2);
			c.add(date2);
			c.add(empt3);
			c.add(trailer);
			c.add(roof);
			c.add(snowChains);
			c.add(navigation);
			c.add(childSeat);
			c.add(empt1);
			
			
			for(int i=0;i<loc.getCars().size();i++) {
				labArr[i].setText(loc.getCars().get(i).toString());
				
			}
			for(int i=0;i<loc.getCars().size();i++) {
				c.add(labArr[i]);
				c.add(butArr[i]);
				
			}
			
			c.add(price);
			c.add(priceBox);
			c.add(verify);
			c.add(exit);
			exit.addActionListener(
					new ActionListener() { //Somutlaştırma Anonymous Inner Class
						 public void actionPerformed(ActionEvent e) {//Exit butonuna<< Basılınca
							 if (e.getSource() == exit) {
									mg=new MainPage(c1);//Main Page'e geri dönülüyor.
									gui.setVisible(false); //Ekranı kapatmak istiyorum ama sistemi durdurmak istemiyorum o nedenle setvisible fonk. kullandım
								}
						 }
					}
				);
			for(int i=0;i<loc.getCars().size();i++) {
			
				 if( loc.getCars().get(i).getRentStatus()==false) {// Araba kiralanmış ise 
					 butArr[i].setVisible(false);
					// System.out.println("You can not rent this car");
				 }
				
			}
			 
			
			but1.addActionListener(
						new ActionListener() { //Somutlaştırma Anonymus Inner Class
							 public void actionPerformed(ActionEvent e) {//Kiralaya Basılınca
								 if(loc.getCars().get(0).getPriceLevel().equals("high price")) {
									 System.out.println("high");
									 long days=DateCalculate(date1.getText(),date2.getText());
									 
									 total=days*200;
									 if(roof.isSelected()) {
										 total=total+500;
									 }if(trailer.isSelected()) {
										 total=total+1500;
									 }
								
									 priceBox.setText(String.valueOf(total));
									 System.out.println(total);
									 
									 
								 }else if(loc.getCars().get(0).getPriceLevel().equals("middle price")) {
									 System.out.println("med");
									 long days=DateCalculate(date1.getText(),date2.getText());
									
									 total=days*150;
									 if(roof.isSelected()) {
										 total=total+500;
									 }if(trailer.isSelected()) {
										 total=total+1500;
									 }if(snowChains.isSelected()) {
										 total=total+200;
									 }if(navigation.isSelected()) {
										 total=total+150;
									 }if(childSeat.isSelected()) {
										 total=total+100;
									 }
									 priceBox.setText(String.valueOf(total));
									 System.out.println(total);
									
									 
								 }else if(loc.getCars().get(0).getPriceLevel().equals("low price")) {
									 System.out.println("low");
									 long days=DateCalculate(date1.getText(),date2.getText());
									 total=days*100;
									 if(roof.isSelected()) {
										 total=total+500;
									 }if(trailer.isSelected()) {
										 total=total+1500;
									 }if(snowChains.isSelected()) {
										 total=total+200;
									 }if(navigation.isSelected()) {
										 total=total+150;
									 }if(childSeat.isSelected()) {
										 total=total+100;
									 }
									 priceBox.setText(String.valueOf(total));
									 System.out.println(total);
									 
								 }
								 verify.addActionListener(new ActionListener() { //Somutlaştırma Anonymus Inner Class
									 public void actionPerformed(ActionEvent e) { //Kiralaya Basılınca
										 int rentNum=0;//Kullanıcı kaç araba kiralamış
										// System.out.println("calisti");
										 rentNum=c1.getRentedCarNum();
										 rentNum=rentNum+1;
										 c1.setRentedCarNum(rentNum);
										 c1.addLocations(l1,l2);
										 totalArr[0]=total;
										 c1.getPaidMoney().add(totalArr);
										 c1.calculateTotalMoney();
										 loc.getCars().get(0).setRentStatus(false);
										 loc.getCars().get(0).setRentalDate(date1.getText());
										 loc.getCars().get(0).setReturnDate(date2.getText());
										 int rentNum2=0;//Araba kaç kere kiralanmış
										 rentNum2=loc.getCars().get(0).getRentNum();
										 rentNum2=rentNum2+1;
										 loc.getCars().get(0).setRentNum(rentNum2);
										 
										 GenerateReport gr=new GenerateReport(Database.clients,Database.locations);
										 
										 
										 if (e.getSource() == verify) {
												mg=new MainPage(c1);
												gui.setVisible(false); //Ekranı kapatmak istiyorum ama sistemi durdurmak istemiyorum o nedenle setvisible fonk. kullandım
											}
										 
									 }
								}
							);
							 }
						}
					);
			
			but2.addActionListener(
					new ActionListener() { //Somutlaştırma Anonymus Inner Class
						 public void actionPerformed(ActionEvent e) {//Kiralaya Basılınca
							 if(loc.getCars().get(1).getPriceLevel().equals("high price")) {
								 System.out.println("high");
								 long days=DateCalculate(date1.getText(),date2.getText());
								 total=days*200;
								 if(roof.isSelected()) {
									 total=total+500;
								 }if(trailer.isSelected()) {
									 total=total+1500;
								 }if(snowChains.isSelected()) {
									 total=total+200;
								 }if(navigation.isSelected()) {
									 total=total+150;
								 }if(childSeat.isSelected()) {
									 total=total+100;
								 }
								 priceBox.setText(String.valueOf(total));
								 System.out.println(total);
								 
							 }else if(loc.getCars().get(1).getPriceLevel().equals("middle price")) {
								 System.out.println("med");
								 long days=DateCalculate(date1.getText(),date2.getText());
								 total=days*150;
								 if(roof.isSelected()) {
									 total=total+500;
								 }if(trailer.isSelected()) {
									 total=total+1500;
								 }if(snowChains.isSelected()) {
									 total=total+200;
								 }if(navigation.isSelected()) {
									 total=total+150;
								 }if(childSeat.isSelected()) {
									 total=total+100;
								 }
								 priceBox.setText(String.valueOf(total));
								 System.out.println(total);
								 
							 }else if(loc.getCars().get(1).getPriceLevel().equals("low price")) {
								 System.out.println("low");
								 long days=DateCalculate(date1.getText(),date2.getText());
								 total=days*100;
								 if(roof.isSelected()) {
									 total=total+500;
								 }if(trailer.isSelected()) {
									 total=total+1500;
								 }if(snowChains.isSelected()) {
									 total=total+200;
								 }if(navigation.isSelected()) {
									 total=total+150;
								 }if(childSeat.isSelected()) {
									 total=total+100;
								 }
								 priceBox.setText(String.valueOf(total));
								 System.out.println(total);
								 
							 } 
							 verify.addActionListener(new ActionListener() { //Somutlaştırma Anonymus Inner Class
								 public void actionPerformed(ActionEvent e) { //Kiralaya Basılınca
									 int rentNum=0;
									 System.out.println("calisti");
									 rentNum=c1.getRentedCarNum();
									 rentNum=rentNum+1;
									 c1.setRentedCarNum(rentNum);
									 System.out.println(l1+l2);
									 c1.addLocations(l1,l2);
									 totalArr[0]=total;
									 c1.getPaidMoney().add(totalArr);
									 c1.calculateTotalMoney();
									 loc.getCars().get(1).setRentStatus(false);
									 loc.getCars().get(1).setRentalDate(date1.getText());
									 loc.getCars().get(1).setReturnDate(date2.getText());
									 int rentNum2=0;//Araba kaç kere kiralanmış
									 rentNum2=loc.getCars().get(1).getRentNum();
									 rentNum2=rentNum2+1;
									 loc.getCars().get(1).setRentNum(rentNum2);
									  GenerateReport gr=new GenerateReport(Database.clients,Database.locations);
									
									 if (e.getSource() == verify) {
											mg=new MainPage(c1);
											gui.setVisible(false); //Ekranı kapatmak istiyorum ama sistemi durdurmak istemiyorum o nedenle setvisible fonk. kullandım
										}
									 
									 
								 }
							}
						);
						 }
					}
					
				);
			but3.addActionListener(
					new ActionListener() { //Somutlaştırma Anonymus Inner Class
						 public void actionPerformed(ActionEvent e) {//Kiralaya Basılınca
							 if(loc.getCars().get(2).getPriceLevel().equals("high price")) {
								 System.out.println("high");
								 long days=DateCalculate(date1.getText(),date2.getText());
								 total=days*200;
								 if(roof.isSelected()) {
									 total=total+500;
								 }if(trailer.isSelected()) {
									 total=total+1500;
								 }if(snowChains.isSelected()) {
									 total=total+200;
								 }if(navigation.isSelected()) {
									 total=total+150;
								 }if(childSeat.isSelected()) {
									 total=total+100;
								 }
								 priceBox.setText(String.valueOf(total));
								 System.out.println(total);
								
								 
								 
							 }else if(loc.getCars().get(2).getPriceLevel().equals("middle price")) {
								 System.out.println("med");
								 long days=DateCalculate(date1.getText(),date2.getText());
								 total=days*150;
								 if(roof.isSelected()) {
									 total=total+500;
								 }if(trailer.isSelected()) {
									 total=total+1500;
								 }if(snowChains.isSelected()) {
									 total=total+200;
								 }if(navigation.isSelected()) {
									 total=total+150;
								 }if(childSeat.isSelected()) {
									 total=total+100;
								 }
								 priceBox.setText(String.valueOf(total));
								 System.out.println(total);
								 
							 }else if(loc.getCars().get(2).getPriceLevel().equals("low price")) {
								 System.out.println("low");
								 long days=DateCalculate(date1.getText(),date2.getText());
								 total=days*100;
								 if(roof.isSelected()) {
									 total=total+500;
								 }if(trailer.isSelected()) {
									 total=total+1500;
								 }if(snowChains.isSelected()) {
									 total=total+200;
								 }if(navigation.isSelected()) {
									 total=total+150;
								 }if(childSeat.isSelected()) {
									 total=total+100;
								 }
								 priceBox.setText(String.valueOf(total));
								 System.out.println(total);
								 
							 }
							 verify.addActionListener(new ActionListener() { //Somutlaştırma Anonymus Inner Class
								 public void actionPerformed(ActionEvent e) { //Rente Basılınca
									 int rentNum=0;
									 System.out.println("calisti");
									 rentNum=c1.getRentedCarNum();
									 rentNum=rentNum+1;
									 c1.setRentedCarNum(rentNum);
									 c1.addLocations(l1,l2);
									 totalArr[0]=total;
									 c1.getPaidMoney().add(totalArr);
									 c1.calculateTotalMoney();
									 loc.getCars().get(2).setRentStatus(false);
									 loc.getCars().get(2).setRentalDate(date1.getText());
									 loc.getCars().get(2).setReturnDate(date2.getText());
									 int rentNum2=0;        //Araba kaç kere kiralanmış
									 rentNum2=loc.getCars().get(2).getRentNum();
									 rentNum2=rentNum2+1;
									 loc.getCars().get(2).setRentNum(rentNum2);
									 
									 GenerateReport gr=new GenerateReport(Database.clients,Database.locations);
									
									 if (e.getSource() == verify) {
											mg=new MainPage(c1);
											gui.setVisible(false); //Ekranı kapatmak istiyorum ama sistemi durdurmak istemiyorum o nedenle setvisible fonk. kullandım
										}
									 
									 
								 }
							}
						);
						 }
					}
				);
			but4.addActionListener(
					new ActionListener() { //Somutlaştırma Anonymus Inner Class
						 public void actionPerformed(ActionEvent e) {//Kiralaya Basılınca
							 if(loc.getCars().get(3).getPriceLevel().equals("high price")) {
								 System.out.println("high");
								 long days=DateCalculate(date1.getText(),date2.getText());
								 total=days*200;
								 if(roof.isSelected()) {
									 total=total+500;
								 }if(trailer.isSelected()) {
									 total=total+1500;
								 }if(snowChains.isSelected()) {
									 total=total+200;
								 }if(navigation.isSelected()) {
									 total=total+150;
								 }if(childSeat.isSelected()) {
									 total=total+100;
								 }
								 priceBox.setText(String.valueOf(total));
								 System.out.println(total);
								 
								 
							 }else if(loc.getCars().get(3).getPriceLevel().equals("middle price")) {
								 System.out.println("med");
								 long days=DateCalculate(date1.getText(),date2.getText());
								 total=days*150;
								 if(roof.isSelected()) {
									 total=total+500;
								 }if(trailer.isSelected()) {
									 total=total+1500;
								 }if(snowChains.isSelected()) {
									 total=total+200;
								 }if(navigation.isSelected()) {
									 total=total+150;
								 }if(childSeat.isSelected()) {
									 total=total+100;
								 }
								 priceBox.setText(String.valueOf(total));
								 System.out.println(total);
								 
							 }else if(loc.getCars().get(3).getPriceLevel().equals("low price")) {
								 System.out.println("low");
								 long days=DateCalculate(date1.getText(),date2.getText());
								 total=days*100;
								 if(roof.isSelected()) {
									 total=total+500;
								 }if(trailer.isSelected()) {
									 total=total+1500;
								 }if(snowChains.isSelected()) {
									 total=total+200;
								 }if(navigation.isSelected()) {
									 total=total+150;
								 }if(childSeat.isSelected()) {
									 total=total+100;
								 }
								 priceBox.setText(String.valueOf(total));
								 System.out.println(total);
								 
							 }
							 verify.addActionListener(new ActionListener() { //Somutlaştırma Anonymus Inner Class
								 public void actionPerformed(ActionEvent e) { //Kiralaya Basılınca
									 int rentNum=0;
									 //System.out.println("calisti");
									 rentNum=c1.getRentedCarNum();
									 rentNum=rentNum+1;
									 c1.setRentedCarNum(rentNum);
									 c1.addLocations(l1,l2);
									 totalArr[0]=total;
									 c1.getPaidMoney().add(totalArr);
									 c1.calculateTotalMoney();
									 loc.getCars().get(3).setRentStatus(false);
									 loc.getCars().get(3).setRentalDate(date1.getText());
									 loc.getCars().get(3).setReturnDate(date2.getText());
									 int rentNum2=0;//Araba kaç kere kiralanmış
									 rentNum2=loc.getCars().get(3).getRentNum();
									 rentNum2=rentNum2+1;
									 loc.getCars().get(3).setRentNum(rentNum2);
									 GenerateReport gr=new GenerateReport(Database.clients,Database.locations);
									
									 
									 if (e.getSource() == verify) {
											mg=new MainPage(c1);
											gui.setVisible(false); //Ekranı kapatmak istiyorum ama sistemi durdurmak istemiyorum o nedenle setvisible fonk. kullandım
										}
									 
								 }
							}
						);
						 }
					}
				);
		
		}
		public long DateCalculate(String rent,String rtrn) { //Arabanın kaç gün kiralanmak istediğini bulan fonksiyon
			
			SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
			String inputString1 = rent;
			String inputString2 = rtrn;
			
			long tot=0;
			try {
			    Date date1 = myFormat.parse(inputString1);
			    Date date2 = myFormat.parse(inputString2);
			    long diff = date2.getTime() - date1.getTime();
			    if(diff<0) {
			    	JOptionPane.showMessageDialog(null, "Hatalı Tarih Tekrar Deneyiniz", null,JOptionPane.ERROR_MESSAGE);
			    	
			    } else {
			    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
			    tot= TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);}
			} catch (Exception e) {
			    e.printStackTrace();
			}
			return tot ;
		}
		
	
		
	}

