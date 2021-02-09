-- MySQL dump 10.13  Distrib 5.1.73, for Win32 (ia32)
--
-- Host: localhost    Database: jobseekproject
-- ------------------------------------------------------
-- Server version	5.1.73-community

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
-- Table structure for table `jobposting`
--

DROP TABLE IF EXISTS `jobposting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobposting` (
  `jobID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `Employer` varchar(30) NOT NULL,
  `employerAddress` varchar(100) DEFAULT NULL,
  `reportingDateTime` datetime DEFAULT NULL,
  `pay` double(6,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`jobID`),
  KEY `Employer` (`Employer`),
  CONSTRAINT `jobposting_ibfk_1` FOREIGN KEY (`Employer`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobposting`
--


--
-- Table structure for table `jobrequest`
--

DROP TABLE IF EXISTS `jobrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobrequest` (
  `jobReqID` varchar(20) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `jobID` int(11) DEFAULT NULL,
  `jobReqStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`jobReqID`),
  KEY `username` (`username`),
  KEY `jobID` (`jobID`),
  CONSTRAINT `jobrequest_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  CONSTRAINT `jobrequest_ibfk_2` FOREIGN KEY (`jobID`) REFERENCES `jobposting` (`jobID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobrequest`
--


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(1024) DEFAULT NULL,
  `accountType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `user`
--
LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Alex','alex@gmail.com','123','JobSeeker'),('Avensys','alex@avensys.com','123','Company');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `jobposting` WRITE;
/*!40000 ALTER TABLE `jobposting` DISABLE KEYS */;
INSERT INTO `jobposting` VALUES (1,'Java Developer','Java Developer Required For An Web Based Application','Avensys','2 Telok Blangah Way','2021-01-20 21:50:50',3000.00,1),(2,'Senior C# Developer','C# Developer Required For Developing of MOBA games.','Avensys','2 Telok Blangah Way','2021-01-20 21:50:50',6000.00,1),(3,'System Admin','System Admininistrator Required day-to-day operations and book-keeping. No Experience Required','Avensys','2 Telok Blangah Way','2021-01-20 21:50:50',2550.00,1);
/*!40000 ALTER TABLE `jobposting` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `jobrequest` WRITE;
/*!40000 ALTER TABLE `jobrequest` DISABLE KEYS */;
INSERT INTO `jobrequest` VALUES ('Al1612863679','Alex',1,1);
/*!40000 ALTER TABLE `jobrequest` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-09 17:42:53
