// Client.java        										Author: Dilara Dündar 22095630

//														    e-mail: dilaradundar2002@gmail.com

//Kullanıcının attiribute ve fonksiyonlarının tanımlanması , IClient interfaceinden implement edilmiştir.
package odev;

import java.util.ArrayList;

public class Client implements IClient {
	
	private String id;
	private String password;
	private int rentedCarNum=0;
	private float totalPaidMoney;
	private String[] rentLoc = new String[5];
	private  String[] returnLoc = new String[5];
	private ArrayList<float[]> paidMoney = new ArrayList<>();


	public Client(String id, String password) {
		
		this.id = id;
		this.password = password;
	}


	@Override
	public String getId() {
		return id;
	}


	@Override
	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String getPassword() {
		return password;
	}


	@Override
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public int getRentedCarNum() {
		return rentedCarNum;
	}


	@Override
	public void setRentedCarNum(int rentedCarNum) {
		this.rentedCarNum = rentedCarNum;
	}


	@Override
	public float getTotalPaidMoney() {
		return totalPaidMoney;
	}


	@Override
	public void setTotalPaidMoney(float totalPaidMoney) {
		this.totalPaidMoney = totalPaidMoney;
	}

	public String[] getRentLoc() {
		return rentLoc;
	}


	public void setRentLoc(String[] rentLoc) {
		this.rentLoc = rentLoc;
	}


	public String[] getReturnLoc() {
		return returnLoc;
	}


	public void setReturnLoc(String[] returnLoc) {
		this.returnLoc = returnLoc;
	}


	public void setPaidMoney(ArrayList<float[]> paidMoney) {
		this.paidMoney = paidMoney;
	}


	public ArrayList<float[]> getPaidMoney() {
		return paidMoney;
	}
	public void addLocations(String loc1,String loc2) {
		
		if(rentLoc[0]==null && returnLoc[0]==null) {
			rentLoc[0]=loc1;
			returnLoc[0]=loc2;
			
		}else if(rentLoc[1]==null ) {
			rentLoc[1]=loc1;
			returnLoc[1]=loc2;
			
		}else if(rentLoc[2]==null ) {
			rentLoc[2]=loc1;
			returnLoc[2]=loc2;
		}else if(rentLoc[3]==null ) {
			rentLoc[3]=loc1;
			returnLoc[2]=loc2;
			
		}	
			
		
		
	}
	
	public void calculateTotalMoney() {
		
		float[] add=new float[paidMoney.size()];;
		for(int i=0;i<paidMoney.size();i++) {
				add =paidMoney.get(i);
		}
		
		for(int i=0;i<paidMoney.size()-(paidMoney.size()-1);i++) {
			totalPaidMoney=totalPaidMoney+add[i];
			System.out.println("Odenen para"+totalPaidMoney);
		}
		
	}
	
	
}
