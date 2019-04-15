import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.hospital.bean.Bed_Details;
import com.hospital.bean.Medical_Record;
import com.hospital.bean.Patient;
import com.hospital.bean.Ward_Details;

public class DeleteStatement {
	Statement st = Connection.getInstance();
	ResultSet rs =null;
	Scanner sc = new Scanner(System.in);
	public void deletePatient(int patientID) {
		String query = "Delete from Patient where Patient_ID="+patientID;
		try {
			st.executeUpdate(query);
			SelectStatement.getPatient();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteStaff(Integer staffID) {
		String query = "";
		
		for(Medical_Record mr : SelectStatement.getMedicalRecords())
	    {
	    	if(mr.getResponsible_staff().equals(staffID.toString()))
	    	{
	    		//System.out.println("I am here");
	    		if(mr.getStatus().equals("1")) {
	    			System.out.println("Please enter a new staff ID for record id: "+mr.getRecord_ID());
	    			int newStaffID = sc.nextInt();
	    			query = "UPDATE MEDICAL_RECORD SET RESPONSIBLE_STAFF = " + newStaffID +" where RECORD_ID="+mr.getRecord_ID();
	    			System.out.println(query);
	    			try {
	    				st.executeUpdate(query);
	    			} catch (SQLException e) {
	    				e.printStackTrace();
	    			}
	    		}	    		
	    		query = "";
	    	}
	    }
		query = "UPDATE MEDICAL_RECORD SET RESPONSIBLE_STAFF = " + 1000 + " where RESPONSIBLE_STAFF="+staffID;
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		query = "UPDATE WARD_DETAILS SET STAFF_ID = " + 1000 + " where STAFF_ID="+staffID;
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
//		for(Ward_Details wd : SelectStatement.getWardDetails())
//	    {
//	    	if(wd.getStaff_ID().equals(staffID.toString()))
//	    	{
//	    		//System.out.println("I am here");
//	    		if(mr.getStatus().equals("1")) {
//	    			System.out.println("Please enter a new staff ID for record id: "+mr.getRecord_ID());
//	    			String newStaffID = sc.next();
//	    			query = "UPDATE MEDICAL_RECORD SET RESPONSIBLE_STAFF = " + newStaffID +" where RECORD_ID="+mr.getRecord_ID();
//	    			System.out.println(query);
//	    		}
//	    		try {
//    				st.executeUpdate(query);
//    			} catch (SQLException e) {
//    				e.printStackTrace();
//    			}
//	    		query = "";
//	    	}
//	    }
		
		query = "Delete from Staff where Staff_ID="+staffID;
		try {
			SelectStatement.getStaff(false);
			st.executeUpdate(query);
			SelectStatement.getStaff(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Boolean deleteWard(Integer wardNumber) {
		
		    for(Bed_Details bed : SelectStatement.getBeds()){
		    	if(bed.Ward_Number.equals(wardNumber.toString()) && bed.Availability_Status.equals("0"))
		    		return false;
		    }
		String query = "Delete from Ward_Details where Ward_Number="+wardNumber;
		try {
			st.executeUpdate(query);
			SelectStatement.getWardDetails();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	public Boolean deleteBed(Integer bedNumber, Integer wardNumber) {

		    for(Bed_Details bed : SelectStatement.getBeds()){
		    	if(bed.Ward_Number==wardNumber.toString() && bed.Bed_Number==bedNumber.toString() && bed.Availability_Status.equals("1"))
		    		return false;
		    }
		String query = "Delete from Bed_Details where Bed_Number="+bedNumber;
		try {
			st.executeUpdate(query);
			query = "UPDATE Ward_Details SET Capacity=Capacity-1 WHERE Ward_Number="+wardNumber;
			st.executeUpdate(query);
			SelectStatement.getBeds();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	public int deleteBed(Integer wardNumber, Integer oldCapacity, int numBed) {
		int count=0;
		System.out.println("Only beds you can delete....others are occupied");
		ArrayList<Integer> beds = new ArrayList<>();
		List<Bed_Details> details = SelectStatement.getBeds();
	    for(Bed_Details bed : details){
	    	if(bed.getWard_Number().equals(wardNumber.toString()) &&  bed.Availability_Status.equals("1")) {
	    		System.out.println(bed.Bed_Number);
	    		beds.add(Integer.parseInt(bed.Bed_Number));
    	}
	    		
	    }
	    for(int i=0;i<numBed;i++) {
	    	System.out.println("Enter bed to delete from above:");
	    	String b = sc.nextLine();
	    	if(beds.contains(Integer.parseInt(b))) {
	    		try {
					st.executeUpdate("DELETE FROM BED_DETAILS WHERE Bed_Number="+b+" and Ward_Number="+wardNumber);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		count++;
	    	}
	    	else
	    		System.out.println("Sorry we can't delete this bed");
	    }
	return count;
}
}
