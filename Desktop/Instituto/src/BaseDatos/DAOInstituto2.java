/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import ClasesBase.Curso;
import ClasesBase.Evento;
import ClasesBase.Instituto;
import ClasesBase.Modulo;
import ClasesBase.Nota;
import Usuarios.Administrador;
import Usuarios.Alumno;
import Usuarios.Profesor;
import Usuarios.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public Alumno obtenerAlumno(String nombre, String nombreInstituto, Instituto i) {

        Alumno a = null;
        String nombreCiclo;
        Curso ciclo;

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "select nombre, contra, DNI, fechaNac,nombreInsti,ciclo,ano from usuario where nombre= '" + nombre + "' and nombreInsti='" + nombreInstituto + "'"
            );

            if (rs.next()) {
                a = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                a = getDatosAlumno(a, rs.getString(6), rs.getInt(7), i);

            } else {

                JOptionPane.showMessageDialog(null, "No existe un alumno con ese nombre en el instituto indicado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public Alumno getDatosAlumno(Alumno a, String nombreCiclo, int anno, Instituto i) {
        Curso ciclo = null;

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery("select * from ciclo where nombre  = '" + nombreCiclo + "' AND anno ='" + anno + "'");
            if (rs.next()) {

                ciclo = i.buscarCurso(nombreCiclo, anno);

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

    public Profesor obtenerProfesor(String nombre, String nombreInstituto, Instituto i) {

        Profesor p = null;
        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "select nombre, contra, DNI, fechaNac,nombreInsti,ciclo from usuario where nombre= '" + nombre + "' and nombreInsti='" + nombreInstituto + "'"
            );

            if (rs.next()) {
                p = new Profesor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                p = getDatosProfesor(p, i);

            } else {

                JOptionPane.showMessageDialog(null, "No existe un profesor con ese nombre en el instituto indicado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;

    }

    public Profesor getDatosProfesor(Profesor p, Instituto i) {

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery("select * from modulo where profesor  = '" + p.getNombre() + "'");

            while (rs.next()) {

                p.annadirModulo(i.buscarCurso(rs.getString("ciclo"), rs.getInt("anno")).getModulo(rs.getString("nombre")));
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
        Curso c = null;

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery("select * from instituto where nombre= '" + nombre + "'");

            if (rs.next()) {

                i = new Instituto(rs.getString(1), rs.getString(2), rs.getString(3));

                rs = ConexionDefault.instancia().getStatement().executeQuery("select c.nombre,c.plazas,c.anno,m.nombre,m.codigoAula,m.horas_semana from ciclo c, modulo m where m.ciclo=c.nombre AND m.anno=c.anno AND c.instituto=m.Instituto AND c.instituto='" + nombre + "'");

                while (rs.next()) {

                    if (i.getCicloNombre(rs.getString(1), rs.getInt(3)) == null) {

                        c = new Curso(rs.getString(1), rs.getInt(2), rs.getInt(3));

                        Modulo m = new Modulo(rs.getString(4), rs.getString(5), rs.getInt(6));
                        c.anadirModulo(m);
                        i.annadirCiclo(c);
                    } else {
                        c = i.getCicloNombre(rs.getString(1), rs.getInt(3));

                        Modulo m = new Modulo(rs.getString(4), rs.getString(5), rs.getInt(6));
                        c.anadirModulo(m);
                    }
                }

                rs = ConexionDefault.instancia().getStatement().executeQuery("select * from Eventos where instituto ='" + i.getNombre() + "'");

                while (rs.next()) {

                    Curso curso = i.buscarCurso(rs.getString("Ciclo"), rs.getInt("anno"));

                    Modulo modulo = curso.getModulo(rs.getString("Modulo"));

                    modulo.annnadirEvento(new Evento(rs.getString("Mensaje"), rs.getDate("Fecha")));
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
                int[] annoCiclo = new int[cantidadFilas];

                int contador = 0;
                while (rs.next()) {

                    Usuario a = null;

                    switch (rs.getString(5)) {

                        case "alu":
                            a = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                            ciclosAlumnos[contador] = rs.getString(6);
                            annoCiclo[contador] = rs.getInt(7);
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
                        a = getDatosAlumno(a, ciclosAlumnos[j], annoCiclo[j], i);

                        i.annadirUsuario(a);
                    } else if (listaUsuario.get(j) instanceof Profesor) {

                        Profesor p = (Profesor) listaUsuario.get(j);
                        p = getDatosProfesor(p, i);
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
        //boolean annadido = false;
        ConexionDefault.crearConexion();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if (u instanceof Alumno) {
                try {

                    ConexionDefault.instancia().getStatement().execute("INSERT INTO usuario VALUES ('"
                            + u.getNombre() + "', '" + u.getContra() + "', '" + u.getDNI() + "', '" + sdf.format(u.getFecha_nacimientoNumerico())
                            + "', 'alu', '" + ((Alumno) u).getCiclo().getNombre() + "', '" + ((Alumno) u).getCiclo().getAnno() + "', '" + i + "')");

                } catch (SQLIntegrityConstraintViolationException s) {
                    JOptionPane.showMessageDialog(null, "Ya existe un usuario en el instituto con este nombre");
                }

            } else if (u instanceof Profesor) {

                try {
                    Profesor p = (Profesor) u;

                    ConexionDefault.instancia().getStatement().execute("INSERT INTO usuario VALUES ('"
                            + u.getNombre() + "', '" + u.getContra() + "', '" + u.getDNI() + "', '" + sdf.format(u.getFecha_nacimientoNumerico()) + "', 'prof', '', " + 0 + ",'" + i + "');");

                } catch (SQLIntegrityConstraintViolationException s) {
                    JOptionPane.showMessageDialog(null, "Ya existe un usuario en el instituto con este nombre");
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOInstituto2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Curso> getCursosdeProfesor(String nombreProfesor, Instituto instituto) {

        ArrayList<Curso> cursos = new ArrayList();

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery("select ciclo,anno from modulo where profesor= '" + nombreProfesor + "' AND instituto ='" + instituto.getNombre() + "'");

            while (rs.next()) {

                cursos.add(instituto.buscarCurso(rs.getString(1), rs.getInt(2)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOInstituto2.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cursos;
    }

    public void borrarNotas(String nombreUsuario, String mod) {

        ConexionDefault.crearConexion();

        try {

            ConexionDefault.instancia().getStatement().execute(""
                    + "delete  from nota where alumno='" + nombreUsuario + "' and modulo='" + mod + "'");

            System.out.println("Borrado");

        } catch (Exception e) {

        }
    }

    public void modificarNotas(String nombreUsuario, String nota, String modulo, String instituto) throws SQLException {

        ConexionDefault.instancia().getStatement().execute(""
                + "INSERT INTO nota VALUES ('" + nombreUsuario + "', '" + modulo + "',  '" + nota + "', '" + instituto + "')");

    }

    public void eliminarUsuario(String nombreUsuario, String instituto) {

        try {
            ConexionDefault.crearConexion();
            ConexionDefault.instancia().getStatement().execute("DELETE FROM usuario where nombre = '" + nombreUsuario + "' AND nombreInsti ='" + instituto + "'");
            ConexionDefault.instancia().getStatement().execute("DELETE FROM nota where alumno = '" + nombreUsuario + "' AND instituto ='" + instituto + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DaoInstituto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarContrasena(String nombreUsuario, String nombreInstituto, String contrasennaNueva) {

        try {
            ConexionDefault.instancia().getStatement().execute("update usuario set contra ='" + contrasennaNueva + "'where nombre = '" + nombreUsuario + "' AND nombreInsti = '" + nombreInstituto + "'");

        } catch (SQLException ex) {

            System.out.println("No se ha podido modificar la contrasena");
        }

    }

    public void annadirCurso(Instituto i, Curso c) throws SQLException {
        //para saber si esta añadido o no
        boolean annadido = false;
        ConexionDefault.instancia().getStatement().execute("INSERT INTO ciclo VALUES ('"
                + c.getNombre() + "', '" + c.getPlazas() + "', '" + c.getAnno() + "');");

    }

    public void modificarprofesorModulo(String nombreProfesor, Modulo m, Curso c, String nombreInstituto) {

        try {
            ConexionDefault.instancia().getStatement().execute("update modulo set profesor='" + nombreProfesor + "' where nombre='" + m.getNombre() + "' AND ciclo= '" + c.getNombre() + "' AND anno ='" + c.getAnno() + "' AND instituto ='" + nombreInstituto + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DAOInstituto2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Curso> getCiclosdeProfesor(String nombreProfesor, Instituto instituto) {

        ArrayList<Curso> cursos = new ArrayList();

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery("select ciclo,anno from modulo where profesor= '" + nombreProfesor + "' AND instituto ='" + instituto.getNombre() + "'");

            while (rs.next()) {

                cursos.add(instituto.buscarCurso(rs.getString(1), rs.getInt(2)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOInstituto2.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cursos;
    }

    public void annadirModulo(Instituto i, Modulo m, Curso c) throws SQLException {

        ConexionDefault.instancia().getStatement().execute("INSERT INTO modulo VALUES ('"
                + m.getNombre() + "', '" + m.getCodigo_aula() + "', '" + m.getHoras_semana() + "', '" + c.getNombre() + "', '" + c.getAnno() + "','', '" + i.getNombre() + "');");

    }

    public void anadirEvento(Evento e, String modulo, Curso ciclo, String instituto) {

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ConexionDefault.instancia().getStatement().execute("insert into Eventos values ('" + e.getMensaje() + "','" + sdf.format(e.getFecha()) + "','" + modulo + "','" + ciclo.getNombre() + "'," + ciclo.getAnno() + ",'" + instituto + "')");
        } catch (SQLException ex) {
            Logger.getLogger(DAOInstituto2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getNeventosProfesor(String nombreProfe) {

        int nEventos = 0;
        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery("select count(*) from modulo m, Eventos e where m.nombre=e.Modulo AND m.ciclo=e.Ciclo AND m.anno= e.Anno AND m.profesor='" + nombreProfe + "'");
            if (rs.next()) {

                nEventos = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOInstituto2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nEventos;
    }

    public int getEventosCurso(Curso c) {

        int nEventos = 0;

        try {
            ResultSet rs = ConexionDefault.instancia().getStatement().executeQuery("select count(*) from Eventos e where Ciclo='" + c.getNombre() + "' AND Anno ='" + c.getAnno() + "'");

            if (rs.next()) {

                nEventos = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOInstituto2.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nEventos;
    }

}
