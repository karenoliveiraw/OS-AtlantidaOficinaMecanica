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
-- Table structure for table `tbos`
--

DROP TABLE IF EXISTS `tbos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbos` (
  `os` int NOT NULL AUTO_INCREMENT,
  `data_os` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `placa` varchar(15) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `cor` varchar(20) NOT NULL,
  `ano` varchar(4) NOT NULL,
  `km` varchar(30) NOT NULL,
  `orcamento` varchar(50) NOT NULL,
  `servico` varchar(150) DEFAULT NULL,
  `defeito` varchar(150) NOT NULL,
  `mecanico` varchar(20) DEFAULT NULL,
  `status_os` varchar(150) NOT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `data_saida` varchar(50) DEFAULT NULL,
  `forma_pagamento` varchar(50) DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`os`),
  KEY `id` (`id`),
  CONSTRAINT `tbos_ibfk_1` FOREIGN KEY (`id`) REFERENCES `tbclientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbos`
--

LOCK TABLES `tbos` WRITE;
/*!40000 ALTER TABLE `tbos` DISABLE KEYS */;
INSERT INTO `tbos` VALUES (4,'2023-03-28 22:28:58','OMA8962','Fiat','Uno','Azul','2020','15000','Ordem de serviço','Trocar a bateria','Não liga','Celso Kuteken','Entregue ao cliente',150.00,'quarta-feira, 5 de abril de 2023','Pix',6),(6,'2023-03-28 22:30:26','FYP2565','Volkswagen','Gol','Verde','2000','250000','Ordem de serviço','Refazer o motor','Motor fundiu','Luiz Claudio','Aguardando peças',100.00,'','Dinheiro',4),(7,'2023-03-29 22:45:43','ABC1234','VOLKS','FUSCA','VERDE','1987','89000','Orçamento','','NÃO LIGA','','Aguardando mêcanico',0.00,'','',1),(8,'2023-03-29 22:54:37','DMA8956','Chevrolet','Zafira','Cinza','2004','198000','Ordem de serviço','Trocar o câmbio automatico.','Cambio não está funcionando.','José de Assis','Entregue ao cliente',500.00,'quarta-feira, 5 de abril de 2023','Crédito',5),(9,'2023-03-29 23:24:13','AZY2780','Nissan','Sentra','Preto','2016','40000','Orçamento','Trocar o escapamento','Ruido no escapamento','Celso Kuteken','Aguardando aprovação',450.00,'','',7),(10,'2023-03-29 23:27:15','PXY8569','Volkswagen','Golf','Vermelho','2020','19000','Ordem de serviço','Trocar modulo eletronico ','Vidros elétricos não sobe','José de Assis','Entregue ao cliente',1000.00,'quarta-feira, 5 de abril de 2023','Pix',6),(11,'2023-03-29 23:31:15','OED8526','Fiat','Palio','Amarelo','2015','89000','Ordem de serviço','Trocar o fusivel','Pisca alerta queimado','Luis Claudio','Entregue ao cliente',250.00,'quarta-feira, 5 de abril de 2023','Pix',6),(12,'2023-04-03 23:08:26','FAL5864','Porshe','Porshe Cayenne','Branco','2012','200000','Ordem de serviço','Trocar embreagem','Carro desliga sozinho','Luiz Claudio','Entregue ao cliente',10000.00,'quarta-feira, 5 de abril de 2023','Dinheiro',10),(13,'2023-04-03 23:22:00','CLI9219','Fiat','Uno','Branco','1991','999999','Ordem de serviço','Limpeza do carburador','Falhando','Luiz Claudio','Entregue ao cliente',250.00,'03/04/2023','Pix',11);
/*!40000 ALTER TABLE `tbos` ENABLE KEYS */;
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
