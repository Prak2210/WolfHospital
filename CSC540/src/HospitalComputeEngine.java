import java.sql.*;
import java.util.Scanner;
public class HospitalComputeEngine {
	static Scanner sc = new Scanner(System.in);
	CheckInProcess checkIn = new CheckInProcess();
	GenerateReports report = new GenerateReports();
	BillManipulations bill = new BillManipulations();
	CheckOutProcess checkOut = new CheckOutProcess();
	InsertStatement insert = new InsertStatement();	
	DeleteStatement delete = new DeleteStatement();

	public void checkINPatient() throws SQLException {
		System.out.println("Welcome to WolfHospital! Will the patient be admitted to a room? Y/N");
		String answer = sc.nextLine();
		java.sql.Connection conn = Connection.getConnectionInstance();
		conn.setAutoCommit(false);
		boolean failure = false;
		if(answer.equals("N"))
			failure = checkIn.checkIN(false,conn);
		else if(answer.equals("Y"))
			failure = checkIn.checkIN(true,conn);
		else {
			System.out.println("please enter an valid option");
			System.exit(0);
		}
		if(!failure) {
			conn.rollback();
			System.out.println("Transaction Failed....we are rolling back the changes");
		}
		else{
			System.out.println("Patient successfully onboarded!");
			conn.commit();
			conn.setAutoCommit(true);
		}

			
	}

	public void generateReports() {
	    report.reportHome();
	}
	
	
	public void checkOutPatient() {
		System.out.println("Please enter the patient ID:");
		int patientID = sc.nextInt();

		if(!checkOut.checkActivePatient(patientID)) {
			//System.out.println("ABCD");
			checkOut.closePatientStatus(patientID);
		}
		else {
			System.out.println("No Patient with that ID or patient is already checked out!");
		}
		
	}

	public void getCurrentBill() {
		System.out.println("Please enter the patient ID:");
		int patientID = sc.nextInt();
		if(checkOut.checkPatient(patientID))
			bill.generateCurrentBill(patientID);
		else
			System.out.println("No Patient with that ID");
	}

	public void addTreatment() {
		System.out.println("Please enter the patient ID:");
		java.sql.Connection conn = Connection.getConnectionInstance();
		int patientID = sc.nextInt();
		try {
			if(checkOut.checkPatient(patientID))
				insert.insertTreatment(patientID, conn,false);
			else
				System.out.println("No Patient with that ID");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void checkExistingWardBed() {
		CheckInProcess.checkWards();		
	}

	public void insertNewStaff() {
		insert.insertStaff();
	}

	public void showStaff() {
		SelectStatement.getStaff(false);
	}

	public void showPatients() {
		SelectStatement.getPatient();
	}
	public void showWards() {
		SelectStatement.getWardDetails();
	}

	public void showBeds() {
		SelectStatement.getBeds();
	}

	public void showAvailableWards() {
		CheckInProcess.checkWards();
	}

	public void addBedDetails() {
		insert.createBed();
	}

	public void addWardDetails() {

		insert.createWard();
	}

	public void deletePatient() {
		System.out.println("Please enter the patient ID:");
		int patientID = sc.nextInt();

		if(checkOut.checkActivePatient(patientID)) {
			delete.deletePatient(patientID);
		}
		else {
			System.out.println("No Patient with that ID or Patient is under Treatment. Please checkout first.");
		}
	}

	public void deleteStaff() {
		System.out.println("Please enter the staff ID:");
		int staff = sc.nextInt();
		delete.deleteStaff(staff);
	}
	public void deleteWard() {
		System.out.println("Please enter the ward number:");
		int ward = sc.nextInt();
		delete.deleteWard(ward);
	}
	public void deleteBed() {
		System.out.println("Please enter the bed number & corresponding ward number");
		int bed = sc.nextInt();
		int ward = sc.nextInt();
		delete.deleteBed(bed,ward);
	}

	public void showMedicalRecords() {
		SelectStatement.getMedicalRecords();
	}

	public void showStaffByRole() {
		SelectStatement.getStaff(true);
	}

	public void updatePatient() {
		System.out.println("Please enter patientID:");
		int patientID = sc.nextInt();
		if(checkOut.checkPatient(patientID))
			UpdateStatements.updatePatient(patientID);
		else
			System.out.println("No Patient with that ID");
	}

	public void updateStaff() {
		System.out.println("Please enter staffID:");
		int staffID = sc.nextInt();
		if(checkOut.checkStaff(staffID))
			UpdateStatements.updateStaff(staffID);
		else
			System.out.println("No Staff with that ID");
	}

	public void updateWard() {
		System.out.println("Please enter Ward Number:");
		int wardNumber = sc.nextInt();
		if(checkOut.checkWard(wardNumber))
			UpdateStatements.updateWard(wardNumber);
		else
			System.out.println("No Ward with that ID");
	}
	
}
