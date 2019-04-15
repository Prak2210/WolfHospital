import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;

import com.hospital.bean.*;
public class BillManipulations {
	InsertStatement insert = new InsertStatement();
	Statement st = Connection.getInstance();
	ResultSet rs = null;
	public void generateCurrentBill(Integer patientID) {
		try {
			System.out.println(patientID.toString());
			List<Medical_Record> record = SelectStatement.getMedicalRecordOfPatient(patientID.toString());
			System.out.println("record "+record.get(0).toString());
			rs = st.executeQuery("SELECT Treatment_Fee,Registration_Fee from Billing_Account where Record_ID="+record.get(0).Record_ID);
			rs.next();
			int treatmentFee = rs.getInt(1), registrationFee = rs.getInt(2);
			
			//rs = st.executeQuery("SELECT Start_Date,End_Date,Ward_Number,Bed_Number from Medical_Record where Patient_ID="+patientID+" AND Status=1");
			//rs.next();
			String startDate = record.get(0).Start_Date, endDate = record.get(0).End_Date;
			int wardNumber=0;

			if(record.get(0).Ward_Number!=null && !record.get(0).Ward_Number.equals("0"))
				wardNumber= Integer.parseInt(record.get(0).Ward_Number);
					
			if(wardNumber!=0) {
				java.util.Date date2 = new java.util.Date();
				java.util.Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
				
				if(endDate == null)
				{
					date2=new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis())); 
				}
				else
				{
					date2=new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
				}
				
				
				//Number of days in hospital
				long diff = date2.getTime() - date1.getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000);
				rs = st.executeQuery("SELECT CHARGES FROM Ward_Details where Ward_Number="+wardNumber);
				int charge=0;
				rs.next();
				charge = rs.getInt(1);
				
				//accomodation set
				//st.executeUpdate("UPDATE Billing_Account SET Accomodation_Fee="+(charge*diffDays)+" where Record_ID="+recordID);
				
				System.out.println("--------------YOUR BILL IS GENERATED----------------------");
				System.out.println("You stayed for: "+diffDays+" days and your accomodation charge is: "+charge*diffDays);
				System.out.println("Registration Fee is: "+registrationFee);
				System.out.println("Treatment Fee is: "+treatmentFee);
				System.out.println("\n Your total amount: "+(treatmentFee+registrationFee+charge*diffDays));
				System.out.println("-------------------END------------------------------------");
			}
			else {
				System.out.println("--------------YOUR BILL IS GENERATED----------------------");
				System.out.println("Registration Fee is: "+registrationFee);
				System.out.println("Treatment Fee is: "+treatmentFee);
				System.out.println("\n Your total amount: "+(treatmentFee+registrationFee));
				System.out.println("-------------------END------------------------------------");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}  
		
	}

	public void generateCurrentBill(Statement st, int recordID, String startDate, String endDate,int wardNumber) {
		try {
			rs = st.executeQuery("SELECT Treatment_Fee,Registration_Fee from Billing_Account where Record_ID="+recordID);
			rs.next();
			int treatmentFee = rs.getInt(1), registrationFee = rs.getInt(2);
			
			if(wardNumber!=0) {
				java.util.Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
				java.util.Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
				
				//Number of days in hospital
				long diff = date2.getTime() - date1.getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000);
				rs = st.executeQuery("SELECT CHARGES FROM Ward_Details where Ward_Number="+wardNumber);
				int charge=0;
				rs.next();
				charge = rs.getInt(1);
				
				//accomodation set
				st.executeUpdate("UPDATE Billing_Account SET Accomodation_Fee="+(charge*diffDays)+" where Record_ID="+recordID);
				
				System.out.println("--------------YOUR BILL IS GENERATED----------------------");
				System.out.println("You stayed for: "+diffDays+" and your accomodation charge is: "+charge*diffDays);
				System.out.println("Registration Fee is: "+registrationFee);
				System.out.println("Treatment Fee is: "+treatmentFee);
				System.out.println("\n Your total amount: "+(treatmentFee+registrationFee+charge*diffDays));
				System.out.println("-------------------END------------------------------------");
			}
			else {
				System.out.println("--------------YOUR BILL IS GENERATED----------------------");
				System.out.println("Registration Fee is: "+registrationFee);
				System.out.println("Treatment Fee is: "+treatmentFee);
				System.out.println("\n Your total amount: "+(treatmentFee+registrationFee));
				System.out.println("-------------------END------------------------------------");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}  
		
	}
}
