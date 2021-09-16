-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: individual_project_b
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asgnmts_courses`
--

DROP TABLE IF EXISTS `asgnmts_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asgnmts_courses` (
  `a_c_id` int NOT NULL AUTO_INCREMENT,
  `crrs_id` int NOT NULL,
  `asgnmts_id` int NOT NULL,
  PRIMARY KEY (`a_c_id`),
  KEY `crrs_id_idx` (`crrs_id`),
  KEY `asgnmts_id_idx` (`asgnmts_id`),
  CONSTRAINT `asgnmts_id` FOREIGN KEY (`asgnmts_id`) REFERENCES `assignment` (`assignment_id`),
  CONSTRAINT `crrs_id` FOREIGN KEY (`crrs_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment` (
  `assignment_id` int NOT NULL AUTO_INCREMENT,
  `asgnmtTitle` varchar(40) NOT NULL,
  `submitDate` date NOT NULL,
  PRIMARY KEY (`assignment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `courseTitle` varchar(40) NOT NULL,
  `courseType` varchar(30) NOT NULL,
  `runTime` varchar(30) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `attendPrice` decimal(6,2) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(30) NOT NULL,
  `name` varchar(45) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `schoolFees` decimal(7,2) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `students_asgnmts`
--

DROP TABLE IF EXISTS `students_asgnmts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_asgnmts` (
  `s_a_id` int NOT NULL AUTO_INCREMENT,
  `studt_id` int NOT NULL,
  `asgnmt_id` int NOT NULL,
  PRIMARY KEY (`s_a_id`),
  KEY `studt_id_idx` (`studt_id`),
  KEY `asgnmt_id_idx` (`asgnmt_id`),
  CONSTRAINT `asgnmt_id` FOREIGN KEY (`asgnmt_id`) REFERENCES `assignment` (`assignment_id`),
  CONSTRAINT `studt_id` FOREIGN KEY (`studt_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `students_courses`
--

DROP TABLE IF EXISTS `students_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_courses` (
  `c_s_id` int NOT NULL AUTO_INCREMENT,
  `crs_id` int NOT NULL,
  `stud_id` int NOT NULL,
  PRIMARY KEY (`c_s_id`),
  KEY `student_id_idx` (`stud_id`),
  KEY `crs_id_idx` (`crs_id`),
  CONSTRAINT `crs_id` FOREIGN KEY (`crs_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `stud_id` FOREIGN KEY (`stud_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `trainer`
--

DROP TABLE IF EXISTS `trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainer` (
  `trainer_id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(30) NOT NULL,
  `name` varchar(45) NOT NULL,
  `teachingCrs` varchar(45) NOT NULL,
  PRIMARY KEY (`trainer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `trainers_courses`
--

DROP TABLE IF EXISTS `trainers_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers_courses` (
  `t_c_id` int NOT NULL AUTO_INCREMENT,
  `crss_id` int NOT NULL,
  `trnr_id` int NOT NULL,
  PRIMARY KEY (`t_c_id`),
  KEY `crs_id_idx` (`crss_id`),
  KEY `trnr_id_idx` (`trnr_id`),
  CONSTRAINT `crss_id` FOREIGN KEY (`crss_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `trnr_id` FOREIGN KEY (`trnr_id`) REFERENCES `trainer` (`trainer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-04 20:34:59
