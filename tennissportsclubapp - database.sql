-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: tennissportsclubapp
-- ------------------------------------------------------
-- Server version	5.7.24-log

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
-- Table structure for table `announcements`
--

DROP TABLE IF EXISTS `announcements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcements` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `text_` varchar(255) DEFAULT NULL,
  `video_` varchar(255) DEFAULT NULL,
  `audio_` varchar(255) DEFAULT NULL,
  `image_` varchar(255) DEFAULT NULL,
  `location_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcements`
--

LOCK TABLES `announcements` WRITE;
/*!40000 ALTER TABLE `announcements` DISABLE KEYS */;
INSERT INTO `announcements` VALUES (1,'Test post',NULL,NULL,'Pretoria-Tyson-Jopson-Union-Buildings.jpg',NULL),(2,'Test post 2',NULL,NULL,'landscape-photography-competition.jpg',NULL),(3,'Test audio','','The Hair and The Hoodie - Vibe 5.mp3','',NULL),(6,'Test Video','Video.mp4','','',NULL),(7,'Test post','','','',NULL);
/*!40000 ALTER TABLE `announcements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `members` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MemberName` varchar(255) DEFAULT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `UsernamePassword` varchar(255) DEFAULT NULL,
  `Role` varchar(255) DEFAULT NULL,
  `ContactNumber` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `NextOfKin` varchar(255) DEFAULT NULL,
  `Sex` varchar(255) DEFAULT NULL,
  `DateOfBirth` varchar(255) DEFAULT NULL,
  `Membership` varchar(255) DEFAULT NULL,
  `PersonalTrainer` varchar(255) DEFAULT NULL,
  `TimeSelected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (1,'ANNA BEDECS ','ANNA1','ABWORD','STANDARD','0812445678','123 1ST STREET','JOHN BEDECS','FEMALE','1988-10-10','JUNIOR','NO',''),(4,'ANTONIO GRATACOS','ANTONIO1','AGWORD','STANDARD','0812345679','TREVOR GRATACOS','TREVOR GRATACOS','MALE','1971-10-20','ADVANCED','YES','14:00'),(5,'THOMAS AXEN','THOMAS1','TAWORD','STANDARD','0712345678','123 3RD STREET','ANNA AXEN','MALE','1965-05-18','BEGINNER','NO',''),(6,'CHRISTINA LEE','CHRISTINA1','CLWORD','STANDARD','0612345678','123 4TH STREET','RON LEE','FEMALE','1981-08-03','PROFESSIONAL','YES','17:30'),(7,'MARTIN GOLDSCHMIDT','MARTIN1','MGWORD','STANDARD','0911345678','123 5TH STREET','JAMES GOLDSCHMIDT','MALE','1965-01-08','ADVANCED','NO',''),(8,'ADMIN','ADMIN','ADMIN','STANDARD','0817190003','0 3RD STREET','ITUMELENG TEKO','FEMALE','1998-12-03','PROFESSIONAL','NO','');
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) DEFAULT NULL,
  `UsernamePassword` varchar(255) DEFAULT NULL,
  `Role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ADMIN','FIRNS','ADMIN'),(2,'ANNA1','FG2TWI','STANDARD'),(3,'ANTONIO1','FL2TWI','STANDARD'),(4,'THOMAS1','YF2TWI','STANDARD'),(5,'CHRISTINA1','HQ2TWI','STANDARD'),(6,'MARTIN1','RL2TWI','STANDARD'),(7,'SUPERVISOR','XZUJW1NXTW6','SUPERVISOR');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tennissportsclubapp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-16  9:58:28
