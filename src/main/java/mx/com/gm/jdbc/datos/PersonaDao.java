package mx.com.gm.jdbc.datos;

import java.sql.*;
import java.util.*;
import mx.com.gm.jdbc.domain.Persona;

public class PersonaDao {
    private static final String SQL_SELECT = "SELECT id_persona,nombre,apellido,email FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido,email) VALUES(?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ? ";

    public List<Persona> selecccionar() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_SELECT);
            rs = statement.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                persona = new Persona(idPersona, nombre, apellido, email);
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                Conexion.close(rs);
                Conexion.close(statement);
                Conexion.close(conn);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return personas;
    }

    public int insertar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return registros;

    }

    public void eliminar(int idUsuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, idUsuario );
            stmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
