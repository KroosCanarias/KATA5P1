
package kata5p1;
import java.sql.*;

public class Kata5P1 {

    public static void main(String[] args) {
        connect();
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
    public static void selectAll(Connection conn){
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
}
