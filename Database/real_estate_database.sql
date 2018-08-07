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
  PRIMARY KEY (`Id`),
  KEY `FK_properties_users` (`UserID`),
  KEY `FK_properties_materials` (`MaterialID`),
  KEY `FK_properties_addresses` (`AddressID`),
  KEY `FK_properties_types` (`TypeID`),
  CONSTRAINT `FK_properties_addresses` FOREIGN KEY (`AddressId`) REFERENCES `addresses` (`Id`),
  CONSTRAINT `FK_properties_materials` FOREIGN KEY (`MaterialID`) REFERENCES `materials` (`Id`),
  CONSTRAINT `FK_properties_types` FOREIGN KEY (`TypeId`) REFERENCES `types` (`Id`),
  CONSTRAINT `FK_properties_users` FOREIGN KEY (`UserID`) REFERENCES `users` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table real_estate.properties: ~2 rows (approximately)
/*!40000 ALTER TABLE `properties` DISABLE KEYS */;
INSERT INTO `properties` (`Id`, `Title`, `Description`, `Date`, `UserID`, `Size`, `Bedrooms`, `Baths`, `Price`, `TypeID`, `MaterialID`, `AddressID`) VALUES
	(1, 'Post1', 'Mladost 2 Bedrooms Apartment ', '2018-08-03 14:14:34', 2, 130, 3, 1, 120000, 1, 3, 1),
	(2, 'Post2', 'House in Musagenitsa', '2018-05-03 14:14:45', 1, 200, 2, 2, 150000, 2, 2, 6);
/*!40000 ALTER TABLE `properties` ENABLE KEYS */;

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
  `password` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `firstName` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `lastName` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

-- Dumping data for table real_estate.users: ~3 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`Id`, `username`, `email`, `password`, `firstName`, `lastName`) VALUES
	(1, 'janidrenchev', 'jani@abv.bg', '123456', 'Jani', 'Drenchev'),
	(2, 'adriyan', 'adriyan@yahoo.com', '123456', 'Adriyan', 'Mihaylov'),
	(3, 'testUsername', 'testusername@abv.bg', '123456', 'TestFirstName', 'TestSecondName');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
