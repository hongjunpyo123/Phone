/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.1.35-MariaDB : Database - phone
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`phone` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `phone`;

/*Table structure for table `bank` */

DROP TABLE IF EXISTS `bank`;

CREATE TABLE `bank` (
  `name` varchar(10) NOT NULL COMMENT '사용자명',
  `number` varchar(11) NOT NULL COMMENT '전화번호',
  `account` varchar(8) NOT NULL COMMENT '계좌번호',
  `cash` int(255) NOT NULL COMMENT '계좌잔액',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `bank` */

insert  into `bank`(`name`,`number`,`account`,`cash`) values 
('admin','01000000000','95506736',992000);

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(10) NOT NULL COMMENT '사용자명',
  `number` varchar(11) NOT NULL COMMENT '사용자번호',
  `persons` int(10) NOT NULL COMMENT '예약인원',
  `check_in_date` date NOT NULL COMMENT '체크인날짜',
  `usage_time` int(10) NOT NULL COMMENT '이용시간',
  `check_in_time` varchar(20) NOT NULL COMMENT '체크인시간',
  `type` varchar(20) NOT NULL COMMENT '방종류',
  `houlyrate` int(10) NOT NULL COMMENT '시간당가격(원)',
  `today` date NOT NULL COMMENT '예약날짜',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `hotel` */

insert  into `hotel`(`id`,`name`,`number`,`persons`,`check_in_date`,`usage_time`,`check_in_time`,`type`,`houlyrate`,`today`) values 
(8,'admin','01000000000',10,'2024-12-12',4,'12:12','StudyRoom',2000,'2024-06-21');

/*Table structure for table `msg` */

DROP TABLE IF EXISTS `msg`;

CREATE TABLE `msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `send_name` varchar(11) NOT NULL,
  `send_number` varchar(11) NOT NULL,
  `message` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `msg` */

/*Table structure for table `transfer` */

DROP TABLE IF EXISTS `transfer`;

CREATE TABLE `transfer` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `account` varchar(8) NOT NULL COMMENT '계좌번호',
  `cash` int(255) NOT NULL COMMENT '금액',
  `sendName` varchar(10) NOT NULL COMMENT '이름',
  `type` varchar(5) NOT NULL COMMENT 'add or sub',
  `today` date NOT NULL COMMENT '날짜',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `transfer` */

insert  into `transfer`(`id`,`account`,`cash`,`sendName`,`type`,`today`) values 
(1,'95506736',10000,'Event','add','2024-06-21'),
(2,'95506736',6000,'yanolja','sub','2024-06-21'),
(3,'95506736',8000,'yanolja','sub','2024-06-21');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
