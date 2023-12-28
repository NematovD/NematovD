package Dars3_oy_9;

import java.sql.*;

public class DbDars {
    public static void main(String[] args) throws InterruptedException {
        enterCar("10A101TA");
        Thread.sleep(5000);
        outCar("10A101TA");
        paymentParking("10A101TA");

    }

    public static void enterCar(String number){
        String sorovInsert = "insert into parking(number, price) values "
                + " (?, 10)";

        try(Connection connection = getConnectTobase();
            PreparedStatement statement = connection.prepareStatement(sorovInsert)) {
            statement.setString(1, number);
            statement.executeUpdate();
            System.out.println("Successfully saved!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void outCar(String number){
        String sorovInsert = "update parking set end_time = current_timestamp where number= '"+number+"'";


        try(Connection connection = getConnectTobase();
            PreparedStatement statement = connection.prepareStatement(sorovInsert);) {

            statement.executeUpdate();

            System.out.println("Successfully saved!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void paymentParking(String number){

        String payment = "update parking set payment = (SELECT EXTRACT(EPOCH FROM (end_time - started_time)) AS interval_minut FROM parking where number=?)* ? where number=?";
        try(Connection connection = getConnectTobase();
            PreparedStatement statement = connection.prepareStatement(payment);) {
            statement.setString(1,number);
            statement.setDouble(2,10);
            statement.setString(3, number);
            statement.executeUpdate();
            System.out.println("Successfully saved!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnectTobase() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/kutubxona";
        String username = "postgres";
        String password = "8880";
        System.out.println("Successfully connected!");
        return DriverManager.getConnection(url,username,password);
    }


}
