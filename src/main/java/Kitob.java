import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kitob {
    public static void main(String[] args) {
        showKitoblar();
    }

    public static void showKitoblar(){
        String sql = "select * from kitob";
        try (Connection connection = new DbConnection().connection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                System.out.println(rs.getString("id")+ "\t"
                        +rs.getString("nomi") + "\t"
                        +rs.getString("tarif"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
