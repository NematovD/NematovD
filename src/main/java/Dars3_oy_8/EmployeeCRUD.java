package Dars3_oy_8;


import java.sql.*;

public class EmployeeCRUD {

    static final String URL = "jdbc:postgresql://localhost:5432/xodimdata1";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "8880";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);


            createEmployee(connection, 4, "Anvar", "Johongir", 70000.00, 7);

            readEmployees(connection);

            updateEmployee(connection, 4, 80000.00);

            readEmployees(connection);

            deleteEmployee(connection, 4);

            readEmployees(connection);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void createEmployee(Connection connection, int id, String firstName, String lastName, double salary, int experience) throws SQLException {
        String insertQuery = "INSERT INTO Employees VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setDouble(4, salary);
            preparedStatement.setInt(5, experience);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Yangi xodim qo'shildi!");
            } else {
                System.out.println("Xodim qo'shishda xatolik yuz berdi.");
            }
        }
    }

    static void readEmployees(Connection connection) throws SQLException {
        String selectQuery = "SELECT * FROM Employees";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                System.out.printf(
                        "ID: %d, Ism: %s, Familiya: %s, Maosh: %.2f, Tajriba yili: %d%n",
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDouble("salary"),
                        resultSet.getInt("year_of_experience")
                );
            }
            System.out.println("-------------------------");
        }
    }

    static void updateEmployee(Connection connection, int id, double newSalary) throws SQLException {
        String updateQuery = "UPDATE Employees SET salary = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setDouble(1, newSalary);
            preparedStatement.setInt(2, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Maosh o'zgartirildi!");
            } else {
                System.out.println("Maosh o'zgartirishda xatolik yuz berdi.");
            }
        }
    }

    static void deleteEmployee(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM Employees WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Xodim o'chirildi!");
            } else {
                System.out.println("Xodim o'chirishda xatolik yuz berdi.");
            }
        }
    }
}
