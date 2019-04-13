package com.hospital.bean;

public class Bed_Details 
{
	public String Ward_Number;
	public String Bed_Number;
	public String Availability_Status;
	
    
    public Bed_Details()
    {
    	
    }

	public Bed_Details(String ward_Number, String bed_Number, String availability_Status) {
		super();
		Ward_Number = ward_Number;
		Bed_Number = bed_Number;
		Availability_Status = availability_Status;
	}

	public String getWard_Number() {
		return Ward_Number;
	}

	public void setWard_Number(String ward_Number) {
		Ward_Number = ward_Number;
	}

	public String getBed_Number() {
		return Bed_Number;
	}

	public void setBed_Number(String bed_Number) {
		Bed_Number = bed_Number;
	}

	public String getAvailability_Status() {
		return Availability_Status;
	}

	public void setAvailability_Status(String availability_Status) {
		Availability_Status = availability_Status;
	}

	@Override
	public String toString() {
		return "Bed_Details [Ward_Number=" + Ward_Number + ", Bed_Number=" + Bed_Number + ", Availability_Status="
				+ Availability_Status + "]";
	}
    
    
    
}
