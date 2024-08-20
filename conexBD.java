import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexBD {
    private static conexBD instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/loja";
    private String username = "root";
    private String password = "password";

    private conexBD() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro na conexão com o banco de dados.");
        }
    }

    public static conexBD getInstance() throws SQLException {
        if (instance == null) {
            instance = new conexBD();
        } else if (instance.getConnection().isClosed()) {
            instance = new conexBD();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
