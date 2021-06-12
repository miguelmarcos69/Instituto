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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        int tipo = 0;
        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "select tipo,nombre, contra, DNI, fechaNac,nombreInsti from usuario where nombre= '" + nombre + "' and nombreInsti='" + nombreInstituto + "'"
            );
//            System.out.println(rs.getString(1));
            if (rs.next()) {
                if (rs.getString(1).equals("adm")) {
                    System.out.println("Es un Administrador");
                    tipo = 0;
                } else if (rs.getString(1).equals("alu")) {
                    System.out.println("Es un Alumno");
                    tipo = 1;
                } else if (rs.getString(1).equals("prof")) {
                    System.out.println("Es un profesor");
                    tipo = 2;
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
                nombreCiclo = rs.getString(6);
                a = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                a = getDatosAlumno(a, nombreCiclo);

            } else {

                JOptionPane.showMessageDialog(null, "No existe un alumno con ese nombre en el instituto indicado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public Alumno getDatosAlumno(Alumno a, String nombreCiclo) {
        Ciclo ciclo = null;

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery("select * from ciclo where nombre  = '" + nombreCiclo + "'");
            if (rs.next()) {
                ciclo = new Ciclo(rs.getString(1), rs.getInt(2), rs.getInt(3));

                rs = ConexionDefault.instancia().getStatement().executeQuery("select * from modulo where ciclo  = '" + nombreCiclo + "'");

                while (rs.next()) {

                    ciclo.anadirModulo(new Modulo(rs.getString(1), rs.getString(2), rs.getInt(3)));
                }

                a.setCiclo(ciclo);
            }

            rs = ConexionDefault.instancia().getStatement().executeQuery("select * from nota where alumno  = '" + a.getNombre() + "'");

            while (rs.next()) {

                a.annadirNotas(new Nota(rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException sqle) {

            sqle.printStackTrace();
        }

        return a;
    }

    public Profesor obtenerProfesor(String nombre, String nombreInstituto) {

        Profesor p = null;
        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "select nombre, contra, DNI, fechaNac,nombreInsti,ciclo from usuario where nombre= '" + nombre + "' and nombreInsti='" + nombreInstituto + "'"
            );

            if (rs.next()) {
                p = new Profesor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                p = getDatosProfesor(p);

            } else {

                JOptionPane.showMessageDialog(null, "No existe un profesor con ese nombre en el instituto indicado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;

    }

    public Profesor getDatosProfesor(Profesor p) {
        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery("select * from modulo where profesor  = '" + p.getNombre() + "'");

            while (rs.next()) {

                p.annadirModulo(new Modulo(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
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

    public Instituto obtenerInstituto(String nombre) {
        Instituto i = null;
        Ciclo c = null;

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery("select * from instituto where nombre= '" + nombre + "'");

            if (rs.next()) {

                i = new Instituto(rs.getString(1), rs.getString(2), rs.getString(3));

                rs = ConexionDefault.instancia().getStatement().executeQuery("select * from ciclo where instituto= '" + nombre + "'");

                while (rs.next()) {

                    c = new Ciclo(rs.getString(1), rs.getInt(2), rs.getInt(3));

                    rs = ConexionDefault.instancia().getStatement().executeQuery("select * from modulo where ciclo ='" + c.getNombre() + "'");

                    while (rs.next()) {

                        c.anadirModulo(new Modulo(rs.getString(1), rs.getString(2), rs.getInt(3)));
                    }

                    i.annadirCiclo(c);
                }

                rs = ConexionDefault.instancia().getStatement().executeQuery("select * from usuario where nombreInsti = '" + i.getNombre() + "'");
                ArrayList<Usuario> listaUsuario = new ArrayList();
                int cantidadFilas = 0;
                //cojo el numero de usuarios
                if (rs.last()) {

                    cantidadFilas = rs.getRow();
                    rs.beforeFirst();
                }
                String[] ciclosAlumnos = new String[cantidadFilas];

                int contador = 0;
                while (rs.next()) {

                    Usuario a = null;

                    switch (rs.getString(5)) {

                        case "alu":
                            a = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                            ciclosAlumnos[contador] = rs.getString(6);
                            break;
                        case "prof":
                            a = new Profesor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                            break;
                        case "adm":
                            a = new Administrador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                    }
                    contador++;

                    listaUsuario.add(a);

                }

                for (int j = 0; j < listaUsuario.size(); j++) {

                    if (listaUsuario.get(j) instanceof Alumno) {
                        Alumno a = (Alumno) listaUsuario.get(j);
                        a = getDatosAlumno(a, ciclosAlumnos[j]);

                        i.annadirUsuario(a);
                    } else if (listaUsuario.get(j) instanceof Profesor) {

                        Profesor p = (Profesor) listaUsuario.get(j);
                        p = getDatosProfesor(p);
                        i.annadirUsuario(p);

                    } else {

                        i.annadirUsuario(listaUsuario.get(j));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOInstituto2.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;
    }

    public void annadirUsuario(String i, Usuario u) {
        boolean annadido = false;
        ConexionDefault.crearConexion();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if (u instanceof Alumno) {

                ConexionDefault.instancia().getStatement().execute("INSERT INTO usuario VALUES ('"
                        + u.getNombre() + "', '" + u.getContra() + "', '" + u.getDNI() + "', '" + sdf.format(u.getFecha_nacimientoNumerico()) + "', 'alu', '" + ((Alumno) u).getCiclo() + "', '" + i + "');");

            }
            if (u instanceof Profesor) {
                Profesor p = (Profesor) u;

                ConexionDefault.instancia().getStatement().execute("INSERT INTO usuario VALUES ('"
                        + u.getNombre() + "', '" + u.getContra() + "', '" + u.getDNI() + "', '" + sdf.format(u.getFecha_nacimientoNumerico()) + "', 'prof', '', '" + i + "');");

                //for ( ) {

                  //  ConexionDefault.instancia().getStatement().execute("Update Modulo Profesor = '" + p.getNombre() + "' where nombre ");
                //}

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOInstituto2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
