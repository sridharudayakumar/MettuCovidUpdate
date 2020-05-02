-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2020 at 11:03 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mettucenter`
--

-- --------------------------------------------------------

--
-- Table structure for table `covidcase`
--

CREATE TABLE `covidcase` (
  `id` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `active` int(11) NOT NULL,
  `cured` int(11) NOT NULL,
  `critical` int(11) NOT NULL,
  `deaths` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `covidcase`
--

INSERT INTO `covidcase` (`id`, `total`, `active`, `cured`, `critical`, `deaths`) VALUES
(1, 133, 59, 69, 0, 3);

-- --------------------------------------------------------

--
-- Table structure for table `newsfeed`
--

CREATE TABLE `newsfeed` (
  `id` bigint(11) NOT NULL,
  `url` varchar(200) NOT NULL,
  `description` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `newsfeed`
--

INSERT INTO `newsfeed` (`id`, `url`, `description`) VALUES
(1, 'https://news.cgtn.com/news/2020-04-17/Chinese-medical-team-arrives-in-Ethiopia-to-help-in-COVID-19-fight-PLym4IZOQ8/index.html', 'Chinese medical team arrives in Ethiopia\r\n													to help in COVID-19 fight'),
(5, 'https://www.bloomberg.com/news/articles/2020-04-16/fear-of-economic-shock-hampers-ethiopia-s-coronavirus-fight', 'Ethiopia''s Nobel Laureate Is Hampering the Virus Fight');

-- --------------------------------------------------------

--
-- Table structure for table `patientinfo`
--

CREATE TABLE `patientinfo` (
  `patientId` int(11) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `middleName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `age` int(3) NOT NULL,
  `gender` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phoneNo` bigint(10) NOT NULL,
  `address` varchar(300) NOT NULL,
  `zone` varchar(30) NOT NULL,
  `kebele` varchar(30) NOT NULL,
  `woreda` varchar(30) NOT NULL,
  `region` varchar(50) NOT NULL,
  `country` varchar(100) NOT NULL,
  `citizenship` varchar(30) NOT NULL,
  `natureOfJob` varchar(50) NOT NULL,
  `preDisease` varchar(150) NOT NULL,
  `admittedOn` varchar(30) NOT NULL,
  `travelHistory` varchar(300) NOT NULL,
  `contactWithCases` varchar(10) NOT NULL,
  `presentStatus` varchar(30) NOT NULL,
  `ecfirstName` varchar(100) NOT NULL,
  `relationShip` varchar(30) NOT NULL,
  `ecAddress` varchar(400) NOT NULL,
  `ecPhoneNo` bigint(10) NOT NULL,
  `ecEmail` varchar(40) NOT NULL,
  `allergies` varchar(400) NOT NULL,
  `medications` varchar(400) NOT NULL,
  `operation1` varchar(300) NOT NULL,
  `doo1` varchar(20) NOT NULL,
  `operation2` varchar(300) NOT NULL,
  `doo2` varchar(20) NOT NULL,
  `operation3` varchar(300) NOT NULL,
  `doo3` varchar(20) NOT NULL,
  `familyHistory` varchar(400) NOT NULL,
  `smoke` varchar(10) NOT NULL,
  `pregnantRisk` varchar(10) NOT NULL,
  `symptoms` varchar(200) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientinfo`
--

INSERT INTO `patientinfo` (`patientId`, `firstName`, `middleName`, `lastName`, `age`, `gender`, `email`, `phoneNo`, `address`, `zone`, `kebele`, `woreda`, `region`, `country`, `citizenship`, `natureOfJob`, `preDisease`, `admittedOn`, `travelHistory`, `contactWithCases`, `presentStatus`, `ecfirstName`, `relationShip`, `ecAddress`, `ecPhoneNo`, `ecEmail`, `allergies`, `medications`, `operation1`, `doo1`, `operation2`, `doo2`, `operation3`, `doo3`, `familyHistory`, `smoke`, `pregnantRisk`, `symptoms`, `status`) VALUES
(6, 'Yosuf', 'adsfasdf', 'YZW', 6, 'Male', 'asd@gmail.com', 2462346464, 'Mettu', 'IlluAbabore', '', 'Mettu', 'Oromia', 'Ethiopia', '', 'Teaching', 'Nil', '2020-04-24', 'Nil', 'Yes', 'Critical', 'Dawid', 'Father', 'adfasdfadssdf', 5673651352, '', 'Nil', 'Nil', 'Nil', '', '', '', '', '', 'NO', 'Yes', 'No', 'Cough,Difficulty in breathing', 'active'),
(7, 'Tedros', 'jjjfd', 'B', 15, 'Male', 'asd@gmail.com', 7585785686, 'Mettu', 'mettu', '', '01', 'Benishangul Gumuz', 'Ethiopia', '', 'Teaching', 'Nil', '2020-04-16', 'From Dubai', 'No', 'Normal', 'Vinay', 'Neighborhood', 'adgnjjdgjgjgdj', 5673651352, '', 'Nil', 'Nil', '', '', '', '', '', '', 'NO', 'Yes', 'No', 'Cough,Body aches,Running nose', 'InActive'),
(8, 'Ramesh', 'Kumar', 'krishna', 46, 'Male', 'ramesh@gmail.com', 4262463473, 'Mettu', 'mettu', '', 'Mettu', 'Oromia', 'India', '', 'Teaching', 'Nil', '2020-04-27', 'From Dubai', 'No', 'Normal', 'Dawid', 'Friend', 'Mettu', 9787687513, '', 'Nil', '', 'Heart', '2020-06-02', '', '', '', '', 'Nil', 'Yes', 'No', 'Cough,Pressure in the chest', 'active'),
(9, 'Demesa', '', 'Lema', 24, 'Male', 'demesa@gmail.com', 4262463473, 'Mettu', 'Addis ababa', '', 'Addis ababa', 'Addis Ababa', 'Ethiopia', '', 'Teaching', 'Nil', '2020-04-23', 'Nil', 'Yes', 'Quarantined', 'Lema', 'Father', 'Mettu', 5673651352, 'adsf@gmail.com', 'Nil', 'Nil', '', '', '', '', '', '', 'NO', 'No', 'No', 'Cough,Sore throat', 'active'),
(10, 'Rajesh', '', 'Kumar', 35, 'Male', 'rajesh@gmail.com', 6764362462, 'Nehru Street, Delhi', 'Addis', '', '02', 'Addis Ababa', 'India', '', 'Teaching', 'Nil', '2020-04-28', 'From USA', 'No', 'Normal', 'Sanjay', 'Father', 'Delhi', 5846723453, '', 'Nil', 'Nil', '', '', '', '', '', '', 'NO', 'Yes', 'No', 'Cough,Running nose,Sore throat', 'active'),
(11, 'Senate', '', 'Abdi', 43, 'Female', 'senate@gmail.com', 9867646386, 'Mettu', 'Illu Aba bore', '', 'Mettu', 'Oromia', 'Ethiopia', '', 'Shop Owner', 'Nil', '2020-04-16', 'From Dubai', 'Yes', 'Recovered', 'Teddy', 'Neighborhood', 'adfsadfsdafdf', 9787687513, 'adsf@gmail.com', 'Nil', '', '', '', '', '', '', '', 'NO', 'No', 'No', 'Cough,Running nose', 'active'),
(12, 'Lalitha', '', 'Paranthaman', 37, 'Female', 'lalitha@gmail.com', 9866435433, 'Some Street', 'Amhara', '', 'Amhara', 'Amhara', 'Ethiopia', '', 'Teaching', 'Nil', '2020-04-23', 'Nil', 'Yes', 'Normal', 'Dawid', 'Neighborhood', 'adfasdfadssdf', 5846723453, '', 'Nil', '', '', '', '', '', '', '', 'NO', 'No', 'No', 'High Fever,Cough', 'active'),
(13, 'Javed', '', 'M', 56, 'Male', 'javed@gmail.com', 9867646333, 'Adama', 'adama', 'adama', 'adama', 'Addis Ababa', 'Ethiopia', 'India', 'Teaching', 'Nil', '2020-05-15', 'From India', 'Yes', 'Normal', 'Vinay', 'Friend', 'Adama', 8765665334, '', 'Nil', 'Nil', 'Nil', '', '', '', '', '', 'NO', 'Yes', 'No', 'High Fever,Cough', 'active'),
(14, 'Vimala', '', 'Rani', 24, 'Female', 'vimala@gmail.com', 7878653334, 'Mettu', 'mettu', 'Mettu', 'Mettu', 'Oromia', 'Ethiopia', 'India', 'Teaching', 'Nil', '2020-05-20', 'Nil', 'Yes', 'Recovered', 'Raja', 'Father', 'India', 8766528773, '', 'Nil', 'Nil', '', '', '', '', '', '', 'NO', 'No', 'No', 'Cough,Body aches', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `patientobservation`
--

CREATE TABLE `patientobservation` (
  `id` int(10) NOT NULL,
  `patientId` int(10) NOT NULL,
  `doo` varchar(30) NOT NULL,
  `temperature` int(11) NOT NULL,
  `bp` varchar(30) NOT NULL,
  `rbc` varchar(30) NOT NULL,
  `wbc` varchar(30) NOT NULL,
  `hb` varchar(30) NOT NULL,
  `hct` varchar(30) NOT NULL,
  `platelets` varchar(30) NOT NULL,
  `spo2` varchar(30) NOT NULL,
  `symptoms` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientobservation`
--

INSERT INTO `patientobservation` (`id`, `patientId`, `doo`, `temperature`, `bp`, `rbc`, `wbc`, `hb`, `hct`, `platelets`, `spo2`, `symptoms`) VALUES
(1, 6, '2020-05-01', 30, '140/80', '', '', '', '', '', '', 'Cough,Body aches'),
(2, 8, '2020-05-01', 28, '150/90', '', '', '', '', '', '', 'Difficulty in breathing,Body aches,Nasal Congestion'),
(3, 6, '2020-05-02', 28, '145/90', '', '', '', '', '', '', 'Cough'),
(4, 8, '2020-04-30', 30, '150/90', '10000', '', '', '', '', '', 'High Fever,Cough,Nasal Congestion,Running nose'),
(5, 6, '2020-04-30', 38, '150/90', '10000', '', '', '', '', '', 'High Fever,Cough,Difficulty in breathing');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(20) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userId`, `firstName`, `lastName`, `email`, `password`, `role`, `status`) VALUES
(1, 'Sridhar', 'U', 'sri123@gmail.com', '123456', 'Administrator', 'active'),
(3, 'Abdi', 'M', 'hospital@gmail.com', '123456', 'Hospital Staff', 'active'),
(4, 'Tedros', 'K', 'police@gmail.com', '123456', 'Police', 'active'),
(5, 'Begna', 'B', 'admin@gmail.com', '123456', 'Administrator', 'active'),
(12, 'Demesa', 'L', 'demesa@gmail.com', '13123123123', 'Police', 'InActive'),
(13, 'Sara', 'Elan', 'sara@gmail.com', '123456', 'Zone Health Bureau', 'active'),
(14, 'Wolkaba', 'A', 'pro@gmail.com', '123456', 'PRO', 'active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `covidcase`
--
ALTER TABLE `covidcase`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `newsfeed`
--
ALTER TABLE `newsfeed`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patientinfo`
--
ALTER TABLE `patientinfo`
  ADD PRIMARY KEY (`patientId`);

--
-- Indexes for table `patientobservation`
--
ALTER TABLE `patientobservation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `newsfeed`
--
ALTER TABLE `newsfeed`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `patientinfo`
--
ALTER TABLE `patientinfo`
  MODIFY `patientId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `patientobservation`
--
ALTER TABLE `patientobservation`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
