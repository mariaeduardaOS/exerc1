import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class autorDAO {
    private Connection connection;

    public autorDAO() throws SQLException {
        this.connection = conexBD.getInstance().getConnection();
    }

    public void inserirautor(autor autor) throws SQLException {
        String sql = "INSERT INTO autor (ID_autor, Nome, Nacionalidade) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, autor.getIdautor());
            stmt.setString(2, autor.getNome());
            stmt.setString(3, autor.getNacionalidade());
            stmt.executeUpdate();
        }
    }

    public void atualizarautor(autor autor) throws SQLException {
        String sql = "UPDATE autor SET Nome = ?, Nacionalidade = ? WHERE ID_autor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());
            stmt.setInt(3, autor.getIdautor());
            stmt.executeUpdate();
        }
    }

    public void excluirautor(int idautor) throws SQLException {
        String sql = "DELETE FROM autor WHERE ID_autor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idautor);
            stmt.executeUpdate();
        }
    }

    public List<autor> listarautores() throws SQLException {
        List<autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM autor";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                autor autor = new autor(rs.getInt("ID_autor"), rs.getString("Nome"), rs.getString("Nacionalidade"));
                autores.add(autor);
            }
        }
        return autores;
    }
}
