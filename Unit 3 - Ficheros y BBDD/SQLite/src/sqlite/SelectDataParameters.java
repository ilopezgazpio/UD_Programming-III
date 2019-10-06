package sqlite;

import java.sql.*;

/**
 *
 * @author sqlitetutorial.net
 */
public class SelectDataParameters
{
    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect()
    {
        // SQLite connection string
        String name = "HelloWorld.db";
        String url = "jdbc:sqlite:" + name;
        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * Get the warehouse whose capacity greater than a specified capacity
     * @param capacity
     */
    public void getCapacityGreaterThan(double capacity)
    {
        String sql = "SELECT id, name, capacity FROM warehouses WHERE capacity > ?";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt  = conn.prepareStatement(sql)
                )
        {

            // set the value
            pstmt.setDouble(1,capacity);


            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while (rs.next())
            {
                System.out.println
                        (
                                rs.getInt("id") +  "\t" +
                                rs.getString("name") + "\t" +
                                rs.getDouble("capacity"));
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SelectDataParameters app = new SelectDataParameters();
        app.getCapacityGreaterThan(3600);
    }
}

