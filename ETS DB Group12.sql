CREATE DATABASE `ets` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `admin` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee_details` (
  `empNo` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `emailId` varchar(60) NOT NULL,
  `designation` varchar(45) NOT NULL,
  `baseLocation` varchar(45) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`empNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `leaves` (
  `leaveId` int NOT NULL AUTO_INCREMENT,
  `empNo` int NOT NULL,
  `leaveType` varchar(45) NOT NULL,
  `takenfrom` date NOT NULL,
  `takento` date NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`leaveId`),
  KEY `empNo_idx` (`empNo`),
  CONSTRAINT `empNo` FOREIGN KEY (`empNo`) REFERENCES `employee_details` (`empNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `project_allocation` (
  `sno` int NOT NULL AUTO_INCREMENT,
  `empNo` int NOT NULL,
  `projectCode` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `allocatedFrom` date NOT NULL,
  `allocatedTo` date NOT NULL,
  `reportingManagerEmailId` varchar(60) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`sno`),
  KEY `empNo_idx` (`empNo`),
  KEY `projectCode_idx` (`projectCode`),
  CONSTRAINT `empNo_pa` FOREIGN KEY (`empNo`) REFERENCES `employee_details` (`empNo`),
  CONSTRAINT `projectCode` FOREIGN KEY (`projectCode`) REFERENCES `projects` (`projectCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `projects` (
  `projectId` int NOT NULL,
  `projectCode` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  `duration` varchar(20) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`projectCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `timesheet` (
  `sno` int NOT NULL AUTO_INCREMENT,
  `empNo` int NOT NULL,
  `projectCode` varchar(45) NOT NULL,
  `taskDescription` varchar(200) NOT NULL,
  `totalWorkingHours` int NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`sno`),
  KEY `empNo_idx` (`empNo`),
  KEY `projectCode_tm_idx` (`projectCode`),
  CONSTRAINT `empNo_tm` FOREIGN KEY (`empNo`) REFERENCES `employee_details` (`empNo`),
  CONSTRAINT `projectCode_tm` FOREIGN KEY (`projectCode`) REFERENCES `projects` (`projectCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO admin(username,password) VALUES('mjohn@ets.com','mjohn22');

UPDATE `ets`.`timesheet`
SET
`sno` = <{sno: }>,
`empNo` = <{empNo: }>,
`projectCode` = <{projectCode: }>,
`taskDescription` = <{taskDescription: }>,
`totalWorkingHours` = <{totalWorkingHours: }>,
`date` = <{date: }>,
`status` = <{status: }>
WHERE `sno` = <{expr}>;
