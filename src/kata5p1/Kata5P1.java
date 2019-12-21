
package kata5p1;
import java.sql.*;

public class Kata5P1 {

    public static void main(String[] args) {
        connect();
        createNewTable();
    }
    private static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:\\Users\\thanq\\Desktop\\Kata5P1\\persona.db";
            conn = DriverManager.getConnection(url);
            selectAll(conn);
            System.out.println("Connexión a SQLite establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }
    private static void selectAll(Connection conn){
        String sql = "SELECT * FROM PEOPLE";
        try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                rs.getString("Name") + "\t" +
                rs.getString("Apellidos") + "\t" +
                rs.getString("Departamento") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createNewTable() {
        String url = "jdbc:sqlite:C:\\Users\\thanq\\Desktop\\Kata5P1\\mail.db";
        String sql = "CREATE TABLE IF NOT EXISTS direcc_email (\n"
            + " id integer PRIMARY KEY AUTOINCREMENT,\n"
            + " direccion text NOT NULL);";
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
    }
}
