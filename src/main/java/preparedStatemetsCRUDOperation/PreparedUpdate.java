package preparedStatemetsCRUDOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedUpdate {
    private static final String url="jdbc:mysql://localhost:3306/information";
    private static final String username="root";
    private static final String password="1520";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            // Inserdata from database
            String query= "update stud SET Student_name=? Where Student_id=?";
            PreparedStatement preparedstmt = connection.prepareStatement(query);
            preparedstmt.setString(1,"Jay");
            preparedstmt.setInt(2,10);
            int rowaffected= preparedstmt.executeUpdate();
            if(rowaffected>0){
                System.out.println("update data successfully");
            }else {
                System.out.println("Data not update");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }
}
