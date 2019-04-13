import java.util.Scanner;

public class HospitalComputeEngine {
	static Scanner sc = new Scanner(System.in);
	CheckInProcess checkIn = new CheckInProcess();
	GenerateReports report = new GenerateReports();
	BillManipulations bill = new BillManipulations();
	CheckOutProcess checkOut = new CheckOutProcess();
	
	public void checkINPatient()
	{
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
	    System.out.println("Please enter PatientID");
	    int patientID = sc.nextInt();
		report.getMedicalHistoryOfPatient(patientID);
	}
	
	
	public void checkOutPatient() {
		System.out.println("Please enter the patient ID:");
		int patientID = sc.nextInt();

		if(checkOut.checkPatient(patientID)) {
			checkOut.closePatientStatus(patientID);
		}
		else {
			System.out.println("NO PATIENT WITH THAT ID");
		}
		
	}

	public void getCurrentBill() {
		System.out.println("Please enter the patient ID:");
		int patientID = sc.nextInt();
		bill.generateCurrentBill(patientID);
	}
	
}
