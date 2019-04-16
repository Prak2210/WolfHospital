/*
 * All the class inside beans package represent a table in the system and all of its attributes
 * this represents Medical Record table and it's attributes with getter and setters
 * */
package com.hospital.bean;

public class Medical_Record 
{
	public String Record_ID;
	public String Start_Date;
	public String End_Date;
	public String Status;
	public String Patient_ID;
	public String Ward_Number;
	public String Bed_Number;
	public String Responsible_staff;
	public String Prescription;
	public String Diagnosis_Details;
    
    public Medical_Record()
    {
    	
    }

	public Medical_Record(String record_ID, String start_Date, String end_Date, String status, String patient_ID,
			String ward_Number, String bed_Number, String responsible_staff, String prescription,
			String diagnosis_Details) {
		super();
		Record_ID = record_ID;
		Start_Date = start_Date;
		End_Date = end_Date;
		Status = status;
		Patient_ID = patient_ID;
		Ward_Number = ward_Number;
		Bed_Number = bed_Number;
		Responsible_staff = responsible_staff;
		Prescription = prescription;
		Diagnosis_Details = diagnosis_Details;
	}

	public String getRecord_ID() {
		return Record_ID;
	}

	public void setRecord_ID(String record_ID) {
		Record_ID = record_ID;
	}

	public String getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(String start_Date) {
		Start_Date = start_Date;
	}

	public String getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(String end_Date) {
		End_Date = end_Date;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(String patient_ID) {
		Patient_ID = patient_ID;
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

	public String getResponsible_staff() {
		return Responsible_staff;
	}

	public void setResponsible_staff(String responsible_staff) {
		Responsible_staff = responsible_staff;
	}

	public String getPrescription() {
		return Prescription;
	}

	public void setPrescription(String prescription) {
		Prescription = prescription;
	}

	public String getDiagnosis_Details() {
		return Diagnosis_Details;
	}

	public void setDiagnosis_Details(String diagnosis_Details) {
		Diagnosis_Details = diagnosis_Details;
	}

	@Override
	public String toString() {
		return "Medical_Record [Record_ID=" + Record_ID + ", Start_Date=" + Start_Date + ", End_Date=" + End_Date
				+ ", Status=" + Status + ", Patient_ID=" + Patient_ID + ", Ward_Number=" + Ward_Number + ", Bed_Number="
				+ Bed_Number + ", Responsible_staff=" + Responsible_staff + ", Prescription=" + Prescription
				+ ", Diagnosis_Details=" + Diagnosis_Details + "]";
	}
    
    
}
