/*
 * All the class inside beans package represent a table in the system and all of its attributes
 * this represents Treatment_Master table and it's attributes with getter and setters
 * */
package com.hospital.bean;

public class Treatment_Master {
	public String Treatment_ID, Description, Charge;
	
	public Treatment_Master() {
			
		}
	public Treatment_Master(String treatment_ID, String description, String charge) {
		super();
		Treatment_ID = treatment_ID;
		Description = description;
		Charge = charge;
	}

	public String getTreatment_ID() {
		return Treatment_ID;
	}

	public void setTreatment_ID(String treatment_ID) {
		Treatment_ID = treatment_ID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCharge() {
		return Charge;
	}

	public void setCharge(String charge) {
		Charge = charge;
	}
	
	@Override
	public String toString() {
		return "Treatment_Master [Treatment_ID=" + Treatment_ID + ", Description=" + Description + ", Charge=" + Charge
				+ "]";
	}

	
}
