import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
            System.out.println("Connected successfully\n");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            printTableContent(statement);
            System.out.println("\n========================\n");
            changeTitleToUppercase(statement);
            System.out.println("\n========================\n");
            printTableContent(statement);


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

    public static void printTableContent(Statement statement) throws SQLException {
        String query = "SELECT * FROM books";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.print("ID: " + resultSet.getString("id") + "   ");
            System.out.print("ISBN: " + resultSet.getString("isbn") + "   ");
            System.out.println("TITLE: " + resultSet.getString("title"));
        }
    }

    public static void changeTitleToUppercase(Statement statement) throws SQLException {
        boolean performRollback = false;
        String query = "SELECT * FROM books";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String newTitle = resultSet.getString("title").toUpperCase();
            resultSet.updateString("title", newTitle);

            if (performRollback) {
                resultSet.cancelRowUpdates();
            } else {
                resultSet.updateRow();
                System.out.println("row updated");
            }
        }
    }
}
