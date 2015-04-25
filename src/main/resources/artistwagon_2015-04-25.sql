# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: localhost (MySQL 5.6.22)
# Database: artistwagon
# Generation Time: 2015-04-25 05:09:09 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table EVENT
# ------------------------------------------------------------

DROP TABLE IF EXISTS `EVENT`;

CREATE TABLE `EVENT` (
  `EVENT_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `OWNER_ID` int(11) DEFAULT NULL,
  `PAYER_ID` int(11) DEFAULT NULL,
  `DATE` varchar(11) NOT NULL DEFAULT '',
  `STATUS` varchar(45) NOT NULL DEFAULT '',
  `AGENCY_FEE` double(20,2) DEFAULT NULL,
  PRIMARY KEY (`EVENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table EVENT_PAYEE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `EVENT_PAYEE`;

CREATE TABLE `EVENT_PAYEE` (
  `EVENT_PAYEE_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `EVENT_ID` int(11) DEFAULT NULL,
  `GROUP_ID` int(11) DEFAULT NULL,
  `AMOUNT` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`EVENT_PAYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table GROUP
# ------------------------------------------------------------

DROP TABLE IF EXISTS `GROUP`;

CREATE TABLE `GROUP` (
  `GROUP_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(45) DEFAULT NULL,
  `NAME` varchar(60) DEFAULT '',
  PRIMARY KEY (`GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `GROUP` WRITE;
/*!40000 ALTER TABLE `GROUP` DISABLE KEYS */;

INSERT INTO `GROUP` (`GROUP_ID`, `TYPE`, `NAME`)
VALUES
	(1,'Artist','Cowboy Jukebox'),
	(2,'Venue','Durty Nellie\'s'),
	(3,'Agent','Double D Booking'),
	(4,'Artist','Nick Lynch'),
	(5,'Artist','Suburban Cowboys'),
	(6,'Artist','Derringer & Rye'),
	(8,'Venue','Whiskey Jacks'),
	(9,'Venue','Toby Keith\'s Bar & Grill'),
	(10,'Venue','Old Crow Smokehouse'),
	(11,'Venue','Firewater Saloon');

/*!40000 ALTER TABLE `GROUP` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table USER
# ------------------------------------------------------------

DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER` (
  `USERNAME` varchar(45) NOT NULL DEFAULT '',
  `PASSWORD` varchar(60) NOT NULL DEFAULT '',
  `IS_ENABLED` tinyint(4) NOT NULL DEFAULT '1',
  `GROUP_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;

INSERT INTO `USER` (`USERNAME`, `PASSWORD`, `IS_ENABLED`, `GROUP_ID`)
VALUES
	('durty.nellies@gmail.com','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y',1,2),
	('josh@doubledbooking.com','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y',1,3),
	('matt.adelberger@gmail.com','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y',1,1),
	('toby.keiths@gmail.com','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y',1,9);

/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table USER_ROLE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `USER_ROLE`;

CREATE TABLE `USER_ROLE` (
  `USER_ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) NOT NULL DEFAULT '',
  `ROLE` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`USER_ROLE_ID`),
  UNIQUE KEY `uni_username_role` (`ROLE`,`USERNAME`),
  KEY `fk_username_idx` (`USERNAME`),
  CONSTRAINT `fk_username` FOREIGN KEY (`USERNAME`) REFERENCES `user` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `USER_ROLE` WRITE;
/*!40000 ALTER TABLE `USER_ROLE` DISABLE KEYS */;

INSERT INTO `USER_ROLE` (`USER_ROLE_ID`, `USERNAME`, `ROLE`)
VALUES
	(2,'durty.nellies@gmail.com','ROLE_USER'),
	(3,'josh@doubledbooking.com','ROLE_USER'),
	(1,'matt.adelberger@gmail.com','ROLE_USER'),
	(4,'toby.keiths@gmail.com','ROLE_USER');

/*!40000 ALTER TABLE `USER_ROLE` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
