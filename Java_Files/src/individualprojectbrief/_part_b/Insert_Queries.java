/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrief._part_b;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haris
 */
public class Insert_Queries
{
    private static final String INSERTCOURSES = "INSERT INTO course (courseTitle, courseType, runTime, startDate, endDate, attendPrice) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String INSERTSTUDENTS = "INSERT INTO student (surname, name, dateOfBirth, schoolFees) VALUES (?, ?, ?, ?)";
    private static final String INSERTASSIGNMENTS = "INSERT INTO assignment (asgnmtTitle, submitDate) VALUES (?, ?)";
    private static final String INSERTTRAINERS = "INSERT INTO trainer (surname, name, teachingCrs) VALUES (?, ?, ?)";
    private static final String INSERTSTUDSPERCRS = "INSERT INTO students_courses (crs_id, stud_id) VALUES (?, ?)";
    private static final String INSERTTRNSPERCRS = "INSERT INTO trainers_courses (crss_id, trnr_id) VALUES (?, ?)";
    private static final String INSERTASGNMTSPERCRS = "INSERT INTO asgnmts_courses (crrs_id, asgnmts_id) VALUES (?, ?)";
    private static final String INSERTASGNMTSPERSTUDS = "INSERT INTO students_asgnmts (studt_id, asgnmt_id) VALUES (?, ?)";

    
    
    // Method for inserting courses data by the user
    public void insertCrs(String courseTitle, String courseType, String runTime, LocalDate startDate, LocalDate endDate, Float attendPrice, Connection conn)
    {
        PreparedStatement pstmt = null;
        try
        {
            pstmt = conn.prepareStatement(INSERTCOURSES);
            pstmt.setString(1, courseTitle); 
            pstmt.setString(2, courseType);
            pstmt.setString(3, runTime);
            Date stDate = Date.valueOf(startDate);
            pstmt.setDate(4, stDate);
            Date edDate = Date.valueOf(endDate);
            pstmt.setDate(5, edDate);
            pstmt.setFloat(6, attendPrice);
            int result = pstmt.executeUpdate();
            if (result == 1)
            {
                System.out.println("Course successfully created! ");
            }
            pstmt.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Insert_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Method for inserting students data by the user
    public void insertStd(String surname, String name, LocalDate dateOfBirth, Float schoolFees, Connection conn)
    {
        PreparedStatement pstmt = null;
        try
        {
            pstmt = conn.prepareStatement(INSERTSTUDENTS);
            pstmt.setString(1, surname);
            pstmt.setString(2, name);
            Date stDate = Date.valueOf(dateOfBirth);
            pstmt.setDate(3, stDate);
            pstmt.setFloat(4, schoolFees);
            int result = pstmt.executeUpdate();
            if (result == 1)
            {
                System.out.println("Student successfully created! ");
            }
            pstmt.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Insert_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // Method for inserting trainers data by the user
    public void insertTrnr(String surname, String name, String teachingCrs, Connection conn)
    {
        PreparedStatement pstmt = null;
        try
        {
            pstmt = conn.prepareStatement(INSERTTRAINERS);
            pstmt.setString(1, surname);
            pstmt.setString(2, name);
            pstmt.setString(3, teachingCrs);
            int result = pstmt.executeUpdate();
            if (result == 1)
            {
                System.out.println("Trainer successfully created! ");
            }
            pstmt.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Insert_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Method for inserting assignments data by the user
    public void insertAsgnmt(String asgnmtTitle, LocalDate submitDate, Connection conn)
    {
        PreparedStatement pstmt = null;
        try
        {
            pstmt = conn.prepareStatement(INSERTASSIGNMENTS);
            pstmt.setString(1, asgnmtTitle);
            Date sbmtDate = Date.valueOf(submitDate);
            pstmt.setDate(2, sbmtDate);
            int result = pstmt.executeUpdate();
            if (result == 1)
            {
                System.out.println("Assignment successfully created! ");
            }
            pstmt.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Insert_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Method for inserting students data for each course by the user
    public void insertStudsPerCrs(int crs_id, int stud_id, Connection conn)
    {
        PreparedStatement pstmt = null;
        try
        {
            pstmt = conn.prepareStatement(INSERTSTUDSPERCRS);
            pstmt.setInt(1, crs_id);
            pstmt.setInt(2, stud_id);

            int result = pstmt.executeUpdate();
            if (result == 1)
            {
                System.out.println("Students per course successfully created! ");
            }
            pstmt.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Insert_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method for inserting trainers data for each course by the user
    public void insertTrnsPerCrs(int crss_id, int trnr_id, Connection conn)
    {
        PreparedStatement pstmt = null;
        try
        {
            pstmt = conn.prepareStatement(INSERTTRNSPERCRS);
            pstmt.setInt(1, crss_id);
            pstmt.setInt(2, trnr_id);

            int result = pstmt.executeUpdate();
            if (result == 1)
            {
                System.out.println("Trainers per course successfully created! ");
            }
            pstmt.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Insert_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Method for inserting assignments data for each course by the user
    public void insertAsgnmtsPerCrs(int crrs_id, int asgnmts_id, Connection conn)
    {
        PreparedStatement pstmt = null;
        try
        {
            pstmt = conn.prepareStatement(INSERTASGNMTSPERCRS);
            pstmt.setInt(1, crrs_id);
            pstmt.setInt(2, asgnmts_id);

            int result = pstmt.executeUpdate();
            if (result == 1)
            {
                System.out.println("Assignments per course successfully created! ");
            }
            pstmt.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Insert_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Method for inserting assignments data for each student by the user
    public void insertAsgnmtsPerStuds(int studt_id, int asgnmt_id, Connection conn)
    {
        PreparedStatement pstmt = null;
        try
        {
            pstmt = conn.prepareStatement(INSERTASGNMTSPERSTUDS);
            pstmt.setInt(1, studt_id);
            pstmt.setInt(2, asgnmt_id);

            int result = pstmt.executeUpdate();
            if (result == 1)
            {
                System.out.println("Assignments per student successfully created! ");
            }
            pstmt.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Insert_Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}