package sqlite;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


class DateUtils
{
    private SimpleDateFormat formatter;

    public DateUtils(String format)
    {
        this.formatter = new SimpleDateFormat(format);
    }

    public java.util.Date string2Date(String date_str) throws ParseException
    {
        return this.formatter.parse(date_str);
    }

    // A main method in a class serves the purpose of rapid debugging, even you know you SHOULD DO this using JUnit !!
    public static void main(String [] args)
    {
        DateUtils myFormatter = new DateUtils("yyyy-MM-dd HH:mm:ss");
        java.util.Date outDate = null;
        try
        {
            outDate = myFormatter.string2Date("2019-10-18 00:00:00");
        }
        catch (ParseException e)
        {
            System.out.println("BadAss error formating string. " + e.getMessage());
        }

        System.out.println(outDate);
    }

}


class DBManager
{
    private Connection conn;
    private String BDname;
    private final String URL = "jdbc:sqlite:";

    private DateUtils myDateTransformer;

    // Constructor
    public DBManager(String BDname)
    {
        this.BDname = this.URL + BDname;
        this.myDateTransformer = new DateUtils("yyyy-MM-dd HH:mm:ss");
    }

    public void createLink() throws SQLException
    {
        try
        {
            this.conn = DriverManager.getConnection(this.BDname);
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error creating connection. " + e.getMessage());
        }
    }

    public void createNewTable() throws SQLException
    {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Table_With_Dates (\n"
                + "    id INTEGER PRIMARY KEY,\n"
                + "    date_string DATETIME NOT NULL,\n"
                + "    java_Util_Date_string DATETIME NOT NULL,\n"
                + "    date_unix_timestamp DATETIME NOT NULL\n"
                + ");";

        try
                (
                        // This is a try with resources syntax, resources taken here will be automatically freed at the end of the try block
                        Statement stmt = this.conn.createStatement()
                )
        {
            // create a new table
            boolean result = stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error creating table. " + e.getMessage());
            System.out.println(sql);
        }
    }

    public void saveData(List<String> data) throws SQLException
    {
        for (String current : data)
        {
            this.insert(current);
        }
    }

    private void insert(String date_str) throws SQLException
    {
        // Take into account that SQLite id attribute is an special attribute that is autoincremented by SQLite
        String sql = "INSERT INTO Table_With_Dates(date_string, java_Util_Date_string, date_unix_timestamp) VALUES(?,?,?)";

        try
                (
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setString(1, date_str ); // will save date as plain string
            pstmt.setString(2, this.myDateTransformer.string2Date(date_str).toString()); // will save date as returned by java.util.Date
            pstmt.setLong(3, this.myDateTransformer.string2Date(date_str).getTime()); // will save date as integer (milliseconds since time 0)
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error executing insert. " + e.getMessage());
        }
        catch (ParseException e)
        {
            System.out.println("BadAss error parsing date. " + e.getMessage());
        }
    }

    public void closeLink() throws SQLException
    {
        try
        {
            if (this.conn != null)
            {
                this.conn.close();
            }
        }
        catch (SQLException ex)
        {
            System.out.println("BadAss error closing connection" + ex.getMessage());
        }
    }

}


public class Dates
{
    public static void main (String [] args)
    {
        DBManager myDBManager;

        try
        {
            // Step 1 - Instantiate the manager
            myDBManager= new DBManager("Database_with_dates.db");

            // Step 2 - Create database
            myDBManager.createLink();

            // Step 3 - Create table
            myDBManager.createNewTable();

            // Step 4 - Work with data
            List<String> data = new ArrayList<String>();
            data.add("2019-10-18 00:00:00");

            // Step 5 call the manager to save data
            myDBManager.saveData(data);

            // Last step - Close connection
            myDBManager.closeLink();
        }
        catch (SQLException e)
        {
            System.out.println("Process terminated with errors");
        }
        finally
        {
            System.out.println("Process terminated successfully");
        }

    }
}
