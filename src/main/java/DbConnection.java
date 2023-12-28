import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final String url = "jdbc:postgresql://localhost/kutubxona";
    private  final String user = "postgres";
    private  final String password = "8880";


    public  Connection connection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }


    }


