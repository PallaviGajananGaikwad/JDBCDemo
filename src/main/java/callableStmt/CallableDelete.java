package callableStmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableDelete {

    private static final String url = "jdbc:mysql://localhost:3306/information";
    private static final String username = "root";
    private static final String password = "1520";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "CALL delete_student(?)";
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, "Gajanan");
            int rowsAffected = callableStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("No student found with the specified name.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
