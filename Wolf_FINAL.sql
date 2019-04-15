-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 15, 2019 at 08:49 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Wolf`
--

-- --------------------------------------------------------

--
-- Table structure for table `Bed_Details`
--

CREATE TABLE `Bed_Details` (
  `Ward_Number` int(11) NOT NULL,
  `Bed_Number` int(11) NOT NULL,
  `Availability_Status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Bed_Details`
--

INSERT INTO `Bed_Details` (`Ward_Number`, `Bed_Number`, `Availability_Status`) VALUES
(1, 1, 0),
(1, 2, 0),
(1, 3, 1),
(1, 4, 1),
(2, 1, 0),
(2, 2, 1),
(2, 3, 1),
(2, 4, 1),
(3, 1, 1),
(3, 2, 1),
(4, 1, 1),
(4, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Billing_Account`
--

CREATE TABLE `Billing_Account` (
  `Record_ID` int(11) NOT NULL,
  `SSN_of_Payee` varchar(11) DEFAULT NULL,
  `Billing_Address` varchar(128) CHARACTER SET utf8 NOT NULL,
  `Payment_Method` varchar(128) CHARACTER SET utf8 NOT NULL,
  `Card_Number` bigint(20) DEFAULT NULL,
  `Registration_Fee` int(11) NOT NULL DEFAULT '100',
  `Accomodation_Fee` int(11) DEFAULT '0',
  `Treatment_Fee` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Billing_Account`
--

INSERT INTO `Billing_Account` (`Record_ID`, `SSN_of_Payee`, `Billing_Address`, `Payment_Method`, `Card_Number`, `Registration_Fee`, `Accomodation_Fee`, `Treatment_Fee`) VALUES
(1, '000011234', '69 ABC St , Raleigh NC 27730', 'Credit card', 4044875409613234, 100, 0, 100),
(2, '000021234', '81 DEF St , Cary NC 27519', 'Credit card', 4401982398541143, 100, 0, 0),
(3, '000031234', '31 OPG St , Cary NC 27519', 'Check', 0, 100, 0, 0),
(4, '000041234', '10 TBC St. Raleigh NC 27730', 'Credit card', 4044987612349123, 100, 400, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Medical_Record`
--

CREATE TABLE `Medical_Record` (
  `Record_ID` int(11) NOT NULL,
  `Start_Date` date NOT NULL,
  `End_Date` date DEFAULT NULL,
  `Status` tinyint(1) NOT NULL,
  `Patient_ID` int(11) NOT NULL,
  `Ward_Number` int(11) DEFAULT NULL,
  `Bed_Number` int(11) DEFAULT NULL,
  `Responsible_staff` int(11) DEFAULT NULL,
  `Prescription` varchar(100) DEFAULT NULL,
  `Diagnosis_Details` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Medical_Record`
--

INSERT INTO `Medical_Record` (`Record_ID`, `Start_Date`, `End_Date`, `Status`, `Patient_ID`, `Ward_Number`, `Bed_Number`, `Responsible_staff`, `Prescription`, `Diagnosis_Details`) VALUES
(1, '2019-03-01', '0000-00-00', 1, 1001, 1, 1, 100, 'Nervine', 'Hospitalization'),
(2, '2019-03-10', '0000-00-00', 1, 1002, 2, 1, 100, 'Nervine', 'Hospitalization'),
(3, '2019-03-15', '0000-00-00', 1, 1003, 1, 2, 100, 'Nervine', 'Hospitalization'),
(4, '2019-03-17', '2019-03-21', 0, 1004, 3, 1, 103, 'Analgesic', 'Surgeon, Hospitalization');

-- --------------------------------------------------------

--
-- Table structure for table `Patient`
--

CREATE TABLE `Patient` (
  `Patient_ID` int(11) NOT NULL,
  `SSN` varchar(11) DEFAULT NULL,
  `Name` varchar(128) CHARACTER SET utf8 NOT NULL,
  `DOB` date NOT NULL,
  `Gender` varchar(128) CHARACTER SET utf8 NOT NULL,
  `Phone` bigint(10) DEFAULT NULL,
  `Street_Address` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `Zipcode` int(11) DEFAULT NULL,
  `Status` varchar(128) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Patient`
--

INSERT INTO `Patient` (`Patient_ID`, `SSN`, `Name`, `DOB`, `Gender`, `Phone`, `Street_Address`, `Zipcode`, `Status`) VALUES
(1001, '000011234', 'David', '1980-01-30', 'Male', 9191233324, '69 ABC St, Raleigh NC', 27730, 'In Ward'),
(1002, '000021234', 'Sarah', '1971-01-30', 'Female', 9195633478, '81 DEF St, Cary NC', 27519, 'In Ward'),
(1003, '000031234', 'Joseph', '1987-01-30', 'Male', 9199572199, '31 OPG St, Cary NC', 27519, 'In Ward'),
(1004, '000041234', 'Lucy', '1985-01-30', 'Female', 9198387123, '10 TBC St, Raleigh NC', 27730, 'Completing Treatment');

-- --------------------------------------------------------

--
-- Table structure for table `Staff`
--

CREATE TABLE `Staff` (
  `Staff_ID` int(11) NOT NULL,
  `Name` varchar(128) CHARACTER SET utf8 NOT NULL,
  `Age` int(11) NOT NULL,
  `Gender` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `Job_Title` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `Professional_Title` varchar(128) CHARACTER SET utf8 NOT NULL,
  `Department` varchar(128) CHARACTER SET utf8 NOT NULL,
  `Phone` bigint(20) DEFAULT NULL,
  `Street_Address` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `Zipcode` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Staff`
--

INSERT INTO `Staff` (`Staff_ID`, `Name`, `Age`, `Gender`, `Job_Title`, `Professional_Title`, `Department`, `Phone`, `Street_Address`, `Zipcode`) VALUES
(100, 'Mary', 40, 'Female', 'Doctor', 'Senior', 'Neurology', 654, '90 ABC St, Raleigh NC', 27),
(101, 'John', 45, 'Male', 'Billing Staff', '', 'Office', 564, '798 XYZ St, Rochester NY', 54),
(102, 'Carol', 55, 'Female', 'Nurse', '', 'ER', 911, '351 MH St, Greensboro, NC', 27),
(103, 'Emma', 55, 'Female', 'Doctor', 'Senior Surgeon', 'Oncological Surgery', 546, '49 ABC St, Raleigh NC', 27),
(104, 'Ava', 55, 'Female', 'Front Desk Staff', '', 'Office', 777, '425 RG St, Raleigh NC', 27),
(105, 'Peter', 52, 'Male', 'Doctor', 'Anesthetist', 'Oncological Surgery', 724, '475 RG St, Raleigh NC', 27),
(106, 'Olivia', 27, 'Female', 'Nurse', '', 'Neurology', 799, '325 PD St, Raleigh NC', 27);

-- --------------------------------------------------------

--
-- Table structure for table `Treatment`
--

CREATE TABLE `Treatment` (
  `Treatment_ID` int(11) NOT NULL,
  `Record_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Treatment`
--

INSERT INTO `Treatment` (`Treatment_ID`, `Record_ID`) VALUES
(20, 1),
(20, 2),
(10, 3),
(5, 4);

-- --------------------------------------------------------

--
-- Table structure for table `Treatment_Master`
--

CREATE TABLE `Treatment_Master` (
  `Treatment_ID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Charge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Treatment_Master`
--

INSERT INTO `Treatment_Master` (`Treatment_ID`, `Description`, `Charge`) VALUES
(5, 'Cancer treatment', 20000),
(10, 'Cornial Surgery', 1000),
(20, 'Surgery', 200);

-- --------------------------------------------------------

--
-- Table structure for table `Ward_Details`
--

CREATE TABLE `Ward_Details` (
  `Ward_Number` int(11) NOT NULL,
  `Capacity` int(11) NOT NULL,
  `Charges` float NOT NULL,
  `Staff_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Ward_Details`
--

INSERT INTO `Ward_Details` (`Ward_Number`, `Capacity`, `Charges`, `Staff_ID`) VALUES
(1, 4, 50, 102),
(2, 4, 50, 102),
(3, 2, 100, 106),
(4, 2, 100, 106);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Bed_Details`
--
ALTER TABLE `Bed_Details`
  ADD PRIMARY KEY (`Ward_Number`,`Bed_Number`);

--
-- Indexes for table `Billing_Account`
--
ALTER TABLE `Billing_Account`
  ADD UNIQUE KEY `SSN_of_Payee` (`SSN_of_Payee`),
  ADD KEY `Record_ID` (`Record_ID`);

--
-- Indexes for table `Medical_Record`
--
ALTER TABLE `Medical_Record`
  ADD PRIMARY KEY (`Record_ID`),
  ADD KEY `medical_record_ibfk_1` (`Patient_ID`),
  ADD KEY `medical_record_ibfk_2` (`Ward_Number`,`Bed_Number`),
  ADD KEY `medical_record_ibfk_3` (`Responsible_staff`);

--
-- Indexes for table `Patient`
--
ALTER TABLE `Patient`
  ADD PRIMARY KEY (`Patient_ID`),
  ADD UNIQUE KEY `SSN` (`SSN`) USING BTREE;

--
-- Indexes for table `Staff`
--
ALTER TABLE `Staff`
  ADD PRIMARY KEY (`Staff_ID`);

--
-- Indexes for table `Treatment`
--
ALTER TABLE `Treatment`
  ADD KEY `Treatment_ID` (`Treatment_ID`),
  ADD KEY `Record_ID` (`Record_ID`);

--
-- Indexes for table `Treatment_Master`
--
ALTER TABLE `Treatment_Master`
  ADD PRIMARY KEY (`Treatment_ID`);

--
-- Indexes for table `Ward_Details`
--
ALTER TABLE `Ward_Details`
  ADD PRIMARY KEY (`Ward_Number`),
  ADD KEY `ward_details_ibfk_1` (`Staff_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Medical_Record`
--
ALTER TABLE `Medical_Record`
  MODIFY `Record_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Patient`
--
ALTER TABLE `Patient`
  MODIFY `Patient_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1010;

--
-- AUTO_INCREMENT for table `Staff`
--
ALTER TABLE `Staff`
  MODIFY `Staff_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=107;

--
-- AUTO_INCREMENT for table `Treatment_Master`
--
ALTER TABLE `Treatment_Master`
  MODIFY `Treatment_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `Ward_Details`
--
ALTER TABLE `Ward_Details`
  MODIFY `Ward_Number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Medical_Record`
--
ALTER TABLE `Medical_Record`
  ADD CONSTRAINT `medical_record_ibfk_1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`Patient_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `medical_record_ibfk_2` FOREIGN KEY (`Ward_Number`,`Bed_Number`) REFERENCES `Bed_Details` (`Ward_Number`, `Bed_Number`) ON DELETE SET NULL,
  ADD CONSTRAINT `medical_record_ibfk_3` FOREIGN KEY (`Responsible_staff`) REFERENCES `Staff` (`Staff_ID`) ON DELETE SET NULL;

--
-- Constraints for table `Ward_Details`
--
ALTER TABLE `Ward_Details`
  ADD CONSTRAINT `ward_details_ibfk_1` FOREIGN KEY (`Staff_ID`) REFERENCES `Staff` (`Staff_ID`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
