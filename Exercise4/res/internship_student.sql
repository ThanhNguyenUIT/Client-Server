-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: internship
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `birth_day` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Mai','Thịnh','08/02/1997','maihophucthinh@gmail.com'),(2,'Lê','Công','24/4/1996','leconglc1996@gmail.com'),(3,'Trần','Tuấn','15/05/1997','khanhtuan623@gmail.com'),(4,'Võ','Thư','24/01/1996','vominhthu241@gmail.com'),(5,'Nguyễn','Hiền','24/01/1996','ntthuhien1324@gmail.com'),(6,'Phạm','Thịnh','25/10/1996','ptthinh1996@gmail.com'),(7,'Nguyễn','Thành','17/10/1995','thanhnt.uit@gmail.com'),(8,'Mai','Thịnh','08/02/1997','maihophucthinh@gmail.com'),(9,'Lê','Công','24/4/1996','leconglc1996@gmail.com'),(10,'Trần','Tuấn','15/05/1997','khanhtuan623@gmail.com'),(11,'Võ','Thư','24/01/1996','vominhthu241@gmail.com'),(12,'Nguyễn','Hiền','24/01/1996','ntthuhien1324@gmail.com'),(13,'Phạm','Thịnh','25/10/1996','ptthinh1996@gmail.com'),(14,'Nguyễn','Thành','17/10/1995','thanhnt.uit@gmail.com'),(15,'Mai','Thịnh','08/02/1997','maihophucthinh@gmail.com'),(16,'Lê','Công','24/4/1996','leconglc1996@gmail.com'),(17,'Trần','Tuấn','15/05/1997','khanhtuan623@gmail.com'),(18,'Võ','Thư','24/01/1996','vominhthu241@gmail.com'),(19,'Nguyễn','Hiền','24/01/1996','ntthuhien1324@gmail.com'),(20,'Nguyễn','Thành','17/10/1995','thanhnt.uit@gmail.com'),(21,'Mai','Thịnh','08/02/1997','maihophucthinh@gmail.com'),(22,'Lê','Công','24/4/1996','leconglc1996@gmail.com'),(23,'Trần','Tuấn','15/05/1997','khanhtuan623@gmail.com'),(24,'Võ','Thư','24/01/1996','vominhthu241@gmail.com'),(25,'Nguyễn','Hiền','24/01/1996','ntthuhien1324@gmail.com'),(26,'Nguyễn','Thành','17/10/1995','thanhnt.uit@gmail.com'),(27,'Mai','Thịnh','08/02/1997','maihophucthinh@gmail.com'),(28,'Lê','Công','24/4/1996','leconglc1996@gmail.com'),(29,'Trần','Tuấn','15/05/1997','khanhtuan623@gmail.com'),(30,'Võ','Thư','24/01/1996','vominhthu241@gmail.com'),(31,'Nguyễn','Hiền','24/01/1996','ntthuhien1324@gmail.com'),(32,'Nguyễn','Thành','17/10/1995','thanhnt.uit@gmail.com'),(33,'Mai','Thịnh','08/02/1997','maihophucthinh@gmail.com'),(34,'Lê','Công','24/4/1996','leconglc1996@gmail.com'),(35,'Trần','Tuấn','15/05/1997','khanhtuan623@gmail.com'),(36,'Võ','Thư','24/01/1996','vominhthu241@gmail.com'),(37,'Nguyễn','Hiền','24/01/1996','ntthuhien1324@gmail.com'),(38,'Nguyễn','Thành','17/10/1995','thanhnt.uit@gmail.com'),(39,'Thịnh','Mai','08/02/1997','maihophucthinh@gmail.com'),(40,'Công','Lê','24/4/1996','leconglc1996@gmail.com'),(41,'Tuấn','Trần','15/05/1997','khanhtuan623@gmail.com'),(42,'Thư','Võ','24/01/1996','vominhthu241@gmail.com'),(43,'Hiền','Nguyễn','24/01/1996','ntthuhien1324@gmail.com'),(44,'Thành','Nguyễn','17/10/1995','thanhnt.uit@gmail.com'),(45,'Thịnh','Mai','08/02/1997','maihophucthinh@gmail.com'),(46,'Công','Lê','24/4/1996','leconglc1996@gmail.com'),(47,'Tuấn','Trần','15/05/1997','khanhtuan623@gmail.com'),(48,'Thư','Võ','24/01/1996','vominhthu241@gmail.com'),(49,'Hiền','Nguyễn','24/01/1996','ntthuhien1324@gmail.com'),(50,'Thành','Nguyễn','17/10/1995','thanhnt.uit@gmail.com'),(51,'Thịnh','Mai','08/02/1997','maihophucthinh@gmail.com'),(52,'Công','Lê','24/4/1996','leconglc1996@gmail.com'),(53,'Tuấn','Trần','15/05/1997','khanhtuan623@gmail.com'),(54,'Thư','Võ','24/01/1996','vominhthu241@gmail.com'),(55,'Hiền','Nguyễn','24/01/1996','ntthuhien1324@gmail.com'),(56,'Thành','Nguyễn','17/10/1995','thanhnt.uit@gmail.com');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-06 16:22:26
