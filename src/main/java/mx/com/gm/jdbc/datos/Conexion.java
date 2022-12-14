package mx.com.gm.jdbc.datos;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "sasa";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement statement) throws SQLException {
        statement.close();
    }

    public static void close(PreparedStatement preparedStatementstatement) throws SQLException {
        preparedStatementstatement.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
