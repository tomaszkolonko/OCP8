import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {

    public static void main(String[] args) {

        String url = "jdbc:derby:c://devsbb//OCP//db;create=true";
        String username = "nets";
        String password = "password";
        tryConnectDB(url, username, password);

    }

    public static void tryConnectDB(String url, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully");

            readBookTableMetaData(connection);
            readBookTable(connection);

        } catch (SQLException e) {
            System.out.println("SQL Connection failed");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Something went wrong while closing the connction");
                }
            }
        }
    }

    public static void readBookTable(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String retrieveBooks = "SELECT * FROM books";
            ResultSet resultSet = statement.executeQuery(retrieveBooks);
            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getString("id") + "   ");
                System.out.print("ISBN: " + resultSet.getString("isbn") + "   ");
                System.out.println("TITLE: " + resultSet.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
    }

    public static void readBookTableMetaData(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String retrieveBooks = "SELECT * FROM books";
            ResultSet resultSet = statement.executeQuery(retrieveBooks);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            resultSet.next();

            int columnCount = resultSetMetaData.getColumnCount();

            for(int i = 1; i <= columnCount; i++) {
                System.out.println("Table name: " + resultSetMetaData.getTableName(i));
                System.out.println("Column name: " + resultSetMetaData.getColumnName(i));
                System.out.println("Column size: " + resultSetMetaData.getColumnDisplaySize(i));
                System.out.println("Column class name: " + resultSetMetaData.getColumnClassName(i));
                System.out.println("\n=============================\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error during closing statemetn");
        }
    }

}
