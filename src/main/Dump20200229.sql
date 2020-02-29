-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: mini_budget
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

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
-- Table structure for table `expense table`
--

DROP TABLE IF EXISTS `expense table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expense table` (
  `expense id` int(11) NOT NULL AUTO_INCREMENT,
  `expense type` varchar(45) NOT NULL,
  `expense amount` int(11) NOT NULL,
  `expense currency` varchar(45) NOT NULL,
  `expense date` varchar(45) NOT NULL,
  `expense notes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`expense id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense table`
--

LOCK TABLES `expense table` WRITE;
/*!40000 ALTER TABLE `expense table` DISABLE KEYS */;
INSERT INTO `expense table` VALUES (1,'Ulasim',100,'TRY','2020-02-02',NULL),(2,'Fatura',400,'TRY','2020-02-03',NULL),(3,'Egitim',500,'TRY','2020-02-03',NULL),(4,'Eglence',400,'TRY','2020-02-05',NULL),(5,'Vergi',1000,'TRY','2020-02-06',NULL),(6,'Yemek',500,'TRY','2020-02-07',NULL),(7,'Hediye/Bagis',200,'TRY','2020-02-08',NULL),(8,'Saglik',200,'TRY','2020-02-09',NULL),(9,'Kira',2000,'TRY','2020-02-10',NULL),(10,'Aidat',100,'TRY','2020-02-11',NULL),(11,'Tamir',100,'TRY','2020-02-12',NULL),(12,'Cocuk',500,'TRY','2020-02-13',NULL),(13,'Kisisel Bakim',200,'TRY','2020-02-14',NULL),(14,'Alisveris',300,'TRY','2020-02-15',NULL),(15,'Seyahat',500,'TRY','2020-02-16',NULL),(16,'Borc',100,'TRY','2020-02-17',NULL),(17,'Giyim',200,'TRY','2020-02-18',NULL),(18,'Diger',100,'TRY','2020-02-19',NULL);
/*!40000 ALTER TABLE `expense table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income table`
--

DROP TABLE IF EXISTS `income table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `income table` (
  `income id` int(11) NOT NULL AUTO_INCREMENT,
  `income type` varchar(45) NOT NULL,
  `income amount` int(11) NOT NULL,
  `income currency` varchar(45) NOT NULL,
  `income date` datetime NOT NULL,
  `income notes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`income id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income table`
--

LOCK TABLES `income table` WRITE;
/*!40000 ALTER TABLE `income table` DISABLE KEYS */;
INSERT INTO `income table` VALUES (1,'maas',10000,'TRY','2020-02-01 00:00:00',NULL),(2,'prim',1000,'TRY','2020-02-01 00:00:00',NULL),(3,'komisyon',500,'TRY','2020-02-02 00:00:00',NULL),(4,'yatirim getirisi',500,'TRY','2020-02-02 00:00:00',NULL),(5,'dukkan kirasi',1000,'TRY','2020-02-02 00:00:00',NULL),(6,'danismanlik',1000,'TRY','2020-02-05 00:00:00',NULL),(7,'ev kirasi',2000,'TRY','2020-02-05 00:00:00',NULL),(8,'burs',300,'TRY','2020-02-10 00:00:00',NULL),(9,'harclik',300,'TRY','2020-02-10 00:00:00',NULL),(10,'sans oyunu',100,'TRY','2020-02-15 00:00:00',NULL),(11,'alacaklar',100,'TRY','2020-02-15 00:00:00',NULL),(12,'diger',200,'TRY','2020-02-16 00:00:00',NULL);
/*!40000 ALTER TABLE `income table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users table`
--

DROP TABLE IF EXISTS `users table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users table` (
  `user id` int(11) NOT NULL AUTO_INCREMENT,
  `user name` varchar(45) NOT NULL,
  `user surname` varchar(45) DEFAULT NULL,
  `user email` varchar(45) NOT NULL,
  `user password` varchar(45) NOT NULL,
  PRIMARY KEY (`user id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users table`
--

LOCK TABLES `users table` WRITE;
/*!40000 ALTER TABLE `users table` DISABLE KEYS */;
INSERT INTO `users table` VALUES (1,'Ali','Asan','aliasan@gmail.com','12345'),(2,'Seyma','Kalir','seymakalir@gmail.com','23456'),(3,'Kadir','Temiz','kadirtemiz@gmail.com','34567'),(4,'Gamze','Seven','gamzeseven@gmail.com','45678'),(5,'Duygu','Guder','duyguguder@gmail.com','56789'),(6,'Serkan','Ucar','serkanucar@gmail.com','67890'),(7,'Elif','Gordu','elifgordu@gmail.com','78900'),(8,'Kagan','Taranci','kagantaranci@gmail.com','89000'),(9,'Melek','Koc','melekkoc@gmail.com','90000'),(10,'Melis','Turk','melisturk@gmail.com','00000');
/*!40000 ALTER TABLE `users table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mini_budget'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-29 22:02:13
