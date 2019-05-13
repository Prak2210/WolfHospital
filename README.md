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
