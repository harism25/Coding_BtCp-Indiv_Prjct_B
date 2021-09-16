/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrief._part_b;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haris
 */
public class DB_Queries
{
    private static final String FINDCOURSES = "SELECT * FROM course";
    private static final String FINDSTUDENTS = "SELECT * FROM student";
    private static final String FINDASSIGNMENTS = "SELECT * FROM assignment";
    private static final String FINDTRAINERS = "SELECT * FROM trainer";
    private static final String FINDSTUDSPERCRS = "SELECT courseTitle, courseType, runTime, student.surname, student.name FROM students_courses "
                                                + "inner join course ON students_courses.crs_id = course.course_id "
                                                + "inner join student ON students_courses.stud_id = student.student_id";
    private static final String FINDTRNSPERCRS = "SELECT courseTitle, courseType, runTime, trainer.surname, trainer.name FROM trainers_courses "
                                                + "inner join course ON trainers_courses.crss_id = course.course_id "
                                                + "inner join trainer ON trainers_courses.trnr_id = trainer.trainer_id";
    private static final String FINDASGNMTSPERCRS = "SELECT courseTitle, courseType, runTime, assignment.asgnmtTitle, assignment.submitDate FROM asgnmts_courses "
                                                + "inner join course ON asgnmts_courses.crrs_id = course.course_id "
                                                + "inner join assignment ON asgnmts_courses.asgnmts_id = assignment.assignment_id";
    private static final String FINDASGNMTSPERSTUDS = "SELECT student.surname, student.name, assignment.asgnmtTitle, assignment.submitDate FROM students_asgnmts "
                                                + "inner join assignment on students_asgnmts.asgnmt_id = assignment.assignment_id "
                                                + "inner join student on students_asgnmts.studt_id = student.student_id";
    private static final String FINDSTUDSMORECRS = "SELECT student.surname, student.name FROM students_courses "
                                                + "inner join course ON students_courses.crs_id = course.course_id "
                                                + "inner join student ON students_courses.stud_id = student.student_id "
                                                + "GROUP by student.name HAVING count(*) > 1";
    
    
    
    // Method for getting all courses info from the database
    public ArrayList<Course> findCourses(Connection conn)
    {
        ArrayList<Course> courseList = new ArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDCOURSES);
            while (rs.next())
            {
                int course_id = rs.getInt(1);
                String courseTitle = rs.getString(2);
                String courseType = rs.getString(3);
                String runTime = rs.getString(4);
                Date startDate = rs.getDate(5);
                Date endDate = rs.getDate(6);
                Float attendPrice = rs.getFloat(7);
                LocalDate localDate1 = Date.valueOf(startDate.toString()).toLocalDate();
                LocalDate localDate2 = Date.valueOf(endDate.toString()).toLocalDate();
                Course course = new Course(courseTitle, courseType, runTime, localDate1, localDate2, attendPrice);
                courseList.add(course);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseList;
    }
    
    
    // Method for getting all courses info from the database (with their DB id)
    public HashMap<Integer, String> findCrsWithId(Connection conn)
    {
        HashMap<Integer, String> crssMap = new HashMap();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDCOURSES);
            while (rs.next())
            {
                int course_id = rs.getInt(1);
                String courseTitle = rs.getString(2);
                String courseType = rs.getString(3);
                crssMap.put(course_id, courseTitle + " " + courseType);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return crssMap;
    }
    
    
    // Method for getting all students info from the database
    public ArrayList<Student> findStudents(Connection conn)
    {
        ArrayList<Student> studentList = new ArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDSTUDENTS);
            while (rs.next())
            {
                int student_id = rs.getInt(1);
                String surname = rs.getString(2);
                String name = rs.getString(3);
                Date dateOfBirth = rs.getDate(4);
                Float schoolFees = rs.getFloat(5);
                LocalDate localDate1 = Date.valueOf(dateOfBirth.toString()).toLocalDate();
                Student student = new Student(surname, name, localDate1, schoolFees);
                studentList.add(student);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentList;
    }
    
    
    // Method for getting all students info from the database (with their DB id)
    public HashMap<Integer, String> findStdsWithId(Connection conn)
    {
        HashMap<Integer, String> stdsMap = new HashMap();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDSTUDENTS);
            while (rs.next())
            {
                int student_id = rs.getInt(1);
                String surname = rs.getString(2);
                String name = rs.getString(3);
                stdsMap.put(student_id, surname + " " + name);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stdsMap;
    }
    
    
    // Method for getting all assignments info from the database
    public ArrayList<Assignment> findAssignments(Connection conn)
    {
        ArrayList<Assignment> asgnmtList = new ArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDASSIGNMENTS);
            while (rs.next())
            {
                int assignment_id = rs.getInt(1);
                String asgnmtTitle = rs.getString(2);
                Date submitDate = rs.getDate(3);
                LocalDate localDate1 = Date.valueOf(submitDate.toString()).toLocalDate();
                Assignment assignment = new Assignment(asgnmtTitle, localDate1);
                asgnmtList.add(assignment);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asgnmtList;
    }
    
    
    // Method for getting all assignments info from the database (with their DB id)
    public HashMap<Integer, String> findAsgnmtsWithId(Connection conn)
    {
        HashMap<Integer, String> asgnmtsMap = new HashMap();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDASSIGNMENTS);
            while (rs.next())
            {
                int assignment_id = rs.getInt(1);
                String asgnmtTitle = rs.getString(2);
                Date submitDate = rs.getDate(3);
                LocalDate localDate1 = Date.valueOf(submitDate.toString()).toLocalDate();
                asgnmtsMap.put(assignment_id, asgnmtTitle + " " +  localDate1.toString());
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asgnmtsMap;
    }
    
    
    // Method for getting all trainers info from the database
    public ArrayList<Trainer> findTrainers(Connection conn)
    {
        ArrayList<Trainer> trnrList = new ArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDTRAINERS);
            while (rs.next())
            {
                int trainer_id = rs.getInt(1);
                String surname = rs.getString(2);
                String name = rs.getString(3);
                String teachinCrs = rs.getString(4);
                Trainer trainer = new Trainer(surname, name, teachinCrs);
                trnrList.add(trainer);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trnrList;
    }
    
    
    // Method for getting all trainers info from the database (with their DB id)
    public HashMap<Integer, String> findTrnrsWithId(Connection conn)
    {
        HashMap<Integer, String> trnrsMap = new HashMap();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDTRAINERS);
            while (rs.next())
            {
                int trainer_id = rs.getInt(1);
                String surname = rs.getString(2);
                String name = rs.getString(3);
                trnrsMap.put(trainer_id, surname + " " + name);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trnrsMap;
    }
    
    
    // Method for getting all students info per course from the database
    public HashMap<String,ArrayList<String>> findStdsPerCrs(Connection conn)
    {
        HashMap<String,ArrayList<String>> stdsPerCrs = new HashMap();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDSTUDSPERCRS);
            while (rs.next())
            {
                String courseTitle = rs.getString(1);
                String courseType = rs.getString(2);
                String runTime = rs.getString(3);
                String stdtSurname = rs.getString(4);
                String stdtName = rs.getString(5);
                if (stdsPerCrs.containsKey(courseTitle))
                {
                    stdsPerCrs.get(courseTitle).add(stdtSurname + " " + stdtName);
                }
                else
                {
                    ArrayList<String> newCrsStds = new ArrayList();
                    newCrsStds.add(stdtSurname + " " + stdtName);
                    stdsPerCrs.put(courseTitle, newCrsStds);
                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stdsPerCrs;
    }
    
    
    // Method for getting all trainers info per course from the database
    public HashMap<String,ArrayList<String>> findTrnsPerCrs(Connection conn)
    {
        HashMap<String,ArrayList<String>> trnsPerCrs = new HashMap();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDTRNSPERCRS);
            while (rs.next())
            {
                String courseTitle = rs.getString(1);
                String courseType = rs.getString(2);
                String runTime = rs.getString(3);
                String trnrSurname = rs.getString(4);
                String trnrName = rs.getString(5);
                if (trnsPerCrs.containsKey(courseTitle))
                {
                    trnsPerCrs.get(courseTitle).add(trnrSurname + " " + trnrName);
                }
                else
                {
                    ArrayList<String> newCrsTrns = new ArrayList();
                    newCrsTrns.add(trnrSurname + " " + trnrName);
                    trnsPerCrs.put(courseTitle, newCrsTrns);
                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trnsPerCrs;
    }
    
    
    // Method for getting all assignments info per course from the database
    public HashMap<String,ArrayList<String>> findAsgnmtsPerCrs(Connection conn)
    {
        HashMap<String,ArrayList<String>> asgnmtsPerCrs = new HashMap();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDASGNMTSPERCRS);
            while (rs.next())
            {
                String courseTitle = rs.getString(1);
                String courseType = rs.getString(2);
                String runTime = rs.getString(3);
                String asgnmtTitle = rs.getString(4);
                Date submitDate = rs.getDate(5);
                LocalDate localDate1 = Date.valueOf(submitDate.toString()).toLocalDate();
                if (asgnmtsPerCrs.containsKey(courseTitle))
                {
                    asgnmtsPerCrs.get(courseTitle).add(asgnmtTitle + " " + submitDate);
                }
                else
                {
                    ArrayList<String> newCrsAsgnmts = new ArrayList();
                    newCrsAsgnmts.add(asgnmtTitle + " " + submitDate);
                    asgnmtsPerCrs.put(courseTitle, newCrsAsgnmts);
                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asgnmtsPerCrs;
    }
    
    
    // Method for getting all assignments info per student from the database
    public HashMap<String,ArrayList<String>> findAsgnmtsPerStuds(Connection conn)
    {
        HashMap<String,ArrayList<String>> asgnmtsPerStuds = new HashMap();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDASGNMTSPERSTUDS);
            while (rs.next())
            {
                String stdtSurname = rs.getString(1);
                String stdtName = rs.getString(2);
                String asgnmtTitle = rs.getString(3);
                Date submitDate = rs.getDate(4);
                LocalDate localDate1 = Date.valueOf(submitDate.toString()).toLocalDate();
                if (asgnmtsPerStuds.containsKey(stdtSurname + " " + stdtName))
                {
                    asgnmtsPerStuds.get(stdtSurname + " " + stdtName).add(asgnmtTitle + " " + localDate1);
                }
                else
                {
                    ArrayList<String> newStudsAsgnmts = new ArrayList();
                    newStudsAsgnmts.add(asgnmtTitle + " " + localDate1);
                    asgnmtsPerStuds.put(stdtSurname + " " + stdtName, newStudsAsgnmts);
                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asgnmtsPerStuds;
    }
    
    
    // Method for getting students in more than one courses from the database
    public ArrayList<String> findStdsMoreCrs(Connection conn)
    {
        ArrayList<String> stdsMoreCrs = new ArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDSTUDSMORECRS);
            while (rs.next())
            {
                String surname = rs.getString(1);
                String name = rs.getString(2);
                stdsMoreCrs.add(surname + " " + name);
                
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stdsMoreCrs;
    }
}
