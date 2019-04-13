import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hospital.bean.Medical_Record;

public class GenerateReports {
	Scanner sc = new Scanner(System.in);
	public void getMedicalHistoryOfPatient(int patientID)
	{
		 // , Start-Date , End-Date:
	    System.out.println("Please enter Start Date : yyyy-mm-dd");
	    
	    String startDate = sc.nextLine();
	    
	    System.out.println("Please enter End Date : yyyy-mm-dd");
	   
	    String endDate = sc.nextLine();
	  
	    List<Medical_Record> listMR = new ArrayList<Medical_Record>();
	    
	    for(Medical_Record mr : SelectStatement.getMedicalRecords())
	    {
	    	if(mr.Patient_ID.equals(patientID+""))
	    	{
	    		listMR.add(mr);
	    		System.out.println(mr.toString());
	    	}
	    }	
	}
}
