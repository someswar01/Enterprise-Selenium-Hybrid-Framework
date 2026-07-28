package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseUtils {

    private static Connection connection;

    /**
     * Private constructor.
     */
    private DatabaseUtils() {
        throw new UnsupportedOperationException(
                "DatabaseUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Establishes database connection.
     *
     * @param url Database URL
     * @param username Database username
     * @param password Database password
     */
    public static void connect(String url,
                               String username,
                               String password) {

        try {

            connection = DriverManager.getConnection(
                    url,
                    username,
                    password);

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Unable to connect to database.", e);
        }
    }

    /**
     * Executes a SELECT query.
     *
     * @param query SQL query
     * @return ResultSet
     */
    public static ResultSet executeQuery(String query) {

        try {

            Statement statement =
                    connection.createStatement();

            return statement.executeQuery(query);

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Unable to execute query.", e);
        }
    }

    /**
     * Executes INSERT/UPDATE/DELETE.
     *
     * @param query SQL query
     * @return Number of affected rows
     */
    public static int executeUpdate(String query) {

        try {

            Statement statement =
                    connection.createStatement();

            return statement.executeUpdate(query);

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Unable to execute update.", e);
        }
    }

    /**
     * Closes database connection.
     */
    public static void disconnect() {

        try {

            if (connection != null &&
                    !connection.isClosed()) {

                connection.close();
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Unable to close database connection.", e);
        }
    }
}