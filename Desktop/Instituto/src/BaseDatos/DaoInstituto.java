/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import ClasesBase.*;

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

    public Instituto cargarNombre(String nombreInstituto, String nombre, String contra) {
        System.out.println("Dao");
        System.out.println(nombreInstituto);
        System.out.println(nombre);
        System.out.println(contra);
        Instituto i = null;
        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "SELECT instituto.clave,instituto.nombre,instituto.direccion,instituto.tlfn,usuario.clave,usuario.nombre, contra, tipo,nombreInsti "
                    + "from instituto,usuario where usuario.nombre = '" + nombre + "'and usuario.contra= '" + contra + "' "
                    + "and instituto.nombre ='" + nombreInstituto + "'"
            );
            System.out.println(rs.getString(9));
            if (rs.next()) {
                //i = new Instituto(rs.getString(2), rs.getString(3),rs.getString(4));
                if (rs.getString(9).equals("adm")) {
                    System.out.println("Es un administrador");

                }
                if (rs.getString(8).equals("alu")) {
                    System.out.println("Es un Alumno");

                }
                if (rs.getString(8).equals("pro")) {
                    System.out.println("Es un profesor");

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

}
