package Revision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/test","abisheks","12345678");
            if(connection != null)
            {
                System.out.println("connected");
            }
            else
            {
                System.out.println("error");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        System.out.println(connection.getSchema());
        connection.close();

    }
}
