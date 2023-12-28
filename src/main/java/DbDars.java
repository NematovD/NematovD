
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDars {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/meningbazam";
        String username = "postgres";
        String password = "8880";

        String sqlSorovJadval = "create table product(id serial, nomi varchar, soni int, narxi numeric)";
        String sorovInsert = "insert into product(nomi,soni, narxi) values "
                + " ('komputer', 25, 3000), "
                + " ('kitob', 100, 100), "
                + " ('telefon', 60, 200)";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement()) {

            statement.execute(sqlSorovJadval);

            statement.executeUpdate(sorovInsert);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
