import java.sql.*;
import java.text.SimpleDateFormat;

public class BillManipulations {

	Statement st = Connection.getInstance();
	ResultSet rs = null;
	public void generateCurrentBill(int patientID) {
		
	}

	public void generateCurrentBill(int recordID, String startDate, String endDate,int wardNumber) {
		try {
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
			rs = st.executeQuery("SELECT Treatment_Fee,Registration_Fee from Billing_Account where Record_ID="+recordID);
			rs.next();
			int treatmentFee = rs.getInt(1), registrationFee = rs.getInt(2);
			System.out.println("\n Your total amount: "+(treatmentFee+registrationFee+charge*diffDays));
		} catch (Exception e) {
			
			e.printStackTrace();
		}  
		
	}
}
