-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2024 at 04:49 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_jeep_routes`
--

-- --------------------------------------------------------

--
-- Table structure for table `jeep`
--

CREATE TABLE `jeep` (
  `jeepcode` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jeep`
--

INSERT INTO `jeep` (`jeepcode`) VALUES
('01A'),
('02B'),
('03A'),
('03C'),
('04A'),
('04B'),
('04D'),
('42C');

-- --------------------------------------------------------

--
-- Table structure for table `jeep_route`
--

CREATE TABLE `jeep_route` (
  `jeepcode` varchar(3) NOT NULL,
  `routename` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jeep_route`
--

INSERT INTO `jeep_route` (`jeepcode`, `routename`) VALUES
('01A', 'alpha'),
('01A', 'bravo'),
('01A', 'charlie'),
('01A', 'echo'),
('01A', 'golf'),
('02B', 'alpha'),
('02B', 'delta'),
('02B', 'echo'),
('02B', 'foxtrot'),
('02B', 'golf'),
('03C', 'charlie'),
('03C', 'delta'),
('03C', 'foxtrot'),
('03C', 'hotel'),
('03C', 'india'),
('04A', 'charlie'),
('04A', 'delta'),
('04A', 'echo'),
('04A', 'foxtrot'),
('04A', 'golf'),
('04D', 'india'),
('42C', 'juliet'),
('42C', 'kilo'),
('42C', 'lima'),
('42C', 'mike'),
('42C', 'oscar');

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `routename` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`routename`) VALUES
('alpha'),
('bravo'),
('charlie'),
('delta'),
('echo'),
('foxtrot'),
('golf'),
('hotel'),
('india'),
('juliet'),
('kilo'),
('lima'),
('mike'),
('november'),
('oscar'),
('papa'),
('quebec'),
('romeo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jeep`
--
ALTER TABLE `jeep`
  ADD PRIMARY KEY (`jeepcode`);

--
-- Indexes for table `jeep_route`
--
ALTER TABLE `jeep_route`
  ADD PRIMARY KEY (`jeepcode`,`routename`),
  ADD KEY `fk_jeeproute_route` (`routename`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`routename`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jeep_route`
--
ALTER TABLE `jeep_route`
  ADD CONSTRAINT `fk_jeeproute_jeep` FOREIGN KEY (`jeepcode`) REFERENCES `jeep` (`jeepcode`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_jeeproute_route` FOREIGN KEY (`routename`) REFERENCES `route` (`routename`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
