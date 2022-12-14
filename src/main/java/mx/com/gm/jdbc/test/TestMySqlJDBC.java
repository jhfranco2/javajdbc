package mx.com.gm.jdbc.test;

import java.sql.Connection;
import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
        // Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "sasa");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT * FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.print("Id Persona:" + resultado.getInt("id_Persona"));
                System.out.print("nombre: " + resultado.getString("nombre"));
                System.out.print("apellido " + resultado.getString("apellido"));
                System.out.print("Email " + resultado.getString("email"));
                System.out.println();
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
