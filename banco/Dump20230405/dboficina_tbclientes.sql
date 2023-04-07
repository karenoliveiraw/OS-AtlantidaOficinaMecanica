-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 10.26.45.130    Database: dboficina
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `tbclientes`
--

DROP TABLE IF EXISTS `tbclientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbclientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(16) DEFAULT NULL,
  `fone` varchar(16) NOT NULL,
  `whatsapp` varchar(16) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `endereco` varchar(100) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `complemento` varchar(20) DEFAULT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `uf` char(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbclientes`
--

LOCK TABLES `tbclientes` WRITE;
/*!40000 ALTER TABLE `tbclientes` DISABLE KEYS */;
INSERT INTO `tbclientes` VALUES (1,'karen','89898989898989','999999999','99999999999','08450540','karen@gmail.com','Rua Freitas de Azevedo','3','b','Lageado','São Paulo','SP'),(2,'Luiz','363.943.978-30','2043-6721','964224872','08235830','luizchaves@gmail.com','Rua Dalmo Cavallari','157','','Parque Guarani','São Paulo','SP'),(4,'Rihanna','120.522.625-10','2045-8521','94522-5844','01153-000','ri_ha-na@gmail.com','Rua Vitorino Carmilo','744','','Barra Funda','São Paulo','SP'),(5,'Mike Tyson','144.544.922-00','4744-5211','96200-4111','02121-021','tyson@yahoo.com.br','Rua Orlando Monteiro','6988','c','Vila Maria','São Paulo','SP'),(6,'Obama','477.522.014-98','2354-5001','96988-0288','01124-000','obamis@htomail.com.br','Rua Afonso Pena','325','A','Bom Retiro','São Paulo','SP'),(7,'Rosa Maria','851.356.975-90','1127583064','987882580','08235840','rosa_maria@email.com','Rua Cristóvão Lopes','8','','Parque Guarani','São Paulo','SP'),(10,'Pedro Marcellus','527.907.378-43','982920852','982920852','08220640','pedromarcellus15@gmail.com','Rua Luiz Antônio Gonçalves','151','','Vila Campanela','São Paulo','SP'),(11,'José de Assis','587.265.258-89','9999-8988','','03085000','ze@email.com','Rua Santa Maria','20','','Parque São Jorge','São Paulo','SP');
/*!40000 ALTER TABLE `tbclientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-05 20:13:50
