import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Boglanish {
    public static void main(String[] args) {
        // JDBC connection parameters
        String url = "jdbc:postgresql://localhost:5432/" ;
        String username = "postgres" ;
        String password = "8880" ;
        // SQL statement to create the database
        String createDatabaseSql = "CREATE DATABASE mydatabase" ;
        // Try-with-resources to automatically close the connection
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            // Execute the SQL statement to create the database
            statement.executeUpdate(createDatabaseSql);
            System.out.println( "Database created successfully." );
        }   catch (SQLException e) {
            System.out.println( "Error creating database: " + e.getMessage());
        }
    }

}

