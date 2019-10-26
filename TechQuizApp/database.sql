-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: onlineexam
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `exam` (
  `examid` varchar(10) NOT NULL,
  `language` varchar(10) DEFAULT NULL,
  `total_question` int(11) DEFAULT NULL,
  PRIMARY KEY (`examid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES ('EX- 1','c',2),('EX- 2','java',2),('EX- 3','c',2),('EX- 4','java',2),('EX- 5','c++',2),('EX- 6','c++',2),('EX- 7','c++',2),('EX- 8','c',2),('EX- 9','java',2);
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performance`
--

DROP TABLE IF EXISTS `performance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `performance` (
  `userid` varchar(10) DEFAULT NULL,
  `examid` varchar(10) NOT NULL,
  `right` int(11) DEFAULT NULL,
  `wrong` int(11) DEFAULT NULL,
  `unattempted` int(11) DEFAULT NULL,
  `per` decimal(5,2) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`examid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performance`
--

LOCK TABLES `performance` WRITE;
/*!40000 ALTER TABLE `performance` DISABLE KEYS */;
INSERT INTO `performance` VALUES ('Deepak','EX- 2',1,1,0,50.00,'java'),('Deepak','EX- 3',1,1,0,50.00,'c'),('Deepak','EX- 4',2,0,0,100.00,'java');
/*!40000 ALTER TABLE `performance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `questions` (
  `examid` varchar(10) NOT NULL,
  `qno` int(11) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL,
  `answer1` varchar(45) DEFAULT NULL,
  `answer2` varchar(45) DEFAULT NULL,
  `answer3` varchar(45) DEFAULT NULL,
  `answer4` varchar(45) DEFAULT NULL,
  `correct_answer` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES ('EX- 2',1,'What is Math in java ?','class','enum','variable','interface','Answer 1','java'),('EX- 2',2,'what is String in java ?','interface','variable','class','arrar of characters','Answer 3','java'),('EX- 4',1,'Which of the following is not a class ?','String','Math','return','Object','Answer 3','java'),('EX- 4',2,'What is the meaning of keyword private ?','Access modifier','variable name','anyone can access the  members','none of the above','Answer 1','java'),('EX- 3',1,'C is procedural ?','true','false','none of the above','partially','Answer 1','c'),('EX- 3',2,'C supports  oops ?','true','false','none of the above','partially','Answer 2','c'),('EX- 5',1,'c++?','lang','name','grammer','class','Answer 1','c++'),('EX- 5',2,'c++ > c ?','false','equal','true','none','Answer 3','c++'),('EX- 6',1,'a','b','c','d','e','Answer 1','c++'),('EX- 6',2,'z','y','x','w','v','Answer 1','c++'),('EX- 7',1,'c++ was made by ?','dennis ritchie','bjarne stroustup','tim berners lee','none','Answer 2','c++'),('EX- 7',2,'c++ was made at ?','Bell labs','chernobyl','India','none','Answer 1','c++'),('EX- 1',1,'struct ?','variable','function','none','keyword','Answer 4','c'),('EX- 1',2,'c is ?','HLL','LLL','SL','none','Answer 1','c'),('EX- 8',1,'1 == 1','no','yes','variable','none','Answer 2','c'),('EX- 8',2,'char','variable','method','data type','none','Answer 3','c'),('EX- 9',1,'AWT ?','method','class','none','package','Answer 4','java');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `userid` varchar(10) NOT NULL,
  `password` varchar(10) DEFAULT NULL,
  `usertype` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('amit','1234','student'),('Deepak','deep','student'),('sachin','sca','admin');
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

-- Dump completed on 2019-10-26 13:53:51
