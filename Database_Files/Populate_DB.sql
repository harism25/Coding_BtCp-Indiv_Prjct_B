use individual_project_b;

INSERT INTO course
VALUES (1,'Java','semiannual','Full-Time','2021-1-1','2021-6-30',200),
(2,'Python','semiannual','Full-Time','2021-1-1','2021-6-30',200),
(3,'JavaScript','semiannual','Full-Time','2021-1-1','2021-6-30',200),
(4,'C#','semiannual','Full-Time','2021-1-1','2021-6-30',200);

INSERT INTO assignment
VALUES (1,'Java_Project_1','2021-5-13'),
(2,'Python_Project_1','2021-5-13'),
(3,'Javascript_Project_1','2021-5-13'),
(4,'C#_Project_1','2021-5-13'),
(5,'Java_Project_2','2021-7-14'),
(6,'Python_Project_2','2021-7-14'),
(7,'Javascript_Project_2','2021-7-14'),
(8,'C#_Project_2','2021-7-14');

INSERT INTO student
VALUES (1,'Ανδριώτης','Αναστάσιος','1989-2-25',2500),
(2,'Μπεγλίτης','Ευάγγελος','1992-7-19',2500),
(3,'Λογοθέτης','Γεώργιος','1990-1-8',2250),
(4,'Ψαριανός','Αναστάσιος','1994-8-14',2500),
(5,'Παπούλιας','Χαράλαμπος','1988-10-20',2500),
(6,'Νικολούδης','Αθανάσιος','1992-12-14',2200),
(7,'Νικολακοπούλου','Βασιλική','1990-3-19',2500),
(8,'Χαλκούση','Άννα','1991-4-21',2500),
(9,'Δημητράκου','Ευαγγελία','1987-9-4',2200),
(10,'Παπαδάκης','Σέργιος','1993-7-15',2500),
(11,'Δημητράτος','Στυλιανός','1996-12-11',2500),
(12,'Παππά','Παναγιώτα','1997-3-27',2250),
(13,'Βασιλείου','Νικόλαος','1993-5-30',2500),
(14,'Ανδρικόπουλος','Γεώργιος','1989-4-19',2500),
(15,'Αναστασάκη','Κατερίνα','1995-9-4',2250);

INSERT INTO trainer
VALUES (1,'Καραγιάννης','Νικόλαος','Java'),
(2,'Οικονόμου','Αναστάσιος','Python'),
(3,'Βουδούρης','Άγγελος','Javascript'),
(4,'Βασιλόπουλος','Νικόλαος','C#'),
(5,'Τσιλιγιάννης','Αθανάσιος','Java'),
(6,'Χατζηδημητρίου','Ελένη','Python'),
(7,'Σπανούδης','Γεώργιος','C#'),
(8,'Φωτιάδη','Ναταλία','Javascript');

INSERT INTO asgnmts_courses
VALUES (1,1,1), (2,1,5),
(3,2,2), (4,2,6),
(5,3,3), (6,3,7),
(7,4,4), (8,4,8);

INSERT INTO students_courses
VALUES (1,1,1), (2,1,4), (3,1,9), (4,1,10), (5,1,12),
(6,2,2), (7,2,6), (8,2,8), (9,2,15), (10,2,11),
(11,3,5), (12,3,13), (13,3,10), (14,3,12), (15,3,11),
(16,4,3), (17,4,14), (18,4,7), (19,4,12), (20,4,11);

INSERT INTO trainers_courses
VALUES (1,1,1), (2,1,5), (3,2,2), (4,2,6), (5,3,3),
(6,3,8), (7,4,4), (8,4,7);

INSERT INTO students_asgnmts
VALUES (1,1,1), (2,1,5), (3,4,1), (4,4,5), (5,9,1), (6,9,5),
(7,10,1), (8,10,5), (9,12,1), (10,12,5), (11,2,2), (12,2,6),
(13,6,2), (14,6,6), (15,8,2), (16,8,6), (17,15,2), (18,15,6),
(19,11,2), (20,11,6), (21,5,3), (22,5,7), (23,13,3), (24,13,7),
(25,10,3), (26,10,7), (27,12,3), (28,12,7), (29,11,3), (30,11,7),
(31,3,4), (32,3,8), (33,14,4), (34,14,8), (35,7,4), (36,7,8),
(37,12,4), (38,12,8), (39,11,4), (40,11,8);

/*DELETE FROM course ORDER BY course_id LIMIT 4;*/