import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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

            DatabaseMetaData databaseMetaData = connection.getMetaData();
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.print("Supports TYPE_FORWARD_ONLY");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,
                        ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and supports CONCUR_UPDATABLE");
                }
            }

            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.print("Supports TYPE_SCROLL_INSENSITIVE");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and supports CONCUR_UPDATABLE");
                }
            }

            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.print("Supports TYPE_SCROLL_SENSITIVE");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and supports CONCUR_UPDATABLE");
                }
            }

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

}
