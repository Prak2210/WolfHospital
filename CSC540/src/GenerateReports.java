/*
*
* this contrioller has functions to generate medical history details of hospital by taking
* year and month
*
* */
import java.util.*;
import com.hospital.bean.Bed_Details;
import com.hospital.bean.Medical_Record;
import com.hospital.bean.Patient;
import com.hospital.bean.Staff;
import com.hospital.bean.Ward_Details;

public class GenerateReports {
	
	boolean cont = true;
	Scanner sc = new Scanner(System.in);
	/**
	 * Takes in PatientID, Year of Interest and Month of Interest
	 * Prints the medical records of that patient for the month entered
	 */
	public void getMedicalHistoryOfPatient()
	{
		System.out.println("Please enter PatientID");
	    String patientID = sc.next();
	    

	    //String startDate = sc.nextLine();
	    
	    System.out.println("Please enter End Date : yyyy-mm-dd");
	   
	   // String endDate = sc.nextLine();
	  
	    List<Medical_Record> listMR = new ArrayList<Medical_Record>();

	    System.out.println("Please enter the year of interest: YYYY");
		String year = sc.next();
	    
	    System.out.println("Please enter the month of interest : MM");	   
	    String month = sc.next();
	    int count = 0;
	    
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("Record info -->");
	    System.out.println("--------------------------------------------------------------------------");
	    for(Medical_Record mr : SelectStatement.getMedicalRecordsR())
	    {
	    	if(mr.getPatient_ID().equals(patientID) && mr.Start_Date.substring(0, 7).equals(year+"-"+month))
	    	{
	    		System.out.println(mr.toString());
	    		count++;
	    	}
	    }
	    System.out.println();
	    if(count == 0) {
	    	System.out.println("No records to display for the patient on the month entered");
	    }
	    System.out.println();
	    exitOrMenu();
	}
	
	
	/**
	 * Prints the ward/bed usage status
	 */
	public void getWardUsageStatus()
	{
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Ward Usage Status -->");
		System.out.println("--------------------------------------------------------------------------");
	    for(Bed_Details bed : SelectStatement.getBedsR())
	    {
	    	System.out.println(bed.toString());
	    }
	    System.out.println();
	    exitOrMenu();
	}
	
	/**
	 * Takes in Year of Interest and Month of Interest
	 * Prints the number of patients/medical records per month
	 */
	public void getPatientsPerMonth()
	{
		System.out.println("Please enter the year of interest: YYYY");
		String year = sc.next();
	    
	    System.out.println("Please enter the month of interest : MM");	   
	    String month = sc.next();
	    
	    int count = 0;
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("Number of Patients for the month entered -->");
	    System.out.println("--------------------------------------------------------------------------");
	    for(Medical_Record mr : SelectStatement.getMedicalRecordsR())
	    {
	    	if(mr.Start_Date.substring(0, 7).equals(year+"-"+month))
	    	{
	    		//System.out.println(mr.toString());
	    		count++;
	    	}
	    }
	    System.out.println();
	    if(count == 0) {
	    	System.out.println("No records to display for the month entered");
	    }
	    else
	    	System.out.println("Found "+ count + " records for the month entered");
	    System.out.println();
	    exitOrMenu();
	}
	
	/**
	 * Prints the ward usage percentage
	 */
	public void getWardUsagePercentage()
	{
		System.out.println("--------------------------------------------------------------------------");
	    System.out.println("Ward Usage Percentage -->");
	    System.out.println("--------------------------------------------------------------------------");
	    for(Ward_Details ward : SelectStatement.getWardDetailsR())
	    {
	    	String ward_Number = ward.getWard_Number();
	    	double used = 0;
	    	double capacity = Integer.parseInt(ward.getCapacity());
	    	double percentage = 0;
	    	for(Bed_Details bed : SelectStatement.getBedsR())
		    {
		    	if(bed.getWard_Number().equals(ward_Number))
		    	{
		    		used += 1-Integer.parseInt(bed.getAvailability_Status());
		    		
		    	}
		    }
    		percentage = (used/capacity)*100;
		    System.out.println("Ward Number= "+ward_Number+" Usage percentage= "+percentage);
	    }	    
	    System.out.println();
	    exitOrMenu();
	}
	
	/**
	 * Takes in staff id
	 * Prints the information about patients the staff is responsible for.
	 */
	public void getPatientsOfStaff()
	{
		System.out.println("Please enter StaffID");
	    String staffID = sc.next();
	    int count = 0;
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("Patients the staff "+staffID+" is currently responsible for -->");
	    System.out.println("--------------------------------------------------------------------------");
	    List<Patient> patients = SelectStatement.getPatientR();
	    
	    for(Medical_Record mr : SelectStatement.getMedicalRecordsR())
	    {
	    	if(mr.getResponsible_staff().equals(staffID) && mr.getStatus().equals("1"))
	    	{
	    		Optional<Patient> matchingObject = patients.stream().
	    	    	    filter(p -> p.Patient_ID.equals(mr.getPatient_ID())).
	    	    	    findFirst();
	    		System.out.println(matchingObject.get().toString());
	    		count++;
	    	}
	    }
	    System.out.println();
	    if(count == 0) {
	    	System.out.println("No records to display for the given Staff");
	    }
	    System.out.println();
	    exitOrMenu();
	}
	
	class Sortbyrole implements Comparator<Staff> 
	{
	    public int compare(Staff a, Staff b) 
	    { 
	        return a.Job_Title.compareTo(b.Job_Title);
	    } 
	}
	
	/**
	 * Prints the staff information ordered by job title
	 */
	public void getStaffGroupedByRole() {
		List<Staff> staff = SelectStatement.getStaffR(false);
		Collections.sort(staff, new Sortbyrole());
		for(Staff s : staff)
	    	System.out.println(s.toString());		
		
		exitOrMenu();
	}
	
	public void exitOrMenu() {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Please Choose an option:");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. Go to reports menu ");
		System.out.println("2. Go to main menu \n");
		System.out.println("Enter valid selection or (press any other key to exit): ");
		int selection = sc.nextInt();
		if(selection == 1);
		else if(selection == 2) 
			cont=false;
		else {
			sc.close();
			System.out.println("Bye");
			System.exit(0);
		}
	}
	
	public void reportHome() {
		
		while(cont) {
			/*--------------------------------------------------------------------------------------------*/
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Please select a report to print:");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("1. Patient's medical history");
			System.out.println("2. Ward/Bed usage status");
			System.out.println("3. Patients per month");
			System.out.println("4. Ward usage percentage");
			System.out.println("5. Patients the given staff responsible for");
			System.out.println("6. Staff grouped by role");
			System.out.println("7. Go to main menu");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Enter valid selection or (Enter any other number to exit): ");
			int selection = sc.nextInt();
			/*--------------------------------------------------------------------------------------------*/
			
			if(selection == 1)
				getMedicalHistoryOfPatient();
			else if(selection == 2) 
				getWardUsageStatus();
			else if(selection == 3)
				getPatientsPerMonth();
			else if(selection == 4) 
				getWardUsagePercentage();
			else if(selection == 5) 
				getPatientsOfStaff();
			else if(selection == 6) 
				getStaffGroupedByRole();
			else if(selection == 7)
				cont=false;
			else {
				sc.close();
				System.out.println("Bye");
				System.exit(0);
			}		
		}
		cont = true;
	}
}