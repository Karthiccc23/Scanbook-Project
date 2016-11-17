-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: scanbook
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `books_inventory`
--

DROP TABLE IF EXISTS `books_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books_inventory` (
  `isbn` bigint(20) NOT NULL,
  `Title` varchar(50) DEFAULT NULL,
  `Author` varchar(50) DEFAULT NULL,
  `Noofpages` int(11) DEFAULT NULL,
  `Publisher` varchar(45) DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_inventory`
--

LOCK TABLES `books_inventory` WRITE;
/*!40000 ALTER TABLE `books_inventory` DISABLE KEYS */;
INSERT INTO `books_inventory` VALUES (9780930289447,'Batman','Jim Starlin',144,'Dc Comics','The fate of the second Robin, a.k.a. Jason Todd, is determined in Ethopia where Jason travels to find his biological mother, Sheila Haywood.'),(9781605096070,'Networking for People Who Hate Networking','Devora Zack',200,'Berrett-Koehler Publishers','Networking is the art of building and maintaining connections for shared positive outcomes. This field guide begins by politely examining, and then shattering to pieces, traditional networking truisms.'),(9781906230166,'Dracula','\"Chaz Brenchley\",\"Bram Stoker\",\"Vanessa Lubach\"',64,'Real Reads Limited','Having discovered the double identity of the wealthy Transylvanian nobleman, Count Dracula, a small group of people vow to rid the world of the evil vampire.');
/*!40000 ALTER TABLE `books_inventory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-17  8:10:24
