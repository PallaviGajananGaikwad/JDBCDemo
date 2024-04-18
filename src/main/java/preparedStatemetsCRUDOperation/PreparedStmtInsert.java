package preparedStatemetsCRUDOperation;

import java.sql.*;

public class PreparedStmtInsert {
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
            String query= "Insert into stud(Student_id,Student_name,Student_age,Student_city) Values(?,?,?,?)";
            PreparedStatement preparedstmt = connection.prepareStatement(query);
            preparedstmt.setInt(1,12);
            preparedstmt.setString(2,"Yash");
            preparedstmt.setInt(3,33);
            preparedstmt.setString(4,"Jaipur");
            int rowaffected= preparedstmt.executeUpdate();
            if(rowaffected>0){
                System.out.println("insert data successfully");
            }else {
                System.out.println("city not found");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }
}
