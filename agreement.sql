-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 18, 2018 at 08:29 AM
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
-- Table structure for table `agreement`
--

DROP TABLE IF EXISTS `agreement`;
CREATE TABLE IF NOT EXISTS `agreement` (
  `agreementId` int(5) NOT NULL AUTO_INCREMENT,
  `prospectId` int(5) NOT NULL,
  `dateOfAgreement` date NOT NULL,
  `finishingDate` date NOT NULL,
  `periodOfContract` int(10) NOT NULL,
  `estimateAmount` double NOT NULL,
  `terminationConditions` varchar(200) NOT NULL,
  `confirm` tinyint(1) NOT NULL,
  `linkToFIle` varchar(200) NOT NULL,
  PRIMARY KEY (`agreementId`),
  KEY `foreign_key_prospect` (`prospectId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `agreement`
--
ALTER TABLE `agreement`
  ADD CONSTRAINT `foreign_key_prospect` FOREIGN KEY (`prospectId`) REFERENCES `prospect` (`prospectID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
