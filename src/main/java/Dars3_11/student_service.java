package Dars3_11;

import java.sql.*;
import java.util.Scanner;

public class student_service {
    static class _connection {
        private static final String url = "jdbc:postgresql://localhost/kutubxona";
        private static final String user = "postgres";
        private static final String password = "8880";

        public static Connection connect() throws SQLException {
            return DriverManager.getConnection(url,user,password);
        }
    }

    public static void start_up_menu(){
        System.out.printf("\nwhich table you need ?\n1.groups\n2.level\n3.students\n4.student group\n-> ");
        int choice = new Scanner(System.in).nextInt();
        switch (choice){
            case 1:
                start_service("groups");
                start_up_menu();
            case 2:
                start_service("level");
                start_up_menu();
            case 3:
                start_service("students");
                start_up_menu();
            case 4:
                start_service("student group");
                start_up_menu();
            case 5:
                break;

        }
    }
    public static void start_service(String table){
        System.out.printf("\n\n1.create\n2.show\n3.update\n4.delete\n5.exit\n-> ");
        int choice = new Scanner(System.in).nextInt();
        switch (choice){
            case 1:
                if(table.equals("students")){
                    students_table_service.insert_to_students();
                } else if (table.equals("level")) {
                    insert_to_level();
                } else if (table.equals("groups")) {
                    groups_table_service.insert_to_groups();
                } else if (table.equals("student group")) {
                    students_group_table_service.insert_to_student_group();
                }
                start_up_menu();
            case 2:
                if(table.equals("students")){
                    students_table_service.showstudents();
                } else if (table.equals("level")) {
                    show_levels();
                } else if (table.equals("groups")) {
                    groups_table_service.showgroups();
                } else if (table.equals("student group")) {
                    students_group_table_service.showstudents();
                }
                start_up_menu();
            case 3:
                if(table.equals("students")){
                    students_table_service.update_students();
                } else if (table.equals("level")) {
                    System.out.println("sorry, you cannot update level table");
                } else if (table.equals("groups")) {
                    System.out.printf("which row you want update ?\n1.price\n2.level\n-> ");
                    int update_choice = new Scanner(System.in).nextInt();
                    if (update_choice==1){
                        groups_table_service.update_groups_price();
                    }else {
                        groups_table_service.update_groups_level();
                    }
                } else if (table.equals("student group")) {
                    students_group_table_service.update_student_group();

                }
                start_up_menu();
            case 4:
                if(table.equals("students")){
                    students_table_service.delete_students();
                } else if (table.equals("level")) {
                    System.out.println("sorry, you cannot delete anything from level table");
                } else if (table.equals("groups")) {
                    groups_table_service.delete_students();
                } else if (table.equals("student group")) {
                    students_group_table_service.delete_student_group();
                }
                start_up_menu();
            case 5:
                break;

        }
    }

    public static void insert_to_level(){
        String querry1 = "INSERT INTO level(name) VALUES(?)";
        try (Connection connection = _connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry1)){
            System.out.printf("enter level-> ");
            String name = new Scanner(System.in).nextLine();
            statement.setString(1,name);

            statement.executeUpdate();
            System.out.println("  Data Successfully Added ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void show_levels(){
            String querry = "SELECT * FROM level";
            try (Connection connection = student_service._connection.connect();
                 Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(querry)){
                System.out.println("id   level\n");
                while (rs.next()) {
                    System.out.println(rs.getString("id") + "\t "
                            + rs.getString("name") + "\n"
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }


    public static void main(String[] args) {
        start_up_menu();
    }

}
