import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import com.hospital.bean.Billing_Account;
import com.hospital.bean.Medical_Record;

public class InsertStatement 
{
	public static String quote(String s) 
	{
	    return new StringBuilder()
	        .append('\'')
	        .append(s)
	        .append('\'')
	        .toString();
	}
	public static void insertPatient()
	{
		//List<String> values = new ArrayList<String>();
		Statement stmt = Connection.getInstance();
		System.out.println("Enter Patient details : Patient_ID, SSN, Name, DOB, Gender, Phone, Street_Address, Zipcode, Treatment_Plan, Status");
		Scanner sc = new Scanner(System.in); 
		
		String Patient_ID = sc.nextLine();
		String SSN = sc.nextLine();
		String Name = sc.nextLine();
		String DOB = sc.nextLine();
		String Gender = sc.nextLine();
		String Phone = sc.nextLine();
		String Street_Address = sc.nextLine();
		String Zipcode = sc.nextLine();
		String Treatment_Plan = sc.nextLine();
		String Status = sc.nextLine(); 
		
		
		//for(int i = 0; i <= 8 ; i++)
			//values.add(sc.nextLine());
		
		//sc.close();
		//System.out.println(query);
		
		String query = "INSERT INTO Patient(Patient_ID, SSN, Name, DOB, Gender, Phone, Street_Address, Zipcode, Treatment_Plan, Status) " +
                "VALUES ("+quote(Patient_ID)+","+quote(SSN)+","+quote(Name)+","+quote(DOB)+","+quote(Gender)+","+quote(Phone)+","
                		+ ""+quote(Street_Address)+","+quote(Zipcode)+","+quote(Treatment_Plan)+","+quote(Status)+")"; 
		
		/*String query = "INSERT INTO Patient(SSN, Name, DOB, Gender, Phone, Street_Address, Zipcode, Treatment_Plan, Status) " +
                "VALUES (?,?,?,?,?,?,?,?,?)"; */
		
		Connection.insertUpdate(stmt, query);
		//Connection.prepareInsertUpdate(query, values);
		
		
	}
	
	public static void insertMedicalRecord(String patientID, String wardNumber , String bedNumber )
	{
		Statement stmt = Connection.getInstance();
		System.out.println("Enter Medical Record details : Start_Date, Patient_ID, Responsible_staff");
		Scanner sc = new Scanner(System.in); 
		//String Record_ID = sc.nextLine();
		String Start_Date = sc.nextLine();
		String Status = "1";
		String Patient_ID = sc.nextLine();
		String Ward_Number = wardNumber;
		String Bed_Number = bedNumber;
		String Responsible_staff = sc.nextLine();
		//sc.close();
		
		String query = "";
		if(wardNumber.equals("NA") && bedNumber.equals("NA"))
		{
			query = "INSERT INTO Medical_Record(Start_Date,Status,Patient_ID,Responsible_staff) " +
	                "VALUES ("+quote(Start_Date)+","+quote(Status)+","+quote(Patient_ID)+","+quote(Responsible_staff)+")";
		}
		else
		{
			query = "INSERT INTO Medical_Record(Start_Date,Status,Patient_ID,Ward_Number,Bed_Number,Responsible_staff) " +
	                "VALUES ("+quote(Start_Date)+","+quote(Status)+","+quote(Patient_ID)+","+quote(Ward_Number)+","
	                		+ ""+quote(Bed_Number)+","+quote(Responsible_staff)+")";
		}

		System.out.println(query);
		Connection.insertUpdate(stmt, query);	
	}
	
	public static void insertBillingAccount()
	{
		List<Medical_Record> latestMed = SelectStatement.getLatestMedicalRecord();
		Statement stmt = Connection.getInstance();
		System.out.println("Enter Billing Account details : SSN_of_Payee, Billing_Address, Payment_Method, Card_Number");
		Scanner sc = new Scanner(System.in); 
		
		String SSN_of_Payee = sc.nextLine();
		String Billing_Address = sc.nextLine();
		String Payment_Method = sc.nextLine();
		String Card_Number = sc.nextLine();
		
		//sc.close();
		
		String query = "INSERT INTO Billing_Account(Record_ID, SSN_of_Payee,Billing_Address,Payment_Method,Card_Number) " +
                "VALUES ("+quote(latestMed.get(0).Record_ID)+","+quote(SSN_of_Payee)+","+quote(Billing_Address)+","+quote(Payment_Method)+","+quote(Card_Number)+")";
		
		
		System.out.println(query);
		Connection.insertUpdate(stmt, query);
		
		
	}
	
	public static void insertStaff()
	{
		
	}
	
	public static void insertWards()
	{
		
	}
	
	public static void toggleBedStatus(String ward_Number , String bed_Number, Integer availability_Status)
	{
		Statement stmt = Connection.getInstance();
		String query = "UPDATE Bed_Details SET Availability_Status = "+availability_Status+ " WHERE Ward_Number = "+quote(ward_Number)+ " AND Bed_Number = "+quote(ward_Number);
		
		System.out.println(query);
		Connection.insertUpdate(stmt, query);
	}
}
