CREATE DATABASE  IF NOT EXISTS `emp_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `emp_db`;
-- MySQL dump 10.13  Distrib 5.5.53, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: emp_db
-- ------------------------------------------------------
-- Server version	5.5.53-0ubuntu0.14.04.1

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'dept1','Department1'),(2,'JD01','JavaDept');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountstatus` varchar(255) DEFAULT NULL,
  `accounttype` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `visible` char(1) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  `manager` int(11) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkxx4wtsgsdt16iix2pso0k126` (`department`),
  KEY `FK4tp40512gf2bbsson55yaq0wj` (`manager`),
  KEY `FKne388g6pc0gjp2el4wyg0gfb` (`role`),
  CONSTRAINT `FK4tp40512gf2bbsson55yaq0wj` FOREIGN KEY (`manager`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKkxx4wtsgsdt16iix2pso0k126` FOREIGN KEY (`department`) REFERENCES `department` (`id`),
  CONSTRAINT `FKne388g6pc0gjp2el4wyg0gfb` FOREIGN KEY (`role`) REFERENCES `role` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'ACTIVE','ADMIN','re','we','2016-12-07 18:37:10','dd@gmail.com','ff','ff','ADMIN','123',1500,'ADMIN','Y',1,NULL,'hr'),(2,'ACTIVE','HR','Rajkot, Rajkot, Rajkot','HRL','2017-09-01 08:56:45','lotiyahardik@gmail.com','Hardik','l','123','9898471971',1500,'hardik','\0',1,1,'manager'),(3,'ACTIVE',NULL,'tt','tt','2017-09-01 09:38:24','tt','tt','tt','tt','123456',22,'tt','\0',1,1,'hr');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persistent_logins` (
  `series` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
INSERT INTO `persistent_logins` VALUES ('3DP8Ivw7vOpoWQfkcLj98g==','ADMIN','pKnaHtludz/MQaxNH8J2Wg==','2017-09-01 04:20:25'),('3iix2M1+Ez5krkwS/6ua0g==','tt','TplDuJu9eoExUniwXdjSHQ==','2017-09-01 04:22:23'),('3we1VkYdSrVOlkN0Waralw==','ADMIN','7Nb1HEZmyV9xDu59Knfd0g==','2017-09-01 03:59:22'),('6IoLZozdUZcR8YPPJ6q39A==','ADMIN','dynxDviXLrRDUuFcYQuv7w==','2017-09-01 04:03:45'),('AHjSwQjFDJaYOoF4UNelMQ==','ADMIN','T12mFzsKx5dxQ7XQP8kAzg==','2017-09-01 03:42:22'),('appF4iJJ7uG5nr6YAZK2aA==','ADMIN','AinfUNfmxoucBHsnVZgXvQ==','2017-09-01 04:25:34'),('bliNMcLCybcWT4ElGVOFQg==','ADMIN','5yU5oaW27Iveyr6pqeEZzg==','2017-08-30 18:55:34'),('cH0ZskdsFluPNHH8Mn7Jkw==','ADMIN','H8Tqg//8SYcAEnQBFr7/vg==','2017-09-01 03:46:49'),('D7/HENBBhouJFZZUUcQ+ig==','ADMIN','0XEae48fqD04rqIElA7KmQ==','2017-09-01 03:44:42'),('dMUHR7W9gCReAX3oLe8xWQ==','ADMIN','qRuYQlVGfpC00mqXUDxlLg==','2017-08-30 19:05:29'),('EtT8/qrFelAzx7JyqAh3wA==','tt','ic3yZOAwQegkA+LD7m7sqw==','2017-09-01 04:15:59'),('iZeizkpFgyraSoZQQFXmTQ==','ADMIN','at1j5sLRlbCsdol/nN0tNw==','2017-09-01 04:03:39'),('JUcDk3YsIM0Yyqs1CHnI1g==','hardik','3ValOrY1896Lug0tc9ydvA==','2017-09-01 04:22:40'),('junD75jTrXuMs+qiuo4MQw==','ADMIN','QxLIMtg6lyX1/ltRfe9/qw==','2017-09-01 04:21:50'),('KWh7n56N4zVvswlQfrNOug==','ADMIN','PARWlqNg7OQAqML3/tEUCQ==','2017-09-01 03:41:52'),('L6q+1ExBRB1GFZh4EX+EBw==','ADMIN','HVc4FrxCkrGnrQQDeUaHRQ==','2017-09-01 03:54:58'),('LcWkjZtPQnlnNg+dI5Q7nw==','ADMIN','z0QDoEZMPToTj0McRrHPqw==','2017-09-01 04:27:33'),('mKzXxN9YhRW+gVRzi5NNvA==','ADMIN','KanUQs0PZcKCGbpoCauI7A==','2017-09-01 03:38:24'),('NAGmax/vY7AujVuW3aLkzg==','ADMIN','kU58dEOKikJM9F/EL9VaWg==','2017-09-01 03:43:47'),('o2GUVvXPfiNLXGD8/C4KRQ==','ADMIN','R8ZnqDhhaamb3AorWbykEw==','2017-09-01 03:41:56'),('OvoPKfHmcW28hCTuKF+2Zw==','ADMIN','JtnNF7N9o1JpWvdnJg9A2A==','2017-09-01 03:20:28'),('pKFFJDtGOQ9Ft9J+yUaF2g==','ADMIN','pKIn7FJhWd5n7NZX+3MqDw==','2017-09-01 04:28:05'),('PPfcuWZx2a6Hq3rmuzfARw==','ADMIN','i5WB9Fc9Uwi+pRRY28YUJA==','2017-09-01 04:16:36'),('qhm4DDkq/U4zAGZIvOqezA==','ADMIN','sY7RVCzXsLcbFKrJrm+zdA==','2017-09-01 04:21:38'),('SAR0+Y6yh5DfE5N46G8BuA==','ADMIN','lDVcOzzHSHPPT/rKibe74g==','2017-09-01 04:21:04'),('V8eFgH8Ct0o18ErIeVpO4Q==','ADMIN','TCIB1/vM0rQibZGyjQz98A==','2017-09-01 04:20:46'),('w4HjNSHFkWOSMLJye0AjfA==','ADMIN','Pe+B+PAddKGgmoLC5YnMxg==','2017-09-01 03:36:55'),('XOyoN3Gzfq4pwpwQ0Ot+7g==','ADMIN','EypE2jhk4/uPj8zxjEpYUg==','2017-09-01 04:18:59'),('YahXFNx+NU5nUkQDR/FD5A==','ADMIN','coXAlsOE9pikR4TgqjATRg==','2017-09-01 04:16:09'),('yuJzNyilNFmvlhFjJH/Uyw==','ADMIN','vPWGcsec2k1NE5LwcsXlCw==','2017-09-01 03:48:21'),('Z8Jhhx1f10pdIOJ6fHudTg==','ADMIN','CyU7NulnHkk0UGrxVpL8JA==','2017-09-01 03:36:44'),('ZlgqDQ0GWf5njDcKFS1xfw==','ADMIN','sTaZSblnx/OO1bYJeUbDuQ==','2017-09-01 04:25:39');
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `name` varchar(255) NOT NULL,
  `menus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('hr','ww'),('manager','tt');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-01 10:00:19
