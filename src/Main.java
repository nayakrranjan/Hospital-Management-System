import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/hospital_managaement_system";
    private static final String id = "root";
    private static final String password = "kalinga";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection connection = DriverManager.getConnection(url, id, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM doctors");
            var result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
