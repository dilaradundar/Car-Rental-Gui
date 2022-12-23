package odev;

public interface ICar {

	String getModel();

	void setModel(String model);

	String getNumberPlate();

	void setNumberPlate(String numberPlate);

	Boolean getRentStatus();

	void setRentStatus(Boolean rentStatus);

	String getRentalDate();

	void setRentalDate(String rentalDate);

	String getReturnDate();

	void setReturnDate(String returnDate);

	int getRentNum();

	void setRentNum(int rentNum);

	String toString();

	Boolean getSmokeStatus();

	void setSmokeStatus(Boolean smokeStatus);

	String getGear();

	void setGear(String gear);

	String getDoorNum();

	void setDoorNum(String doorNum);

	String getPriceLevel();
	String getFuel_type() ;

	void setFuel_type(String fuel_type); 

	void setPriceLevel(String priceLevel);

}