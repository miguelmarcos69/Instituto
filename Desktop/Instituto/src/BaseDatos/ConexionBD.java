/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Marcos
 */
public class ConexionBD {

    Connection conn;
    Statement stmt;

    static ConexionBD instancia = null;

    private ConexionBD() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inmobiliariabd", "root", "");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión con base de datos de inmobiliaria",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error");
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public Statement getStatement() {
        return stmt;
    }

    public static void crearConexion() {
        try {
            if (instancia == null) {
                instancia = new ConexionBD();
            }
        } catch (Exception e) {
            System.out.println("Error en la conexion con la base de datos");
        }

    }

    public static ConexionBD instancia() {
        return instancia;
    }

    public static void desconectar() {
        if (instancia != null) {
            try {
                instancia.stmt.execute("shutdown");
                instancia.stmt.close();
                instancia.conn.close();
                instancia = null;
            } catch (SQLException e) {
            }
        }
    }

}
