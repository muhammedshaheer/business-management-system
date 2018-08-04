-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 24, 2018 at 05:46 PM
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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `employeeID` varchar(10) NOT NULL,
  `firstName` varchar(127) NOT NULL,
  `lastName` varchar(127) NOT NULL,
  `emailId` varchar(512) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  PRIMARY KEY (`employeeID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employeeID`, `firstName`, `lastName`, `emailId`, `designation`, `phoneNumber`) VALUES
('1', 'q', 'w', 'q@q.q', 'CFO', '998'),
('91', 'Harry', 'Potter', 'harry@hogwarts.com', 'Managers', '987654'),
('12009', 'Hermoine', 'Granger', 'hermoine@hogwarts.com', 'CTO', '1234567890'),
('565443', 'wdasd', 'sdazcx', 'as@jh.dcdw', 'Sales Executive', '5132315'),
('87965', 'Mol', 'Mol', 'ashmy.as@gmail.com', 'Sales Executive', '9061225025');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
