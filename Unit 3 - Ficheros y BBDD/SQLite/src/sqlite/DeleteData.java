package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class DeleteData
{
    /**
     * Connect to the test.db database
     *
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
     * Delete a warehouse specified by the id
     *
     * @param id
     */
    public void delete(int id)
    {
        String sql = "DELETE FROM warehouses WHERE id = ?";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {

            // set the corresponding param
            pstmt.setInt(1, id);

            // execute the delete statement
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        DeleteData app = new DeleteData();
        // delete the row with id 3
        app.delete(3);
    }

}
