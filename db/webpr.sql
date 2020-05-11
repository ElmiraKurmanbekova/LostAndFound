-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 11, 2020 at 01:29 PM
-- Server version: 5.7.30-0ubuntu0.16.04.1
-- PHP Version: 7.0.33-0ubuntu0.16.04.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webpr`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(7),
(7),
(7);

-- --------------------------------------------------------

--
-- Table structure for table `objects`
--

CREATE TABLE `objects` (
  `id` bigint(20) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `date` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `objects`
--

INSERT INTO `objects` (`id`, `category`, `date`, `description`, `status`, `title`) VALUES
(1, 'ID Card', '2020-05-08 00:15:00', 'I have found a id card. Student number is 16010109832', 'active', 'ID card found');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `active`, `email`, `name`, `password`, `phonenumber`, `student_id`, `surname`) VALUES
(1, 1, 'kanat@gmail.com', 'Kanat', '$2a$10$p1WyFAN9rkyNgJGMqQ4OGuzIxgd.Kg6xvCE/MjvPxwmKHj6EPvs3.', '0550717171', 15010109852, 'Isaev'),
(2, 1, 'sake@gmail.com', 'Sake', '$2a$10$0KXcKFYtU2YcfLP0W8G.kuTQNXxp7GKvjRKGgNov/PJaoNJ1U0u22', '0764287823', 1691918237, 'Zheniki'),
(3, 1, 'admin@gmail.com', 'Admin', '$2a$10$IX/VpERsZV0fpONNvEH9yeXBfHwg5uZw/Fgo2rIiU/o0gBzNk7rQ6', '07063213432', 1, 'ADmins'),
(4, 1, 'eak@gmail.com', 'Eak', '$2a$10$AVq7PBiDNjNdeu0eYCXma.BNHF4xNgdoPA20pg6mRHvZ/8XNYNXYm', '471238247823', 15010109833, 'kea'),
(5, 1, 'bale@gmail.com', 'Gareth', '$2a$10$MssT3c2COJXHbHR5fR18wepLV0mwXirtZqY0egMYfvLZh5uA9IuNi', '9988334245', 1691928373, 'Bale'),
(6, 1, 'ronaldo@gmal.com', 'Ronaldo', '$2a$10$M8kd9alyCosl.fBwIpeadOnbzMN7nBMwnak8hDCXGmv/lB9GXf2XK', '7897878678', 19893783, 'Cristiano');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(2, 2),
(3, 1),
(4, 2),
(5, 2),
(6, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `objects`
--
ALTER TABLE `objects`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
