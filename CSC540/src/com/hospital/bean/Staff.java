/*
 * All the class inside beans package represent a table in the system and all of its attributes
 * this represents Staff table and it's attributes with getter and setters
 * */
package com.hospital.bean;

public class Staff 
{
	public String Staff_ID;
	public String Name;
	public String Age;
	public String Gender;
	public String Job_Title;
	public String Professional_Title;
	public String Department;
	public String Phone;
	public String Street_Address;
	public String Zipcode;
    
    public Staff()
    {
    	
    }

	public Staff(String staff_ID, String name, String age, String gender, String job_Title, String professional_Title,
			String department, String phone, String street_Address, String zipcode) {
		super();
		Staff_ID = staff_ID;
		Name = name;
		Age = age;
		Gender = gender;
		Job_Title = job_Title;
		Professional_Title = professional_Title;
		Department = department;
		Phone = phone;
		Street_Address = street_Address;
		Zipcode = zipcode;
	}

	public String getStaff_ID() {
		return Staff_ID;
	}

	public void setStaff_ID(String staff_ID) {
		Staff_ID = staff_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getJob_Title() {
		return Job_Title;
	}

	public void setJob_Title(String job_Title) {
		Job_Title = job_Title;
	}

	public String getProfessional_Title() {
		return Professional_Title;
	}

	public void setProfessional_Title(String professional_Title) {
		Professional_Title = professional_Title;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
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

	@Override
	public String toString() {
		return "Staff [Staff_ID=" + Staff_ID + ", Name=" + Name + ", Age=" + Age + ", Gender=" + Gender + ", Job_Title="
				+ Job_Title + ", Professional_Title=" + Professional_Title + ", Department=" + Department + ", Phone="
				+ Phone + ", Street_Address=" + Street_Address + ", Zipcode=" + Zipcode + "]";
	}
    
}
