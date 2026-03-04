package com.backend;

import java.sql.*;

public class JDBC {
    private static String url = "jdbc:postgresql://localhost:5432/media_collection?" + "user=user&password=password";

    protected static void openConnection() {
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()
        ) {

            System.out.println("A");

            //String query = "INSERT INTO media (id, title, type) VALUES (, 'Cyberpunk', 'game')";
            String query_search = "SELECT * FROM media m";

            //with this object you can create a SQL statement
            //Execution of the query
            //statement.executeUpdate(query);
            //statement.executeUpdate(query_search);

            //ResultSet resultSet = statement.executeQuery(query);
            ResultSet resultSet = statement.executeQuery(query_search);


            while (resultSet.next()) {
                System.out.println(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //test
        openConnection();
    }
}
