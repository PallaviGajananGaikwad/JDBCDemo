package simpleCRUDOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionStringWithProperties
{
    public static void main(String[] args) {
        // JDBC URL for MySQL database
        String url = "jdbc:mysql://localhost:3306/?user=root?user=root&password=1520&autoReconnect=true&connectTimeout=3000";

        Connection connection = null;
        try {
            // Establishing connection
            connection = DriverManager.getConnection(url);

            // Connection successful, you can now use 'connection' object to interact with the database
            System.out.println("Connected to database successfully!");
        } catch (SQLException e) {
            // Handle any errors that may occur during connection establishment
            e.printStackTrace();
        } finally {
            // Closing the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
