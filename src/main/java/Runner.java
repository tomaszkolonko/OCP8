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

            createANewBookTable(connection);
            populateTheBookTable(connection);
            System.out.println("\n=========================================\n");
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
                    + "('123-123', 'The nice Sunset', 23),"
                    + "('443-295', 'Coding Styles by Martin', 99),"
                    + "('635-152', 'How to find a Hobby', 19),"
                    + "('837-368', 'Driving a car mad easy', 89),"
                    + "('443-111', 'History of SBB', 15),"
                    + "('599-128', 'How to invest in stocks', 23),"
                    + "('443-223', 'Fermenting Sauerkraut made easy', 31)";
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


    private static void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error during closing statemetn");
        }
    }

}
