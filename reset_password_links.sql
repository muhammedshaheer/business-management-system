-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 25, 2018 at 05:06 AM
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
-- Table structure for table `reset_password_links`
--

DROP TABLE IF EXISTS `reset_password_links`;
CREATE TABLE IF NOT EXISTS `reset_password_links` (
  `username` varchar(40) NOT NULL,
  `tokenhash` varchar(200) NOT NULL,
  `timestamp` timestamp(6) NOT NULL,
  `salt` varchar(150) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reset_password_links`
--

INSERT INTO `reset_password_links` (`username`, `tokenhash`, `timestamp`, `salt`) VALUES
('ckshaheer2012', 'DlyCsZ1dBgSZ1lLUx99BMSt55GO0ZaAFUa3ogGz/kmGFbTKtVyDP0yuf5Bx03/gSDbvJO/4P1THGP5cpXE/G8g==', '2018-07-22 23:28:03.748000', 'QTCaGUtod2fKoQBaGa9KLg=='),
('root', '43Mh+vgKYPLdFseuHXxbC57bbv31yN9Ts4GtqlgvGWPLOxNfZsUL6YUtjPU0mEmJVnnXek1uAQtEnfVSeCS8HQ==', '2018-07-24 19:50:44.126000', '7MWjEqJHn4yAw3KQf+Cx7A==');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
