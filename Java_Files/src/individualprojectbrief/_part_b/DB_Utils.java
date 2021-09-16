/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrief._part_b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haris
 */
public class DB_Utils
{
    private final String url = "jdbc:mysql://localhost:3306/individual_project_b";
    private final String user = "root";
    private final String password = "root";

    // Opening the connection with MySQL database
    protected Connection getConnection()
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    // Closing the connection with MySQL database
    protected void closeConnection(Connection conn)
    {
        try
        {
            //rs.close();
            //stmt.close();
            conn.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
