import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import com.hospital.bean.*;
public class InsertStatement 
{
	Scanner sc = new Scanner(System.in);
	java.sql.Connection conn = Connection.getConnectionInstance();
	public static String quote(String s) 
	{
	    return new StringBuilder()
	        .append('\'')
	        .append(s)
	        .append('\'')
	        .toString();
	}
	public boolean insertPatient(java.sql.Connection conn) throws SQLException {
		//List<String> values = new ArrayList<String>();
		Statement stmt = Connection.getInstance(conn);
		System.out.println("Enter Patient details : Patient_ID, SSN, Name, DOB, Gender, Phone, Street_Address, Zipcode, Status");
		
		
		String Patient_ID = sc.nextLine();
		String SSN = sc.nextLine();
		String Name = sc.nextLine();
		String DOB = sc.nextLine();
		String Gender = sc.nextLine();
		String Phone = sc.nextLine();
		String Street_Address = sc.nextLine();
		String Zipcode = sc.nextLine();
		String Status = sc.nextLine(); 
		
		
		String query = "INSERT INTO Patient(Patient_ID, SSN, Name, DOB, Gender, Phone, Street_Address, Zipcode, Status) " +
                "VALUES ("+quote(Patient_ID)+","+quote(SSN)+","+quote(Name)+","+quote(DOB)+","+quote(Gender)+","+quote(Phone)+","
                		+ ""+quote(Street_Address)+","+quote(Zipcode)+","+quote(Status)+")";

		return Connection.insertUpdate(stmt,query);
	}
	
	public boolean insertMedicalRecord(String recordID, String patientID, String wardNumber , String bedNumber, java.sql.Connection conn ) throws SQLException {
		Statement stmt = Connection.getInstance(conn);
		System.out.println("Enter Medical Record details : Responsible_staff");
		//String Record_ID = sc.nextLine();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");  
		java.util.Date date = new java.util.Date(System.currentTimeMillis());  
		String currentDate = formatter.format(date);
		
		String Start_Date = currentDate;
		String End_Date = "0000-00-00";
		String Status = "1";
		String Patient_ID = patientID;
		String Ward_Number = wardNumber;
		String Bed_Number = bedNumber;
		String Responsible_staff = sc.nextLine();

		String query = "";
		if(wardNumber.equals("NA") && bedNumber.equals("NA"))
		{
			query = "INSERT INTO Medical_Record(Record_ID, Start_Date,End_Date,Status,Patient_ID,Responsible_staff) " +
	                "VALUES ("+quote(recordID)+","+quote(Start_Date)+","+quote(End_Date)+","+quote(Status)+","+quote(Patient_ID)+","+quote(Responsible_staff)+")";
		}
		else
		{
			query = "INSERT INTO Medical_Record(Record_ID, Start_Date,End_Date,Status,Patient_ID,Ward_Number,Bed_Number,Responsible_staff) " +
	                "VALUES ("+quote(recordID)+","+quote(Start_Date)+","+quote(End_Date)+","+quote(Status)+","+quote(Patient_ID)+","+quote(Ward_Number)+","
	                		+quote(Bed_Number)+","+quote(Responsible_staff)+")";

			System.out.println(query);
		}

		return Connection.insertUpdate(stmt, query);
	}
	
	public boolean insertBillingAccount(String recordID, java.sql.Connection conn) throws SQLException {
		//List<Medical_Record> latestMed = SelectStatement.getLatestMedicalRecord();
		Statement stmt = Connection.getInstance(conn);
		System.out.println("Enter Billing Account details : SSN_of_Payee, Billing_Address, Payment_Method, Card_Number");
		String SSN_of_Payee = sc.nextLine();
		String Billing_Address = sc.nextLine();
		String Payment_Method = sc.nextLine();
		String Card_Number = sc.nextLine();
		
		//sc.close();
		
		String query = "INSERT INTO Billing_Account(Record_ID, SSN_of_Payee,Billing_Address,Payment_Method,Card_Number) " +
                "VALUES ("+quote(recordID)+","+quote(SSN_of_Payee)+","+quote(Billing_Address)+","+quote(Payment_Method)+","+quote(Card_Number)+")";
		return Connection.insertUpdate(stmt, query);
		
		
	}
	
	public boolean insertTreatment(Integer patientID, java.sql.Connection conn,boolean checkIN) throws SQLException {
		List<Medical_Record> listMedicalRecord = SelectStatement.getMedicalRecordOfActivePatient(patientID.toString());
		if(!checkIN && listMedicalRecord.size() != 0)
		{
			Statement stmt = Connection.getInstance(conn);
			System.out.println("Enter Treatment details : Treatment Plan");
			String treatment = sc.nextLine();
			String Record_ID = listMedicalRecord.get(0).Record_ID;
						
			String query = "INSERT INTO Treatment(Record_ID,Treatment_ID) " +
	                "VALUES("+quote(Record_ID)+","+quote(treatment)+")";
			Connection.insertUpdate(stmt, query);
			
			List<Treatment_Master> charge = SelectStatement.getTreatmentMaster(treatment);
			System.out.println(charge.get(0).toString());
			return UpdateStatements.updateBillingAccount(Record_ID, charge.get(0).Charge);
		}
		else if(checkIN){
			Statement stmt = Connection.getInstance(conn);
			System.out.println("Enter Treatment details : Treatment Plan,Record ID");
			String treatment = sc.nextLine();
			String recordID = sc.nextLine();

			String query = "INSERT INTO Treatment(Record_ID,Treatment_ID) " +
					"VALUES("+quote(recordID)+","+quote(treatment)+")";
			Connection.insertUpdate(stmt, query);

			List<Treatment_Master> charge = SelectStatement.getTreatmentMaster(treatment);
			System.out.println(charge.get(0).toString());
			return UpdateStatements.updateBillingAccount(recordID, charge.get(0).Charge);
		}
		else {
			System.out.println("Patient does not exist or has been Checked out!");
			return false;
		}

	}
	
	public void insertStaff()
	{
		System.out.println("Please enter Staff Details:");
		Statement stmt = Connection.getInstance();
		System.out.println("Enter Staff details :Name, Gender, Age, Job_Title, Professional Title, "
				+ "Dept, Phone, Street_Address, Zipcode, Status");
		String Name = sc.nextLine();
		String Gender = sc.nextLine();
		String Age = sc.nextLine();
		String Job_Title = sc.nextLine();
		String Professional_Title = sc.nextLine();
		String Dept = sc.nextLine();
		String Phone = sc.nextLine();
		String Street_Address = sc.nextLine();
		String Zipcode = sc.nextLine(); 
			
		String query = "INSERT INTO Staff(Name, Gender, Age, Job_Title, Professional_Title, Department,Phone , Street_Address, Zipcode, Status) " +
                "VALUES ("+quote(Name)+","+quote(Gender)+","+quote(Age)+","+quote(Job_Title)+","+quote(Professional_Title)+","+quote(Dept)+","
                		+ quote(Phone)+","+quote(Street_Address)+","+quote(Zipcode)+")"; 
		try {
			int row_updated = stmt.executeUpdate(query);
			if(row_updated==0)
				System.out.println("Failed to enter data");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Check if Staff ID already exists or invalid data format / datatype mismatch.");
		}
	}
	

	public boolean toggleBedStatus(String ward_Number , String bed_Number, Integer availability_Status, java.sql.Connection conn)
	{
		Statement stmt = Connection.getInstance(conn);
		String query = "UPDATE Bed_Details SET Availability_Status = "+availability_Status+ " WHERE Ward_Number = "+quote(ward_Number)+ " AND Bed_Number = "+quote(bed_Number);
		
		System.out.println(query);
		return Connection.insertUpdate(stmt, query);
	}
	public int createBed()
	{
		Statement stmt = Connection.getInstance();
		System.out.println("Enter Bed details : Bed_Number, Ward_Number");
		
		String Bed_Number = sc.nextLine();
		String Ward_Number = sc.nextLine();
		String Availability_Status = "1";
		
		String query = "INSERT INTO Bed_Details(Ward_Number, Bed_Number, Availability_Status ) " +
                "VALUES ("+quote(Ward_Number)+","+quote(Bed_Number)+","+quote(Availability_Status)+")"; 
	
		try 
		{
			int row_updated = stmt.executeUpdate(query);
			
			if(row_updated==0)
				return 0;
			
			query = "UPDATE Ward_Details SET Capacity=Capacity+1 WHERE Ward_Number="+Ward_Number;
			stmt.executeUpdate(query);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Please check if ward_number exists in System.");
			return 0;
		}
		return 1;
	}
	
	public void createBedForWard(String wardNumber, String bedNumber)
	{
		try
		{
			Statement stmt = Connection.getInstance();

			String Ward_Number = wardNumber;
			String Bed_Number = bedNumber;
			String Availability_Status = "1";
			
			String query = "INSERT INTO Bed_Details(Ward_Number, Bed_Number, Availability_Status ) " +
	                "VALUES ("+quote(Ward_Number)+","+quote(Bed_Number)+","+quote(Availability_Status)+")"; 
			System.out.println(query);
			stmt.executeUpdate(query);	
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void createWard()
	{
		
		try
		{
			Statement stmt = Connection.getInstance();
			System.out.println("Enter Ward details : Ward_Number, Capacity, Charges, Staff_ID");
			
			
			String Ward_Number = sc.nextLine();
			String Capacity = sc.nextLine();
			String Charges = sc.nextLine();
			String Staff_ID = sc.nextLine();
			
			if(Capacity.equals("1") || Capacity.equals("2") || Capacity.equals("4"))
			{

				String query = "INSERT INTO Ward_Details(Ward_Number, Capacity, Charges, Staff_ID ) " +
		                "VALUES ("+quote(Ward_Number)+","+quote(Capacity)+","+quote(Charges)+","+quote(Staff_ID)+")"; 
				
				 
				
				stmt.executeUpdate(query);
					for(Integer i = 1 ; i <= Integer.parseInt(Capacity) ; i++)
					{
						createBedForWard(Ward_Number , i.toString());
					}
			}
			else
			{
				System.out.println("Allowed capacity : 1,2,4 only. Please check entered capacity");
			}
		
		}
		catch(SQLException e)
		{
			System.out.println("Please check Staff ID entered or you have enetered duplicate ward number! "+e.getMessage());
		}
	}

}
