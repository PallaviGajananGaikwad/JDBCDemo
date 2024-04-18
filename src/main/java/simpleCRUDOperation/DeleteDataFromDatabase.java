package simpleCRUDOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDataFromDatabase
{
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
            String query= "Delete from stud where Student_id= 13";
            int rowaffected= statement.executeUpdate(query);
            if(rowaffected>0){
                System.out.println("Delete data successfully");
            }else {
                System.out.println("data not delete");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }
}
