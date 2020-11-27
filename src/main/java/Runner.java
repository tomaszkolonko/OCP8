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

            absoluteExample(statement);
            System.out.println("\n\n========================\n");
            relativeExample(statement);
            System.out.println("\n\n========================\n");
            someExtraMethods(statement);


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

    public static void absoluteExample(Statement statement) throws SQLException {
        String query = "SELECT * FROM books";
        ResultSet resultSet = statement.executeQuery(query);
        int rowCount = 0;
        if(resultSet.last()) {
            rowCount = resultSet.getRow();
        }


        for(int i = 1; i <= rowCount; i += 2) {
            if(resultSet.absolute(i)) {
                System.out.print("ID: " + resultSet.getString("id") + "   ");
                System.out.print("ISBN: " + resultSet.getString("isbn") + "   ");
                System.out.println("TITLE: " + resultSet.getString("title"));
            }
        }

        System.out.println("\n-----------------\n");

        resultSet.absolute(-1);
        System.out.print("ID: " + resultSet.getString("id") + "   ");

        resultSet.absolute(-2);
        System.out.print("ID: " + resultSet.getString("id") + "   ");

        resultSet.absolute(-3);
        System.out.print("ID: " + resultSet.getString("id") + "   ");

        resultSet.absolute(0);
//        System.out.print("ID: " + resultSet.getString("id") + "   ");
    }

    public static void relativeExample(Statement statement) throws SQLException {
        String query = "SELECT * FROM books";
        ResultSet resultSet = statement.executeQuery(query);

        resultSet.absolute(4);
        System.out.println("ID: " + resultSet.getString("id") + "   ");
        resultSet.relative(2);
        System.out.println("ID: " + resultSet.getString("id") + "   ");
        resultSet.relative(-4);
        System.out.println("ID: " + resultSet.getString("id") + "   ");
    }

    public static void someExtraMethods(Statement statement) throws SQLException {
        String query = "SELECT * FROM books";
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.afterLast();
//        System.out.println("ID: " + resultSet.getString("id") + "   ");
        while(resultSet.previous()) {
            System.out.print("ID: " + resultSet.getString("id") + "   ");
            System.out.print("ISBN: " + resultSet.getString("isbn") + "   ");
            System.out.println("TITLE: " + resultSet.getString("title"));
        }

        System.out.println("Has the cursor reache the first element? " + resultSet.isFirst());
        System.out.println("Get row number " + resultSet.getRow());
        resultSet.first();
        System.out.println("Has the cursor reache the first element? " + resultSet.isFirst());

    }
}
