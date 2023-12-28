import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {
    public static void main(String[] args) {
        // JDBC connection parameters
        String url = "jdbc:postgresql://localhost:5432/mydatabase" ;
        String username = "postgres";
        String password = "8880";
        // SQL statement to create the table
        String createTableSql = "CREATE TABLE product (" +
                "id SERIAL PRIMARY KEY," +
                "name TEXT," +
                "product_type_enum VARCHAR(255)," +
                "date DATE" +
                ")";
// Try-with-resources to automatically close the connection
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            // Execute the SQL statement to create the table
            statement.execute(createTableSql);
            System.out.println( "Table created successfully." );
        } catch (SQLException e) {
            System.out.println( "Error creating table: " + e.getMessage());
        }
    }

}
