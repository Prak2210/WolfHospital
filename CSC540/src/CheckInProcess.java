/*
 * This is control class which is used to onbard patient. Patient can be new or existing patient of the system.
 *
 * */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.hospital.bean.Bed_Details;

//  Adds new patient or existing one. Contains Transaction also
public class CheckInProcess {
	Scanner sc = new Scanner(System.in);
	InsertStatement insert = new InsertStatement();

	public boolean checkIN(Boolean Staying,java.sql.Connection conn) {
		//java.sql.Connection conn = null;

		try {
			//conn = Connection.getConnectionInstance();

			if(!Staying)
			{
				System.out.println("Have you been admitted to Wolfhospital before?- Y/N");
				String answer = sc.nextLine();
				if(answer.equals("N"))
				{
					if (!insert.insertPatient(conn))
						return false;
				}

				else
					{
					System.out.println("Enter your existing PatientID");
					String patientID = sc.nextLine();
					UpdateStatements.changeStatus("Not In Ward",Integer.parseInt(patientID),conn);
				}
				System.out.println("Please enter PatientID & Record ID:");
			    String patientID = sc.nextLine();
			    String recordID = sc.nextLine();
			    if(!insert.insertMedicalRecord(recordID, patientID, "NA", "NA",conn))
			    	return false;
				if(!insert.insertBillingAccount(recordID,conn))
					return false;

			}
			else {
				checkWards();
			    System.out.println("Are you fine with available bed and Ward? - Y/N");
			    String ans = sc.nextLine();
				if(ans.equals("Y"))
				{
					System.out.println("Have you been admitted to Wolfhospital before?- Y/N");
					String answer = sc.nextLine();
					if(answer.equals("N"))
					{
						if(!insert.insertPatient(conn))
							return false;
					}
					else {
						System.out.println("Enter existing PatientID");
						String patientID = sc.nextLine();
						if(!UpdateStatements.changeStatus("In Ward",Integer.parseInt(patientID),conn))
							return false;
					}

						System.out.println("Please enter required Ward Number , Bed Number , PatientID, RecordID:");

						String wardNumber = sc.nextLine();
						String bedNumber = sc.nextLine();
						String patientID = sc.nextLine();
						String recordID = sc.nextLine();
						if(!insert.insertMedicalRecord(recordID,patientID, wardNumber, bedNumber,conn))
							return false;
						if(!insert.toggleBedStatus(wardNumber, bedNumber, 0,conn))
							return false;
						if(!insert.insertBillingAccount(recordID, conn))
							return false;
			    }
			    else
			    {
			    	System.out.println("Come back later!");
			    }
			}


		}
		catch(Exception e) {
			System.out.println("Exception Occurred: Rollbacking Checkin process:");
			return false;
		}
		return true;
	}

	// check available wards in our existing system
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
		


