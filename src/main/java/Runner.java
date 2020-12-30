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
            System.out.println("Connected successfully");

//            createANewBookTable(connection);
//            populateTheBookTable(connection);
            System.out.println("\n=========================================\n");
            readBookTable(connection);
            System.out.println("\n=========================================\n");
            playWithTheCursor(connection);


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

    public static void createANewBookTable(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String createTable = "CREATE TABLE books (id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, isbn VARCHAR (20), title VARCHAR (50),  price INT)";
            statement.executeUpdate(createTable);
            System.out.println("Successfully created a new table named 'books'");
        } catch (SQLException e) {
            System.out.println("Error during creating Table books");
        } finally {
            closeStatement(statement);
        }
    }

    public static void populateTheBookTable(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String insertBooks = "INSERT INTO books(isbn, title, price) VALUES"
                    + "('111-111', 'The nice Sunset', 23),"
                    + "('222-222', 'Coding Styles by Martin', 99),"
                    + "('333-333', 'How to find a Hobby', 19),"
                    + "('444-444', 'Driving a car mad easy', 89),"
                    + "('555-555', 'History of SBB', 15),"
                    + "('666-666', 'How to invest in stocks', 23),"
                    + "('777-777', 'Fermenting Sauerkraut made easy', 31),"
                    + "('888-888', 'The Joy of Kotlin', 31),"
                    + "('999-999', 'The Clean Coder', 31)";
            statement.execute(insertBooks);
            System.out.println("Successfully populated the 'books' table: ");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
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

    public static void playWithTheCursor(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String retrieveBooks = "SELECT * FROM books";
            ResultSet resultSet = statement.executeQuery(retrieveBooks);

            resultSet.beforeFirst();
            System.out.println(resultSet.relative(2));
            System.out.println(resultSet.relative(12));
            System.out.println(resultSet.);
            System.out.println(resultSet.relative(2));

            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));

            System.out.println(resultSet.relative(-10));
            System.out.println(resultSet.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
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
