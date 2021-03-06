# WolfHospital

Entire hospital management system is developed using Java. You can find the source code under CSC540 directory.

## Assumptions

1. Patients do not have access to the Hospital’s Database Management System.
2. Ward Information does not have Patient SSN as an attribute as Ward Information is linked with Patient via CheckIn.
3. Every Bed is uniquely identified by a number.
4. The field Visit Date has not been captured in Billing Account schema assuming that it is similar to Start Date of Medical record which is included as a primary key - foreign key relationship on Billing account.
5. Doctors and Nurse cannot view billing accounts and information for patients.
6. Operators cannot access treatment information for any medical records of a patient.
7. Patient cannot change the bed for an active medical-record.
8. There are multiple payment methods such as Cash, Card, DD, Cheque.
9. A staff can be responsible for multiple wards.
10. The Start_Date and End_Date in medical records have timestamp.
11. Responsible staff for each treatment is added under Treatment (attribute staff ID) relation showing responsible staff for different treatments during a medical record.
12. Capacity in Ward_Details represents type of ward (4-bed, 3-bed, 2-bed, 1-bed etc)


# Access Division
Entire system will have two different views for different classes of users.
1. Operators View (Receptionists)
2. Medical Staff View (Doctors and Nurse)

# Entity Relation Diagrams

## Operators View
![Operators View](https://user-images.githubusercontent.com/20255532/57651496-56e8f880-759b-11e9-870b-632418bdaf29.png)

## Medical Staff View
![Medical Staff](https://user-images.githubusercontent.com/20255532/57651495-56e8f880-759b-11e9-9e4a-1d499da998ca.png)


# Functions Available
At this moment, we have added these features:
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
