//GenerateReports.java        										Author: Dilara Dündar 22095630


//															e-mail: dilaradundar2002@gmail.com
//Rapor oluşturulması ve Dosyaya yazma işlemlerinin yapılması
package odev;
import java.io.*;


import java.util.ArrayList;

public class GenerateReport extends Database {
	
	public GenerateReport(ArrayList<Client> client , ArrayList<ILocation> location) {
		
		
	}
	public GenerateReport() {
		
		
	}
	
	public void yaz() {
		System.out.println("\nClient reports\n");
		
	for(int j=0;j<Database.clients.size();j++) {
		System.out.print(Database.clients.get(j).getId()+"---"+Database.clients.get(j).getRentedCarNum()+"---"+Database.clients.get(j).getTotalPaidMoney());
		for (int i=0;i<Database.clients.get(j).getRentedCarNum();i++) {
			String[] arr=Database.clients.get(i).getRentLoc();
			String[] arr1=Database.clients.get(i).getReturnLoc();
			System.out.print("  "+ arr[i]+"  "+arr1[i]);
		}
		System.out.println("");
		}
	
	System.out.println("\nCar reports\n");
	
	for(int j=0;j<3;j++) {
		for(int i=0;i<Database.locations.get(j).getCars().size();i++) {
		System.out.println(Database.locations.get(j).getCars().get(i).getNumberPlate()+" "+Database.locations.get(j).getCars().get(i).getRentNum()+" "+Database.locations.get(j).getCars().get(i).getRentalDate());
		
		}
		System.out.println("");
		}

	
	
	
}//yazın sonu
 public void dosyaYaz() {
	File file=new File("clients_id.txt");
	File file1=new File("car_plate.txt");
	
	try { 
		
	FileWriter fw = new FileWriter(file);
	PrintWriter pw= new PrintWriter(fw);
	
	FileWriter fw1 = new FileWriter(file1);
	PrintWriter pw1= new PrintWriter(fw1);
	//pw.println();
	pw.println("\nClient reports\n");
	pw.println("Client Id - Rented Car Number - Total Paid Money - Rent and return Locations\n");
	for(int j=0;j<Database.clients.size();j++) {
		pw.print(Database.clients.get(j).getId()+" -  "+Database.clients.get(j).getRentedCarNum()+"  - "+Database.clients.get(j).getTotalPaidMoney());
		for (int i=0;i<Database.clients.get(j).getRentedCarNum();i++) {
			String[] arr=Database.clients.get(i).getRentLoc();
			String[] arr1=Database.clients.get(i).getReturnLoc();
			pw.print("  "+ arr[i]+"  "+arr1[i]);
		
		}
		pw.println("");
		}
	pw.close();
	pw1.println("\nCar reports\n");
	pw1.println("Number Plate - Number of rentals - Date\n");
	
	for(int j=0;j<3;j++) {
		for(int i=0;i<Database.locations.get(j).getCars().size();i++) {
		pw1.println(Database.locations.get(j).getCars().get(i).getNumberPlate()+" - "+Database.locations.get(j).getCars().get(i).getRentNum()+"  -  "+Database.locations.get(j).getCars().get(i).getRentalDate()+"  -  "+Database.locations.get(j).getCars().get(i).getReturnDate());
		
		}
		pw1.println("");
		}
	pw1.close();

	}catch(Exception e) {
		e.getMessage();
		
	}
	
		
}//DosyaYazFonkSonu
 
 public String[] dosyaOku() throws IOException  {
	 String path="\\Users\\user\\Desktop\\reservation.txt";
	 String line="";
	 String clientId,gear,fuel,vehicleGroup,rentLoc,returnLoc,rentDate,returnDate;
	 String[] valueArr=new String[8];
	 
	 try {
		BufferedReader br=new BufferedReader(new FileReader(path));
		while((line= br.readLine())!=null) {
			String[] values=line.split(",");
			System.out.println(values[7]);
			clientId=values[0];
			gear=values[1];
			fuel=values[2];
			vehicleGroup=values[3];
			rentLoc=values[4];
			returnLoc=values[5];
			rentDate=values[6];
			returnDate=values[7];
			for(int i=0 ;i<8;i++) {
				valueArr[i]=values[i];
			}
			
			
		}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	 return valueArr;
 }
	

	
	}
	
	
	

