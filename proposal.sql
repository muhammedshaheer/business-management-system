-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 26, 2018 at 07:22 AM
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
-- Table structure for table `proposal`
--

DROP TABLE IF EXISTS `proposal`;
CREATE TABLE IF NOT EXISTS `proposal` (
  `proposalID` int(11) NOT NULL AUTO_INCREMENT,
  `proposalName` varchar(127) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `dateOfAcceptance` date DEFAULT NULL,
  `dateOfModification` date DEFAULT NULL,
  `linkToFile` varchar(1000) DEFAULT NULL,
  `prospectID` int(11) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`proposalID`),
  UNIQUE KEY `prospectID` (`prospectID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proposal`
--

INSERT INTO `proposal` (`proposalID`, `proposalName`, `description`, `dateOfAcceptance`, `dateOfModification`, `linkToFile`, `prospectID`, `status`) VALUES
(1, 'madhav', 'hgvbhjk', '2018-06-30', '2018-07-26', 'C:/Ospyn/MainProject/workspace/bms/files/proposal/1.sql', 1, 'Accept');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
