package preparedStatemetsCRUDOperation;

import java.sql.*;

public class PreparedRetrive
{ private static final String url="jdbc:mysql://localhost:3306/information";
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
            String query="select Student_city from stud Where Student_name= ?";
            PreparedStatement preparedstmt = connection.prepareStatement(query);
            preparedstmt.setString(1,"Gajanan");
            ResultSet resultSet= preparedstmt.executeQuery();
            if(resultSet.next()){
                String Student_city=resultSet.getString("Student_city");
                System.out.println("Student_city"+Student_city);
            }else {
                System.out.println("city not found");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }

}
