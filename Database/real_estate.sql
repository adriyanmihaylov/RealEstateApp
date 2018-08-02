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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table real_estate.addresses: ~0 rows (approximately)
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;

-- Dumping structure for table real_estate.estates
CREATE TABLE IF NOT EXISTS `estates` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `AddressID` int(11) NOT NULL,
  `MaterialID` int(11) NOT NULL,
  `TypeID` int(11) NOT NULL,
  `Price` int(11) unsigned NOT NULL,
  `Baths` int(10) unsigned DEFAULT 0,
  `Bedrooms` int(10) unsigned DEFAULT 0,
  PRIMARY KEY (`Id`),
  KEY `FK_estates_addresses` (`AddressID`),
  KEY `FK_estates_materials` (`MaterialID`),
  KEY `FK_estates_types` (`TypeID`),
  CONSTRAINT `FK_estates_addresses` FOREIGN KEY (`AddressID`) REFERENCES `addresses` (`Id`),
  CONSTRAINT `FK_estates_materials` FOREIGN KEY (`MaterialID`) REFERENCES `materials` (`Id`),
  CONSTRAINT `FK_estates_types` FOREIGN KEY (`TypeID`) REFERENCES `types` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

-- Dumping data for table real_estate.estates: ~0 rows (approximately)
/*!40000 ALTER TABLE `estates` DISABLE KEYS */;
/*!40000 ALTER TABLE `estates` ENABLE KEYS */;

-- Dumping structure for table real_estate.materials
CREATE TABLE IF NOT EXISTS `materials` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table real_estate.materials: ~0 rows (approximately)
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;

-- Dumping structure for table real_estate.posts
CREATE TABLE IF NOT EXISTS `posts` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) NOT NULL DEFAULT '0',
  `UserID` int(10) unsigned NOT NULL DEFAULT 0,
  `Description` varchar(255) DEFAULT NULL,
  `Date` datetime NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_posts_users` (`UserID`),
  CONSTRAINT `FK_posts_users` FOREIGN KEY (`UserID`) REFERENCES `users` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table real_estate.posts: ~0 rows (approximately)
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;

-- Dumping structure for table real_estate.types
CREATE TABLE IF NOT EXISTS `types` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

-- Dumping data for table real_estate.types: ~2 rows (approximately)
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` (`Id`, `Name`) VALUES
	(1, 'Apartment'),
	(2, 'House');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;

-- Dumping structure for table real_estate.users
CREATE TABLE IF NOT EXISTS `users` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `firstName` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `lastName` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

-- Dumping data for table real_estate.users: ~0 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
