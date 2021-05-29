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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDefault {

    private final String DB = "BH2l2SghdC";
    private final String URL = "jdbc:mysql://remotemysql.com:3306/" + DB + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER = "BH2l2SghdC";
    private final String PASS = "EHmfdE6pLk";
    static ConexionDefault instancia = null;
    Statement stmt;

    private ConexionDefault() {
        Connection connect = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = (Connection) DriverManager.getConnection(URL, USER, PASS);
            stmt = connect.createStatement();

            if (connect != null) {
                System.out.println("Conexión exitosa");
            } else {
                System.out.println("Conexión Fallida");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error " + ex.getMessage());
        }
    }

    public static void crearConexion() {

        try {
            
            if (instancia == null) {
                instancia = new ConexionDefault();
            }
        } catch (Exception e) {
            System.out.println("Error en la conexion con la base de datos");
        }

    }

    public void closeConnection(Connection connect) {
        try {
            connect.close();
            System.out.println("Conexión Cerrada Exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDefault.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Statement getStatement() {
        return stmt;
    }
    public static ConexionDefault instancia(){
    
        return instancia;
    }

}
