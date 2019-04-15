import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.hospital.bean.Bed_Details;

public class CheckInProcess {
	Scanner sc = new Scanner(System.in);
	InsertStatement insert = new InsertStatement();
	public void checkIN(Boolean Staying) {
		java.sql.Connection conn = null;
		try {
			conn = Connection.getConnectionInstance();
			if(!Staying) {
				System.out.println("Have you been admitted to Wolfhospital before?- Y/N");
				String answer = sc.nextLine();
				if(answer.equals("N"))
					insert.insertPatient();

				else{
					System.out.println("Enter your existing PatientID");
					String patientID = sc.nextLine();
					UpdateStatements.changeStatus("Not In Ward",Integer.parseInt(patientID));
				}
				System.out.println("Please enter PatientID:");
			    String patientID = sc.nextLine();
			    insert.insertMedicalRecord(patientID, "NA", "NA");
				insert.insertBillingAccount();
				insert.insertTreatment(Integer.parseInt(patientID));
			}
			else {
				checkWards();
			    System.out.println("Are you fine with available bed and Ward? - Y/N");
			    String ans = sc.nextLine();
				System.out.println("Have you been admitted to Wolfhospital before?- Y/N");
				String answer = sc.nextLine();
				if(answer.equals("N"))
				{
					insert.insertPatient();
				}
				else{
					System.out.println("Enter your existing PatientID");
					String patientID = sc.nextLine();
					UpdateStatements.changeStatus("In Ward",Integer.parseInt(patientID));
				}
			    if(ans.equals("Y"))
			    {
			    	System.out.println("Have you been admitted to Wolfhospital before?- Y/N");
					answer = sc.nextLine();
				    System.out.println("Please enter required Ward Number , Bed Number , PatientID:");
				    
				    String wardNumber = sc.nextLine();
				    String bedNumber = sc.nextLine();
				    String patientID = sc.nextLine();

					insert.insertMedicalRecord(patientID, wardNumber, bedNumber);
					insert.toggleBedStatus(wardNumber, bedNumber, 0);
					insert.insertBillingAccount();
					insert.insertTreatment(Integer.parseInt(patientID));
				    
				    System.out.println("Patient successfully onboarded!");
			    }
			    else
			    {
			    	System.out.println("Come back later!");
			    }
			}
		}
		catch(Exception e) {
			System.out.println("Exception Occured: Rollbacking Checkin process:");
		}
	}

	public static void checkWards() {
		
		System.out.print("Ward Information -->\n");
		//List<Ward_Details> listWards = SelectStatement.getWardDetails();
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
		
	}
}
		


