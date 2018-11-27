package kata5p1;

import java.sql.*;

public class Kata5P1 {
    public static void main(String[] args) {
        selectAll();
    }

    private static Connection connect() {
        Connection connection = null;
        String url = "jdbc:sqlite:kata5.db";

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private static void selectAll() {
        String sqlQuery = "SELECT * FROM PEOPLE";

        try(Connection connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            while(resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" +
                        resultSet.getString("Name") + "\t" +
                        resultSet.getString("Apellidos") + "\t" +
                        resultSet.getString("Departamento") + "\t");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
