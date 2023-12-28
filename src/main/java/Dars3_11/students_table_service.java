package Dars3_11;

import java.sql.*;
import java.util.Scanner;

public class students_table_service {

    public static void showstudents() {
        String querry = "SELECT * FROM students";
        try (Connection connection = student_service._connection.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(querry)){
            System.out.println("id   fullname     phone\n");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "\t "
                        + rs.getString("fullname") + "\t"
                        + rs.getString("phone") + "\n"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert_to_students(){
        String querry1 = "INSERT INTO students(fullname,phone) VALUES(?,?)";
        try (Connection connection = student_service._connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry1)){
            System.out.printf("name: ");
            String name = new Scanner(System.in).nextLine();
            statement.setString(1,name);

            System.out.printf("phone number: ");
            String phone = new Scanner(System.in).nextLine();
            statement.setString(2,phone);

            statement.executeUpdate();
            System.out.println("  Data Successfully Added ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update_students(){
        String querry = "UPDATE students SET phone=? WHERE id=?";
        try (Connection connection = student_service._connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry)){

            System.out.printf("enter new phone number: ");
            String new_name = new Scanner(System.in).nextLine();
            statement.setString(1,new_name);
            System.out.printf("id: ");
            int id = new Scanner(System.in).nextInt();
            statement.setInt(2,id);
            statement.executeUpdate();
            System.out.println("  Data Successfully Updated ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delete_students(){
        String querry = "DELETE FROM students WHERE id=?";
        try (Connection connection = student_service._connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry)){
            System.out.printf("id: ");
            int id = new Scanner(System.in).nextInt();
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("    Data Successfully Deleted ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
