// Main.java        										Author: Dilara Dündar 22095630
//														    e-mail: dilaradundar2002@gmail.com

//Program başlangıcını sağlayan main classı, sabit arabaların ve clientların tanımlandığı, ayrıca listelere atıldığı class.
//Bahsedilen listeler Database classında tutulmakta.
package odev;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Database {
//public Car(String model,String numberPlate,Boolean smokeStatus, String gear, int doorNum, String priceLevel) {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		

		Car car1=new Car("Daica", "35 ABC 123", true, "manuel", "4 doors", "middle price");
		Car car2=new Car("Honda", "35 TA 320", false, "automatic", "4 doors", "middle price");
		Car car3=new Car("Ford", "35 BR 750", true, "automatic", "2 doors", "low price");
		
		Car car4=new Car("Hyundai", "06 DD 630", true, "manuel", "4 doors", "middle price");
		Car car5=new Car("Skoda", "06 DB 466", true, "manuel", "4 doors", "middle price");
		Car car10=new Car("Lexus", "06 BS  18", false, "automatic", "4 doors", "high price");
		
		Car car7=new Car("Toyota", "34 TD 914", true, "manuel","4 doors", "low price");
		Car car8=new Car("Renault", "34 SP 780", true, "manuel", "4 doors", "middle price");
		Car car9=new Car("Mercedes", "34 BHJ 110 ", false, "automatic", "4 doors", "high price");
		Car car6=new Car("Suzuki", "34 CBR 732", false, "manuel", "2 doors", "middle price");
		
	
		ArrayList<Car> izmir=new ArrayList<>();
		ArrayList<Car> ankara=new ArrayList<>();
		ArrayList<Car> istanbul=new ArrayList<>();
		
		izmir.add(car1);
		izmir.add(car2);
		izmir.add(car3);
	
		ankara.add(car4);
		ankara.add(car5);
		ankara.add(car10);
		
		istanbul.add(car7);
		istanbul.add(car8);
		istanbul.add(car9);
		istanbul.add(car6);
		
		
		ILocation loc1=new Location("Ankara",ankara);
		ILocation loc2=new Location("İstanbul",istanbul);
		ILocation loc3=new Location("İzmir",izmir);
				
		locations.add(loc1);
		locations.add(loc2);
		locations.add(loc3);
	
		Client client1=new Client("1","pass123");
		Client client2=new Client("2","pass345");
		Client client3=new Client("3","pass678");
		
		clients.add(client1);
		clients.add(client2);
		clients.add(client3);
		
		GenerateReport gr=new GenerateReport();
		gr.yaz();
		gr.dosyaOku();
		Login lg = new Login();
		
		
       // Reservation app = new Reservation(loc2);
		
	}
	
	
}
