jre: 1.7.0_65
IDE: eclipse
Server: tomcat8.0
DB: MySQL 5.6.21
Index url: http://localhost:8080/staff
login name: admin
password: admin

Database create:
CREATE DATABASE `staff` DEFAULT CHARACTER SET utf8;
use staff;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `empid` int(11) DEFAULT NULL,
  `perm` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `loginname_UNIQUE` (`loginname`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
insert into admin (loginname,password,perm) values ('admin','admin',2);
CREATE TABLE `employ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `sex` varchar(3) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `salary` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=utf8;
CREATE TABLE `holiday` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empid` int(11) NOT NULL,
  `datefrom` date NOT NULL,
  `dateto` date NOT NULL,
  `reason` varchar(1000) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
CREATE TABLE `sign` (
  `empid` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`empid`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;