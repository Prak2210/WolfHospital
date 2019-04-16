/*
* This is a Menu based controller which allows selection of operation. You can consider it as a Front-end of our system which routes call to compute Engine.
* You can find a detailed menu here...which works as router to all the other methods.
* */
import java.sql.SQLException;
import java.util.*;


public class WolfHospitalController 
{
	public static void main(String[] args) 
	{
		//AVOID writing long methods here and in compute engine class...use them as drivers of the system only
		
		HospitalComputeEngine hospital = new HospitalComputeEngine();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("what would you like to do now?");
			System.out.println("1. CheckIn");
			System.out.println("2. CheckOut");
			System.out.println("3. Add Treatment");
			System.out.println("4. Billing");
			System.out.println("5. Generate Reports");
			System.out.println("6. Get Existing Ward Bed");
			System.out.println("7. Insert New Staff");
			System.out.println("8. Show all Staff");
			System.out.println("9. Show all Patients");
			System.out.println("10. Show all Wards");
			System.out.println("11. Show all Beds");
			System.out.println("12. Show all available Bed and Ward");
			System.out.println("13. Show Medical Records");
			System.out.println("14. Show Staff By Roles");
			System.out.println("15. Add Bed");
			System.out.println("16. Add Ward");
			System.out.println("17. Delete Patient Information");
			System.out.println("18. Delete Staff Information");
			System.out.println("19. Delete Ward Information");
			System.out.println("20. Delete Bed Information");
			System.out.println("21. Update Patient Basic Info");
			System.out.println("22. Update Staff Basic Info");
			System.out.println("23. Update Ward Charge or Capacity");
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("Enter valid selection or (press any other key to exit): ");
			int selection = sc.nextInt();
			
			
			if(selection == 1) {
				try {
					hospital.checkINPatient();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else if(selection == 2) 
				hospital.checkOutPatient();
			else if(selection == 3) 
				hospital.addTreatment();
			else if(selection == 4)
				hospital.getCurrentBill();
			else if(selection == 5) 
				hospital.generateReports();
			else if(selection == 6)
				hospital.checkExistingWardBed();
			else if(selection == 7)
				hospital.insertNewStaff();
			
			else if(selection == 8)
				hospital.showStaff();
			else if(selection == 9)
				hospital.showPatients();
			else if(selection == 10)
				hospital.showWards();
			else if(selection == 11)
				hospital.showBeds();
			else if(selection == 12)
				hospital.showAvailableWards();
			else if(selection == 13)
				hospital.showMedicalRecords();
			else if(selection == 14)
				hospital.showStaffByRole();
			
			else if(selection == 15)
				hospital.addBedDetails();
			else if(selection == 16)
				hospital.addWardDetails();
			
			else if(selection == 17)
				hospital.deletePatient();
			else if(selection == 18)
				hospital.deleteStaff();
			else if(selection == 19)
				hospital.deleteWard();
			else if(selection == 20)
				hospital.deleteBed();
			
			else if(selection == 21)
				hospital.updatePatient();
			else if(selection == 22)
				hospital.updateStaff();
			else if(selection==23)
				hospital.updateWard();
			else {
				sc.close();
				System.out.println("Bye");
				System.exit(0);
			}
		
		}
	   
	}

}
