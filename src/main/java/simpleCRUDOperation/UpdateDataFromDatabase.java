package simpleCRUDOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDataFromDatabase {
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
            Statement statement= connection.createStatement();
            String query= String.format("update stud SET Student_city = '%s' WHERE Student_name='%s'","Pune","Gajanan");
            int rowaffected= statement.executeUpdate(query);
            if(rowaffected>0){
                System.out.println("Update data successfully");
            }else {
                System.out.println("data not Update");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }
}
