/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrief._part_b;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haris
 */
public class IndividualProjectBrief_PART_B
{

    public static void printQrsExecutions()
    {
        DB_Utils db_utils = new DB_Utils();
        Connection conn = db_utils.getConnection();
        System.out.println(conn);
        DB_Queries db_queries = new DB_Queries();

        // Executing query for getting all the courses
        ArrayList<Course> courseList = db_queries.findCourses(conn);
        System.out.println("\033[1;33mL I S T   O F   C O U R S E S: ");
        System.out.println("\033[1;33m*-----*-----*-----*-----*-----*\033[0m" + "\n");
        for (Course crs : courseList)
        {
            System.out.println("Coursetitle: " + crs.getCourseTitle() + " Coursetype: " + crs.getCourseType() + " Runtime: "
                    + crs.getRunTime() + " Starting Date: " + crs.getStartDate() + " Ending Date: " + crs.getEndDate()
                    + " Attending Price: " + crs.getAttendPrice());
        }
        System.out.println();

        // Executing query for getting all the students
        ArrayList<Student> studentList = db_queries.findStudents(conn);
        System.out.println("\033[1;33mL I S T   O F   S T U D E N T S: ");
        System.out.println("\033[1;33m*-----*-----*-----*-----*-----*\033[0m" + "\n");
        for (Student std : studentList)
        {
            System.out.println("Surname: " + std.getSurname() + " Name: " + std.getName()
                    + " Date of birth: " + std.getDateOfBirth() + " School fees: " + std.getSchoolFees());
        }
        System.out.println();

        // Executing query for getting all the assignments
        ArrayList<Assignment> asgnmtList = db_queries.findAssignments(conn);
        System.out.println("\033[1;33mL I S T   O F   A S S I G N M E N T S: ");
        System.out.println("\033[1;33m*-----*-----*-----*-----*-----*-----*\033[0m" + "\n");
        for (Assignment asgnmt : asgnmtList)
        {
            System.out.println("Assignment title: " + asgnmt.getAsgnmtTitle() + " Date for submitting: " + asgnmt.getSubmitDate());
        }
        System.out.println();

        // Executing query for getting all the trainers
        ArrayList<Trainer> trnrList = db_queries.findTrainers(conn);
        System.out.println("\033[1;33mL I S T   O F   T R A I N E R S: ");
        System.out.println("\033[1;33m*-----*-----*-----*-----*-----*\033[0m" + "\n");
        for (Trainer trnr : trnrList)
        {
            System.out.println("Surname: " + trnr.getSurname() + " Name: " + trnr.getName() + " Teaching courses: " + trnr.getTeachingCrs());
        }
        System.out.println();

        // Executing query for getting all students per course
        HashMap<String, ArrayList<String>> stdsPerCrs = db_queries.findStdsPerCrs(conn);
        System.out.println("\033[1;33mL I S T  O F  S T U D E N T S  P E R  C O U R S E: ");
        System.out.println("\033[1;33m*-----*-----*-----*-----*-----*-----*-----*-----*\033[0m" + "\n");
        for (HashMap.Entry<String, ArrayList<String>> set : stdsPerCrs.entrySet())
        {
            System.out.print("Course: " + set.getKey() + "   " + "\nStudents are: ");
            for (String str : set.getValue())
            {
                System.out.print(str);
            }
            System.out.println();
        }
        System.out.println();

        // Executing query for getting all trainers per course
        HashMap<String, ArrayList<String>> trnsPerCrs = db_queries.findTrnsPerCrs(conn);
        System.out.println("\033[1;33mL I S T  O F  T R A I N E R S  P E R  C O U R S E: ");
        System.out.println("\033[1;33m*-----*-----*-----*-----*-----*-----*-----*-----*\033[0m" + "\n");
        for (HashMap.Entry<String, ArrayList<String>> set : trnsPerCrs.entrySet())
        {
            System.out.print("Course: " + set.getKey() + "   " + "\nTrainers are: ");
            for (String str : set.getValue())
            {
                System.out.print(str);
            }
            System.out.println();
        }
        System.out.println();

        // Executing query for getting all assignments per course
        HashMap<String, ArrayList<String>> asgnmtsPerCrs = db_queries.findAsgnmtsPerCrs(conn);
        System.out.println("\033[1;33mL I S T  O F  A S S I G N M E N T S  P E R  C O U R S E: ");
        System.out.println("\033[1;33m*-----*-----*-----*-----*-----*-----*-----*-----*-----*\033[0m" + "\n");
        for (HashMap.Entry<String, ArrayList<String>> set : asgnmtsPerCrs.entrySet())
        {
            System.out.println("Course: " + set.getKey() + "  " + "\nAssignments are: ");
            for (String str : set.getValue())
            {
                System.out.println(str);
            }
            System.out.println();
        }
        System.out.println();

        // Executing query for getting all assignments per student
        HashMap<String, ArrayList<String>> asgnmtsPerStuds = db_queries.findAsgnmtsPerStuds(conn);
        System.out.println("\033[1;33mL I S T  O F  A S S I G N M E N T S  P E R  S T U D E N T: ");
        System.out.println(" \033[1;33m*-----*-----*-----*-----*-----*-----*-----*-----*-----*\033[0m" + "\n");
        for (HashMap.Entry<String, ArrayList<String>> set : asgnmtsPerStuds.entrySet())
        {
            System.out.println("Student: " + set.getKey() + "  " + "\nAssignments are: ");
            for (String str : set.getValue())
            {
                System.out.println(str);
            }
            System.out.println();
        }

        ArrayList<String> stdsMoreCrs = db_queries.findStdsMoreCrs(conn);
        System.out.println("\033[1;33mL I S T  O F  S T U D E N T S  I N  M O R E  T H A N  O N E  C O U R S E S: ");
        System.out.println(" \033[1;33m*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*\033[0m" + "\n");
        for (String stdt : stdsMoreCrs)
        {
            System.out.println(stdt);
        }
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("\033[41mEnd of program, have a nice day!\033[0m ");
        db_utils.closeConnection(conn);
        
    }

    // Method for inserting new courses from keyboard!
    public static void insertCourses(Connection conn, Scanner scan, Insert_Queries insertQrs)
    {
        String courseTitle;
        String courseType;
        String runTime;
        LocalDate startDate;
        LocalDate endDate;
        float attendPrice;
        System.out.println("\033[0;37mHow many courses do you want to insert? ");
        String insertCourses;
        int inputCoursesNum;

        for (;;)
        {
            insertCourses = scan.nextLine();
            try
            {
                inputCoursesNum = Integer.parseInt(insertCourses);
                break;
            }
            catch (Exception e)
            {
                System.out.println("Wrong input, please type a number!");
            }
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < inputCoursesNum; i++)
        {
            System.out.println("\033[0;37mPlease insert a course title: ");
            courseTitle = scan.nextLine();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("\033[0;37mPlease insert a course type (e.g. semiannual or annual): ");
            courseType = scan.nextLine();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("\033[0;37mPlease insert the run time of the course (e.g. Full-Time or Part-Time): ");
            runTime = scan.nextLine();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("\033[0;37mPlease insert course's starting date (e.g. yyyy-mm-dd): ");
            for (;;)
            {
                String strDate = scan.nextLine();
                try
                {
                    startDate = LocalDate.parse(strDate);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println("Wrong input, please type a date in the yyyy-mm-dd format! ");
                }
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("\033[0;37mPlease insert course's ending date (e.g. yyyy-mm-dd): ");
            for (;;)
            {
                String edDate = scan.nextLine();
                try
                {
                    endDate = LocalDate.parse(edDate);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println("Wrong input, please type a date in the yyyy-mm-dd format! ");
                }
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("\033[0;37mPlease put in the course's price for attendance (e.g. 1000.00): ");
            for (;;)
            {
                String price = scan.nextLine();
                try
                {
                    attendPrice = Float.parseFloat(price);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println("Wrong input, please type a correct number! ");
                }
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            insertQrs.insertCrs(courseTitle, courseType, runTime, startDate, endDate, attendPrice, conn);

        }

    }

    // Method for inserting new students from keyboard!
    public static void insertStudents(Connection conn, Scanner scan, Insert_Queries insertQrs)
    {
        String surname;
        String name;
        LocalDate dateOfBirth;
        float schoolFees;
        System.out.println("\033[0;37mHow many students do you want to insert? ");
        String insertStudents;
        int inputStudentsNum;
        for (;;)
        {
            insertStudents = scan.nextLine();
            try
            {
                inputStudentsNum = Integer.parseInt(insertStudents);
                break;
            }
            catch (Exception e)
            {
                System.out.println("Wrong input, please type a number!");
            }
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < inputStudentsNum; i++)
        {
            System.out.println("\033[0;37mPlease insert a student's surname: ");
            surname = scan.nextLine();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("\033[0;37mPlease insert a student's name: ");
            name = scan.nextLine();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("\033[0;37mPlease type student's birth date (e.g. yyyy-mm-dd): ");
            for (;;)
            {
                String birthDate = scan.nextLine();
                try
                {
                    dateOfBirth = LocalDate.parse(birthDate);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println("Wrong input, please type a date in the yyyy-mm-dd format! ");
                }
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("\033[0;37mPlease type amount of fees the student has to pay (e.g. 5000.00): ");
            for (;;)
            {
                String price = scan.nextLine();
                try
                {
                    schoolFees = Float.parseFloat(price);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println("Wrong input, please type a correct number! ");
                }
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }
            insertQrs.insertStd(surname, name, dateOfBirth, schoolFees, conn);
        }
    }

    // Method for inserting new assignments from keyboard!
    public static void insertAssignments(Connection conn, Scanner scan, Insert_Queries insertQrs)
    {
        String asgnmtTitle;
        LocalDate submitDate;
        System.out.println("\033[0;37mHow many assignments do you want to insert? ");
        String insertAsgnmts;
        int inputAsgnmtsNum;
        for (;;)
        {
            insertAsgnmts = scan.nextLine();
            try
            {
                inputAsgnmtsNum = Integer.parseInt(insertAsgnmts);
                break;
            }
            catch (Exception e)
            {
                System.out.println("Wrong input, please type a number!");
            }
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < inputAsgnmtsNum; i++)
        {
            System.out.println("\033[0;37mPlease insert title for a new assignment: ");
            asgnmtTitle = scan.nextLine();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("\033[0;37mPlease type new assignment's submitting date (e.g. yyyy-mm-dd): ");
            for (;;)
            {
                String sbmtDate = scan.nextLine();
                try
                {
                    submitDate = LocalDate.parse(sbmtDate);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println("Wrong input, please type a date in the yyyy-mm-dd format! ");
                }
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            insertQrs.insertAsgnmt(asgnmtTitle, submitDate, conn);
        }
    }

    // Method for inserting new trainers from keyboard!
    public static void insertTrainers(Connection conn, Scanner scan, Insert_Queries insertQrs)
    {
        String surname;
        String name;
        String teachingCrs;
        System.out.println("\033[0;37mHow many trainers do you want to insert? ");
        String insertTrainers;
        int inputTrainersNum;
        for (;;)
        {
            insertTrainers = scan.nextLine();
            try
            {
                inputTrainersNum = Integer.parseInt(insertTrainers);
                break;
            }
            catch (Exception e)
            {
                System.out.println("Wrong input, please type a number!");
            }
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < inputTrainersNum; i++)
        {
            System.out.println("\033[0;37mPlease insert a trainer's surname: ");
            surname = scan.nextLine();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("\033[0;37mPlease insert a trainers's name: ");
            name = scan.nextLine();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("\033[0;37mPlease type what course for the ones you entered above the trainer will be teaching in: ");
            teachingCrs = scan.nextLine();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }

            insertQrs.insertTrnr(surname, name, teachingCrs, conn);
        }
    }
    
    // Method for inserting new students for each course!
    public static void insertStdsPerCrs(Connection conn, Scanner scan, Insert_Queries insertQrs)
    {
        HashMap<Integer, Integer> stdsPerCrs = new HashMap();
        DB_Queries dbQrs = new DB_Queries();
        HashMap<Integer, String> crssMap = dbQrs.findCrsWithId(conn);
        HashMap<Integer, String> stdsMap = dbQrs.findStdsWithId(conn);
        for (Map.Entry<Integer, String> entry : stdsMap.entrySet())
        {
            System.out.println("\033[0;37mHow many courses will student '" + entry.getValue() + "' be attending in? ");
            String inputCrss;
            int inputCrsNum;
            for (;;)
            {
                inputCrss = scan.nextLine();
                try
                {
                    inputCrsNum = Integer.parseInt(inputCrss);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println("Wrong input, please type a number!");
                }
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < inputCrsNum; i++)
            {
                System.out.println("\033[0;37mChoose course (type one number at a time): ");
                for (Map.Entry<Integer, String> crsentry : crssMap.entrySet())
                {
                    System.out.println(crsentry.getKey() + crsentry.getValue());
                }
                String inputCrs;
                int inCrsNum;
                for (;;)
                {
                    inputCrs = scan.nextLine();
                    try
                    {
                        inCrsNum = Integer.parseInt(inputCrs);
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Wrong input, please type a number!");
                    }
                }
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
                }
                stdsPerCrs.put(inCrsNum, entry.getKey());
            }
        }
        for (Map.Entry<Integer, Integer> stdCrsPair : stdsPerCrs.entrySet())
        {
            insertQrs.insertStudsPerCrs(stdCrsPair.getKey(), stdCrsPair.getValue(), conn);
        }
    }
    
    // Method for inserting new trainers for each course!
    public static void insertTrnrsPerCrs(Connection conn, Scanner scan, Insert_Queries insertQrs)
    {
        HashMap<Integer, Integer> trnrsPerCrs = new HashMap();
        DB_Queries dbQrs = new DB_Queries();
        HashMap<Integer, String> crssMap = dbQrs.findCrsWithId(conn);
        HashMap<Integer, String> trnrsMap = dbQrs.findTrnrsWithId(conn);
        for (Map.Entry<Integer, String> entry : trnrsMap.entrySet())
        {
            System.out.println("\033[0;37mHow many courses will trainer '" + entry.getValue() + "' be teaching in? ");
            String inputCrss;
            int inputCrsNum;
            for (;;)
            {
                inputCrss = scan.nextLine();
                try
                {
                    inputCrsNum = Integer.parseInt(inputCrss);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println("Wrong input, please type a number!");
                }
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < inputCrsNum; i++)
            {
                System.out.println("\033[0;37mChoose course (type one number at a time): ");
                for (Map.Entry<Integer, String> crsentry : crssMap.entrySet())
                {
                    System.out.println(crsentry.getKey() + crsentry.getValue());
                }
                String inputCrs;
                int inCrsNum;
                for (;;)
                {
                    inputCrs = scan.nextLine();
                    try
                    {
                        inCrsNum = Integer.parseInt(inputCrs);
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Wrong input, please type a number!");
                    }
                }
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
                }
                trnrsPerCrs.put(inCrsNum, entry.getKey());
            }
        }
        for (Map.Entry<Integer, Integer> trnrCrsPair : trnrsPerCrs.entrySet())
        {
            insertQrs.insertTrnsPerCrs(trnrCrsPair.getKey(), trnrCrsPair.getValue(), conn);
        }
    }
    
    // Method for inserting new assignments for each course!
    public static void insertAsgnmtsPerCrs(Connection conn, Scanner scan, Insert_Queries insertQrs)
    {
        HashMap<Integer, Integer> asgnmtsPerCrs = new HashMap();
        DB_Queries dbQrs = new DB_Queries();
        HashMap<Integer, String> crssMap = dbQrs.findCrsWithId(conn);
        HashMap<Integer, String> asgnmtsMap = dbQrs.findAsgnmtsWithId(conn);
        for (Map.Entry<Integer, String> entry : asgnmtsMap.entrySet())
        {
            System.out.println("\033[0;37mHow many assignnments will course '" + entry.getValue() + "' have? ");
            String inputAsgnmts;
            int inputAsgNum;
            for (;;)
            {
                inputAsgnmts = scan.nextLine();
                try
                {
                    inputAsgNum = Integer.parseInt(inputAsgnmts);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println("Wrong input, please type a number!");
                }
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < inputAsgNum; i++)
            {
                System.out.println("\033[0;37mChoose assignment (type one number at a time): ");
                for (Map.Entry<Integer, String> asgnmtentry : asgnmtsMap.entrySet())
                {
                    System.out.println(asgnmtentry.getKey() + asgnmtentry.getValue());
                }
                String inputAsgnmt;
                int inAsgNum;
                for (;;)
                {
                    inputAsgnmt = scan.nextLine();
                    try
                    {
                        inAsgNum = Integer.parseInt(inputAsgnmt);
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Wrong input, please type a number!");
                    }
                }
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
                }
                asgnmtsPerCrs.put(inAsgNum, entry.getKey());
            }
        }
        for (Map.Entry<Integer, Integer> asgnmtCrsPair : asgnmtsPerCrs.entrySet())
        {
            insertQrs.insertAsgnmtsPerCrs(asgnmtCrsPair.getKey(), asgnmtCrsPair.getValue(), conn);
        }
    }
    
    // All the methods used for inserting data gathered in one method
    public static void insertQrsExecutions()
    {
        Insert_Queries insertQrs = new Insert_Queries();
        DB_Utils dbUtils = new DB_Utils();
        Connection conn = dbUtils.getConnection();
        Scanner scan = new Scanner(System.in);
        
        // Methods for inserting data from keyboard
        insertCourses(conn, scan, insertQrs);

        insertStudents(conn, scan, insertQrs);

        insertAssignments(conn, scan, insertQrs);

        insertTrainers(conn, scan, insertQrs);
        
        insertStdsPerCrs(conn, scan, insertQrs);
        
        insertTrnrsPerCrs(conn, scan, insertQrs);
        
        insertAsgnmtsPerCrs(conn, scan, insertQrs);
        
        
        dbUtils.closeConnection(conn);
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        System.out.println("\033[32;1;4mHello user!");                                                                // Program start with the user's prompt for input
        try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println("\033[32;1;4mWelcome to this program..  (May I suggest using a dark background "
                + "before you continue so that letters will be more visible!)");
        try
            {
                Thread.sleep(1200);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println("\033[33;1;4m.....");
        try
            {
                Thread.sleep(1500);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println("\033[33;1;4m..........");
        try
            {
                Thread.sleep(2500);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println("\033[32;1;4mWould you like to access existing database or create your own data?"
                + "(Type 1 or 2 accordingly)\033[0m");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.equals("1"))
        {
            try
            {
                Thread.sleep(800);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }
            printQrsExecutions();
        }
        else if (input.equals("2"))
        {
            try
            {
                Thread.sleep(600);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Ok...");
            try
            {
                Thread.sleep(700);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(IndividualProjectBrief_PART_B.class.getName()).log(Level.SEVERE, null, ex);
            }
            insertQrsExecutions();
        }
        else
        {
            System.out.println("\033[41mWrong input, please run the programm again.\033[0m ");
            return;
        }
    }
}
