package beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class DatabaseUtils {
 
    public static void storeInDatabase(String generatedString) {
        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
 
        // Insert into the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Atten!@nce")) {
            insertIntoDatabase(connection, generatedString);
            System.out.println("Strings inserted into the database successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    private static void insertIntoDatabase(Connection connection, String generatedString) throws SQLException {
        String query = "INSERT INTO generated_strings(g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
 
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int index = 0;
            int parameterIndex = 1;
            while (index < generatedString.length()) {
                String substring = generatedString.substring(index, Math.min(index + 3, generatedString.length()));
                preparedStatement.setString(parameterIndex++, substring);
                index += 3;
            }
            preparedStatement.executeUpdate();
        }
    }
}
