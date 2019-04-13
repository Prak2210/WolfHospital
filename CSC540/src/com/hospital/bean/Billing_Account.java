package com.hospital.bean;

public class Billing_Account 
{
	public String Record_ID;
	public String SSN_of_Payee;
	public String Billing_Address;
	public String Payment_Method;
	public String Card_Number;
	public String Registration_Fee;
	public String Medication_Prescribed;
	public String Accomodation_Fee;
	public String Treatment_Fee;
    
    public Billing_Account(String record_ID, String sSN_of_Payee, String billing_Address, String payment_Method,
			String card_Number, String registration_Fee, String medication_Prescribed, String accomodation_Fee,
			String treatment_Fee) {
		super();
		Record_ID = record_ID;
		SSN_of_Payee = sSN_of_Payee;
		Billing_Address = billing_Address;
		Payment_Method = payment_Method;
		Card_Number = card_Number;
		Registration_Fee = registration_Fee;
		Medication_Prescribed = medication_Prescribed;
		Accomodation_Fee = accomodation_Fee;
		Treatment_Fee = treatment_Fee;
	}

	public Billing_Account()
    {
    	
    }

	public String getRecord_ID() {
		return Record_ID;
	}

	public void setRecord_ID(String record_ID) {
		Record_ID = record_ID;
	}

	public String getSSN_of_Payee() {
		return SSN_of_Payee;
	}

	public void setSSN_of_Payee(String sSN_of_Payee) {
		SSN_of_Payee = sSN_of_Payee;
	}

	public String getBilling_Address() {
		return Billing_Address;
	}

	public void setBilling_Address(String billing_Address) {
		Billing_Address = billing_Address;
	}

	public String getPayment_Method() {
		return Payment_Method;
	}

	public void setPayment_Method(String payment_Method) {
		Payment_Method = payment_Method;
	}

	public String getCard_Number() {
		return Card_Number;
	}

	public void setCard_Number(String card_Number) {
		Card_Number = card_Number;
	}

	public String getRegistration_Fee() {
		return Registration_Fee;
	}

	public void setRegistration_Fee(String registration_Fee) {
		Registration_Fee = registration_Fee;
	}

	public String getMedication_Prescribed() {
		return Medication_Prescribed;
	}

	public void setMedication_Prescribed(String medication_Prescribed) {
		Medication_Prescribed = medication_Prescribed;
	}

	public String getAccomodation_Fee() {
		return Accomodation_Fee;
	}

	public void setAccomodation_Fee(String accomodation_Fee) {
		Accomodation_Fee = accomodation_Fee;
	}

	public String getTreatment_Fee() {
		return Treatment_Fee;
	}

	public void setTreatment_Fee(String treatment_Fee) {
		Treatment_Fee = treatment_Fee;
	}

	@Override
	public String toString() {
		return "Billing_Account [Record_ID=" + Record_ID + ", SSN_of_Payee=" + SSN_of_Payee + ", Billing_Address="
				+ Billing_Address + ", Payment_Method=" + Payment_Method + ", Card_Number=" + Card_Number
				+ ", Registration_Fee=" + Registration_Fee + ", Medication_Prescribed=" + Medication_Prescribed
				+ ", Accomodation_Fee=" + Accomodation_Fee + ", Treatment_Fee=" + Treatment_Fee + "]";
	}

	    
    
}
