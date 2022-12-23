
// Car.java        										Author: Dilara Dündar 22095630
//														e-mail: dilaradundar2002@gmail.com
//Car classının özelliklerinin ve fonksiyonlarının belirlenmesi constructorlarının oluşturulması(ICar interfaceinden implemet alınmıştır.)
package odev;
public class Car implements ICar {

	private String model;
	private String numberPlate;
	private Boolean rentStatus=true;
	private String rentalDate;
	private Boolean smokeStatus;
	private String gear;
	private String doorNum;
	private String returnDate;
	private int rentNum;
	private String priceLevel;
	private String fuel_type="gasoline";
	
	/*@Override
	public String toString() {
		return "Car [doorNum=" + doorNum + ", gear=" + gear + ", model=" + model + ", numberPlate=" + numberPlate
				+ ", rentalDate=" + rentalDate + ", rentNum=" + rentNum + ", rentStatus=" + rentStatus + ", returnDate="
				+ returnDate + ", smokeStatus=" + smokeStatus + "]";
	}*/
	
	public Car(String model,String numberPlate,Boolean smokeStatus, String gear, String doorNum, String priceLevel) {
		this.model=model;
		this.numberPlate=numberPlate;
		this.smokeStatus=smokeStatus;
		this.gear=gear;
		this.doorNum=doorNum;
		this.priceLevel=priceLevel;
	}
	
	@Override
	public String getModel() {
		return model;
	}
	@Override
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String getNumberPlate() {
		return numberPlate;
	}
	@Override
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	@Override
	public Boolean getRentStatus() {
		return rentStatus;
	}
	@Override
	public void setRentStatus(Boolean rentStatus) {
		this.rentStatus = rentStatus;
	}
	@Override
	public String getRentalDate() {
		return rentalDate;
	}
	@Override
	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	@Override
	public String getReturnDate() {
		return returnDate;
	}
	@Override
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public int getRentNum() {
		return rentNum;
	}
	@Override
	public void setRentNum(int rentNum) {
		this.rentNum = rentNum;
	}
	@Override
	public String toString() {
		
		return this.model+", "+this.gear+", "+this.numberPlate+", "+this.priceLevel+", "+this.doorNum+", "+"Smoke Availability:"+this.smokeStatus+", "+"Fuel Type: "+this.fuel_type+", "+" Rentability: "+this.rentStatus;
	}

	@Override
	public Boolean getSmokeStatus() {
		return smokeStatus;
	}

	@Override
	public void setSmokeStatus(Boolean smokeStatus) {
		this.smokeStatus = smokeStatus;
	}

	@Override
	public String getGear() {
		return gear;
	}

	@Override
	public void setGear(String gear) {
		this.gear = gear;
	}

	@Override
	public String getDoorNum() {
		return doorNum;
	}

	@Override
	public void setDoorNum(String doorNum) {
		this.doorNum = doorNum;
	}

	@Override
	public String getPriceLevel() {
		return priceLevel;
	}

	@Override
	public void setPriceLevel(String priceLevel) {
		this.priceLevel = priceLevel;
	}

	public String getFuel_type() {
		return fuel_type;
	}

	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
}
