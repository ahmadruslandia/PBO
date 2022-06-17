-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2022 at 06:42 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `courselist_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `allcourse`
--

CREATE TABLE `allcourse` (
  `id` int(11) NOT NULL,
  `course_name` varchar(30) NOT NULL,
  `course_number` varchar(50) NOT NULL,
  `course_enrollment` bigint(20) NOT NULL,
  `course_start` date NOT NULL,
  `course_end` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `allcourse`
--

INSERT INTO `allcourse` (`id`, `course_name`, `course_number`, `course_enrollment`, `course_start`, `course_end`) VALUES
(1, 'Pemrograman Berorientasi Objek', '1303KKA403 - 20212 - A1 B1 B2 B3', 122, '2021-05-20', '2022-01-20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allcourse`
--
ALTER TABLE `allcourse`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `allcourse`
--
ALTER TABLE `allcourse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
