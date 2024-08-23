import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class XDAO {
    private static final String URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<X> listar() {
        List<X> xs = new ArrayList<>();
        String sql = "SELECT * FROM X";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double valor = rs.getDouble("valor");
                X x = new X(id, nome, valor);
                xs.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xs;
    }

    public void inserir(X x) {
        String sql = "INSERT INTO X (nome, valor) VALUES (?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, x.getNome());
            pstmt.setDouble(2, x.getValor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(X x) {
        String sql = "UPDATE X SET nome = ?, valor = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, x.getNome());
            pstmt.setDouble(2, x.getValor());
            pstmt.setInt(3, x.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM X WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
