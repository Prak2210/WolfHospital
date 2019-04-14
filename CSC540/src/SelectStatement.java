import java.sql.*;
import java.util.*;
import com.hospital.bean.Patient;
import java.lang.reflect.Field;
import com.hospital.bean.*;

public class SelectStatement 
{
	public static List<Medical_Record> getMedicalRecordOfActivePatient(String patientID)
	{
		Statement stmt = Connection.getInstance();
		String query = "SELECT * FROM Medical_Record Where Status = 1 AND Patient_ID= "+patientID;
	    ResultSet rs = Connection.getResultset(stmt, query);
	   
	    List<Medical_Record> listMR = new ArrayList<Medical_Record>();
		Class ftClass = new Medical_Record().getClass();
		Field[] fields = ftClass.getDeclaredFields();
	    try 
	    {
	    	 while(rs.next())
	 	    {
	    		Medical_Record ft = new Medical_Record();
	    		for(Field field: fields) 
	    		{
	    			String name = field.getName();
	    			String value = rs.getString(name);
	    			//System.out.println(value);
	    			field.set(ft,value);
	    		}
	    		listMR.add(ft);
	 	      }
	    	
	    }
	    catch(SQLException | IllegalArgumentException | IllegalAccessException  | SecurityException se)
	    {
	    	System.out.println("Exception @WolfHospitalController getActiveMedicalRecordOfPatient"+se.getMessage());
	    }
	    return listMR;
	}
	
	public static List<Medical_Record> getMedicalRecordOfPatient(String patientID)
	{
		Statement stmt = Connection.getInstance();
		String query = "SELECT * FROM Medical_Record Where Patient_ID= "+patientID;
	    ResultSet rs = Connection.getResultset(stmt, query);
	   
	    List<Medical_Record> listMR = new ArrayList<Medical_Record>();
		Class ftClass = new Medical_Record().getClass();
		Field[] fields = ftClass.getDeclaredFields();
	    try 
	    {
	    	 while(rs.next())
	 	    {
	    		Medical_Record ft = new Medical_Record();
	    		for(Field field: fields) 
	    		{
	    			String name = field.getName();
	    			String value = rs.getString(name);
	    			//System.out.println(value);
	    			field.set(ft,value);
	    		}
	    		listMR.add(ft);
	 	      }
	    	
	    }
	    catch(SQLException | IllegalArgumentException | IllegalAccessException  | SecurityException se)
	    {
	    	System.out.println("Exception @WolfHospitalController getActiveMedicalRecordOfPatient"+se.getMessage());
	    }
	    return listMR;
	}
	
	public static List<Medical_Record> getLatestMedicalRecord()
	{
		Statement stmt = Connection.getInstance();
		String query = "SELECT * FROM Medical_Record ORDER BY Record_ID DESC LIMIT 1";
	    ResultSet rs = Connection.getResultset(stmt, query);
	   
	    List<Medical_Record> listMR = new ArrayList<Medical_Record>();
		Class ftClass = new Medical_Record().getClass();
		Field[] fields = ftClass.getDeclaredFields();
	    try 
	    {
	    	 while(rs.next())
	 	    {
	    		Medical_Record ft = new Medical_Record();
	    		for(Field field: fields) 
	    		{
	    			String name = field.getName();
	    			String value = rs.getString(name);
	    			//System.out.println(value);
	    			field.set(ft,value);
	    		}
	    		listMR.add(ft);
	 	      }
	    	
	    }
	    catch(SQLException | IllegalArgumentException | IllegalAccessException  | SecurityException se)
	    {
	    	System.out.println("Exception @WolfHospitalController getActiveMedicalRecordOfPatient"+se.getMessage());
	    }
	    return listMR;
	}
	
	public static List<Patient> getLatestPatient()
	{
		Statement stmt = Connection.getInstance();
		String query = "SELECT * FROM Patient ORDER BY Patient_ID DESC LIMIT 1";
	    ResultSet rs = Connection.getResultset(stmt, query);
	    
	    List<Patient> listPatient = new ArrayList<Patient>();
		Class ftClass = new Patient().getClass();
		Field[] fields = ftClass.getDeclaredFields();
	    try 
	    {
	    	 while(rs.next())
	 	    {
	    		Patient ft = new Patient();
	    		for(Field field: fields) 
	    		{
	    			String name = field.getName();
	    			String value = rs.getString(name);
	    			field.set(ft,value);
	    		}
	    		listPatient.add(ft);
	 	      }
//	    	 System.out.println("Printing list");
//	    	 for(Patient p : listPatient)
//	    	 {
//	    		 System.out.print(p.toString());
//	    		 System.out.println("\n");
//	    	 }
	    }
	    catch(SQLException | IllegalArgumentException | IllegalAccessException  | SecurityException se)
	    {
	    	System.out.println("Exception @WolfHospitalController"+se.getMessage());
	    }
	    return listPatient;
	}
	
	public static List<Patient> getPatient()
	{
		Statement stmt = Connection.getInstance();
		String query = "SELECT * FROM Patient";
	    ResultSet rs = Connection.getResultset(stmt, query);
	    
	    List<Patient> listPatient = new ArrayList<Patient>();
		Class ftClass = new Patient().getClass();
		Field[] fields = ftClass.getDeclaredFields();
	    try 
	    {
	    	 while(rs.next())
	 	    {
	    		Patient ft = new Patient();
	    		for(Field field: fields) 
	    		{
	    			String name = field.getName();
	    			String value = rs.getString(name);
	    			//System.out.println("declared field:"+name+"==Value===="+value);
	    			field.set(ft,value);
	    		}
	    		listPatient.add(ft);
	 	      }
//	    	 System.out.println("Printing list");
//	    	 for(Patient p : listPatient)
//	    	 {
//	    		 System.out.print(p.toString());
//	    		 System.out.println("\n");
//	    	 }
	    }
	    catch(SQLException | IllegalArgumentException | IllegalAccessException  | SecurityException se)
	    {
	    	System.out.println("Exception @WolfHospitalController"+se.getMessage());
	    }
	    return listPatient;
	}
	
	public static List<Staff> getStaff(Boolean byRoles)
	{
		Statement stmt = Connection.getInstance();
		String query = null;
		if(!byRoles)
			query = "SELECT * FROM Staff";
		else
			query = "SELECT * FROM Staff GROUP BY Job_Title,Staff_ID";
	    ResultSet rs = Connection.getResultset(stmt, query);
	    
	    List<Staff> listStaff = new ArrayList<Staff>();
		Class ftClass = new Staff().getClass();
		Field[] fields = ftClass.getDeclaredFields();
	    try 
	    {
	    	 while(rs.next())
	 	    {
	    		Staff ft = new Staff();
	    		for(Field field: fields) 
	    		{
	    			String name = field.getName();
	    			String value = rs.getString(name);
	    			field.set(ft,value);
	    		}
	    		listStaff.add(ft);
	 	      }
//	    	 System.out.println("Printing list");
//	    	 for(Staff p : listStaff)
//	    	 {
//	    		 System.out.print(p.toString());
//	    		 System.out.println("\n");
//	    	 }
	    }
	    catch(SQLException | IllegalArgumentException | IllegalAccessException  | SecurityException se)
	    {
	    	System.out.println("Exception @WolfHospitalController"+se.getMessage());
	    }
	    return listStaff;
	}
	
	public static List<Ward_Details> getWardDetails()
	{
		Statement stmt = Connection.getInstance();
		String query = "SELECT * FROM Ward_Details";
	    ResultSet rs = Connection.getResultset(stmt, query);
	    
	    List<Ward_Details> listWards = new ArrayList<Ward_Details>();
		Class ftClass = new Ward_Details().getClass();
		Field[] fields = ftClass.getDeclaredFields();
	    try 
	    {
	    	 while(rs.next())
	 	    {
	    		Ward_Details ft = new Ward_Details();
	    		for(Field field: fields) 
	    		{
	    			String name = field.getName();
	    			String value = rs.getString(name);
	    			field.set(ft,value);
	    		}
	    		listWards.add(ft);
	 	      }
//	    	 for(Ward_Details p : listWards)
//	    	 {
//	    		 System.out.print(p.toString());
//	    		 System.out.println("\n");
//	    	 }
	    }
	    catch(SQLException | IllegalArgumentException | IllegalAccessException  | SecurityException se)
	    {
	    	System.out.println("Exception @WolfHospitalController"+se.getMessage());
	    }
	    return listWards;
	}

	
	public static List<Bed_Details> getBeds()
	{
		Statement stmt = Connection.getInstance();
		String query = "SELECT * FROM Bed_Details";
	    ResultSet rs = Connection.getResultset(stmt, query);
	    
	    List<Bed_Details> listAvailableBeds = new ArrayList<Bed_Details>();
		Class ftClass = new Bed_Details().getClass();
		Field[] fields = ftClass.getDeclaredFields();
	    try 
	    {
	    	 while(rs.next())
	 	    {
	    		 Bed_Details ft = new Bed_Details();
	    		for(Field field: fields) 
	    		{
	    			String name = field.getName();
	    			String value = rs.getString(name);
	    			field.set(ft,value);
	    		}
	    		listAvailableBeds.add(ft);
	 	      }
	    	 for(Bed_Details p : listAvailableBeds)
	    	 {
	    		 System.out.print(p.toString());
	    		 System.out.println("\n");
	    	 }
	    }
	    catch(SQLException | IllegalArgumentException | IllegalAccessException  | SecurityException se)
	    {
	    	System.out.println("Exception @WolfHospitalController"+se.getMessage());
	    }
	    return listAvailableBeds;
	}

	
	public static List<Medical_Record> getActiveMedicalRecordOfPatient(Integer patientID)
	{
		Statement stmt = Connection.getInstance();
		String query = "SELECT * FROM Medical_Record WHERE Status = 1 AND Patient_ID = "+patientID;
	    ResultSet rs = Connection.getResultset(stmt, query);
	   
	    List<Medical_Record> listMR = new ArrayList<Medical_Record>();
		Class ftClass = new Medical_Record().getClass();
		Field[] fields = ftClass.getDeclaredFields();
	    try 
	    {
	    	 while(rs.next())
	 	    {
	    		Medical_Record ft = new Medical_Record();
	    		for(Field field: fields) 
	    		{
	    			String name = field.getName();
	    			String value = rs.getString(name);
	    			//System.out.println(value);
	    			field.set(ft,value);
	    		}
	    		listMR.add(ft);
	 	      }
	    	
	    }
	    catch(SQLException | IllegalArgumentException | IllegalAccessException  | SecurityException se)
	    {
	    	System.out.println("Exception @WolfHospitalController getActiveMedicalRecordOfPatient"+se.getMessage());
	    }
	    return listMR;
	}
	
	public static List<Medical_Record> getMedicalRecords()
	{
		Statement stmt = Connection.getInstance();
		String query = "SELECT * FROM Medical_Record";
	    ResultSet rs = Connection.getResultset(stmt, query);
	   
	    List<Medical_Record> listMR = new ArrayList<Medical_Record>();
		Class ftClass = new Medical_Record().getClass();
		Field[] fields = ftClass.getDeclaredFields();
	    try 
	    {
	    	 while(rs.next())
	 	    {
	    		Medical_Record ft = new Medical_Record();
	    		for(Field field: fields) 
	    		{
	    			String name = field.getName();
	    			String value = rs.getString(name);
	    			//System.out.println(value);
	    			field.set(ft,value);
	    		}
	    		listMR.add(ft);
	 	      }
	    	 for(Medical_Record p : listMR)
	    	 {
	    		 System.out.print(p.toString());
	    		 System.out.println("\n");
	    	 }
	    	
	    }
	    catch(SQLException | IllegalArgumentException | IllegalAccessException  | SecurityException se)
	    {
	    	System.out.println("Exception @WolfHospitalController getActiveMedicalRecordOfPatient"+se.getMessage());
	    }
	    return listMR;
	}
	
	public static List<Treatment_Master> getTreatmentMaster(String treatmentID)
	{
		Statement stmt = Connection.getInstance();
		String query = "SELECT * FROM Treatment_Master where Treatment_ID ="+treatmentID;
	    ResultSet rs = Connection.getResultset(stmt, query);
	   
	    List<Treatment_Master> listMR = new ArrayList<Treatment_Master>();
		Class ftClass = new Treatment_Master().getClass();
		Field[] fields = ftClass.getDeclaredFields();
	    try 
	    {
	    	 while(rs.next())
	 	    {
	    		 Treatment_Master ft = new Treatment_Master();
	    		for(Field field: fields) 
	    		{
	    			String name = field.getName();
	    			String value = rs.getString(name);
	    			//System.out.println(value);
	    			field.set(ft,value);
	    		}
	    		listMR.add(ft);
	 	      }
	    	
	    }
	    catch(SQLException | IllegalArgumentException | IllegalAccessException  | SecurityException se)
	    {
	    	System.out.println("Exception @WolfHospitalController getActiveMedicalRecordOfPatient"+se.getMessage());
	    }
	    return listMR;
	}

	public static void showStaffByRole() {
		
	}
	
	
}
