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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `passwordSalt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `passwordSalt`) VALUES
('root', '/c6yzeCnfExykY/JX+iqP1c5WW6BpByhJCoEUHkMMF4iM3zcdOYzftJrS6W4CQdfqe9GoDeGRtEW4hgD4JfZnQ==', '+lZPp/Vyo06akyl+Hh+b5w=='),
('admin', 'G4sl9SVOViAowP1Vg9N95WZ7wtsh12puiXcw76u6toO2KgfOaHIsszEEGd8EU0gJVsCGZJ6BX01KjAuyh5M+pg==', 'nXlYoVJMkliEoMpGcIiDsw=='),
('harry@hogwarts.com', 'fY2Ql2niBW9hkbzavlxrC88H6CrgOAGh51XdB5cyEV3jv3PRdzQFZ8p/8y7W0JJAp9SVlNf1K53c9dHo1hT5LQ==', 'Yj4mfimr+xnlxK28lTSQyg=='),
('ashmy.as@ieee.org', 'H++MocTiPbRHmD5jAu1z2BgClppHj9JI5tw5rMeubfBHG92ICPUE8c/9YsMON5oMZdwgjhvH/mnnUkUOWbtkPQ==', 'bEIHKzO0KyE85XflPRuaSw=='),
('hermoine@hogwarts.com', 'a3a4YLhsGvSGKEUWDxIJ+hasnH7CoSNcMk1A8ICfBa6aCaABII14Tm8NXhd3FmnZ+CZAS+SP1xFdlOwoMtY2xw==', 'I6WgOnlTzy/2mgyeHOX3/g=='),
('sadSFd@AS.DSC', 'P1W+XltiJVqTdfuhT7M4wzW446zogpVNXBS6R6BEQevOTVpr4citCdgRFEExA1UfGDbaQgKoJrm7DlVko9SYIw==', 'yk3oS/CsS/0ttMQQE9y6kA=='),
('as@jh.dcdw', 'kWlyuVlczsAjdpWrIKcsRXhogYEotwSCh0bTL1HIqNCke6DsUQ8uN1AufYwYTef8fn6vtzEYQ3l41Hi603/sTg==', 'REowqTw9DrD5rSuivaAjTw=='),
('ashmy.as@gmail.com', 'tB5oidKQHDVcVa6gYix24vXMWb88a9LKeDoZeP60dY/QCATYVComzlkktW/7wr+1hd28kfyPYyrEJCx8KtggOw==', 'a4aoCxzOkyq1MZ/jW48n7Q==');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
