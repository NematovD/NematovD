package Dars3_11;

import java.sql.*;
import java.util.Scanner;

public class groups_table_service {

    public static void showgroups() {
        String querry = "SELECT * FROM groups";
        try (Connection connection = student_service._connection.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(querry)){
            System.out.println("id   name       started_time                level_id      price\n");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "\t "
                        + rs.getString("name") + "\t"
                        + rs.getString("start_time") + "\t"
                        + rs.getString("level_id") + "\t"
                        + rs.getString("price") + "\n"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insert_to_groups(){
        String querry1 = "INSERT INTO groups(name,start_time,level_id,price) VALUES(?,current_timestamp,?,?)";
        try (Connection connection = student_service._connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry1)){
            System.out.printf("group name: ");
            String name = new Scanner(System.in).nextLine();
            statement.setString(1,name);

            System.out.printf("level_id: ");
            int level_id = new Scanner(System.in).nextInt();
            statement.setInt(2, level_id);

            System.out.printf("its price(float): ");
            float price = new Scanner(System.in).nextFloat();
            statement.setFloat(3,price);


            statement.executeUpdate();
            System.out.println("  Data Successfully Added ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update_groups_price(){
        String querry = "UPDATE groups SET price=? WHERE id=?";
        try (Connection connection = student_service._connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry)){

            System.out.printf("enter group new price(float): ");
            float new_price = new Scanner(System.in).nextFloat();
            statement.setFloat(1,new_price);
            System.out.printf("group id: ");
            int id = new Scanner(System.in).nextInt();
            statement.setInt(2,id);
            statement.executeUpdate();
            System.out.println("  Data Successfully Updated ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update_groups_level(){
        String querry = "UPDATE groups SET level_id=? WHERE id=?";
        try (Connection connection = student_service._connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry)){

            System.out.printf("enter group new level id: ");
            float new_price = new Scanner(System.in).nextFloat();
            statement.setFloat(1,new_price);
            System.out.printf("group id: ");
            int id = new Scanner(System.in).nextInt();
            statement.setInt(2,id);
            statement.executeUpdate();
            System.out.println("  Data Successfully Updated ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delete_students(){
        String querry = "DELETE FROM groups WHERE id=?";
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
