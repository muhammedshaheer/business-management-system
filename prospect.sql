-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 26, 2018 at 07:23 AM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `businessmanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `prospect`
--

DROP TABLE IF EXISTS `prospect`;
CREATE TABLE IF NOT EXISTS `prospect` (
  `prospectID` int(5) NOT NULL AUTO_INCREMENT,
  `prospectName` varchar(255) DEFAULT NULL,
  `dateOfIdentification` date DEFAULT NULL,
  `specification` varchar(1000) DEFAULT NULL,
  `prospectType` varchar(127) DEFAULT NULL,
  `sector` varchar(127) DEFAULT NULL,
  `customerID` int(5) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `responseDeadline` date DEFAULT NULL,
  `employeeInChargeID` int(5) DEFAULT NULL,
  `budget` int(11) NOT NULL DEFAULT '0',
  `status` varchar(20) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `linkToFile` varchar(1000) DEFAULT NULL,
  `proposalID` int(11) DEFAULT NULL,
  PRIMARY KEY (`prospectID`),
  UNIQUE KEY `proposalID` (`proposalID`),
  KEY `foreign_key` (`customerID`),
  KEY `foreign_key_emp` (`employeeInChargeID`)
) ENGINE=MyISAM AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prospect`
--

INSERT INTO `prospect` (`prospectID`, `prospectName`, `dateOfIdentification`, `specification`, `prospectType`, `sector`, `customerID`, `source`, `responseDeadline`, `employeeInChargeID`, `budget`, `status`, `category`, `linkToFile`, `proposalID`) VALUES
(7, 'werg', '2018-07-22', 'ewrefd', 'RFP', 'Public', 4, 'wedf', '2018-08-04', 91, 0, 'Pending', 'Hot', 'C:/Ospyn/MainProject/workspace/bms/files/prospect/7.sql', NULL),
(6, '3243546', '2018-07-14', '32wergfd', 'RFP', 'Public', 2, 'werwagfdsbv', '2018-07-28', 91, 0, 'Pending', 'Hot', 'C:/Ospyn/MainProject/workspace/bms/files/prospect/6.sql', NULL),
(5, 'qwerfds', '2018-07-07', 'asdfd', 'RFP', 'Public', 2, 'wdfcx', '2018-07-28', 1, 0, 'Pending', 'Hot', 'C:/Ospyn/MainProject/workspace/bms/files/prospect/5.sql', NULL),
(3, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL),
(4, 'ewaretryt', '2018-07-06', 'weretrgfd', 'RFP', 'Public', 1, 'ertryt', '2018-07-29', 12009, 0, 'Pending', 'Hot', 'C:/Ospyn/MainProject/workspace/bms/files/prospect/4.sql', NULL),
(8, 'dwfegrt', '2018-07-21', 'wqewds', 'RFP', 'Public', 2, 'wqefd', '2018-07-27', 91, 0, 'Pending', 'Hot', 'C:/Ospyn/MainProject/workspace/bms/files/prospect/8.sql', NULL),
(2, 'swdert', '2018-06-28', 'q3r4t5yth', 'RFP', 'Public', 1, '31rtgf', '2018-07-28', 12009, 0, 'Pending', 'Hot', 'C:/Ospyn/MainProject/workspace/bms/files/prospect/2.sql', NULL),
(1, 'DDFS', '2018-07-22', 'qwertyuio', 'RFP', 'Public', 3, 'bjhvh', '2018-07-28', 12009, 0, 'Accept', 'Hot', 'C:/Ospyn/MainProject/workspace/bms/files/prospect/1.sql', 1),
(9, 'dwfegrt', '2018-07-21', 'wqewds', 'RFP', 'Public', 2, 'wqefd', '2018-07-27', 91, 0, 'Pending', 'Hot', 'C:/Ospyn/MainProject/workspace/bms/files/prospect/9.sql', NULL),
(10, 'qwer', '2018-07-14', 'wqedfcxzdwqe', 'RFP', 'Public', 2, '23erdw', '2018-07-28', 1, 0, 'Pending', 'Hot', 'C:/Ospyn/MainProject/workspace/bms/files/prospect/10.sql', NULL),
(11, 'qwerf', '2018-07-15', 'wef', 'RFP', 'Public', 3, 'kschagc', '2018-07-28', 12009, 132030, 'Pending', 'Hot', 'C:/Ospyn/MainProject/workspace/bms/files/prospect/11.sql', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
