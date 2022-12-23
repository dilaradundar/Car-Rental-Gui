package odev;

import java.util.ArrayList;

public class Location implements ILocation {

	private String nameCity;
	private ArrayList<Car> cars;
			
 //public  ArrayList<IMembership> members = new ArrayList<>(); 
	
	public Location(String name, ArrayList<Car> car){
		this.nameCity=name;
		this.cars=car;
		
	}

	@Override
	public String getNameCity() {
		return nameCity;
	}

	@Override
	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	@Override
	public ArrayList<Car> getCars() {
		return cars;
	}

	@Override
	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}
	
	
}
