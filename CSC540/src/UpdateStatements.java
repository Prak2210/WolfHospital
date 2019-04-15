import java.sql.*;
import java.util.Scanner;
import com.hospital.*;

public class UpdateStatements {
	static InsertStatement insert = new InsertStatement();
	static DeleteStatement delete = new DeleteStatement();
	static Statement st = Connection.getInstance();
	static ResultSet rs = null;
	static Scanner sc = new Scanner(System.in);
	static java.sql.Connection conn = Connection.getConnectionInstance();

	public static boolean updateBillingAccount(String recordID, String treatmentCharge) throws SQLException {
		String query = "UPDATE Billing_Account SET Treatment_Fee=Treatment_Fee+"+Integer.parseInt(treatmentCharge)+" WHERE Record_ID="+recordID;
		System.out.println(query);
		return Connection.insertUpdate(st,query);
	}

	public static void updatePatient(int patientID) {
		System.out.println("what attribute do you want to update?");
		System.out.println("1. Name");
		System.out.println("2. DOB");
		System.out.println("3. Gender");
		System.out.println("4. Phone");
		System.out.println("5. Street_Address");
		System.out.println("6. Zipcode");
		System.out.println("Enter number:");
		String selection = sc.nextLine();
		System.out.println("Enter valid value:");
		String value = sc.nextLine();
		
		String operation = null;

		if(selection.equals("1"))
			operation = "Name";
		else if(selection.equals("2"))
			operation = "DOB";
		else if(selection.equals("3"))
			operation = "Gender";
		else if(selection.equals("4"))
			operation = "Phoner";
		else if(selection.equals("5"))
			operation = "Street_Address";
		else if(selection.equals("6"))
			operation = "Zipcode";
		
		
		
		String query = "UPDATE PATIENT SET "+operation+" = '"+value +"' where Patient_ID="+patientID;
		System.out.println(query);
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public static void updateStaff(int staffID) {
		System.out.println("what attribute do you want to update?");
		System.out.println("1. Name");
		System.out.println("2. Age");
		System.out.println("3. Gender");
		System.out.println("4. Professional_Title");
		System.out.println("5. Department");
		System.out.println("6. Phone");
		System.out.println("7. Street_Address");
		System.out.println("Enter number:");
		String selection = sc.nextLine();
		System.out.println("Enter valid value:");
		String value = sc.nextLine();
		
		String operation = null;

		if(selection.equals("1"))
			operation = "Name";
		else if(selection.equals("2"))
			operation = "Age";
		else if(selection.equals("3"))
			operation = "Gender";
		else if(selection.equals("4"))
			operation = "Professional_title";
		else if(selection.equals("5"))
			operation = "Department";
		else if(selection.equals("6"))
			operation = "Phone";
		else if(selection.equals("7"))
			operation = "Street_Address";
		
		
		
		String query = "UPDATE STAFF SET "+operation+" = '"+value +"' where Patient_ID="+staffID;
		System.out.println(query);
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateWard(Integer wardNumber) {
		try {
			System.out.println("what attribute do you want to update?");
			System.out.println("1. Capacity");
			System.out.println("2. Charge");
			System.out.println("Enter selection:");
			String selection = sc.nextLine();
			System.out.println("Enter valid new value:");
			String value = sc.nextLine();
			String query=null;
			String operation = null;
	
			if(selection.equals("1")) {
				operation = "Capacity";
				System.out.println("1. Add Bed or 2. Remove Bed");
				selection = sc.nextLine();
				System.out.println("How much capacity?");
				String numBed = sc.nextLine();
				if(selection.equals("1")) {
					query = "select Capacity from Ward_Details where Ward_Number="+wardNumber;
				
						rs = st.executeQuery(query);
						rs.next();
						int oldCapacity = rs.getInt(1);
						query = "UPDATE Ward_Details SET Capacity=Capacity+"+numBed +" where Ward_Number="+wardNumber;
						st.executeUpdate(query);
						for(Integer i = oldCapacity+1 ; i <= Integer.parseInt(numBed) ; i++)
							insert.createBedForWard(wardNumber.toString() , i.toString());
				
				}
				else {

					query = "select Capacity from Ward_Details where Ward_Number="+wardNumber;
					
					rs = st.executeQuery(query);
					rs.next();
					int oldCapacity = rs.getInt(1);
					int count = delete.deleteBed(wardNumber, oldCapacity, Integer.parseInt(numBed));
					System.out.println("Capacity decreased by "+count);
					query = "UPDATE Ward_Details SET Capacity=Capacity-"+count +" where Ward_Number="+wardNumber;
					if(Integer.parseInt(numBed)<oldCapacity)
						st.executeUpdate(query);
					else
						System.out.println("invalid number of beds");
					
				}
				
			
			}
			else if(selection.equals("2")) {
				operation = "Charges";
				query = "UPDATE Ward_Details SET "+operation+" = '"+value +"' where Ward_Number="+wardNumber;
				System.out.println(query);
				st.executeUpdate(query);
				}
		}
		catch(Exception e) {
			
		}
	}

    public static boolean changeStatus(String status, int patientID,java.sql.Connection conn) {
		try {
			Statement st = Connection.getInstance(conn);
			st.executeUpdate("UPDATE PATIENT SET Status = '"+status+"' where PATIENT_ID="+patientID);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
