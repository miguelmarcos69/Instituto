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
import java.util.ArrayList;
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
                     + ",'alu' , ' " + nombreInsituto + "')");
            //ConexionBD.instancia().getStatement().execute("INSERT INTO usuario VALUES ('" + a.getNombre() + "','" + a.getContrasenna() +"','"+a.getDNI() + "'," + a.getFecha_nacimiento() 
            //        + "," +a.getEdad() + ",'alumno' , ' " + nombreInsituto + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DaoInstituto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void annadirProfesor(Profesor a, String nombreInsituto) {

        try {

            ConexionDefault.crearConexion();
            ConexionDefault.instancia().getStatement().execute("INSERT INTO usuario VALUES ('" + a.getNombre() + "','" + a.getContrasenna() + "','" + a.getDNI() + "'," + a.getFecha_nacimiento()
                    + ",'pro' , ' " + nombreInsituto + "')");
            //ConexionBD.instancia().getStatement().execute("INSERT INTO usuario VALUES ('" + a.getNombre() + "','" + a.getContrasenna() +"','"+a.getDNI() + "'," + a.getFecha_nacimiento() 
            //        + "," +a.getEdad() + ",'alumno' , ' " + nombreInsituto + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DaoInstituto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuarios.Usuario cargarNombre(String nombreInstituto, String nombre) {
        System.out.println("Dao");

        Usuario u = null;
        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "select tipo,nombre, contra, DNI, fechaNac,nombreInsti from usuario where nombre= '" + nombre + "' and nombreInsti='" + nombreInstituto + "'"
            );
//            System.out.println(rs.getString(1));
            if (rs.next()) {
               // i = new Instituto(rs.getString(2), rs.getString(3),rs.getString(4));
                if (rs.getString(1).equals("adm")) {
                    System.out.println("Es un administrador");
                    u = new Administrador(rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
                } else if (rs.getString(1).equals("alu")) {
                    System.out.println("Es un Alumno");
                    u = new Alumno(rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
                    
                    rs =ConexionDefault.instancia().getStatement().executeQuery("");
                } else if (rs.getString(1).equals("pro")) {
                    System.out.println("Es un profesor");
                   u = new Profesor(rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
                }
                System.out.println("******************");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    //cargar usuarios para mostrarlos por las tablas
    public ArrayList cargarUsuarios() {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery("SELECT nombre,contra,fechaNac FROM usuario where tipo ='alu';");
            while (rs.next()) {
               // usuarios.add(new Alumno(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getInt(8), rs.getString(9)));
            }

            rs = ConexionDefault.instancia().getStatement().executeQuery("SELECT * FROM vehiculos, furgonetas WHERE vehiculos.id = furgonetas.id_veh;");

            while (rs.next()) {
              //  usuarios.add(new Profesor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getDouble(8), rs.getString(9)));
            }

            rs = ConexionDefault.instancia().getStatement().executeQuery("SELECT nombre,contra,fechaNac,edad FROM usuario where tipo ='alu';");
            while (rs.next()) {
              //  usuarios.add(new Administrador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getInt(8), rs.getString(9)));
            }

        } catch (SQLException exc) {
            System.out.println("Excepción SQL " + exc.getMessage());
        } catch (Exception exc) {
            System.out.println("Excepción " + exc.getMessage());
        }

        return usuarios;
    }
    
        public void annadirCurso(Instituto i,Curso c) throws SQLException {
            
         ConexionDefault.instancia().getStatement().execute("INSERT INTO ciclo VALUES ('"
                            + c.getNombre() + "', '" + c.getPlazas() + "', '" + c.getAnno()+"', '"+ i.getNombre()+"');");
         
        
    }
         public void annadirModulo(Instituto i,Modulo m,Curso c) throws SQLException {
            
         ConexionDefault.instancia().getStatement().execute("INSERT INTO modulo VALUES ('"
                            + m.getNombre() + "', '" + m.getCodigo_aula() + "', '" + m.getHoras_semana()+"', '"+ c.getNombre()+ "', '"+c.getAnno()+"','', '"+ i.getNombre()+"');");
         
        
    }
        

}
