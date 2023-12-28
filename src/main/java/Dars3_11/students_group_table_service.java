package Dars3_11;

import java.sql.*;
import java.util.Scanner;

public class students_group_table_service {

    public static void showstudents() {
        String querry = "SELECT * FROM student_group";
        try (Connection connection = student_service._connection.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(querry)){
            System.out.println("id_in_table   student_id    group_id\n");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "\t\t\t "
                        + rs.getString("student_id") + "\t\t\t\t"
                        + rs.getString("group_id") + "\n"
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insert_to_student_group() {
        String querry1 = "INSERT INTO student_group(student_id,group_id) VALUES(?,?)";
        try (Connection connection = student_service._connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry1)) {

            System.out.printf("student id: ");
            int student_id = new Scanner(System.in).nextInt();
            statement.setInt(1, student_id);

            System.out.printf("group id: ");
            int group_id = new Scanner(System.in).nextInt();
            statement.setInt(2, group_id);

            statement.executeUpdate();
            System.out.println("  Data Successfully Added ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void update_student_group(){
        String querry = "UPDATE student_group SET group_id=? WHERE id=?";
        try (Connection connection = student_service._connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry)){

            System.out.printf("enter group(group id): ");
            int new_group = new Scanner(System.in).nextInt();
            statement.setInt(1,new_group);
            System.out.printf("user's id on table: ");
            int id = new Scanner(System.in).nextInt();
            statement.setInt(2,id);
            statement.executeUpdate();
            System.out.println("  Data Successfully Updated ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delete_student_group(){
        String querry = "DELETE FROM student_group WHERE id=?";
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
