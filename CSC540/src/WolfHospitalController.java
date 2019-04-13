import java.sql.*;
import java.util.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.hospital.bean.*;

public class WolfHospitalController 
{
	
	public static void createPatient()
	{
		System.out.println("Welcome to WolfHospital! Will the patient be admitted to a room? Y/N");
		Scanner sc = new Scanner(System.in);
		String answer = sc.nextLine();
		//sc.close();
		if(answer.equals("N"))
		{
			InsertStatement.insertPatient();
			System.out.println("Please enter PatientID:");
		    
		    String patientID = sc.nextLine();
		    
			InsertStatement.insertMedicalRecord(patientID, "NA", "NA");
			InsertStatement.insertBillingAccount();
		}
		else if(answer.equals("Y"))
		{
			System.out.print("Ward Information -->\n");
			List<Ward_Details> listWards = SelectStatement.getWardDetails();
		    
			System.out.println("\n");
			
		    System.out.println("Available Bed Information -->");
		    List<Bed_Details> availableBeds = new ArrayList<Bed_Details>();
		    for(Bed_Details bed : SelectStatement.getBeds())
		    {
		    	if(bed.Availability_Status.equals("1"))
		    	{
		    		availableBeds.add(bed);
		    		System.out.print(bed.toString());
		    		System.out.println("\n");
		    	}
		    }
		    
		    System.out.println("Are you fine with available bed and Ward? - Y/N");
		    String ans = sc.nextLine();
		    if(ans.equals("Y"))
		    {
		    	InsertStatement.insertPatient();
			    
			    System.out.println("Please enter required Ward Number , Bed Number , PatientID:");
			    
			    String wardNumber = sc.nextLine();
			    String bedNumber = sc.nextLine();
			    String patientID = sc.nextLine();
			     
			    //List<Medical_Record> listMR = SelectStatement.getActiveMedicalRecordOfPatient(patientID);
			    
			    InsertStatement.insertMedicalRecord(patientID, wardNumber, bedNumber);
				InsertStatement.toggleBedStatus(wardNumber, bedNumber, 1);
			    InsertStatement.insertBillingAccount();
			    
			    System.out.println("Patient successfully onboarded!");
		    }
		    else
		    {
		    	System.out.println("Come back later!");
		    }
	    	 
		}
		else
		{
			System.out.println("Please enter valid option!");
		
		}
		//sc.close();
	
	}
	
	public static void assignWardBedOnPreference()
	{
		System.out.print("Ward Information -->\n");
		List<Ward_Details> listWards = SelectStatement.getWardDetails();
	    
		System.out.println("\n \n");
		
	    System.out.println("Available Bed Information -->");
	    //Availability_Status = 1
	    List<Bed_Details> availableBeds = new ArrayList<Bed_Details>();
	    
	    for(Bed_Details bed : SelectStatement.getBeds())
	    {
	    	if(bed.Availability_Status.equals("1"))
	    	{
	    		availableBeds.add(bed);
	    	}
	    }
	    
	   
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Please enter required Ward Number , Bed Number , PatientID:");
	    
	    Integer wardNumber = sc.nextInt();
	    Integer bedNumber = sc.nextInt();
	    Integer patientID = sc.nextInt();
	    
	    //sc.close(); 
	    List<Medical_Record> listMR = SelectStatement.getActiveMedicalRecordOfPatient(patientID);
	    
	    if(listMR.size() == 1)
	    {
	    	Medical_Record current = listMR.get(0);
	    	current.setWard_Number(wardNumber.toString());
	    	current.setBed_Number(bedNumber.toString());
	    	
	    	//Update Medical Record
	    	//Update New Bed Status to 1
	    	//Update Old Bed if available to 0
	    	
	    	
	    	
	    }
	    else if(listMR.size() > 1)
	    {
	    	System.out.println("Please create an active Medical record for Patient "+patientID);
	    }
	    else
	    {
	    	System.out.println("No medical record exists for patient "+patientID);
	    }
 
	}
	
	//Sakthi
	public static void getMedicalHistoryOfPatient()
	{
		Scanner sc = new Scanner(System.in);
	    System.out.println("Please enter PatientID"); // , Start-Date , End-Date:

	    Integer patientID = sc.nextInt();
	    
	    System.out.println("Please enter Start Date : yyyy-mm-dd");
	    
	    String startDate = sc.nextLine();
	    
	    System.out.println("Please enter End Date : yyyy-mm-dd");
	    
	    String endDate = sc.nextLine();
	    
	    sc.close(); 
	    List<Medical_Record> listMR = new ArrayList<Medical_Record>();
	    
	    for(Medical_Record mr : SelectStatement.getMedicalRecords())
	    {
	    	if(mr.Patient_ID.equals(patientID.toString()))
	    	{
	    		listMR.add(mr);
	    		System.out.println(mr.toString());
	    	}
	    }
	    
	    	
	}
	
	public static void main(String[] args) 
	{
		//InsertStatement.insertPatient();
		//SelectStatement.getStaff();
		//SelectStatement.getAvailableWardBed();
		//assignWardBedOnPreference();
		//getMedicalHistoryOfPatient();
		
		createPatient();
		
	   
	}

}
