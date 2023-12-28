package Dars_4_4;

import java.sql.*;
import java.util.Scanner;

public class HeadHunterApp {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/kutubxona";
    private static final String USER = "postgres";
    private static final String PASSWORD = "8880";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Foydalanuvchi nomingizni kiriting: ");
            String username = scanner.nextLine();

            System.out.print("Parolingizni kiriting: ");
            String password = scanner.nextLine();

            System.out.print("Telefoningizni kiriting: ");
            String phone = scanner.nextLine();

            System.out.print("Elektron pochtangizni kiriting:");
            String email = scanner.nextLine();

            System.out.print("Rolingizni tanlang (kompaniya yoki nomzod):");
            String role = scanner.nextLine();

            // Foydalanuvchi jadvalidagi ma'lumotlarni kiritish
            String userQuery = "INSERT INTO users(username, password, phone, email, role) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement userStatement = connection.prepareStatement(userQuery, Statement.RETURN_GENERATED_KEYS)) {
                userStatement.setString(1, username);
                userStatement.setString(2, password);
                userStatement.setString(3, phone);
                userStatement.setString(4, email);
                userStatement.setString(5, role);

                int affectedRows = userStatement.executeUpdate();

                if (affectedRows > 0) {
                    ResultSet generatedKeys = userStatement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int userId = generatedKeys.getInt(1);

                            if ("kompaniya".equalsIgnoreCase(role)) {
                            // Kompaniya ma'lumotlarini kiritish
                            addCompanyInfo(connection, userId);
                        } else if ("nomzod".equalsIgnoreCase(role)) {
                            // Ish izlovchisi ma'lumotlarini kiritish
                            addCandidateInfo(connection, userId);
                        } else {
                            System.out.println("Rol notogri");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addCompanyInfo(Connection connection, int userId) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kompaniya ma'lumotlarini kiriting: ");
        String information = scanner.nextLine();

        System.out.print("Kompaniya veb-saytiga havolani kiriting: ");
        String websiteLink = scanner.nextLine();

        System.out.print("Asosiy ofis manzilini kiriting: ");
        String mainOfficeLocation = scanner.nextLine();

        System.out.print("Ishchilar sonini kiriting: ");
        int numberOfWorkers = scanner.nextInt();

        System.out.print("Egasining ismini kiriting:");
        String owner = scanner.next();

        // Kompaniya haqida ma'lumotlarni kiritish
        String companyInfoQuery = "INSERT INTO company_description(company_id, information, " +
                "web_sayt_link, main_office_location, number_of_worker, owner) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement companyInfoStatement = connection.prepareStatement(companyInfoQuery)) {
            companyInfoStatement.setInt(1, userId);
            companyInfoStatement.setString(2, information);
            companyInfoStatement.setString(3, websiteLink);
            companyInfoStatement.setString(4, mainOfficeLocation);
            companyInfoStatement.setInt(5, numberOfWorkers);
            companyInfoStatement.setString(6, owner);

            companyInfoStatement.executeUpdate();
            System.out.println("Kompaniya ma'lumotlari muvaffaqiyatli qo'shildi!");
        }
    }

    private static void addCandidateInfo(Connection connection, int userId) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qisqa rezyume ma'lumotlarini kiriting: ");
        String resumeInfo = scanner.nextLine();

        System.out.print("LinkedIn havolasini kiriting: ");
        String linkedInLink = scanner.nextLine();

        System.out.print("Manzilni kiriting: ");
        String address = scanner.nextLine();

        System.out.print("Yoshni kiriting: ");
        int age = scanner.nextInt();

        // Ish izlovchisi ma'lumotlarini kiritish
        String candidateInfoQuery = "INSERT INTO candidate_resume(candidate_id, information, " +
                "linkedin_link, address, age) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement candidateInfoStatement = connection.prepareStatement(candidateInfoQuery)) {
            candidateInfoStatement.setInt(1, userId);
            candidateInfoStatement.setString(2, resumeInfo);
            candidateInfoStatement.setString(3, linkedInLink);
            candidateInfoStatement.setString(4, address);
            candidateInfoStatement.setInt(5, age);

            candidateInfoStatement.executeUpdate();
            System.out.println("Nomzod ma'lumotlari muvaffaqiyatli qo'shildi!");
        }
    }
}
