-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for real_estate
CREATE DATABASE IF NOT EXISTS `real_estate` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `real_estate`;

-- Dumping structure for table real_estate.addresses
CREATE TABLE IF NOT EXISTS `addresses` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table real_estate.addresses: ~7 rows (approximately)
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` (`Id`, `Name`) VALUES
	(1, 'Mladost 1'),
	(2, 'Mladost 1A'),
	(3, 'Mladost 2'),
	(4, 'Mladost 3'),
	(5, 'Mladost 4'),
	(6, 'Musagenitsa'),
	(7, 'Durvenitsa');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;

-- Dumping structure for table real_estate.materials
CREATE TABLE IF NOT EXISTS `materials` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table real_estate.materials: ~3 rows (approximately)
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` (`Id`, `Name`) VALUES
	(1, 'Brick'),
	(2, 'Panel'),
	(3, 'EPK');
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;

-- Dumping structure for table real_estate.properties
CREATE TABLE IF NOT EXISTS `properties` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) NOT NULL DEFAULT '0',
  `Description` varchar(255) DEFAULT NULL,
  `Date` datetime NOT NULL,
  `UserID` int(11) NOT NULL,
  `Size` int(11) NOT NULL DEFAULT 0,
  `Bedrooms` int(11) DEFAULT 0,
  `Baths` int(11) DEFAULT 0,
  `Price` int(11) NOT NULL DEFAULT 0,
  `TypeID` int(11) NOT NULL,
  `MaterialID` int(11) NOT NULL,
  `AddressID` int(11) NOT NULL,
  `imgSrc` text DEFAULT '',
  PRIMARY KEY (`Id`),
  KEY `FK_properties_users` (`UserID`),
  KEY `FK_properties_materials` (`MaterialID`),
  KEY `FK_properties_addresses` (`AddressID`),
  KEY `FK_properties_types` (`TypeID`),
  CONSTRAINT `FK_properties_addresses` FOREIGN KEY (`AddressID`) REFERENCES `addresses` (`Id`),
  CONSTRAINT `FK_properties_materials` FOREIGN KEY (`MaterialID`) REFERENCES `materials` (`Id`),
  CONSTRAINT `FK_properties_types` FOREIGN KEY (`TypeID`) REFERENCES `types` (`Id`),
  CONSTRAINT `FK_properties_users` FOREIGN KEY (`UserID`) REFERENCES `users` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table real_estate.properties: ~7 rows (approximately)
/*!40000 ALTER TABLE `properties` DISABLE KEYS */;
INSERT INTO `properties` (`Id`, `Title`, `Description`, `Date`, `UserID`, `Size`, `Bedrooms`, `Baths`, `Price`, `TypeID`, `MaterialID`, `AddressID`, `imgSrc`) VALUES
	(1, 'Post1', 'Mladost 2 Bedrooms Apartment ', '2018-08-03 14:14:34', 2, 130, 3, 1, 120000, 1, 3, 1, 'http://localhost:8080/img/list/1.png'),
	(2, 'Post2', 'House in Musagenitsa', '2018-05-03 14:14:45', 1, 200, 2, 2, 150000, 2, 2, 6, 'http://localhost:8080/img/list/2.png'),
	(3, 'PropertyWithImage', 'ImageTRest', '2018-08-09 12:10:22', 1, 120, 3, 2, 180000, 2, 2, 3, 'http://localhost:8080/img/list/3.png'),
	(4, 'PropertyWithImage', 'ImageTRest', '2018-08-09 12:10:22', 1, 80, 3, 2, 500000, 2, 2, 3, 'http://localhost:8080/img/list/4.png'),
	(5, 'PropertyWithImage', 'ImageTRest', '2018-08-09 12:10:22', 1, 120, 3, 2, 100000, 2, 2, 3, 'http://localhost:8080/img/list/5.png'),
	(6, 'PropertyWithImage', 'ImageTRest', '2018-08-09 12:10:22', 1, 100, 3, 2, 180000, 2, 2, 3, 'http://localhost:8080/img/list/6.png'),
	(7, 'PropertyWithImage', 'ImageTRest', '2018-08-09 12:10:22', 1, 90, 3, 2, 600000, 2, 2, 3, 'http://localhost:8080/img/list/6.png');
/*!40000 ALTER TABLE `properties` ENABLE KEYS */;

-- Dumping structure for table real_estate.role
CREATE TABLE IF NOT EXISTS `role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Role` varchar(50) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table real_estate.role: ~2 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`Id`, `Role`, `name`) VALUES
	(1, 'ADMIN\r\n', ''),
	(2, 'USER', '');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table real_estate.types
CREATE TABLE IF NOT EXISTS `types` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

-- Dumping data for table real_estate.types: ~3 rows (approximately)
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` (`Id`, `Name`) VALUES
	(1, 'Apartment'),
	(2, 'House'),
	(3, 'Garage');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;

-- Dumping structure for table real_estate.users
CREATE TABLE IF NOT EXISTS `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `firstName` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `lastName` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `RoleID` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `FK_users_role` (`RoleID`),
  CONSTRAINT `FK_users_role` FOREIGN KEY (`RoleID`) REFERENCES `role` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

-- Dumping data for table real_estate.users: ~6 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`Id`, `username`, `email`, `password`, `firstName`, `lastName`, `RoleID`) VALUES
	(1, 'janidrenchev', 'jani@abv.bg', '123456', 'Jani', 'Drenchev', 1),
	(2, 'adriyan', 'adriyan@yahoo.com', '123456', 'Adriyan', 'Mihaylov', 1),
	(3, 'testUsername', 'testusername@abv.bg', '123456', 'TestFirstName', 'TestSecondName', 2),
	(4, 'registered', 'registered@abv.bg', '$2a$10$TCDCZmrrhCbJSb7iymL40uX.UP/h5ko5LQoMjxOrkIkee610d9VAe', NULL, NULL, 1),
	(6, 'adriyanmihaylov', 'adriyanmihaylov@yahoo.com', '$2a$10$cjbe3O4vRl7hu2cvJj5wP.WLia0IOMTDOfwAYlCQggLUHRhgyded6', NULL, NULL, 2),
	(7, 'user', 'user@yahoo.com', '$2a$10$XiVNc9WVKAY8zg9VuvXAEutzS01CQ5CsEocv0QN497.fw5wBxRiBi', NULL, NULL, 2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table real_estate.user_roles
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_email` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table real_estate.user_roles: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
