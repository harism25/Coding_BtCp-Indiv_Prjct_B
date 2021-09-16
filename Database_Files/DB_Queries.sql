use individual_project_b;

## a list of all the courses
select * from course;

## a list of all the students
select * from student;

## a list of all the assignments
select * from assignment;

## a list of all the trainers
select * from trainer;

## a list of all students per course
select courseTitle, courseType, runTime, student.surname, student.name
from students_courses
inner join course on students_courses.crs_id = course.course_id
inner join student on students_courses.stud_id = student.student_id;

## a list of all trainers per course
select courseTitle, courseType, runTime, trainer.surname, trainer.name
from trainers_courses
inner join course on trainers_courses.crss_id = course.course_id
inner join trainer on trainers_courses.trnr_id = trainer.trainer_id;

## a list of all assignments per course
select courseTitle, courseType, runTime, assignment.asgnmtTitle, assignment.submitDate
from asgnmts_courses
inner join course on asgnmts_courses.crrs_id = course.course_id
inner join assignment on asgnmts_courses.asgnmts_id = assignment.assignment_id;

## a list of all assignments per student
select student.surname, student.name, assignment.asgnmtTitle, assignment.submitDate
from students_asgnmts
inner join assignment on students_asgnmts.asgnmt_id = assignment.assignment_id
inner join student on students_asgnmts.studt_id = student.student_id;

## a list of students that belong to more than one courses
select student.surname, student.name
from students_courses
inner join course on students_courses.crs_id = course.course_id
inner join student on students_courses.stud_id = student.student_id
#group by courseTitle, student.surname, student.name;
group by student.name
having count(*) > 1;
