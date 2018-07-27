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

-- Dumping data for table black_cat.addresses: ~5 rows (approximately)
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` (`id`, `Name`) VALUES
	(1, 'Mladost1'),
	(2, 'Mladost2'),
	(3, 'Mladost1A'),
	(4, 'Mladost3'),
	(5, 'Mladost4');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;

-- Dumping data for table black_cat.ads: ~0 rows (approximately)
/*!40000 ALTER TABLE `ads` DISABLE KEYS */;
/*!40000 ALTER TABLE `ads` ENABLE KEYS */;

-- Dumping data for table black_cat.estates: ~3 rows (approximately)
/*!40000 ALTER TABLE `estates` DISABLE KEYS */;
INSERT INTO `estates` (`Id`, `AddressID`, `MaterialID`, `Baths`, `Bedrooms`, `TypeID`, `Price`, `Size`) VALUES
	(1, 1, 1, 2, 3, 1, 120000, 160),
	(3, 2, 1, 3, 4, 2, 250000, 240),
	(5, 5, 3, 1, 0, 6, 200000, 170);
/*!40000 ALTER TABLE `estates` ENABLE KEYS */;

-- Dumping data for table black_cat.materials: ~4 rows (approximately)
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` (`Id`, `Name`) VALUES
	(1, 'Brick'),
	(2, 'Panel\r\n'),
	(3, 'EPK'),
	(4, 'Gredored');
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;

-- Dumping data for table black_cat.types: ~7 rows (approximately)
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` (`Id`, `Name`) VALUES
	(1, 'Apartment'),
	(2, 'House'),
	(3, 'Hotel'),
	(4, 'Garage'),
	(5, 'Zavedenie'),
	(6, 'Office'),
	(7, 'Zemq');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;

-- Dumping data for table black_cat.users: ~2 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`Id`, `Username`, `FirstName`, `SecondName`, `Password`) VALUES
	(1, 'user1', 'Ivan', 'Ivanov', '123456'),
	(2, 'user2', 'George', 'Georgiev', '12345');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
