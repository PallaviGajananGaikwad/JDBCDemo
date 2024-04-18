// Data Retrive from database;
package simpleCRUDOperation;
import java.sql.*;
public class RetriveDataFromDatabase {

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
            String query= "select * from stud";
            ResultSet resultSet= statement.executeQuery(query);
            while(resultSet.next())
            {
                int Student_id=resultSet.getInt("Student_id");
                String Student_name= resultSet.getString("Student_Name");
                int Student_age=resultSet.getInt("Student_age");
                String Student_city = resultSet.getString("Student_City");
                System.out.println("Student_id"+Student_id);
                System.out.println("Student_Name"+Student_name);
                System.out.println("Student_age"+Student_age);
                System.out.println("Student_city"+Student_city);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }
}
