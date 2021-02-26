
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `Private School` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `Private School`;
DROP TABLE IF EXISTS `assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL,
  `subDate` date NOT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_assignmentspercourse` (`course_id`),
  CONSTRAINT `fk_assignmentspercourse` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` VALUES (1,'Math ex.1','Introduction to math elements','2019-12-15',1),(2,'Math ex.2','Advanced math elements','2019-12-31',1),(3,'Science ex.1','Science exercise 1','2019-12-31',2),(4,'Music ex.1','Getting to know music','2020-01-17',3),(5,'Music ex.2','Intermediate music','2020-02-17',3),(6,'Music ex.3','Music advanced','2020-03-16',3),(7,'Poetry intro','start scripting','2020-11-29',4),(8,'Philosophy thesis','engage to philosophy','2020-11-30',5),(9,'Performance','Uncle Vanias Act','2020-05-16',NULL);
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `assignmentsperstudentpercourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignmentsperstudentpercourse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `studentspercourses_id` int DEFAULT NULL,
  `assignments_id` int DEFAULT NULL,
  `oral_mark` int DEFAULT NULL,
  `total_mark` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `studentspercourses_id` (`studentspercourses_id`),
  KEY `assignments_id` (`assignments_id`),
  CONSTRAINT `assignmentsperstudentpercourse_ibfk_1` FOREIGN KEY (`studentspercourses_id`) REFERENCES `studentspercourse` (`id`),
  CONSTRAINT `assignmentsperstudentpercourse_ibfk_2` FOREIGN KEY (`assignments_id`) REFERENCES `assignments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `assignmentsperstudentpercourse` WRITE;
/*!40000 ALTER TABLE `assignmentsperstudentpercourse` DISABLE KEYS */;
INSERT INTO `assignmentsperstudentpercourse` VALUES (1,1,4,18,90),(2,1,5,10,70),(3,1,6,19,45),(4,2,7,20,100),(5,3,1,20,70),(6,3,2,28,79),(7,4,7,15,95),(8,5,7,15,90),(9,6,8,20,80),(10,7,1,20,78),(11,7,2,20,95),(12,8,3,18,97),(13,9,7,10,83),(14,10,1,10,68),(15,10,2,15,98),(16,11,1,16,94),(17,11,2,16,95),(18,12,3,18,97),(19,13,7,20,79),(20,14,1,18,76),(21,14,2,16,79),(22,15,8,18,85);
/*!40000 ALTER TABLE `assignmentsperstudentpercourse` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `stream` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Math','Vectors','full-time','2019-12-01','2019-12-31'),(2,'Science','Nuclear physics','part-time','2019-01-12','2019-12-13'),(3,'Music','Clarinet','part-time','2019-12-17','2020-03-17'),(4,'Poetry','greek poets','part-time','2019-10-31','2020-10-03'),(5,'Philosophy','eastern philosophers','full-time','2019-12-01','2020-11-30'),(11,'Acting','Drama Actions','Part Time','2021-01-15','2021-06-15');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `f_name` varchar(30) NOT NULL,
  `l_name` varchar(30) NOT NULL,
  `date_of_birth` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'John','Papas','1997-12-05'),(2,'Mixalis','Kalamanis','1999-10-05'),(3,'Maria','Zampeta','1982-03-18'),(4,'Eleni','Mparmpouni','1980-10-01'),(5,'Mixalis','Kakogiannis','1950-11-04'),(6,'Miltos','Pasxalidis','1984-06-01'),(7,'Angela','Merkel','1920-07-16'),(8,'Elizabeth','Taylor','1932-02-27');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `studentspercourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentspercourse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `studentspercourse_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `studentspercourse_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `studentspercourse` WRITE;
/*!40000 ALTER TABLE `studentspercourse` DISABLE KEYS */;
INSERT INTO `studentspercourse` VALUES (1,1,3),(2,1,4),(3,2,1),(4,2,4),(5,3,4),(6,3,5),(7,4,1),(8,4,2),(9,4,4),(10,5,1),(11,6,3),(12,6,2),(13,6,4),(14,7,1),(15,7,5),(16,7,3),(17,8,3);
/*!40000 ALTER TABLE `studentspercourse` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `trainers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `f_name` varchar(30) NOT NULL,
  `l_name` varchar(30) NOT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_trainerspercourse` (`course_id`),
  CONSTRAINT `fk_trainerspercourse` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `trainers` WRITE;
/*!40000 ALTER TABLE `trainers` DISABLE KEYS */;
INSERT INTO `trainers` VALUES (1,'Giannis','Varoufakis',1),(2,'Kostas','Tsakonas',3),(3,'Sapfo','Notara',2),(4,'Malvina','Karali',5),(5,'Aleka','Papariga',4),(6,'Komis','Drakoula',11),(7,'Elli','Lampeti',11),(8,'Miles','Davis',3);
/*!40000 ALTER TABLE `trainers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

