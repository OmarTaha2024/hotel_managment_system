-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2022 at 09:40 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `name` varchar(25) NOT NULL,
  `room_ID` int(3) NOT NULL,
  `nationality` varchar(20) NOT NULL,
  `nationalID` varchar(14) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `city` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`name`, `room_ID`, `nationality`, `nationalID`, `address`, `phone`, `city`, `email`) VALUES
('Mostafa', 11, 'Egyptian', '*******', '**********', '***********', '**********', '************'),
('Mohammed', 11, '123', '123', '123', '123', '123', '123'),
('Mohammed', 12, '123', '123', '123', '123', '123', '123'),
('Ahmed', 11, '*******', '*********', '************', '8', '*********', '8*'),
('Mostafa', 11, '123', '123', '123', '123', '123', '123'),
('ahmed', 1, '123', '123', '123', '123', '123', '123'),
('ahmed', 12, '123', '123', '123', '123', '123', '123'),
('mahmoud', 13, '123', '123', '123123', '123', '123', '123'),
('taha', 13, '123', '123123', '123', '123', '123', '123'),
('mohammed', 12, '**', '**', '*', '*', '*', '*'),
('ahmed', 11, 'asdas', 'sda', 'asd', 'asd', 'asd', 'asd'),
('Ahmed', 11, 'egyptian', '123', '11st', '123', 'cairo', '.com');

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `RoomID` varchar(3) NOT NULL,
  `breakfast` tinyint(1) NOT NULL,
  `lunch` tinyint(1) NOT NULL,
  `dinner` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`RoomID`, `breakfast`, `lunch`, `dinner`) VALUES
('1', 0, 0, 0),
('2', 0, 0, 0),
('3', 0, 0, 0),
('4', 0, 0, 0),
('5', 0, 0, 0),
('6', 1, 1, 1),
('7', 0, 0, 0),
('8', 0, 0, 0),
('9', 0, 0, 0),
('10', 0, 0, 0),
('11', 0, 0, 0),
('12', 0, 0, 0),
('13', 0, 0, 0),
('14', 0, 0, 0),
('15', 0, 0, 0),
('16', 0, 0, 0),
('17', 0, 0, 0),
('18', 0, 0, 0),
('19', 0, 0, 0),
('20', 0, 0, 0),
('21', 0, 0, 0),
('22', 0, 0, 0),
('23', 0, 0, 0),
('24', 0, 0, 0),
('25', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `roomID` int(3) NOT NULL,
  `roomType` varchar(10) NOT NULL,
  `isBooked` varchar(45) NOT NULL DEFAULT 'false',
  `num_of_Days` int(3) NOT NULL,
  `owner` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`roomID`, `roomType`, `isBooked`, `num_of_Days`, `owner`) VALUES
(1, 'VIP', 'false', 0, 'false'),
(2, 'VIP', 'false', 0, 'false'),
(3, 'VIP', 'false', 0, 'false'),
(4, 'VIP', 'false', 0, 'false'),
(5, 'VIP', 'false', 0, 'false'),
(6, 'VIP', 'false', 0, 'false'),
(7, 'VIP', 'false', 0, 'false'),
(8, 'VIP', 'false', 0, 'false'),
(9, 'VIP', 'false', 0, 'false'),
(10, 'VIP', 'false', 0, 'false'),
(11, 'Normal', 'true', 4, 'Ahmed'),
(12, 'Normal', 'false', 0, 'false'),
(13, 'Normal', 'false', 0, 'false'),
(14, 'Normal', 'false', 0, 'false'),
(15, 'Normal', 'false', 0, 'false'),
(16, 'Normal', 'false', 0, 'false'),
(17, 'Normal', 'false', 0, 'false'),
(18, 'Normal', 'false', 0, 'false'),
(19, 'Normal', 'false', 0, 'false'),
(20, 'Normal', 'false', 0, 'false'),
(21, 'Economy', 'false', 0, 'false'),
(22, 'Economy', 'false', 0, 'false'),
(23, 'Economy', 'false', 0, 'false'),
(24, 'Economy', 'false', 0, 'false'),
(25, 'Economy', 'false', 0, 'false'),
(26, 'Economy', '0', 0, ''),
(27, 'Economy', '0', 0, ''),
(28, 'Economy', '0', 0, ''),
(29, 'Economy', '0', 0, ''),
(30, 'Economy', '0', 0, ''),
(31, 'Normal', 'false', 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `username` varchar(35) NOT NULL,
  `password` varchar(35) NOT NULL,
  `privilege` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `username`, `password`, `privilege`) VALUES
(1, 'Omar Zakaria', 'root', 'admin'),
(2, 'Omar Taha', 'pass', 'user'),
(3, 'Omar Abdelgawad', 'pass', 'user'),
(4, 'Omar Akwah', 'pass', 'user'),
(5, 'Abdelrahman ', 'pass', 'user'),
(6, 'Mohammed', 'pass', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`roomID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UNIQUE` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `roomID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
