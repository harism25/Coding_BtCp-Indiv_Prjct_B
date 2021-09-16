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

CREATE TABLE `assignment` (
  `assignment_id` int NOT NULL AUTO_INCREMENT,
  `asgnmtTitle` varchar(40) NOT NULL,
  `submitDate` date NOT NULL,
  PRIMARY KEY (`assignment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `courseTitle` varchar(40) NOT NULL,
  `courseType` varchar(30) NOT NULL,
  `runTime` varchar(30) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `attendPrice` decimal(6,2) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `student` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(30) NOT NULL,
  `name` varchar(45) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `schoolFees` decimal(7,2) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `students_asgnmts` (
  `s_a_id` int NOT NULL AUTO_INCREMENT,
  `studt_id` int NOT NULL,
  `asgnmt_id` int NOT NULL,
  PRIMARY KEY (`s_a_id`),
  KEY `studt_id_idx` (`studt_id`),
  KEY `asgnmt_id_idx` (`asgnmt_id`),
  CONSTRAINT `asgnmt_id` FOREIGN KEY (`asgnmt_id`) REFERENCES `assignment` (`assignment_id`),
  CONSTRAINT `studt_id` FOREIGN KEY (`studt_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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

CREATE TABLE `trainer` (
  `trainer_id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(30) NOT NULL,
  `name` varchar(45) NOT NULL,
  `teachingCrs` varchar(45) NOT NULL,
  PRIMARY KEY (`trainer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
