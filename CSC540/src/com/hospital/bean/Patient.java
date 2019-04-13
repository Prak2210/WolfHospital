package com.hospital.bean;

public class Patient 
{
	 public String Patient_ID;
	 public String SSN;
	 public String Name;
	 public String DOB;
	 public String Gender;
	 public String Phone;
	 public String Street_Address;
	 public String Zipcode;
	 public String Treatment_Plan;
	 public String Status;
     
     public Patient()
     {
    	 
     }

	public Patient(String patient_ID, String sSN, String name, String dOB, String gender, String phone,
			String street_Address, String zipcode, String treatment_Plan, String status) 
	{
		super();
		this.Patient_ID = patient_ID;
		this.SSN = sSN;
		this.Name = name;
		this.DOB = dOB;
		this.Gender = gender;
		this.Phone = phone;
		this.Street_Address = street_Address;
		this.Zipcode = zipcode;
		this.Treatment_Plan = treatment_Plan;
		this.Status = status;
	}

	public String getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(String patient_ID) {
		Patient_ID = patient_ID;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getStreet_Address() {
		return Street_Address;
	}

	public void setStreet_Address(String street_Address) {
		Street_Address = street_Address;
	}

	public String getZipcode() {
		return Zipcode;
	}

	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}

	public String getTreatment_Plan() {
		return Treatment_Plan;
	}

	public void setTreatment_Plan(String treatment_Plan) {
		Treatment_Plan = treatment_Plan;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Patient [Patient_ID=" + Patient_ID + ", SSN=" + SSN + ", Name=" + Name + ", DOB=" + DOB + ", Gender="
				+ Gender + ", Phone=" + Phone + ", Street_Address=" + Street_Address + ", Zipcode=" + Zipcode
				+ ", Treatment_Plan=" + Treatment_Plan + ", Status=" + Status + "]";
	}
}
