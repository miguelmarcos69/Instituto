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

        Instituto i = null;
        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                    //"select * from instituto"
                    "select tipo from usuario where nombre= 'miguel'"
            );
//            System.out.println(rs.getString(1));
            if (rs.next()) {
                //i = new Instituto(rs.getString(2), rs.getString(3),rs.getString(4));
                if (rs.getString(1).equals("adm")) {
                    System.out.println("Es un administrador");

                }
                if (rs.getString(1).equals("alu")) {
                    System.out.println("Es un Alumno");

                }
                if (rs.getString(1).equals("pro")) {
                    System.out.println("Es un profesor");

                }
                System.out.println("******************");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

}
