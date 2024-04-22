package callableStmt;

import java.sql.*;

public class CallableRetrive
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
            String call = "{call getStudentCity(?, ?)}";
            CallableStatement callableStatement = connection.prepareCall(call);
            callableStatement.setString(1, "Gajanan");
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.execute();

            String studentCity = callableStatement.getString(2);
            if (studentCity != null) {
                System.out.println("Student City: " + studentCity);
            } else {
                System.out.println("City not found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
