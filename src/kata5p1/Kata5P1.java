package kata5p1;

import java.sql.*;

public class Kata5P1 {
    public static void main(String[] args) {
        Connection connection = connect();
        selectAll(connection);
        createNewTable(connection);
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

    private static void selectAll(Connection connection) {
        String sqlQuery = "SELECT * FROM PEOPLE";

        try(Statement statement = connection.createStatement();
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

    public static void createNewTable(Connection connection) {
        String url = "jdbc:sqlite:kata5.db";

        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " Mail text NOT NULL);";

        try(Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
