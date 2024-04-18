package simpleCRUDOperation;

import java.sql.*;

public class InsertDataFromDatabase
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
            String query= String.format("Insert into stud(Student_id,Student_name,Student_age,Student_city) Values(%o,'%s',%o,'%s')",11,"Rahul",20,"Delhi");
                int rowaffected= statement.executeUpdate(query);
                if(rowaffected>0){
                    System.out.println("insert data successfully");
                }else {
                    System.out.println("data not inserted");
                }
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }
}
