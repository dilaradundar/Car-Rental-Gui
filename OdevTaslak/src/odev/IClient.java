//IClient.java        										Author: Dilara Dündar 22095630

//															e-mail: dilaradundar2002@gmail.com
//IClient interfaceinin oluşturulması
package odev;

import java.util.ArrayList;

public interface IClient {

	String getId();

	void setId(String id);

	String getPassword();

	void setPassword(String password);

	int getRentedCarNum();

	void setRentedCarNum(int rentedCarNum);

	float getTotalPaidMoney();

	void setTotalPaidMoney(float totalPaidMoney);
	 
	void addLocations(String loc1, String loc2);
	
	public void setPaidMoney(ArrayList<float[]> paidMoney) ;
	
	public ArrayList<float[]> getPaidMoney() ;
	public String[] getRentLoc() ;


	public void setRentLoc(String[] rentLoc) ;
	public void calculateTotalMoney();

	public  String[] getReturnLoc() ;


	public void setReturnLoc(String[] returnLoc) ;
	
}