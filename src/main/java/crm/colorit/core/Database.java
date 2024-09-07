package crm.colorit.core;

import java.sql.*;

import static crm.colorit.util.Constants.DATABASE_URL;

public class Database {

    public static void register(String work, String firstName, String lastName, int age) {

        String sqlInsert = "INSERT INTO workers(work, firstName, lastName, age) VALUES(?, ?, ?, ?)";


        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {

            pstmt.setString(1, work);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setInt(4, age);
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    System.out.println("ID: " + generatedId);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            System.out.println("Work: " + work);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Age: " + age);
            System.out.println("Работник зарегестрирован!!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getWorkerById(int id) {

        String sqlSelect = "SELECT id, work, firstName, lastName, age FROM workers WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sqlSelect)) {

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int workerId = rs.getInt("id");
                String work = rs.getString("work");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int age = rs.getInt("age");

                System.out.println("ID: " + workerId);
                System.out.println("Work: " + work);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Age: " + age);
            } else {
                System.out.println("Работник с id " + id + " не найден.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteWorkerById(int id) {

        String sqlDelete = "DELETE FROM workers WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Работник с id " + id + " успешно удалён.");
            } else {
                System.out.println("Работник с id " + id + " не найден.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
