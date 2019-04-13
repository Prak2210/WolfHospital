package com.hospital.bean;

public class Treatment 
{
	public String Summary;
	public String Record_ID;
	public String Charges;
	
	public Treatment()
	{
		
	}

	public Treatment(String summary, String record_ID, String charges) {
		super();
		Summary = summary;
		Record_ID = record_ID;
		Charges = charges;
	}

	public String getSummary() {
		return Summary;
	}

	public void setSummary(String summary) {
		Summary = summary;
	}

	public String getRecord_ID() {
		return Record_ID;
	}

	public void setRecord_ID(String record_ID) {
		Record_ID = record_ID;
	}

	public String getCharges() {
		return Charges;
	}

	public void setCharges(String charges) {
		Charges = charges;
	}

	@Override
	public String toString() {
		return "Treatment [Summary=" + Summary + ", Record_ID=" + Record_ID + ", Charges=" + Charges + "]";
	}
	
	
}
