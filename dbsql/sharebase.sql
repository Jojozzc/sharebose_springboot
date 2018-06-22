-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: sharebase
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu18.04.1

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` varchar(20) NOT NULL,
  `user_password` varchar(32) NOT NULL,
  `user_nickname` varchar(20) NOT NULL,
  `user_email` varchar(40) DEFAULT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `user_regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_nickname` (`user_nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('109','3vzVYCbTjqHtuGzXjtSUkQ==','bbbbb','','','2018-06-20 06:06:07'),('111','GAcBoOmBnureJa8a8BdjoQ==','suxioahui','','','2018-06-20 05:42:56'),('120','FW3EhEpHCPNtzEdmzAZ32w==','jjjjj','','','2018-06-20 06:04:11'),('123456789','Vk0VHxepkdLOsycszK6D/w==','zouzhichao ','','','2018-06-20 01:35:23'),('13342228768','LoGn+cfL8XSXI8MtircNEw==','suxiaohui','','','2018-06-20 01:22:03'),('admin','4QrcOUm6Wau+VuBX8g+IPg==','admin','','','2018-06-18 13:43:12'),('leizong','qZJbC8TIYv6y2Dd6mW3zYw==',' suxiaohui','','','2018-06-20 01:26:22'),('test staff4','123456','staff4',NULL,NULL,'2018-06-20 01:17:10'),('test staffDOg','123456','小狗',NULL,NULL,'2018-06-20 06:22:24'),('test1','SYvhS38bkmVMdlPKeSxHsg==','test staff','','','2018-06-18 14:46:30'),('test2','SYvhS38bkmVMdlPKeSxHsg==','test staff2','','','2018-06-18 14:50:38'),('wqw','KY25XZrqm7CQrzM4TM/KCA==','suhsjsj','','','2018-06-20 01:42:25');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sharebase'
--

--
-- Dumping routines for database 'sharebase'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-20 15:39:13
