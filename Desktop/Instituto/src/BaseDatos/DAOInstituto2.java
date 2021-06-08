/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import ClasesBase.Ciclo;
import ClasesBase.Instituto;
import ClasesBase.Modulo;
import ClasesBase.Nota;
import Usuarios.Administrador;
import Usuarios.Alumno;
import Usuarios.Profesor;
import Usuarios.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author abili
 */
public class DAOInstituto2 {

    static DAOInstituto2 instancia = null;

    public static DAOInstituto2 instancia() {
        if (instancia == null) {
            instancia = new DAOInstituto2();
        }
        return instancia;
    }

    public int obtenerTipoUsuario(String nombre, String nombreInstituto) {

        System.out.println("Dao");

        int tipo =0;
        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "select tipo,nombre, contra, DNI, fechaNac,nombreInsti from usuario where nombre= '" + nombre + "' and nombreInsti='" + nombreInstituto + "'"
            );
//            System.out.println(rs.getString(1));
            if (rs.next()) {
                if (rs.getString(1).equals("adm")) {
                    System.out.println("Es un Administrador");
                    tipo=1;
                } else if (rs.getString(1).equals("alu")) {
                    System.out.println("Es un Alumno");
                    tipo=1;
                } else if (rs.getString(1).equals("pro")) {
                    System.out.println("Es un profesor");
                   tipo=2;
                }
                System.out.println("******************");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipo;
    }

    public Alumno obtenerAlumno(String nombre, String nombreInstituto) {

        Alumno a = null;
        String nombreCiclo;
        Ciclo ciclo;

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "select nombre, contra, DNI, fechaNac,nombreInsti,ciclo from usuario where nombre= '" + nombre + "' and nombreInsti='" + nombreInstituto + "'"
            );

            if (rs.next()) {
                nombreCiclo = rs.getString(5);
                a = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));

                rs = ConexionDefault.instancia().getStatement().executeQuery("select * from ciclo where nombre  = " + nombreCiclo);
                if (rs.next()) {
                    ciclo = new Ciclo(rs.getString(1), rs.getInt(2));

                    rs = ConexionDefault.instancia().getStatement().executeQuery("select * from Modulo where ciclo  = " + nombreCiclo);

                    while (rs.next()) {

                        ciclo.anadirModulo(new Modulo(rs.getString(1), rs.getString(2), rs.getInt(3)));
                    }

                    a.setCiclo(ciclo);
                }

                rs = ConexionDefault.instancia().getStatement().executeQuery("select * from nota where alumno  = " + nombre);

                while (rs.next()) {

                    a.annadirNotas(new Nota(rs.getString(2), rs.getInt(3)));
                }

            } else {

                JOptionPane.showMessageDialog(null, "No existe un alumno con ese nombre en el instituto indicado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public Profesor obtenerProfesor(String nombre, String nombreInstituto) {

        Profesor p = null;

        String nombreCiclo;
        Ciclo ciclo;
        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "select nombre, contra, DNI, fechaNac,nombreInsti,ciclo from usuario where nombre= '" + nombre + "' and nombreInsti='" + nombreInstituto + "'"
            );

            if (rs.next()) {
                nombreCiclo = rs.getString(5);
                p = new Profesor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));

                if (rs.next()) {

                    rs = ConexionDefault.instancia().getStatement().executeQuery("select * from Modulo where profesor  = " + nombre);

                    while (rs.next()) {

                        p.annadirModulo(new Modulo(rs.getString(1), rs.getString(2), rs.getInt(3)));
                    }
                }

            } else {

                JOptionPane.showMessageDialog(null, "No existe un profesor con ese nombre en el instituto indicado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;

    }

    public Administrador obtenerAdministrador(String nombre, String nombreInstituto) {

        Administrador a = null;

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "select nombre, contra, DNI, fechaNac,nombreInsti,ciclo from usuario where nombre= '" + nombre + "' and nombreInsti='" + nombreInstituto + "'"
            );

            if (rs.next()) {
                a = new Administrador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return a;

    }
}
