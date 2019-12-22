package org.example;

import java.sql.*;

public class JdbcTest {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/demo",
                "postgres",
                "postgres")) {

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM seats LIMIT 10");

            System.out.println("simple statement");
            while (result.next()) {
                System.out.println(
                        String.format("%d [aircraft_code=%s, seat_no=%s]",
                                result.getRow(),
                                result.getString("aircraft_code"),
                                result.getString("seat_no")));
            }


            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM seats WHERE seat_no=?");
            preparedStatement.setString(1, "1A");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("\nprepared statement");
            while (resultSet.next()) {
                System.out.println(
                        String.format("%d [aircraft_code=%s, seat_no=%s]",
                                resultSet.getRow(),
                                resultSet.getString("aircraft_code"),
                                resultSet.getString("seat_no")));
            }
        }
    }
}
