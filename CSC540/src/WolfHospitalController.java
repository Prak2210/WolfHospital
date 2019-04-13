import java.util.*;

public class WolfHospitalController 
{
	public static void main(String[] args) 
	{
		//AVOID writing long methods here and in compute engine class...use them as drivers of the system only
		
		HospitalComputeEngine hospital = new HospitalComputeEngine();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			/*--------------------------------------------------------------------------------------------*/
			System.out.println("what would you like to do now?");
			System.out.println("1. checkIn");
			System.out.println("2. checkOut");
			System.out.println("3. Billing");
			System.out.println("4. Generate Reports \n");
			System.out.println("Enter valid selection or (press any other key to exit): ");
			int selection = sc.nextInt();
			/*--------------------------------------------------------------------------------------------*/
			
			//by Joshi
			if(selection == 1)
				hospital.checkINPatient();
			//by Prakshat
			else if(selection == 2) 
				hospital.checkOutPatient();
			else if(selection == 3)
				hospital.getCurrentBill();
			//by Sakthi
			else if(selection == 4) 
				hospital.generateReports();
			else {
				sc.close();
				System.out.println("Bye");
				System.exit(0);
			}
		
		}
	   
	}

}
