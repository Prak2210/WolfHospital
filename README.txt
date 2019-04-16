-------------------------------
CSC 540 
Wolf Hospital Management System
------------------------------- 

Documented By

Benzil John (bparass)
Prakshatkumar Shah (pmshah)
Sakthi Murugan (srmuruga)
Shrijeet Joshi (sjoshi22) 




-----------
Assumptions
-----------

1.Patients do not have access to the Hospital’s Database Management System.
2.Ward Information does not have Patient SSN as an attribute as Ward Information is linked with Patient via Medical Record.
3.Every Bed is uniquely identified by a number.
4.The field Visit Date has not been captured in Billing Account schema assuming that it is similar to Start Date of Medical record which is included as a primary key - foreign key relationship on Billing account.
5.Patient cannot change the bed for an active medical-record.
6.There are multiple payment methods such as Cash, Card, DD, Cheque.
7.A staff can be responsible for multiple wards.
8.Each treatment is added under Treatment relation which maps medical record to the treatment_plan in the treatment_master relation
9.Capacity in Ward_Details represents type of ward (4-bed, 3-bed, 2-bed, 1-bed etc)
10.There are only 3 treatment plan in the Hospital. Any new treament plan is added by the Database Administrator using the backend SQL prompt.

------------------------------------
Program Structure - Design Decisions
------------------------------------

Our application program runs in a menu style framework.

* Connection - Provides the interface for connection and disconnection to the JDBC
* WolfHospitalController - Provides the Main Menu interface with basic Hospital Operations for the Operator

The following are the operations listed in the Main Menu for the Hospital Front-desk staff:
1. CheckIn
2. CheckOut
3. Add Treatment
4. Billing
5. Generate Reports
6. Get Existing Ward Bed
7. Insert New Staff
8. Show all Staff
9. Show all Patients
10. Show all Wards
11. Show all Beds
12. Show all available Bed and Ward
13. Show Medical Records
14. Show Staff By Roles
15. Add Bed
16. Add Ward
17. Delete Patient Information
18. Delete Staff Information
19. Delete Ward Information
20. Delete Bed Information
21. Update Patient Basic Info
22. Update Staff Basic Info
23. Update Ward Charge or Capacity

The Generate Reports has the following menu list:
1. Patient's medical history
2. Ward/Bed usage status
3. Patients per month
4. Ward usage percentage
5. Patients the given staff responsible for
6. Staff grouped by role
7. Go to main menu

* HospitalComputeEngine - Provides the main interface for all the operations listed above.
* InsertStatement, SelectStatement, UpdateStatements, DeleteStatement class provides reusable functions for Insert/Select/Update/Delete records for all tables.
* CheckInProcess - Provides functionalities for onboarding a patient at the time of the visit.
* CheckOutProcess - Provides functionalities for checking out patient on completing treatment and generating the billing account for that visit.
* GenerateReports - Provides functions for implementing the tasks provided in the project narrative.

Our program uses Java bean classes for each table for extracting the records for the purpose of encapsulation, maintenance and easy access.


