-- MySQL dump 10.16  Distrib 10.3.8-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: real_estate
-- ------------------------------------------------------
-- Server version	10.3.8-MariaDB-1:10.3.8+maria~bionic-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresses` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'Mladost 1'),(2,'Mladost 1A'),(3,'Mladost 2'),(4,'Mladost 3'),(5,'Mladost 4'),(6,'Musagenitsa'),(7,'Durvenitsa');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materials` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (1,'Brick'),(2,'Panel'),(3,'EPK');
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `properties`
--

DROP TABLE IF EXISTS `properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `properties` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `properties`
--

LOCK TABLES `properties` WRITE;
/*!40000 ALTER TABLE `properties` DISABLE KEYS */;
INSERT INTO `properties` VALUES (1,'Post1','Mladost 2 Bedrooms Apartment ','2018-08-03 14:14:34',2,130,3,1,120000,1,3,1,'http://localhost:8080/img/list/1.png'),(2,'Post2','House in Musagenitsa','2018-05-03 14:14:45',1,200,2,2,150000,2,2,6,'http://localhost:8080/img/list/2.png'),(3,'PropertyWithImage','ImageTRest','2018-08-09 12:10:22',1,120,3,2,180000,2,2,3,'http://localhost:8080/img/list/3.png'),(4,'PropertyWithImage','ImageTRest','2018-08-09 12:10:22',1,80,3,2,500000,2,2,3,'http://localhost:8080/img/list/4.png'),(5,'PropertyWithImage','ImageTRest','2018-08-09 12:10:22',1,120,3,2,100000,2,2,3,'http://localhost:8080/img/list/5.png'),(6,'PropertyWithImage','ImageTRest','2018-08-09 12:10:22',1,100,3,2,180000,2,2,3,'http://localhost:8080/img/list/6.png'),(7,'PropertyWithImage','ImageTRest','2018-08-09 12:10:22',1,90,3,2,600000,2,2,3,'http://localhost:8080/img/list/6.png');
/*!40000 ALTER TABLE `properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Role` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN\r\n'),(2,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types`
--

DROP TABLE IF EXISTS `types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `types` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` VALUES (1,'Apartment'),(2,'House'),(3,'Garage');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `firstName` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `lastName` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  `RoleID` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `FK_users_role` (`RoleID`),
  CONSTRAINT `FK_users_role` FOREIGN KEY (`RoleID`) REFERENCES `role` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'janidrenchev','jani@abv.bg','123456','Jani','Drenchev',1),(2,'adriyan','adriyan@yahoo.com','123456','Adriyan','Mihaylov',1),(3,'testUsername','testusername@abv.bg','123456','TestFirstName','TestSecondName',2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-09 17:53:56
