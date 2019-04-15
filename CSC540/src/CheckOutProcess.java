import java.sql.*;
import java.text.SimpleDateFormat;

public class CheckOutProcess {
	InsertStatement insert = new InsertStatement();
	BillManipulations bill = new BillManipulations();
	Statement st = Connection.getInstance();
	ResultSet rs = null;

	public Boolean checkPatient(int patientID) {
		try {
			rs = st.executeQuery("select Patient_ID from Patient");
			while(rs.next()) {
				if(rs.getInt(1)==patientID)
					return true;
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
	}

	public Boolean checkActivePatient(int patientID) {
		try {
			String s = "Completing Treatment";
			rs = st.executeQuery("select Patient_ID from Patient WHERE Status = '"+s+"';");
			while(rs.next()) {
				if(rs.getInt(1)==patientID)
					return true;
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
	}

	public void closePatientStatus(int patientID) {
		java.sql.Connection conn = null;
		try
		{
			conn = Connection.getConnectionInstance();
			conn.setAutoCommit(false);
			Statement st = conn.createStatement();
			//patient's status change
			st.executeUpdate("UPDATE PATIENT SET Status='Completing Treatment' where Patient_ID="+patientID+";");

			//record id & dates fetched
			rs = st.executeQuery("SELECT Record_ID,Ward_Number,Bed_Number,Start_Date From Medical_Record where Patient_ID="+patientID+" AND Status=1;");
			Integer recordID = 0,bedNumber = -1,wardNumber = -1;
			String startDate = null;
			while(rs.next()) {
				recordID = rs.getInt(1);
				bedNumber = rs.getInt(3);
				wardNumber = rs.getInt(2);
				startDate = rs.getString(4);
			}			
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");  
			java.util.Date date = new java.util.Date(System.currentTimeMillis());  
			String currentDate = formatter.format(date);

			//bill generated
			System.out.println("ward: "+wardNumber);
			bill.generateCurrentBill(st, recordID,startDate,currentDate,wardNumber);
			
				
			
			//medical record->inactive & bed->available
			st.executeUpdate("UPDATE Medical_Record SET Status=0, End_Date='"+currentDate+"' where Patient_ID="+patientID+" AND Status=1;");
			
			//Use this statement to implement ACID transaction
			st.executeUpdate("UPDATE Bed_Details SET Availability_Status = 1 WHERE Ward_Number = "+wardNumber+ " AND Bed_Number = "+bedNumber+";");
			//insert.toggleBedStatus(wardNumber.toString(), bedNumber.toString(), 1);
			
			//throw new Exception();			
			conn.commit();
			conn.setAutoCommit(true);
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured: Rolling-back Checkout process:");
			try 
			{
				conn.rollback();
			} 
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
