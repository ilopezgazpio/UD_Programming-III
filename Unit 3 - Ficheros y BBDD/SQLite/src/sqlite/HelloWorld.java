package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author sqlitetutorial.net
 */
public class HelloWorld
{
    /**
     * Connect to a sample database
     */
    public static void connect()
    {
        Connection conn = null;

        // db parameters
        String path = "myDB.db";
        String url = "jdbc:sqlite:" + path;
        try
        {
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        }
        catch (SQLException e)
        {
            System.out.println("Cannot connect to " + url + "database");
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        connect();
    }
}