import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class livroDAO {
    private Connection connection;

    public livroDAO() throws SQLException {
        this.connection = conexBD.getInstance().getConnection();
    }

    public void inserirlivro(livro livro) throws SQLException {
        String sql = "INSERT INTO livro (ID_livro, titulo, datePublicacao, ID_autor) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, livro.getIdlivro());
            stmt.setString(2, livro.gettitulo());
            stmt.setInt(3, livro.getdatePublicacao());
            stmt.setInt(4, livro.getIdautor());
            stmt.executeUpdate();
        }
    }

    public void atualizarlivro(livro livro) throws SQLException {
        String sql = "UPDATE livro SET titulo = ?, datePublicacao = ?, ID_autor = ? WHERE ID_livro = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, livro.gettitulo());
            stmt.setInt(2, livro.getdatePublicacao());
            stmt.setInt(3, livro.getIdautor());
            stmt.setInt(4, livro.getIdlivro());
            stmt.executeUpdate();
        }
    }

    public void excluirlivro(int idlivro) throws SQLException {
        String sql = "DELETE FROM livro WHERE ID_livro = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idlivro);
            stmt.executeUpdate();
        }
    }

    public List<livro> listarlivros() throws SQLException {
        List<livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                livro livro = new livro(rs.getInt("ID_livro"), rs.getString("titulo"), rs.getInt("datePublicacao"), rs.getInt("ID_autor"));
                livros.add(livro);
            }
        }
        return livros;
    }

    public List<livro> listarlivrosPorautor(int idautor) throws SQLException {
        List<livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro WHERE ID_autor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idautor);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    livro livro = new livro(rs.getInt("ID_livro"), rs.getString("titulo"), rs.getInt("datePublicacao"), rs.getInt("ID_autor"));
                    livros.add(livro);
                }
            }
        }
        return livros;
    }
}
