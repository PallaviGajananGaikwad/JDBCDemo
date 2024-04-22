package callableStmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableUpdate
{
    private static final String url = "jdbc:mysql://localhost:3306/information";
    private static final String username = "root";
    private static final String password = "1520";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String call = "{call updateStudentCity(?, ?)}";
            CallableStatement callableStatement = connection.prepareCall(call);
            callableStatement.setString(1, "Gajanan");
            callableStatement.setString(2, "New City");
            callableStatement.execute();

            System.out.println("Data updated successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
