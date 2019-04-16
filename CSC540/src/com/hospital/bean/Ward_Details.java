/*
 * All the class inside beans package represent a table in the system and all of its attributes
 * this represents Ward_Details table and it's attributes with getter and setters
 * */
package com.hospital.bean;

public class Ward_Details 
{
	public String Ward_Number;
	public String Capacity;
	public String Charges;
	public String Staff_ID;
    
    public Ward_Details()
    {
    	
    }

	public Ward_Details(String ward_Number, String capacity, String charges, String staff_ID) {
		super();
		Ward_Number = ward_Number;
		Capacity = capacity;
		Charges = charges;
		Staff_ID = staff_ID;
	}

	public String getWard_Number() {
		return Ward_Number;
	}

	public void setWard_Number(String ward_Number) {
		Ward_Number = ward_Number;
	}

	public String getCapacity() {
		return Capacity;
	}

	public void setCapacity(String capacity) {
		Capacity = capacity;
	}

	public String getCharges() {
		return Charges;
	}

	public void setCharges(String charges) {
		Charges = charges;
	}

	public String getStaff_ID() {
		return Staff_ID;
	}

	public void setStaff_ID(String staff_ID) {
		Staff_ID = staff_ID;
	}

	@Override
	public String toString() {
		return "Ward_Details [Ward_Number=" + Ward_Number + ", Capacity=" + Capacity + ", Charges=" + Charges
				+ ", Staff_ID=" + Staff_ID + "]";
	}
    
    
}
