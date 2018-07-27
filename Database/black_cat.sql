-- MySQL dump 10.16  Distrib 10.3.8-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: black_cat
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
-- Table structure for table `Addresses`
--

DROP TABLE IF EXISTS `Addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Addresses` (
  `idAddresses` int(11) NOT NULL,
  `Name` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  PRIMARY KEY (`idAddresses`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Addresses`
--

LOCK TABLES `Addresses` WRITE;
/*!40000 ALTER TABLE `Addresses` DISABLE KEYS */;
/*!40000 ALTER TABLE `Addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ads`
--

DROP TABLE IF EXISTS `Ads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ads` (
  `idAds` int(11) NOT NULL,
  `Title` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `Description` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAds`),
  KEY `fk_users_idx` (`UserID`),
  CONSTRAINT `fk_users` FOREIGN KEY (`UserID`) REFERENCES `users` (`idUsers`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ads`
--

LOCK TABLES `Ads` WRITE;
/*!40000 ALTER TABLE `Ads` DISABLE KEYS */;
/*!40000 ALTER TABLE `Ads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estates`
--

DROP TABLE IF EXISTS `Estates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estates` (
  `idEstates` int(11) NOT NULL,
  `AddressId` int(11) DEFAULT NULL,
  `MaterialID` int(11) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `baths` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `bedrooms` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `TypeID` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEstates`),
  KEY `fk_addresses_idx` (`AddressId`),
  KEY `fk_materials_idx` (`MaterialID`),
  KEY `fk_types_idx` (`TypeID`),
  CONSTRAINT `fk_addresses` FOREIGN KEY (`AddressId`) REFERENCES `Addresses` (`idAddresses`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_materials` FOREIGN KEY (`MaterialID`) REFERENCES `Materials` (`idMaterials`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_types` FOREIGN KEY (`TypeID`) REFERENCES `Types` (`idTypes`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estates`
--

LOCK TABLES `Estates` WRITE;
/*!40000 ALTER TABLE `Estates` DISABLE KEYS */;
/*!40000 ALTER TABLE `Estates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Materials`
--

DROP TABLE IF EXISTS `Materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Materials` (
  `idMaterials` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`idMaterials`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Materials`
--

LOCK TABLES `Materials` WRITE;
/*!40000 ALTER TABLE `Materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `Materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Types`
--

DROP TABLE IF EXISTS `Types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Types` (
  `idTypes` int(11) NOT NULL,
  PRIMARY KEY (`idTypes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Types`
--

LOCK TABLES `Types` WRITE;
/*!40000 ALTER TABLE `Types` DISABLE KEYS */;
/*!40000 ALTER TABLE `Types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `idUsers` int(11) NOT NULL,
  `email` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `password` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `fullName` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `AddId` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsers`),
  KEY `fk_addId_idx` (`AddId`),
  CONSTRAINT `fk_addId` FOREIGN KEY (`AddId`) REFERENCES `Ads` (`idAds`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
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

-- Dump completed on 2018-07-27  9:20:30
