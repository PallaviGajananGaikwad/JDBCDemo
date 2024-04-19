package batchProcessing;

import java.sql.*;
import java.util.Scanner;

public class BatchProcessing
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
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "Insert into stud(Student_id,Student_name,Student_age,Student_city) Values(?,?,?,?)";
            PreparedStatement preparedstmt = connection.prepareStatement(query);
            Scanner sc = new Scanner(System.in);
            while (true) {

                System.out.println("Enter Student_id");
                int Student_id = sc.nextInt();
                System.out.println("Enter Student_name");
                String Student_name = sc.next();
                System.out.println("Enter Student_age");
                int Student_age = sc.nextInt();
                System.out.println("Enter Student_city");
                String Student_city = sc.next();
                System.out.println("Enter more data(Y/N):");
                String Choice = sc.next();
                preparedstmt.setInt(1,Student_id);
                preparedstmt.setString(2,Student_name);
                preparedstmt.setInt(3,Student_age);
                preparedstmt.setString(4,Student_city);

                preparedstmt.addBatch();
                if (Choice.toUpperCase().equals("N")) {
                    break;
                }
            }
           int arr[]= preparedstmt.executeBatch();
            for(int i=0 ;i < arr.length; i++){
                if(arr[i]==0){
                    System.out.println("Query" +i+ " Query not execute successfully");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }
}
