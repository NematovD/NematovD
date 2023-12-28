package Dars3_oy_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class AvtoUlov {
    private String nomi;
    private long kirmoqVaqt;
    private long chiqmoqVaqt;

    public AvtoUlov(String nomi) {
        this.nomi = nomi;
        this.kirmoqVaqt = System.currentTimeMillis();
        System.out.println(nomi + " turargohga kirdi.");
    }

    public void chiqish() {
        this.chiqmoqVaqt = System.currentTimeMillis();
        System.out.println(nomi + " turargohdan chiqdi.");
    }

    public long haqTolash() {
        long saotlar = (chiqmoqVaqt - kirmoqVaqt) / 1000 / 60 / 60; // soatlar
        long haq = saotlar * 5000; // har soat uchun 5000 so'm
        return haq;
    }
}

public class ParkingCarSystem {
    private static final String DATABASE_URL = "jdbc:sqlite:parking.db";

    public static void main(String[] args) {
        createTableIfNotExists();

        // AvtoUlov kiritish
        String avtoNomi = "AB123CD";
        avtoUlovKirit(avtoNomi);

                avtoUlovChiqar(avtoNomi);
    }

    private static void createTableIfNotExists() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement()) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS avtoulovlar (" +
                    "nomi TEXT PRIMARY KEY," +
                    "kirmoqVaqt INTEGER," +
                    "chiqmoqVaqt INTEGER)";

            statement.execute(createTableSQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void avtoUlovKirit(String avtoNomi) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO avtoulovlar (nomi, kirmoqVaqt) VALUES (?, ?)")) {

            preparedStatement.setString(1, avtoNomi);
            preparedStatement.setLong(2, System.currentTimeMillis());

            preparedStatement.executeUpdate();
            System.out.println(avtoNomi + " turargohga kirdi.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void avtoUlovChiqar(String avtoNomi) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM avtoulovlar WHERE nomi = ?")) {

            preparedStatement.setString(1, avtoNomi);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                AvtoUlov avtoUlov = new AvtoUlov(avtoNomi);
                avtoUlov.chiqish();
                long haq = avtoUlov.haqTolash();
                System.out.println(avtoNomi + " uchun to'lov: " + haq + " so'm");
            } else {
                System.out.println("Bunday avtoUlov topilmadi.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
