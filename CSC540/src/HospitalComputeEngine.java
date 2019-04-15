import java.sql.SQLException;
import java.util.Scanner;
public class HospitalComputeEngine {
	static Scanner sc = new Scanner(System.in);
	CheckInProcess checkIn = new CheckInProcess();
	GenerateReports report = new GenerateReports();
	BillManipulations bill = new BillManipulations();
	CheckOutProcess checkOut = new CheckOutProcess();
	InsertStatement insert = new InsertStatement();	
	DeleteStatement delete = new DeleteStatement();
	
	public void checkINPatient(){
		System.out.println("Welcome to WolfHospital! Will the patient be admitted to a room? Y/N");
		String answer = sc.nextLine();
		
		if(answer.equals("N"))
			checkIn.checkIN(false);
		else if(answer.equals("Y"))
			checkIn.checkIN(true);
		else {
			System.out.println("please enter an valid option");
			System.exit(0);
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
		bill.generateCurrentBill(patientID);
	}

	public void addTreatment() {
		System.out.println("Please enter the patient ID:");
		int patientID = sc.nextInt();
		try {
			insert.insertTreatment(patientID);
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
		UpdateStatements.updatePatient(patientID);
		
	}

	public void updateStaff() {
		System.out.println("Please enter staffID:");
		int staffID = sc.nextInt();
		UpdateStatements.updateStaff(staffID);
		
	}

	public void updateWard() {
		System.out.println("Please enter Ward Number:");
		int wardNumber = sc.nextInt();
		UpdateStatements.updateWard(wardNumber);
	}
	
}
