/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import ClasesBase.*;
import Usuarios.Administrador;
import Usuarios.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Marcos
 */
public class DaoInstituto {

    static DaoInstituto instancia = null;

    public static DaoInstituto instancia() {
        if (instancia == null) {
            instancia = new DaoInstituto();
        }
        return instancia;
    }

    public void annadirAlumno(Alumno a, String nombreInsituto) {

        try {

            ConexionDefault.crearConexion();
            ConexionDefault.instancia().getStatement().execute("INSERT INTO usuario VALUES ('" + a.getNombre() + "','" + a.getContrasenna() + "','" + a.getDNI() + "'," + a.getFecha_nacimiento()
                    + "," + a.getEdad() + ",'alumno' , ' " + nombreInsituto + "')");
            //ConexionBD.instancia().getStatement().execute("INSERT INTO usuario VALUES ('" + a.getNombre() + "','" + a.getContrasenna() +"','"+a.getDNI() + "'," + a.getFecha_nacimiento() 
            //        + "," +a.getEdad() + ",'alumno' , ' " + nombreInsituto + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DaoInstituto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuarios.Usuario cargarNombre(String nombreInstituto, String nombre, String contra) {
        System.out.println("Dao");

        Usuario u = null;
        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "select tipo,nombre, contra, DNI, fechaNac, edad,nombreInsti from usuario where nombre= '" + nombre + "' and nombreInsti='" + nombreInstituto + "'"
            );
//            System.out.println(rs.getString(1));
            if (rs.next()) {
                //i = new Instituto(rs.getString(2), rs.getString(3),rs.getString(4));
                if (rs.getString(1).equals("adm")) {
                    System.out.println("Es un administrador");

                    Administrador a = new Administrador(String.valueOf(rs.getString(2)), String.valueOf(rs.getString(3)), String.valueOf(rs.getString(4)), rs.getInt(5), rs.getInt(6), String.valueOf(rs.getString(1)), String.valueOf(rs.getString(7)));
                    u = a;
                } else if (rs.getString(1).equals("alu")) {
                    System.out.println("Es un Alumno");
                    Alumno al = new Alumno(String.valueOf(rs.getString(2)), String.valueOf(rs.getString(3)), String.valueOf(rs.getString(4)), rs.getInt(5), rs.getInt(6));
                    u = al;
                } else if (rs.getString(1).equals("pro")) {
                    System.out.println("Es un profesor");
                    Profesor p = new Profesor(String.valueOf(rs.getString(2)), String.valueOf(rs.getString(3)), String.valueOf(rs.getString(4)), rs.getInt(5), rs.getInt(6));
                    u = p;
                }
                System.out.println("******************");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

}
