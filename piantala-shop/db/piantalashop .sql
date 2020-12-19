-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: piantalashop
-- ------------------------------------------------------
-- Server version	8.0.12

--
-- Table structure for table `categoria`
--

CREATE TABLE `categoria` (
  `idcategoria` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `composizione`
--

CREATE TABLE `composizione` (
  `idordine` int(15) NOT NULL,
  `idprodotto` varchar(45) NOT NULL,
  `quantità` int(10) unsigned DEFAULT NULL,
  `prezzo` decimal(5,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`idordine`,`idprodotto`),
  KEY `idprodotto_idx` (`idprodotto`),
  CONSTRAINT `idordine` FOREIGN KEY (`idordine`) REFERENCES `ordine` (`idordine`),
  CONSTRAINT `idprodotto` FOREIGN KEY (`idprodotto`) REFERENCES `prodotto` (`idprodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `inviarichiesta`
--

CREATE TABLE `inviarichiesta` (
  `idrichiesta` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `tiporichiesta` varchar(45) NOT NULL,
  PRIMARY KEY (`idrichiesta`,`iduser`),
  KEY `iduser_idx` (`iduser`),
  CONSTRAINT `idrichiesta` FOREIGN KEY (`idrichiesta`) REFERENCES `richiesta` (`id`),
  CONSTRAINT `iduser` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `ordine`
--

CREATE TABLE `ordine` (
  `idordine` int(15) NOT NULL,
  `totale` decimal(6,2) unsigned NOT NULL,
  `dataordine` date NOT NULL,
  `iduser` int(11) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idordine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `prodotto`
--

CREATE TABLE `prodotto` (
  `idprodotto` varchar(5) NOT NULL,
  `nomeprodotto` varchar(45) NOT NULL,
  `prezzo` decimal(5,2) NOT NULL,
  `descrizione` varchar(150) DEFAULT NULL,
  `disponibilità` decimal(6,2) unsigned DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  `idagricoltore` int(11) NOT NULL,
  `idcategoria` int(2) unsigned NOT NULL,
  PRIMARY KEY (`idprodotto`),
  KEY `idagricoltore_idx` (`idagricoltore`),
  KEY `idcategoria_idx` (`idcategoria`),
  CONSTRAINT `idagricoltore` FOREIGN KEY (`idagricoltore`) REFERENCES `user` (`id`),
  CONSTRAINT `idcategoria` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `richiesta`
--

CREATE TABLE `richiesta` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `descrizione` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `dnascita` date NOT NULL,
  `indirizzo` varchar(45) NOT NULL,
  `città` varchar(45) NOT NULL,
  `provincia` varchar(2) NOT NULL,
  `cap` varchar(5) NOT NULL,
  `cellulare` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `ruolo` varchar(45) NOT NULL DEFAULT 'user',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
